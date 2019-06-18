package io.scalajs.npm.aws

import io.scalajs.nodejs.stream

import scala.scalajs.js

/**
  * Represents an Http Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpResponse extends js.Object {

  /**
    * Disables buffering on the HTTP response and returns the stream for reading.
    */
  def createUnbufferedStream(): stream.Readable /*|XMLHttpRequest*/ = js.native

  /**
    * The response body payload.
    */
  def body: js.Any /*String | Buffer | Uint8Array*/ = js.native

  /**
    * A map of response header keys and their respective values.
    */
  def headers: HttpHeaders = js.native

  /**
    * The HTTP status code of the response (e.g., 200, 404).
    */
  def statusCode: StatusCode = js.native

  /**
    * The HTTP status message of the response (e.g., 'Bad Request', 'Not Found')
    */
  def statusMessage: String = js.native

  /**
    * Whether this response is being streamed at a low-level.
    */
  def streaming: Boolean = js.native
}
