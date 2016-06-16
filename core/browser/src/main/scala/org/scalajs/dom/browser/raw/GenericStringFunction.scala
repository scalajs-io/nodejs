package org.scalajs.dom.browser.raw

import scala.scalajs.js

/**
  * JavaScript decodeuri() / encodeuri() Function
  * @see [[http://www.w3schools.com/jsref/jsref_unescape.asp]]
  */
@js.native
trait GenericStringFunction extends js.Object  {

  def apply(text: String): String = js.native

}
