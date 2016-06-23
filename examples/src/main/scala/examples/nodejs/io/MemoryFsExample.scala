package examples.nodejs.io

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.core.Assert
import org.scalajs.nodejs.fs.{FileIOError, Stats}
import org.scalajs.nodejs.memoryfs.MemoryFS
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.{Bootstrap, console}

import scala.concurrent.ExecutionContext
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js

/**
  * Memory-fs Example
  * @author lawrence.daniels@gmail.com
  */
class MemoryFsExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val assert = Assert()
  val memoryFileSystem = MemoryFS()
  val fs = memoryFileSystem() // Optionally pass a javascript object

  example2()

  /**
    * Synchronous example
    */
  def example1() {
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

  /**
    * Example using Scala Future's
    */
  def example2() {
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

  /**
    * Asynchronous example
    */
  def example3()(implicit ec: ExecutionContext) {
    var output1: Buffer = null
    var output2: js.Array[String] = null
    var output3: Boolean = false

    fs.mkdirp("/a/test/dir", (err1: FileIOError) => {
      assert.ifError(err1)

      fs.writeFile("/a/test/dir/file.txt", "Hello World", (err2: FileIOError) => {
        assert.ifError(err2)

        fs.readFile("/a/test/dir/file.txt", (err3: FileIOError, data: Buffer) => {
          assert.ifError(err3)
          output1 = data // ~> Buffer("Hello World")

          fs.unlink("/a/test/dir/file.txt", (err4: FileIOError) => {
            assert.ifError(err4)

            fs.readdir("/a/test", (err5: FileIOError, dir: js.Array[String]) => {
              assert.ifError(err5)
              output2 = dir // ~> ["dir"]

              fs.stat("/a/test/dir",  (err6: FileIOError, stats: Stats) => {
                assert.ifError(err6)
                output3 = stats.isDirectory() // ~> true

                fs.rmdir("/a/test/dir", (err7: FileIOError) => {
                  assert.ifError(err7)
                  fs.mkdirp("C:\\use\\windows\\style\\paths", (err8: FileIOError) => {
                    assert.ifError(err8)
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

}
