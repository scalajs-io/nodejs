package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js

/**
  * To use this module, do require('string_decoder'). StringDecoder decodes a buffer to a string. It is a simple
  * interface to [[com.github.ldaniels528.meansjs.nodejs.buffer.Buffer.toString()]] but provides additional support for utf8.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait StringDecoder extends NodeModule {

  def StringDecoder: StringDecoderClass = js.native

}
