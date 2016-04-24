package com.github.ldaniels528.meansjs.nodejs

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer

import scala.scalajs.js

/**
  * Accepts a single argument, encoding which defaults to 'utf8'.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait StringDecoderInstance extends js.Object {

  /**
    * Returns any trailing bytes that were left in the buffer.
    * @example decoder.end()
    */
  def end(): String = js.native

  /**
    * Returns a decoded string.
    * @example decoder.write(buffer)
    */
  def write(buffer: Buffer): String = js.native

}
