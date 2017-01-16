package io.scalajs.dom.html

import scala.scalajs.js

/**
  * The HTMLAnchorElement interface represents hyperlink elements and provides special properties
  * and methods (beyond those of the regular HTMLElement object interface they also have available
  * to them by inheritance) for manipulating the layout and presentation of such elements.
  * @author lawrence.daniels@gmail.com
  * @see https://developer.mozilla.org/en-US/docs/Web/API/HTMLAnchorElement
  */
@js.native
class HTMLAnchorElement extends HTMLElement {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Is a DOMString representing a single character that switches input focus to the hyperlink.
    */
  def accessKey: String = js.native

  /**
    * Is a USVString representing the hostname and port (if it's not the default port) in the referenced URL.
    */
  def host: String = js.native

  /**
    * Is a USVString representing the hostname in the referenced URL.
    */
  def hostname: String = js.native

  /**
    * Is a DOMString being a synonym for the Node.textContent property.
    */
  def text: String = js.native

}
