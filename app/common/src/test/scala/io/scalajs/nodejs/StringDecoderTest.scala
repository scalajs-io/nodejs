package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer
import org.scalatest.FunSpec

/**
  * StringDecoder Tests
  * @author lawrence.daniels@gmail.com
  */
class StringDecoderTest extends FunSpec {

  describe("StringDecoder") {

    it("should decode strings or buffer") {
      val decoder = new StringDecoder("utf8")

      info(decoder.write(Buffer.from("Hello ")))
      info(decoder.write(Buffer.from("World")))
      info(decoder.end(Buffer.from("!")))
    }

  }

}
