package io.scalajs.dom.html

import io.scalajs.dom.Element
import io.scalajs.dom.collection.DOMStringMap
import io.scalajs.dom.html.css.CSSStyleDeclaration

import scala.scalajs.js

/**
  * The HTMLElement interface represents any HTML element. Some elements directly implement this interface,
  * others implement it via an interface that inherits it.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HTMLElement extends Element {

  /**
    * Is a DOMString, where a value of "true" means the element is editable and a value of "false" means it isn't.
    */
  var contentEditable: String = js.native

  /**
    * Returns a Boolean that indicates whether or not the content of the element can be edited.
    */
  def isContentEditable: Boolean = js.native

  /**
    * Is a HTMLMenuElement representing the contextual menu associated with the element. It may be null
    */
  var contextMenu: HTMLMenuElement = js.native

  /**
    * Returns a [[DOMStringMap]] with which script can read and write the element's custom data attributes (data-*).
    * @see https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/dataset
    */
  def dataset: DOMStringMap = js.native

  /**
    * Is a DOMString, reflecting the dir global attribute, representing the directionality of the element.
    * Possible values are "ltr", "rtl", and "auto".
    */
  var dir: String = js.native

  /**
    * Is a DOMString representing the language of an element's attributes, text, and element contents.
    */
  var lang: String = js.native

  /**
    * Is a [[CSSStyleDeclaration]], an object representing the declarations of an element's style attributes.
    */
  var style: CSSStyleDeclaration = js.native

  /**
    * Is a long representing the position of the element in the tabbing order.
    */
  var tabIndex: String = js.native

  /**
    * Is a DOMString containing the text that appears in a popup box when mouse is over the element.
    */
  var title: String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Removes the  keyboard focus from the current element.
    */
  def blur(): Unit = js.native

  /**
    * Sends a mouse click event to the element.
    */
  def click(): Unit = js.native

  /**
    * Gives the keyboard focus to the current element.
    */
  def focus(): Unit = js.native

}
