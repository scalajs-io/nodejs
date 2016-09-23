package org.scalajs.nodejs.memoryfs

import org.scalajs.nodejs.NodeRequire.require
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.console
import org.scalajs.nodejs.fs.{FileIOError, Stats}
import org.scalajs.nodejs.util.ScalaJsHelper._
import utest._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Memory-Fs Tests
  * @author lawrence.daniels@gmail.com
  */
object MemoryFsTests extends TestSuite {

  override val tests = this {
    val memoryFileSystem = MemoryFS()
    val fs = memoryFileSystem() // Optionally pass a javascript object

    "memory-fs - asynchronous" - {
      var output1: Buffer = null
      var output2: js.Array[String] = null
      var output3: Boolean = false

      fs.mkdirp("/a/test/dir", (err1: FileIOError) => {
        err1 ==> null

        fs.writeFile("/a/test/dir/file.txt", "Hello World", (err2: FileIOError) => {
          err2 ==> null

          fs.readFile("/a/test/dir/file.txt", (err3: FileIOError, data: Buffer) => {
            err3 ==> null
            output1 = data // ~> Buffer("Hello World")

            fs.unlink("/a/test/dir/file.txt", (err4: FileIOError) => {
              err4 ==> null

              fs.readdir("/a/test", (err5: FileIOError, dir: js.Array[String]) => {
                err5 ==> null
                output2 = dir // ~> ["dir"]

                fs.stat("/a/test/dir", (err6: FileIOError, stats: Stats) => {
                  err6 ==> null
                  output3 = stats.isDirectory() // ~> true

                  fs.rmdir("/a/test/dir", (err7: FileIOError) => {
                    err7 ==> null
                    fs.mkdirp("C:\\use\\windows\\style\\paths", (err8: FileIOError) => {
                      err8 ==> null
                    })
                  })
                })
              })
            })
          })
        })
      })

      console.log("output1 =", output1.toString(), output1)
      console.log("output2 =", output2)
      console.log("output3 =", output3)
    }

    "memory-fs - synchronous" - {
      fs.mkdirpSync("/a/test/dir")
      fs.writeFileSync("/a/test/dir/file.txt", "Hello World")
      val output1 = fs.readFileSync("/a/test/dir/file.txt") // ~> Buffer("Hello World")
      fs.unlinkSync("/a/test/dir/file.txt")
      val output2 = fs.readdirSync("/a/test") // ~> ["dir"]
      val output3 = fs.statSync("/a/test/dir").isDirectory() // ~> true
      fs.rmdirSync("/a/test/dir")
      fs.mkdirpSync("C:\\use\\windows\\style\\paths")

      console.log("output1 =", output1.toString(), output1)
      console.log("output2 =", output2)
      console.log("output3 =", output3)
    }

    "memory-fs - promises" - {
      for {
        _ <- fs.mkdirpFuture("/a/test/dir")
        _ <- fs.writeFileFuture("/a/test/dir/file.txt", "Hello World")
        output1 <- fs.readFileFuture("/a/test/dir/file.txt") // ~> Buffer("Hello World")
        _ <- fs.unlinkFuture("/a/test/dir/file.txt")
        output2 <- fs.readdirFuture("/a/test") // ~> ["dir"]
        output3 <- fs.statFuture("/a/test/dir").map(_.isDirectory()) // ~> true
        _ <- fs.rmdirFuture("/a/test/dir")
        _ <- fs.mkdirpFuture("C:\\use\\windows\\style\\paths")
      } {
        console.log("output1 =", output1.toString(), output1)
        console.log("output2 =", output2)
        console.log("output3 =", output3)
      }
    }

  }

}
