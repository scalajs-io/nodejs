package io.scalajs.dom.ws

import io.scalajs.dom.html.Blob

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.typedarray.ArrayBuffer
import scala.scalajs.js.|

/**
  * The WebSocket object provides the API for creating and managing a WebSocket connection to a server, as well as for
  * sending and receiving data on the connection.
  * @param endpoint  The URL to which to connect; this should be the URL to which the WebSocket server will respond.
  * @param protocols Either a single protocol string or an array of protocol strings. These strings are used to
  *                  indicate sub-protocols, so that a single server can implement multiple WebSocket sub-protocols
  *                  (for example, you might want one server to be able to handle different types of interactions
  *                  depending on the specified protocol). If you don't specify a protocol string, an empty string is assumed.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/WebSockets_API
  * @see https://developer.mozilla.org/en-US/docs/Web/API/WebSocket
  * @author lawrence.daniels@gmail.com
  */
@js.native
class WebSocket(endpoint: String, protocols: String*) extends js.Object {

  ///////////////////////////////////////////////////////////////
  //    Properties
  ///////////////////////////////////////////////////////////////

  /**
    * A string indicating the type of binary data being transmitted by the connection.
    * This should be either "blob" if DOM Blob objects are being used or "arraybuffer"
    * if ArrayBuffer objects are being used.
    */
  def binaryType: String = js.native

  /**
    * The number of bytes of data that have been queued using calls to send() but not yet transmitted to the network.
    * This value resets to zero once all queued data has been sent. This value does not reset to zero when the
    * connection is closed; if you keep calling send(), this will continue to climb. Read only.
    */
  def bufferedAmount: Long = js.native

  /**
    * The extensions selected by the server. This is currently only the empty string or a list of
    * extensions as negotiated by the connection.
    */
  def extensions: String = js.native

  /**
    * An event listener to be called when the WebSocket connection's readyState changes to CLOSED.
    * The listener receives a CloseEvent named "close".
    */
  var onclose: js.Function1[CloseEvent, Any] = js.native

  /**
    * An event listener to be called when an error occurs. This is a simple event named "error".
    */
  var onerror: js.Function1[ErrorEvent, Any] = js.native

  /**
    * An event listener to be called when a message is received from the server.
    * The listener receives a MessageEvent named "message".
    */
  var onmessage: js.Function1[MessageEvent, Any] = js.native

  /**
    * An event listener to be called when the WebSocket connection's readyState changes to OPEN;
    * this indicates that the connection is ready to send and receive data. The event is a simple
    * one with the name "open".
    */
  var onopen: js.Function1[OpenEvent, Any] = js.native

  /**
    * A string indicating the name of the sub-protocol the server selected; this will be one of the
    * strings specified in the protocols parameter when creating the WebSocket object.
    */
  def protocol: String = js.native

  /**
    * The current state of the connection; this is one of the Ready state constants. Read only.
    */
  def readyState: Int = js.native

  /**
    * The URL as resolved by the constructor. This is always an absolute URL. Read only.
    */
  def url: String = js.native

  ///////////////////////////////////////////////////////////////
  //    Methods
  ///////////////////////////////////////////////////////////////

  /**
    * Closes the WebSocket connection or connection attempt, if any. If the connection is already CLOSED,
    * this method does nothing.
    * @param code   Optional: A numeric value indicating the status code explaining why the connection is being closed.
    *               If this parameter is not specified, a default value of 1000 (indicating a normal
    *               "transaction complete" closure) is assumed. See the list of status codes on the CloseEvent
    *               page for permitted values.
    * @param reason Optional: A human-readable string explaining why the connection is closing. This string must be no
    *               longer than 123 bytes of UTF-8 text (not characters).
    */
  def close(code: Int = js.native, reason: String = js.native): Unit = js.native

  /**
    * Transmits data to the server over the WebSocket connection.
    * @param data A text string to send to the server.
    */
  def send(data: String | ArrayBuffer | Blob): Unit = js.native

}

@js.native
@JSName("WebSocket")
object WebSocket extends js.Object {

  /**
    * The connection is not yet open.
    */
  val CONNECTING: Int = js.native

  /**
    * The connection is open and ready to communicate.
    */
  val OPEN: Int = js.native

  /**
    * The connection is in the process of closing.
    */
  val CLOSING: Int = js.native

  /**
    * The connection is closed or couldn't be opened.
    */
  val CLOSED: Int = js.native

}