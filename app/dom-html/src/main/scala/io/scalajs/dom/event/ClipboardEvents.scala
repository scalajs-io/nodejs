package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Created by ldaniels on 12/14/16.
  */
@js.native
trait ClipboardEvents extends js.Object {

  /**
    * The event occurs when the user copies the content of an element
    */
  def oncopy(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the user cuts the content of an element
    * @param callback
    */
  def oncut(callback: js.Function): Unit = js.native

  /**
    * The event occurs when the user pastes some content in an element
    */
  def onpaste(callback: js.Function): Unit = js.native

}
