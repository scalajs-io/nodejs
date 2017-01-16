package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Server-Sent Event
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ServerSentEvents extends js.Object {

  /**
    * The event occurs when an error occurs with the event source
    */
  def onerror(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a message is received through the event source
    */
  def onmessage(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a connection with the event source is opened
    */
  def onopen(callback: js.Function): Unit = js.native

}
