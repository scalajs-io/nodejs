package io.scalajs.dom.html

import io.scalajs.dom.Element

import scala.scalajs.js

/**
  * The HTMLElement interface represents any HTML element. Some elements directly implement this interface,
  * others implement it via an interface that inherits it.
  * @author lawrence.daniels@gmail.com
  * @see https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement
  */
@js.native
trait HTMLElement extends Element {

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
