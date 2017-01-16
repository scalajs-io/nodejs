package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Form Events
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FormEvents extends js.Object {

  /**
    * The event occurs when an element loses focus
    */
  def onblur(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the content of a form element, the selection, or the checked state have
    * changed (for <input>, <keygen>, <select>, and <textarea>)
    */
  def onchange(callback: js.Function): Unit = js.native

  /**
    * The event occurs when an element gets focus
    */
  def onfocus(callback: js.Function): Unit = js.native

  /**
    * The event occurs when an element is about to get focus
    */
  def onfocusin(callback: js.Function): Unit = js.native

  /**
    * The event occurs when an element is about to lose focus
    */
  def onfocusout(callback: js.Function): Unit = js.native

  /**
    * The event occurs when an element gets user input
    */
  def oninput(callback: js.Function): Unit = js.native

  /**
    * The event occurs when an element is invalid
    */
  def oninvalid(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a form is reset
    */
  def onreset(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the user writes something in a search field (for <input="search">)
    */
  def onsearch(callback: js.Function): Unit = js.native

  /**
    * The event occurs after the user selects some text (for <input> and <textarea>)
    */
  def onselect(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a form is submitted
    */
  def onsubmit(callback: js.Function): Unit = js.native

}
