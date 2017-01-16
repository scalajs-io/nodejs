package io.scalajs.dom.html

import scala.scalajs.js

/**
  * The HTMLEmbedElement interface, which provides special properties (beyond the regular HTMLElement interface
  * it also has available to it by inheritance) for manipulating <embed> elements.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/HTMLEmbedElement
  * @author lawrence.daniels@gmail.com
  */
@js.native
class HTMLEmbedElement extends HTMLElement {

  /**
    * Is a DOMString representing an enumerated property indicating alignment of the element's contents
    * with respect to the surrounding context. The possible values are "left", "right", "center", and "justify".
    */
  def height: Int = js.native

  /**
    * Is a DOMString that reflects the src HTML attribute, containing the address of the resource.
    */
  def src: String = js.native

  /**
    * Is a DOMString that reflects the type HTML attribute, containing the type of the resource.
    */
  def `type`: String = js.native

  /**
    * Is a DOMString that reflects the width HTML attribute, containing the displayed width of the resource.
    */
  def width: Int = js.native

}
