package io.scalajs.dom.html

import scala.scalajs.js

/**
  * The HTMLHeadElement interface contains the descriptive information, or metadata, for a document.
  * This object inherits all of the properties and methods described in the HTMLElement interface.
  * @author lawrence.daniels@gmail.com
  */
@js.native
class HTMLHeadElement extends HTMLElement {

  /**
    * Is a DOMString representing the URIs of one or more metadata profiles (white space separated).
    */
  def profile: String = js.native

}
