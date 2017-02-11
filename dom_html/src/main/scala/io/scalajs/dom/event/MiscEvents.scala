package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Miscellaneous Events
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait MiscEvents extends js.Object {

  /**
    * The event occurs when a message is received through or from an object (WebSocket, Web Worker, Event Source or a child frame or a parent window)
    */
  def onmessage(callback: js.Function): Unit = js.native

  /**
    * Deprecated. Use the onwheel event instead
    */
  def onmousewheel(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the browser starts to work online
    */
  def ononline(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the browser starts to work offline
    */
  def onoffline(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the window's history changes
    */
  def onpopstate(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a <menu> element is shown as a context menu
    */
  def onshow(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a Web Storage area is updated
    */
  def onstorage(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the user opens or closes the <details> element
    */
  def ontoggle(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the mouse wheel rolls up or down over an element
    */
  def onwheel(callback: js.Function): Unit = js.native

}
