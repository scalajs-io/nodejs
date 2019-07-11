package io.scalajs.npm.memoryfs

import io.scalajs.nodejs.FileIOError
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.fs.Stats
import org.scalatest.funspec.AnyFunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Memory-Fs Tests
  * @author lawrence.daniels@gmail.com
  */
class MemoryFsTest extends AnyFunSpec {

  describe("MemoryFs") {

    it("can be used asynchronously - callbacks") {
      val fs = new MemoryFs()
      var output1: Buffer = null
      var output2: js.Array[String] = null
      var output3: Boolean = false

      fs.mkdirp("/a/test/dir", (err1: FileIOError) => {
        fs.writeFile("/a/test/dir/file.txt", "Hello World", (err2: FileIOError) => {
          fs.readFile("/a/test/dir/file.txt", (err3: FileIOError, data: Buffer) => {
            output1 = data // ~> Buffer("Hello World")

            fs.unlink("/a/test/dir/file.txt", (err4: FileIOError) => {
              fs.readdir("/a/test", (err5: FileIOError, dir: js.Array[String]) => {
                output2 = dir // ~> ["dir"]

                fs.stat("/a/test/dir", (err6: FileIOError, stats: Stats) => {
                  output3 = stats.isDirectory() // ~> true

                  fs.rmdir("/a/test/dir", (err7: FileIOError) => {
                    fs.mkdirp("C:\\use\\windows\\style\\paths", (err8: FileIOError) => {
                      show("output1 =", output1.toString(), output1)
                      show("output2 =", output2)
                      show("output3 =", output3)
                    })
                  })
                })
              })
            })
          })
        })
      })
    }

    it("can be used asynchronously - promises") {
      val fs = new MemoryFs() // Optionally pass a javascript object
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
        show("output1 =", output1.toString(), output1)
        show("output2 =", output2)
        show("output3 =", output3)
      }
    }

    it("can be used synchronously") {
      val fs = new MemoryFs() // Optionally pass a javascript object
      fs.mkdirpSync("/a/test/dir")
      fs.writeFileSync("/a/test/dir/file.txt", "Hello World")
      val output1 = fs.readFileSync("/a/test/dir/file.txt") // ~> Buffer("Hello World")
      fs.unlinkSync("/a/test/dir/file.txt")
      val output2 = fs.readdirSync("/a/test")
      // ~> ["dir"]
      val output3 = fs.statSync("/a/test/dir").isDirectory() // ~> true
      fs.rmdirSync("/a/test/dir")
      fs.mkdirpSync("C:\\use\\windows\\style\\paths")

      show("output1 =", output1.toString(), output1)
      show("output2 =", output2)
      show("output3 =", output3)
    }

  }

  def show(label: String, value: js.Any*): Unit = {
    info(s"$label ${value.mkString(" ")}")
  }

}
