package com.github.ldaniels528.meansjs.nodejs.http

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * Node.js http.ClientRequest
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/http.html#http_class_http_clientrequest]]
  */
@js.native
trait ClientRequest extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Marks the request as aborting. Calling this will cause remaining data in the response
    * to be dropped and the socket to be destroyed.
    * @see [[https://nodejs.org/api/http.html#http_request_abort]]
    */
  def abort(): Unit = js.native

  /**
    * Finishes sending the request. If any parts of the body are unsent, it will flush them to the stream.
    * If the request is chunked, this will send the terminating '0\r\n\r\n'.
    * @see [[https://nodejs.org/api/http.html#http_request_end_data_encoding_callback]]
    */
  def end(data: js.Any, encoding: String, callback: js.Function): Unit = js.native

  def end(data: js.Any, encoding: String): Unit = js.native

  def end(data: js.Any): Unit = js.native

  def end(): Unit = js.native

  /**
    * Flush the request headers.
    *
    * For efficiency reasons, Node.js normally buffers the request headers until you call
    * request.end() or write the first chunk of request data. It then tries hard to pack the
    * request headers and data into a single TCP packet.
    *
    * That's usually what you want (it saves a TCP round-trip) but not when the first data isn't sent
    * until possibly much later. request.flushHeaders() lets you bypass the optimization and kickstart
    * the request.
    * @see [[https://nodejs.org/api/http.html#http_request_flushheaders]]
    */
  def flushHeaders(): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setNoDelay() will be called.
    */
  def setNoDelay(noDelay: Int): Unit = js.native

  def setNoDelay(): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setKeepAlive() will be called.
    * @see [[https://nodejs.org/api/http.html#http_request_setsocketkeepalive_enable_initialdelay]]
    */
  def setSocketKeepAlive(enable: Boolean, initialDelay: Int): Unit = js.native

  def setSocketKeepAlive(enable: Boolean): Unit = js.native

  def setSocketKeepAlive(initialDelay: Int): Unit = js.native

  def setSocketKeepAlive(): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setTimeout() will be called.
    * <ul>
    * <li>timeout {Number} Milliseconds before a request is considered to be timed out.</li>
    * <li>callback {Function} Optional function to be called when a timeout occurs.
    * Same as binding to the timeout event.</li>
    * </ul>
    */
  def setTimeout(timeout: Int, callback: js.Function): Unit = js.native

  def setTimeout(timeout: Int): Unit = js.native

  /**
    * Sends a chunk of the body. By calling this method many times, the user can stream a
    * request body to a server--in that case it is suggested to use the ['Transfer-Encoding', 'chunked']
    * header line when creating the request.
    *
    * The chunk argument should be a Buffer or a string.
    * The encoding argument is optional and only applies when chunk is a string. Defaults to 'utf8'.
    * The callback argument is optional and will be called when this chunk of data is flushed.
    * Returns request.
    */
  def write(chunk: js.Any, encoding: String, callback: js.Function): Unit = js.native

  def write(chunk: js.Any): Unit = js.native

  def write(chunk: js.Any, encoding: String): Unit = js.native

}

/**
  * Client Request Companion
  * @author lawrence.daniels@gmail.com
  */
object ClientRequest {

  /**
    * Client Request Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class ClientRequestEnrich(val request: ClientRequest) extends AnyVal {

    def endAsync(data: js.Any, encoding: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[Unit]()
      request.end(data, encoding, () => promise.success({}))
      promise.future
    }

    def writeAsync(chunk: js.Any, encoding: String)(implicit ec: ExecutionContext) = {
      val promise = Promise[js.Any]()
      request.write(chunk, encoding, () => promise.success(chunk))
      promise.future
    }

  }

}