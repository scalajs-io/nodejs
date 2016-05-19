package com.github.ldaniels528.meansjs.nodejs.http

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter
import com.github.ldaniels528.meansjs.nodejs.stream.Writable

import scala.scalajs.js

/**
  * Node.js http.ServerResponse
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/http.html#http_class_http_serverresponse]]
  */
@js.native
trait ServerResponse extends EventEmitter with Writable {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Boolean value that indicates whether the response has completed. Starts as false.
    * After response.end() executes, the value will be true.
    */
  def finished: Boolean = js.native

  /**
    * The response headers
    * @return
    */
  def headers: js.Dictionary[String] = js.native

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
    * Reads out a header that's already been queued but not sent to the client.
    * Note that the name is case insensitive. This can only be called before
    * headers get implicitly flushed.
    */
  def getHeader(name: String): js.UndefOr[String] = js.native

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

  /**
    * Server Response Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class ServerResponseExtensions(val response: ServerResponse) extends AnyVal {

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