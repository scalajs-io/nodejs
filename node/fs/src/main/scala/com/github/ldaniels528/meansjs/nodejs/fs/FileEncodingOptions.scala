package com.github.ldaniels528.meansjs.nodejs.fs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * File Encoding Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FileEncodingOptions extends js.Object {
  var encoding: String = _
}

/**
  * File Encoding Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FileEncodingOptions {

  def apply(encoding: String) = {
    val options = new FileEncodingOptions()
    options.encoding = encoding
    options
  }

}