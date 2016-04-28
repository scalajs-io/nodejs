package com.github.ldaniels528.meansjs.nodejs.http

import scala.scalajs.js

/**
  * Node.js http.ServerResponse
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/http.html#http_class_http_serverresponse]]
  */
@js.native
trait ServerResponse extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Boolean value that indicates whether the response has completed. Starts as false.
    * After response.end() executes, the value will be true.
    */
  def finished: Boolean = js.native

  /**
    * Boolean (read-only). True if headers were sent, false otherwise.
    */
  def headersSent: Boolean = js.native

  /**
    * When true, the Date header will be automatically generated and sent in the response
    * if it is not already present in the headers. Defaults to true.
    */
  var sendDate: Boolean = js.native

  /**
    * When using implicit headers (not calling response.writeHead() explicitly), this property controls
    * the status code that will be sent to the client when the headers get flushed.
    */
  var statusCode: Int = js.native

  /**
    * When using implicit headers (not calling response.writeHead() explicitly), this property controls
    * the status message that will be sent to the client when the headers get flushed. If this is left
    * as undefined then the standard message for the status code will be used.
    */
  var statusMessage: js.UndefOr[String] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * This method adds HTTP trailing headers (a header but at the end of the message) to the response.
    * Trailers will only be emitted if chunked encoding is used for the response; if it is not (e.g., if
    * the request was HTTP/1.0), they will be silently discarded.
    * <p><b>Note</b> that HTTP requires the Trailer header to be sent if you intend to emit trailers, with
    * a list of the header fields in its value.
    */
  def addTrailers(headers: js.Any): Unit = js.native

  /**
    * This method signals to the server that all of the response headers and body have been sent;
    * that server should consider this message complete. The method, response.end(), MUST be called on each response.
    * <p/>If data is specified, it is equivalent to calling response.write(data, encoding) followed by response.end(callback).
    * <p/>If callback is specified, it will be called when the response stream is finished.
    * @example response.end([data][, encoding][, callback])
    */
  def end(data: js.Any, encoding: String, callback: js.Function): Unit = js.native

  def end(data: js.Any, encoding: String): Unit = js.native

  def end(data: js.Any, callback: js.Function): Unit = js.native

  def end(data: js.Any): Unit = js.native

  def end(callback: js.Function): Unit = js.native

  def end(): Unit = js.native

  /**
    * Reads out a header that's already been queued but not sent to the client.
    * Note that the name is case insensitive. This can only be called before
    * headers get implicitly flushed.
    */
  def getHeader(name: String): js.UndefOr[String] = js.native

  def on(event: String, callback: js.Function): Unit = js.native

  /**
    * Removes a header that's queued for implicit sending.
    */
  def removeHeader(name: String): Unit = js.native

  def render(path: String): Unit = js.native

  def send(data: js.Any): Unit = js.native

  def sendStatus(statusCode: Int): Unit = js.native

  def set(name: String, value: js.Any): Unit = js.native

  def set(headers: js.Any): Unit = js.native

  def setEncoding(encoding: String): Unit = js.native

  /**
    * Sets a single header value for implicit headers. If this header already exists in the to-be-sent headers,
    * its value will be replaced. Use an array of strings here if you need to send multiple headers with the same name.
    */
  def setHeader(name: String, value: String): Unit = js.native

  /**
    * Sets the Socket's timeout value to msecs. If a callback is provided, then
    * it is added as a listener on the 'timeout' event on the response object.
    *
    * If no 'timeout' listener is added to the request, the response, or the server,
    * then sockets are destroyed when they time out. If you assign a handler on the
    * request, the response, or the server's 'timeout' events, then it is your
    * responsibility to handle timed out sockets.
    *
    * Returns response.
    */
  def setTimeout(msecs: Int, callback: js.Function): Unit = js.native

  def status(statusCode: Int): this.type = js.native

  def `type`(mime: String): js.UndefOr[String] = js.native

  /**
    * If this method is called and response.writeHead() has not been called, it will switch to implicit header
    * mode and flush the implicit headers. This sends a chunk of the response body. This method may be called
    * multiple times to provide successive parts of the body.
    * <p/>chunk can be a string or a buffer. If chunk is a string, the second parameter specifies how to encode it
    * into a byte stream. By default the encoding is 'utf8'. The last parameter callback will be called when
    * this chunk of data is flushed.
    * <p/>Note: This is the raw HTTP body and has nothing to do with higher-level multi-part body encodings that may be used.
    * The first time response.write() is called, it will send the buffered header information and the first body
    * to the client. The second time response.write() is called, Node.js assumes you're going to be streaming data,
    * and sends that separately. That is, the response is buffered up to the first chunk of body.
    * <p/>Returns true if the entire data was flushed successfully to the kernel buffer.
    * <p/>Returns false if all or part of the data was queued in user memory. 'drain' will be emitted when the
    * buffer is free again.
    * @example response.write(chunk[, encoding][, callback])
    */
  def write(chunk: js.Any, encoding: String, callback: js.Function): Unit = js.native

  def write(chunk: js.Any, encoding: String): Unit = js.native

  def write(chunk: js.Any): Unit = js.native

  /**
    * Sends a HTTP/1.1 100 Continue message to the client, indicating that the request body should be sent.
    * See the 'checkContinue' event on Server.
    */
  def writeContinue(): Unit = js.native

  /**
    * Sends a response header to the request. The status code is a 3-digit HTTP status code, like 404.
    * The last argument, headers, are the response headers. Optionally one can give a human-readable
    * statusMessage as the second argument.
    * @example response.writeHead(statusCode[, statusMessage][, headers])
    */
  def writeHead(statusCode: Int, statusMessage: String, headers: js.Any): Unit = js.native

  def writeHead(statusCode: Int, statusMessage: String): Unit = js.native

  def writeHead(statusCode: Int, headers: js.Any): Unit = js.native

}

/**
  * Server Response
  * @author lawrence.daniels@gmail.com
  */
object ServerResponse {
  val EventClose = "close"
  val EventFinish = "finish"

  /**
    * Server Response Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ServerResponseEnrich(val response: ServerResponse) extends AnyVal {

    @inline
    def badRequest() = response.sendStatus(400)

    @inline
    def forbidden() = response.sendStatus(403)

    @inline
    def internalServerError() = response.sendStatus(500)

    @inline
    def notFound() = response.sendStatus(404)

  }

}