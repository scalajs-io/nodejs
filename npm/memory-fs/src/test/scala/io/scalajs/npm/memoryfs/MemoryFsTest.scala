package io.scalajs.npm.memoryfs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.console
import io.scalajs.nodejs.fs.{FileIOError, Stats}
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Memory-Fs Tests
  * @author lawrence.daniels@gmail.com
  */
class MemoryFsTest extends FunSpec {

  describe("MemoryFs") {

    val fs = new MemoryFileSystem() // Optionally pass a javascript object

    it("can be used asynchronously - callbacks") {
      /*
      var output1: Buffer = null
      var output2: js.Array[String] = null
      var output3: Boolean = false

      fs.mkdirp(
        "/a/test/dir", (err1: FileIOError) => {
          assert(err1 == null, err1)

          fs.writeFile("/a/test/dir/file.txt", "Hello World", (err2: FileIOError) => {
            assert(err2 == null, err2)

            fs.readFile("/a/test/dir/file.txt", (err3: FileIOError, data: Buffer) => {
              assert(err3 == null, err3)
              output1 = data // ~> Buffer("Hello World")

              fs.unlink("/a/test/dir/file.txt", (err4: FileIOError) => {
                assert(err4 == null, err4)

                fs.readdir("/a/test", (err5: FileIOError, dir: js.Array[String]) => {
                  assert(err5 == null, err5)
                  output2 = dir // ~> ["dir"]

                  fs.stat("/a/test/dir", (err6: FileIOError, stats: Stats) => {
                    assert(err6 == null, err6)
                    output3 = stats.isDirectory() // ~> true

                    fs.rmdir("/a/test/dir", (err7: FileIOError) => {
                      assert(err7 == null, err7)

                      fs.mkdirp("C:\\use\\windows\\style\\paths", (err8: FileIOError) => {
                        assert(err8 == null, err8)
                      })
                    })
                  })
                })
              })
            })
          })
        })

      show("output1 =", output1.toString(), output1)
      show("output2 =", output2)
      show("output3 =", output3)*/
    }

    it("can be used asynchronously - promises") {
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
