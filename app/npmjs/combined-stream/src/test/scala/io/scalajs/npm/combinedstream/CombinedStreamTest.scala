package io.scalajs.npm.combinedstream

import io.scalajs.nodejs.fs.Fs
import io.scalajs.nodejs.process
import org.scalatest.funspec.AnyFunSpec

/**
  * CombinedStream Tests
  * @author lawrence.daniels@gmail.com
  */
class CombinedStreamTest extends AnyFunSpec {

  describe("CombinedStream") {

    it("combines multiple inputs into a single output") {
      val combinedStream = CombinedStream.create()
      combinedStream.append(Fs.createReadStream("./src/test/resources/file1.txt"))
      combinedStream.append(Fs.createReadStream("./src/test/resources/file2.txt"))
      combinedStream.pipe(process.stdout)
    }

    it("supports pausing streams") {
      val combinedStream = CombinedStream.create(new CombineStreamOptions(pauseStreams = false))
      combinedStream.append(Fs.createReadStream("./src/test/resources/file1.txt"))
      combinedStream.append(Fs.createReadStream("./src/test/resources/file2.txt"))
      combinedStream.pipe(process.stdout)
    }

    it("supports lazy initialization of streams") {
      val combinedStream = CombinedStream.create()
      combinedStream.append(_ (Fs.createReadStream("./src/test/resources/file1.txt")))
      combinedStream.append(_ (Fs.createReadStream("./src/test/resources/file2.txt")))
      combinedStream.pipe(process.stdout)
    }

  }

}
