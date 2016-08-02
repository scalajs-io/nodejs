package org.scalajs.nodejs.util

import scala.scalajs.js
import scala.scalajs.js.JSON

/**
  * JSON Helper
  * @author lawrence.daniels@gmail.com
  */
object JSONHelper {

  /**
    * JSON Conversions
    * @param value the given JavaScript value
    */
  implicit class JSONConversions(val value: js.Any) extends AnyVal {

    def toJson = JSON.stringify(value)

  }

  /**
    * JSON Conversions
    * @param value the given JavaScript value
    */
  implicit class JSONParser(val value: String) extends AnyVal {

    def fromJson = JSON.parse(value)

  }

}
