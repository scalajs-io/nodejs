package io.scalajs.nodejs.fs

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.FunSpec

/**
  * File System (Fs) Tests
  * @author lawrence.daniels@gmail.com
  */
class FsTest extends FunSpec {

  describe("Fs") {

    it("should stream data") {
      val file1 = "./nodejs/src/test/resources/fileA1.txt"
      val file2 = "./nodejs/src/test/resources/fileA2.txt"
      val file3 = "./nodejs/src/test/resources/fileC2.txt"

      val readable = Fs.createReadStream(file1)
      val writable = Fs.createWriteStream(file2)
      readable.setEncoding("utf8")
      readable.onData((chunk: Buffer) => writable.write(chunk))
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
      val file1 = "./nodejs/src/test/resources/fileB1.txt"
      val file2 = "./nodejs/src/test/resources/fileB2.txt"

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
