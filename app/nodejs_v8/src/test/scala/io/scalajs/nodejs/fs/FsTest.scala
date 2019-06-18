package io.scalajs.nodejs.fs

import io.scalajs.JSON
import io.scalajs.nodejs.setImmediate
import io.scalajs.nodejs.util.Util
import io.scalajs.util.ScalaJsHelper._
import org.scalatest.FunSpec

/**
  * File System (Fs) Tests
  *
  */
class FsTest extends FunSpec {

  val TEST_RESOURCES = "./app/nodejs_v8/src/test/resources/"

  describe("Fs") {

    it("supports watching files") {
      val watcher = Fs.watch(s"${TEST_RESOURCES}", (eventType, file) => {
        info(s"watcher: eventType = '$eventType' file = '$file'")
      })
      info(s"watcher: ${Util.inspect(watcher)}")

      setImmediate(
        () =>
          Fs.writeFile(s"${TEST_RESOURCES}1.txt", "Hello", error => {
            if (isDefined(error)) {
              alert(s"error: ${JSON.stringify(error)}")
            }
          })
      )
    }

    it("should stream data") {
      val file1 = s"${TEST_RESOURCES}fileA1.txt"
      val file2 = s"${TEST_RESOURCES}fileA2.txt"
      val file3 = s"${TEST_RESOURCES}fileC2.txt"

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
      val file1 = s"${TEST_RESOURCES}fileB1.txt"
      val file2 = s"${TEST_RESOURCES}fileB2.txt"

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
