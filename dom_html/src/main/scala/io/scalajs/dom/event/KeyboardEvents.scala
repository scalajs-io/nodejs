package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Keyboard Events
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait KeyboardEvents extends js.Object {

  /**
    * The event occurs when the user is pressing a key
    */
  def onkeydown(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the user presses a key
    */
  def onkeypress(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the user releases a key
    */
  def onkeyup(callback: js.Function): Unit = js.native

}
