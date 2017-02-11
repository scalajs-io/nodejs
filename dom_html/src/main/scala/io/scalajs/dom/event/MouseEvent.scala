package io.scalajs.dom.event

import io.scalajs.dom.{Element, Event}

import scala.scalajs.js

/**
  * Mouse Event Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
class MouseEvent extends Event {

  /**
    * Returns whether the "ALT" key was pressed when the mouse event was triggered
    */
  def altKey: Int = js.native

  /**
    * Returns which mouse button was pressed when the mouse event was triggered	2
    */
  def button: Int = js.native

  /**
    * Returns which mouse buttons were pressed when the mouse event was triggered
    */
  def buttons: Int = js.native

  /**
    * Returns the horizontal coordinate of the mouse pointer, relative to the current window, when the mouse event was triggered
    */
  def clientX: Int = js.native

  /**
    * Returns the vertical coordinate of the mouse pointer, relative to the current window, when the mouse event was triggered
    */
  def clientY: Int = js.native

  /**
    * Returns whether the "CTRL" key was pressed when the mouse event was triggered
    */
  def ctrlKey: Int = js.native

  /**
    * Returns a number that indicates how many times the mouse was clicked
    */
  def detail: Int = js.native

  /**
    * Returns whether the "META" key was pressed when an event was triggered
    */
  def metaKey: Int = js.native

  /**
    * Returns the horizontal coordinate of the mouse pointer, relative to the document, when the mouse event was triggered
    */
  def pageX: Int = js.native

  /**
    * Returns the vertical coordinate of the mouse pointer, relative to the document, when the mouse event was triggered
    */
  def pageY: Int = js.native

  /**
    * Returns the element related to the element that triggered the mouse event
    */
  def relatedTarget: Element = js.native

  /**
    * Returns the horizontal coordinate of the mouse pointer, relative to the screen, when an event was triggered
    */
  def screenX: Int = js.native

  /**
    * Returns the vertical coordinate of the mouse pointer, relative to the screen, when an event was triggered
    */
  def screenY: Int = js.native

  /**
    * Returns whether the "SHIFT" key was pressed when an event was triggered
    */
  def shiftKey: Int = js.native

  /**
    * Returns which mouse button was pressed when the mouse event was triggered
    */
  def which: Int = js.native

}
