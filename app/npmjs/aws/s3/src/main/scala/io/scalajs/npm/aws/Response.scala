package io.scalajs.npm.aws

import scala.scalajs.js

/**
  * AWS.Response
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Response[T, E] extends js.Object {
  /**
    * Whether more pages of data can be returned by further requests.
    */
  def hasNextPage(): Boolean = js.native

  /**
    * Creates a new request for the next page of response data, calling the callback with the page data if a callback is provided.
    */
  def nextPage(callback: (E, T) => Any): this.type = js.native

  /**
    * The de-serialized response data from the service.
    * Can be null if an error occurred.
    */
  def data: js.UndefOr[T] = js.native

  /**
    * A structure containing information about a service or networking error.
    */
  def error: js.UndefOr[E] = js.native

  /**
    * Returns the unique request ID associated with the response.
    * Log this value when debugging requests for AWS support.
    */
  def requestId: String = js.native

  /**
    * The number of redirects that were followed before the request was completed.
    */
  def redirectCount: Int = js.native

  /**
    * The number of retries that were attempted before the request was completed.
    */
  def retryCount: Int = js.native

  /**
    * The raw HTTP response object containing the response headers and body information from the server.
    */
  def httpResponse: HttpResponse = js.native
}
