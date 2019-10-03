package io

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * scalajs package object
  */
package object scalajs {

  @deprecated("Use js.Any", "0.9.0")
  type JsAnything = js.Any // js.Any | js.Object | JsNumber | String | Boolean

  @deprecated("Use Double or specific Number sub type", "0.9.0")
  type JsNumber = Byte | Double | Float | Int | Long | Short | java.lang.Number

  @deprecated("Use specific type", "0.9.0")
  type RawOptions = js.Dictionary[_] | js.Object

  /**
    * JSON Enrichment
    * @param json the given [[JSON]] object
    */
  @deprecated("Use scala.scalajs.js.JSON and io.scalajs.util.JSONHelper.", "0.9.0")
  implicit final class JSONEnrichment(val json: JSON) extends AnyVal {
    import io.scalajs.util.JSONHelper._

    @inline
    def parseAs[T](text: String): T = js.JSON.parseAs[T](text)

    @inline
    def parseAs[T](text: String, reviver: js.Function): T =
      js.JSON.parseAs[T](text, reviver.asInstanceOf[js.Function2[js.Any, js.Any, js.Any]])

  }

}
