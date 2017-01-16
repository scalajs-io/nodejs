package io.scalajs.npm.escapehtml

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * escape-html - Escape string for use in HTML
  * @version 1.0.3
  * @see https://www.npmjs.com/package/escape-html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("escape-html", JSImport.Namespace)
object EscapeHtml extends js.Object {

  /**
    * Encodes the given URI
    * @param uri the given URI
    * @return the encoded URI
    */
  def apply(uri: String): String = js.native

}
