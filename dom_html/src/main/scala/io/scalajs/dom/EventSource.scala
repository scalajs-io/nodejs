package io.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The EventSource interface is used to receive server-sent events. It connects to a server over HTTP
  * and receives events in text/event-stream format without closing the connection.
  * @param url A DOMString representing the URL of the source.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/EventSource
  */
@js.native
@JSName("EventSource")
class EventSource(val url: String) extends EventTarget {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Is an EventHandler being called when an error occurs and the error event is dispatched on this object.
    */
  var onerror: js.Function = js.native

  /**
    * Is an EventHandler being called when a message event is received, that is when a message is coming from the source.
    */
  var onmessage: js.Function = js.native

  /**
    * Is an EventHandler being called when an open event is received, that is when the connection was just opened.
    */
  var onopen: js.Function = js.native

  /**
    * Read only: An unsigned short representing the state of the connection.
    * Possible values are CONNECTING (0), OPEN (1), or CLOSED (2).
    */
  def readyState: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Closes the connection, if any, and sets the readyState attribute to CLOSED.
    * If the connection is already closed, the method does nothing.
    */
  def close(): Unit = js.native

}
