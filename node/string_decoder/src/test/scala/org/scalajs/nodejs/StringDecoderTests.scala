package org.scalajs.nodejs

import org.scalajs.nodejs.NodeRequire._
import org.scalajs.nodejs.buffer.Buffer
import utest._

import scala.scalajs.js

/**
  * StringDecoder Tests
  * @author lawrence.daniels@gmail.com
  */
object StringDecoderTests extends TestSuite {

  override val tests = this {

    "string_decoder should decode strings or buffer" - {
      val StringDecoderClass = StringDecoder().StringDecoder
      val decoder = StringDecoderClass("utf8")

      val cent = Buffer.from(js.Array(0xC2, 0xA2))
      console.log(decoder.write(cent))

      val euro = Buffer.from(js.Array(0xE2, 0x82, 0xAC))
      console.log(decoder.write(euro))
    }

  }

}
