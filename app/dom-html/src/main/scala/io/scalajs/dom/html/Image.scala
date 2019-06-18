package io.scalajs.dom.html

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * MDN Image
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class Image extends js.Object {
  var src: String         = js.native
  var width: Double       = js.native
  var height: Double      = js.native
  var onload: js.Function = js.native
}
