package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * To use this module, do require('string_decoder'). StringDecoder decodes a buffer to a string. It is a simple
  * interface to [[Buffer.toString()]] but provides additional support for utf8.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("string_decoder", "StringDecoder")
class StringDecoder(encoding: String = js.native) extends IEventEmitter {

  /**
    * Returns any trailing bytes that were left in the buffer.
    * @example decoder.end()
    */
  def end(buffer: Buffer = js.native): String = js.native

  /**
    * Returns a decoded string.
    * @example decoder.write(buffer)
    */
  def write(buffer: Buffer): String = js.native

}
