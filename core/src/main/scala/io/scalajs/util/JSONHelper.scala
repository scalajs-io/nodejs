package io.scalajs.util

import scala.scalajs.js

/**
  * JSON Helper
  */
@deprecated("Unrelated to Node.js. Use your own extension method.", "v0.10.0")
object JSONHelper {

  /**
    * JSON Conversions
    * @param value the given JavaScript value
    */
  @deprecated("Unrelated to Node.js. Use your own extension method.", "v0.10.0")
  implicit final class JSONConversionsToJson[T <: js.Any](val value: T) extends AnyVal {
    @inline
    def toJson: String = js.JSON.stringify(value)

    @inline
    def toPrettyJson: String = js.JSON.stringify(value, null.asInstanceOf[js.Array[js.Any]], 4)
  }

  /**
    * JSON Conversions
    * @param text the given text string
    */
  @deprecated("Unrelated to Node.js. Use your own extension method.", "v0.10.0")
  implicit final class JSONConversionFromJson(val text: String) extends AnyVal {
    @inline
    def fromJson[T <: js.Any]: T = js.JSON.parse(text).asInstanceOf[T]
  }

  @deprecated("Unrelated to Node.js. Use your own extension method.", "v0.10.0")
  implicit final class ScalaJsJSONEnrichment(val json: js.JSON.type) extends AnyVal {
    @inline
    def parseAs[T](text: String): T =
      js.JSON.parse(text).asInstanceOf[T]

    @inline
    def parseAs[T](text: String, reviver: js.Function2[js.Any, js.Any, js.Any]): T =
      js.JSON.parse(text, reviver).asInstanceOf[T]
  }
}
