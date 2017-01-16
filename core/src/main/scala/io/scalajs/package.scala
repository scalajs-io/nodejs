package io

import scala.scalajs.js

/**
  * scalajs package object
  * @author lawrence.daniels@gmail.com
  */
package object scalajs {

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
