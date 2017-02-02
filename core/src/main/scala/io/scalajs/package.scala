package io

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * scalajs package object
  * @author lawrence.daniels@gmail.com
  */
package object scalajs {

  type JsAnything = js.Any | js.Object | JsNumber | String | Boolean

  type JsNumber = Byte | Double | Float | Int | Long | Short | java.lang.Number

  type RawOptions = js.Dictionary[_] | js.Object

  /**
    * JSON Enrichment
    * @param json the given [[JSON]] object
    */
  implicit class JSONEnrichment(val json: JSON) extends AnyVal {

    @inline
    def parseAs[T](text: String): T = json.parse(text).asInstanceOf[T]

    @inline
    def parseAs[T](text: String, reviver: js.Function): T = json.parse(text, reviver).asInstanceOf[T]

  }

}
