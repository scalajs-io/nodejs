package io.scalajs.dom.html.css

import io.scalajs.dom.html.Style

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * CSS Selector
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal("CSSSelector")
class CSSSelector extends js.Object {

  def style: Style = js.native

  def textContent: String = js.native

}
