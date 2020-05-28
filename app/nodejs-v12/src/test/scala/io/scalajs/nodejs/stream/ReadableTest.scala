package io.scalajs.nodejs.stream

import io.scalajs.nodejs.fs.ReadStream
import org.scalatest.funspec.AnyFunSpec

class ReadableTest extends AnyFunSpec {
  describe("Readable") {
    it("readableEncoding") {
      assert(new ReadStream("package.json").readableEncoding === null)
    }
  }
}
