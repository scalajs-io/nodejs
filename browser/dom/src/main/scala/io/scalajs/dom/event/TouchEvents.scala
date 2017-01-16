package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Touch Events
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TouchEvents extends js.Object {

  /**
    * The event occurs when the touch is interrupted
    */
  def ontouchcancel(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a finger is removed from a touch screen
    */
  def ontouchend(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a finger is dragged across the screen
    */
  def ontouchmove(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a finger is placed on a touch screen
    */
  def ontouchstart(callback: js.Function): Unit = js.native

}
