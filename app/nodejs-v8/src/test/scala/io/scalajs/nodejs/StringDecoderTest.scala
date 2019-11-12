package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.FunSpec

class StringDecoderTest extends FunSpec {
  describe("StringDecoder") {
    it("should decode strings or buffer") {
      val decoder = new StringDecoder("utf8")
      assert(decoder.write(Buffer.from("Hello ")) === "Hello ")
      assert(decoder.write(Buffer.from("World")) === "World")
      assert(decoder.end(Buffer.from("!")) === "!")
    }
  }
}
