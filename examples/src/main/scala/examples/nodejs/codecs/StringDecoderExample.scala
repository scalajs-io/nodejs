package examples.nodejs.codecs

import org.scalajs.dom.console
import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.{Bootstrap, StringDecoder}

import scala.scalajs.js

/**
  * String Decoder Example
  * @author lawrence.daniels@gmail.com
  */
class StringDecoderExample(bootstrap: Bootstrap) {
  implicit val require = bootstrap.require

  val StringDecoderClass = StringDecoder().StringDecoder
  val decoder = StringDecoderClass("utf8")

  val cent = Buffer.from(js.Array(0xC2, 0xA2))
  console.log(decoder.write(cent))

  val euro = Buffer.from(js.Array(0xE2, 0x82, 0xAC))
  console.log(decoder.write(euro))

}
