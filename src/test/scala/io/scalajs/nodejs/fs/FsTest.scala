package io.scalajs.nodejs.fs

import io.scalajs.JSON
import io.scalajs.nodejs.setImmediate
import io.scalajs.nodejs.util.Util
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * File System (Fs) Tests
  * @author lawrence.daniels@gmail.com
  */
class FsTest extends FunSpec {

  describe("Fs") {

    it("supports watching files") {
      val watcher = Fs.watch("./src/test/resources/", (eventType, file) => {
        info(s"watcher: eventType = '$eventType' file = '$file'")
      })
      info(s"watcher: ${Util.inspect(watcher)}")

      setImmediate(() => Fs.writeFile("./src/test/resources/1.txt", "Hello", error => {
        if (isDefined(error)) {
          alert(s"error: ${JSON.stringify(error)}")
        }
      }))
    }

    it("should stream data") {
      val file1 = "./src/test/resources/fileA1.txt"
      val file2 = "./src/test/resources/fileA2.txt"
      val file3 = "./src/test/resources/fileC2.txt"

      val readable = Fs.createReadStream(file1)
      val writable = Fs.createWriteStream(file2)
      readable.setEncoding("utf8")
      readable.onData[String](chunk => writable.write(chunk))
      writable.onFinish { () =>
        info("Comparing file sizes:")
        info(s"$file1 is ${Fs.statSync(file1).size} bytes")
        info(s"$file2 is ${Fs.statSync(file2).size} bytes")
        assert(Fs.statSync(file1).size == Fs.statSync(file2).size)

        info("should rename the file")
        Fs.renameSync(file2, file3)
        assert(Fs.statSync(file2).isFile())

        info("should delete the file")
        Fs.unlinkSync(file3)
        val deleted = !Fs.existsSync(file3)
        info(s"deleted? $deleted")
        assert(deleted)
      }
    }

    it("should pipe data from a Readable to a Writable") {
      val file1 = "./src/test/resources/fileB1.txt"
      val file2 = "./src/test/resources/fileB2.txt"

      val readable = Fs.createReadStream(file1)
      val writable = Fs.createWriteStream(file2)
      readable.pipe(writable)
      writable.onFinish { () =>
        info("Comparing file sizes:")
        info(s"$file1 is ${Fs.statSync(file1).size} bytes")
        info(s"$file2 is ${Fs.statSync(file2).size} bytes")
        assert(Fs.statSync(file1).size == Fs.statSync(file2).size)
      }
    }

  }

}
