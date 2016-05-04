package com.github.ldaniels528.meansjs.nodejs.http

import com.github.ldaniels528.meansjs.nodejs
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Node.js http.ClientRequest
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/http.html#http_class_http_clientrequest]]
  */
@js.native
trait ClientRequest extends nodejs.stream.Readable {

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

  /**
    * Finishes sending the request. If any parts of the body are unsent, it will flush them to the stream.
    * If the request is chunked, this will send the terminating '0\r\n\r\n'.
    * @see [[https://nodejs.org/api/http.html#http_request_end_data_encoding_callback]]
    */
  def end(data: js.Any, encoding: String): Unit = js.native

  /**
    * Finishes sending the request. If any parts of the body are unsent, it will flush them to the stream.
    * If the request is chunked, this will send the terminating '0\r\n\r\n'.
    * @see [[https://nodejs.org/api/http.html#http_request_end_data_encoding_callback]]
    */
  def end(data: js.Any): Unit = js.native

  /**
    * Finishes sending the request. If any parts of the body are unsent, it will flush them to the stream.
    * If the request is chunked, this will send the terminating '0\r\n\r\n'.
    * @see [[https://nodejs.org/api/http.html#http_request_end_data_encoding_callback]]
    */
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

  /**
    * Once a socket is assigned to this request and is connected socket.setNoDelay() will be called.
    */
  def setNoDelay(): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setKeepAlive() will be called.
    * @see [[https://nodejs.org/api/http.html#http_request_setsocketkeepalive_enable_initialdelay]]
    */
  def setSocketKeepAlive(enable: Boolean, initialDelay: Int): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setKeepAlive() will be called.
    * @see [[https://nodejs.org/api/http.html#http_request_setsocketkeepalive_enable_initialdelay]]
    */
  def setSocketKeepAlive(enable: Boolean): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setKeepAlive() will be called.
    * @see [[https://nodejs.org/api/http.html#http_request_setsocketkeepalive_enable_initialdelay]]
    */
  def setSocketKeepAlive(initialDelay: Int): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setKeepAlive() will be called.
    * @see [[https://nodejs.org/api/http.html#http_request_setsocketkeepalive_enable_initialdelay]]
    */
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

  /**
    * Once a socket is assigned to this request and is connected socket.setTimeout() will be called.
    * <ul>
    * <li>timeout {Number} Milliseconds before a request is considered to be timed out.</li>
    * <li>callback {Function} Optional function to be called when a timeout occurs.
    * Same as binding to the timeout event.</li>
    * </ul>
    */
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
  def write(chunk: js.Any, encoding: String): Unit = js.native

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
  def write(chunk: js.Any): Unit = js.native

}

/**
  * Client Request Companion
  * @author lawrence.daniels@gmail.com
  */
object ClientRequest {

  /**
    * Client Request Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ClientRequestEnrich(val request: ClientRequest) extends AnyVal {

    @inline
    def endAsync(data: js.Any, encoding: String) = callbackWithErrorToFuture[js.Any](request.end(data, encoding, _))

    @inline
    def writeAsync(chunk: js.Any, encoding: String) = callbackWithErrorToFuture[js.Any](request.write(chunk, encoding, _))

    /**
      * Emitted when the request has been aborted by the client. This event is only emitted on the first call to abort().
      */
    @inline
    def onAbort(callback: js.Function) = request.on("abort", callback)

    /**
      * Emitted each time a request with an http Expect header is received, where the value is not 100-continue.
      * If this event isn't listened for, the server will automatically respond with a 417 Expectation Failed as appropriate.
      * <b>Note</b> that when this event is emitted and handled, the request event will not be emitted.
      */
    @inline
    def onCheckExpectation(callback: js.Function) = request.on("checkExpectation", callback)

    /**
      * Emitted each time a server responds to a request with a CONNECT method. If this event isn't being listened for,
      * clients receiving a CONNECT method will have their connections closed.
      */
    @inline
    def onConnect(callback: js.Function) = request.on("connect", callback)

    /**
      * Emitted when the server sends a '100 Continue' HTTP response, usually because the request
      * contained 'Expect: 100-continue'. This is an instruction that the client should send the request body.
      */
    @inline
    def onContinue(callback: js.Function) = request.on("continue", callback)

    /**
      * Emitted when a response is received to this request. This event is emitted only once.
      * The response argument will be an instance of http.IncomingMessage.
      */
    @inline
    def onResponse(callback: js.Function) = request.on("response", callback)

    /**
      * Emitted after a socket is assigned to this request.
      */
    @inline
    def onSocket(callback: js.Function) = request.on("socket", callback)

    /**
      * Emitted each time a server responds to a request with an upgrade. If this event isn't being listened for,
      * clients receiving an upgrade header will have their connections closed.
      */
    @inline
    def onUpgrade(callback: js.Function) = request.on("upgrade", callback)

  }

}