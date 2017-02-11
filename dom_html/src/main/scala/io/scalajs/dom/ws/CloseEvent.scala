package io.scalajs.dom.ws

import io.scalajs.dom.Event

import scala.scalajs.js

/**
  * A CloseEvent is sent to clients using WebSockets when the connection is closed. This is delivered to the
  * listener indicated by the WebSocket object's onclose attribute.
  */
@js.native
class CloseEvent() extends Event {

  ///////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////

  /**
    * Returns an unsigned short containing the close code send by the server.
    * The following values are permitted status codes.
    */
  def code: Int = js.native

  /**
    * Returns a DOMString indicating the reason the server closed the connection.
    * This is specific to the particular server and sub-protocol.
    */
  def reason: String = js.native

  /**
    * Returns a Boolean that Indicates whether or not the connection was cleanly closed.
    */
  def wasClean: Boolean = js.native

  ///////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////

  /**
    * Initializes the value of a CloseEvent created. If the event has already being dispatched, this method does nothing.
    * Do not use this method anymore, use the CloseEvent() constructor instead.
    */
  def initCloseEvent(): Unit = js.native

}
