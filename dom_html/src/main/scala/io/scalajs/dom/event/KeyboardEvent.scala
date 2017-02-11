package io.scalajs.dom.event

import io.scalajs.dom.Event

import scala.scalajs.js

/**
  * Keyboard Event Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
class KeyboardEvent extends Event with KeyboardEvents {

  /**
    * Returns whether the "ALT" key was pressed when the key event was triggered
    */
  def altKey: Int = js.native

  /**
    * Returns whether the "CTRL" key was pressed when the key event was triggered
    */
  def ctrlKey: Int = js.native

  /**
    * Returns the Unicode character code of the key that triggered the onkeypress event
    */
  def charCode: Int = js.native

  /**
    * Returns the key value of the key represented by the event
    */
  def key: Int = js.native

  /**
    * Returns the Unicode character code of the key that triggered the onkeypress event,
    * or the Unicode key code of the key that triggered the onkeydown or onkeyup event
    */
  def keyCode: Int = js.native

  /**
    * Returns the location of a key on the keyboard or device
    */
  def location: Int = js.native

  /**
    * Returns whether the "meta" key was pressed when the key event was triggered
    */
  def metaKey: Int = js.native

  /**
    * Returns whether the "SHIFT" key was pressed when the key event was triggered
    */
  def shiftKey: Int = js.native

  /**
    * Returns the Unicode character code of the key that triggered the onkeypress event,
    * or the Unicode key code of the key that triggered the onkeydown or onkeyup event
    */
  def which: Int = js.native

}
