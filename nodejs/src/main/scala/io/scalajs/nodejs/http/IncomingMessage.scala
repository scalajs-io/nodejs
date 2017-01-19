package io.scalajs.nodejs.http

import io.scalajs.nodejs.net.Socket
import io.scalajs.nodejs.stream
import io.scalajs.nodejs.net.Socket
import io.scalajs.nodejs.stream.Readable

import scala.concurrent.duration.FiniteDuration
import scala.scalajs.js

/**
  * An IncomingMessage object is created by http.Server or http.ClientRequest and passed as the first argument
  * to the 'request' and 'response' event respectively. It may be used to access response status, headers and data.
  * It implements the Readable Stream interface, as well as the following additional events, methods, and properties.
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/http.html#http_class_http_incomingmessage]]
  */
@js.native
trait IncomingMessage extends Readable {

  /**
    * The request/response headers object. Key-value pairs of header names and values. Header names are lower-cased.
    * @example message.headers
    */
  def headers: js.Dictionary[String] = js.native

  /**
    * In case of server request, the HTTP version sent by the client. In the case of client response,
    * the HTTP version of the connected-to server. Probably either '1.1' or '1.0'.
    * @example message.httpVersion
    */
  def httpVersion: String = js.native

  /**
    * Only valid for request obtained from http.Server. The request method as a string. Read only. Example: 'GET', 'DELETE'.
    * @example message.method
    */
  def method: String = js.native

  /**
    * The raw request/response headers list exactly as they were received. <b>Note</b> that the keys and values are
    * in the same list. It is not a list of tuples. So, the even-numbered offsets are key values, and the odd-numbered
    * offsets are the associated values. Header names are not lowercased, and duplicates are not merged.
    * @example message.rawHeaders
    */
  def rawHeaders: js.Array[String] = js.native

  /**
    * The raw request/response trailer keys and values exactly as they were received. Only populated at the 'end' event.
    * @example message.rawTrailers
    */
  def rawTrailers: js.Array[String] = js.native

  /**
    * Calls message.connection.setTimeout(msecs, callback).
    * @example message.setTimeout(msecs, callback)
    */
  def setTimeout(msecs: Int, callback: js.Function): Unit = js.native

  /**
    * Calls message.connection.setTimeout(msecs, callback).
    * @example message.setTimeout(msecs, callback)
    */
  def setTimeout(msecs: Double, callback: js.Function): Unit = js.native

  /**
    * Only valid for response obtained from http.ClientRequest. The 3-digit HTTP response status code (e.g. 404).
    * @example message.statusCode
    */
  def statusCode: Int = js.native

  /**
    * Only valid for response obtained from http.ClientRequest. The HTTP response status message (reason phrase)
    * (e.g. OK or Internal Server Error).
    * @example message.statusMessage
    */
  def statusMessage: String = js.native

  /**
    * The net.Socket object associated with the connection. With HTTPS support, use request.socket.getPeerCertificate()
    * to obtain the client's authentication details.
    * @example message.socket
    */
  def socket: Socket = js.native

  /**
    * The request/response trailers object. Only populated at the 'end' event.
    * @example message.trailers
    */
  def trailers: js.Array[String] = js.native

  /**
    * Only valid for request obtained from http.Server. Request URL string. This contains only the URL that is
    * present in the actual HTTP request.
    * @example message.url
    */
  def url: String = js.native

}

/**
  * Incoming Message Companion
  * @author lawrence.daniels@gmail.com
  */
object IncomingMessage {

  /**
    * Incoming Message Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class IncomingMessageExtensions(val message: IncomingMessage) extends AnyVal {

    @inline
    def onClose(callback: js.Function) = message.on("close", callback)

    @inline
    def setTimeout(duration: FiniteDuration, callback: js.Function) = message.setTimeout(duration.toMillis.toDouble, callback)

  }

}