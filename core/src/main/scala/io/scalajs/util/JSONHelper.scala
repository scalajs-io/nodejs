package io.scalajs.util

import io.scalajs.JSON

import scala.scalajs.js

/**
  * JSON Helper
  * @author lawrence.daniels@gmail.com
  */
object JSONHelper {

  /**
    * JSON Conversions
    * @param value the given JavaScript value
    */
  implicit class JSONConversionsToJson[T <: js.Any](val value: T) extends AnyVal {

    @inline
    def toJson: String = JSON.stringify(value)

    @inline
    def toPrettyJson: String = JSON.stringify(value, null, 4)

  }

  /**
    * JSON Conversions
    * @param text the given text string
    */
  implicit class JSONConversionFromJson(val text: String) extends AnyVal {

    @inline
    def fromJson[T <: js.Any]: T = JSON.parse(text).asInstanceOf[T]

  }

}
