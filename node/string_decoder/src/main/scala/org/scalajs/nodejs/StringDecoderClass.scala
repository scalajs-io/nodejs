package org.scalajs.nodejs

import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

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

    @inline
    def apply(encoding: String) = `class`.New[StringDecoderInstance](encoding)

  }

}