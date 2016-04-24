package com.github.ldaniels528.meansjs.nodejs

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * String Decoder Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait StringDecoderClass extends js.Object

/**
  * String Decoder Class Companion
  * @author lawrence.daniels@gmail.com
  */
object StringDecoderClass {

  /**
    * String Decoder Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class StringDecoderClassExtensions(val `class`: StringDecoderClass) extends AnyVal {

    def apply(encoding: String) = `class`.New[StringDecoderInstance](encoding)

  }

}