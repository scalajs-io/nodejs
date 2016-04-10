package com.github.ldaniels528.meansjs.angularjs.core

import scala.language.implicitConversions
import scala.scalajs.js

/**
 * HTTP Service - The $http service is a core Angular service that facilitates communication
 * with the remote HTTP servers via the browser's XMLHttpRequest object or via JSONP.
 * @see https://docs.angularjs.org/api/ng/service/\$http
 */
@js.native
trait Http extends js.Object {

  /**
   * Usage: $http(config)
   * @param config Object describing the request to be made and how it should be processed.
   * @return Returns a promise object with the standard then method and two http specific methods: success and error.
   *         The then method takes two arguments a success and an error callback which will be called with a response
   *         object. The success and error methods take a single argument - a function that will be called when the
   *         request succeeds or fails respectively. The arguments passed into these functions are destructured
   *         representation of the response object passed into the then method.
   */
  def apply[T <: js.Any](config: HttpConfig): HttpPromise[T] = js.native

  /**
   * Relative or absolute URL specifying the destination of the request
   * @param url Relative or absolute URL specifying the destination of the request
   * @param config Optional configuration object
   * @return a [[HttpPromise promise]] of an response
   */
  def get[T <: js.Any](url: String, config: HttpConfig = js.native, headers: js.Dictionary[js.Any] = js.native): HttpPromise[T] = js.native

  /**
   * Shortcut method to perform a DELETE request.
   * @param url Relative or absolute URL specifying the destination of the request
   * @param data Request content
   * @param config Optional configuration object
   * @return a [[HttpPromise promise]] of an response
   */
  def delete[T <: js.Any](url: String, data: js.Any = js.native, config: HttpConfig = js.native, headers: js.Dictionary[js.Any] = js.native): HttpPromise[T] = js.native

  /**
   * Shortcut method to perform a HEAD request.
   * @param url Relative or absolute URL specifying the destination of the request
   * @param config Optional configuration object
   * @return a [[HttpPromise promise]] of an response
   */
  def head[T <: js.Any](url: String, config: HttpConfig = js.native): HttpPromise[T] = js.native

  /**
   * Shortcut method to perform a JSONP request.
   * @param url Relative or absolute URL specifying the destination of the request
   * @param config Optional configuration object
   * @return a [[HttpPromise promise]] of an response
   */
  def jsonp[T <: js.Any](url: String, config: HttpConfig = js.native): HttpPromise[T] = js.native

  /**
   * Shortcut method to perform a POST request.
   * @param url Relative or absolute URL specifying the destination of the request
   * @param data Request content
   * @param config Optional configuration object
   * @return a [[HttpPromise promise]] of an response
   */
  def post[T <: js.Any](url: String, data: js.Any = js.native, config: HttpConfig = js.native, headers: js.Dictionary[js.Any] = js.native, responseType: String = js.native): HttpPromise[T] = js.native

  /**
   * Shortcut method to perform a PUT request.
   * @param url Relative or absolute URL specifying the destination of the request
   * @param config Optional configuration object
   * @param data Request content
   * @return a [[HttpPromise promise]] of an response
   */
  def put[T <: js.Any](url: String, data: js.Any = js.native, config: HttpConfig = js.native, headers: js.Dictionary[js.Any] = js.native, responseType: String = js.native): HttpPromise[T] = js.native

  /**
   * Shortcut method to perform a PATCH request.
   * @param url Relative or absolute URL specifying the destination of the request
   * @param data Request content
   * @param config Optional configuration object
   * @return a [[HttpPromise promise]] of an response
   */
  def patch[T <: js.Any](url: String, data: js.Any = js.native, config: HttpConfig = js.native, headers: js.Dictionary[js.Any] = js.native, responseType: String = js.native): HttpPromise[T] = js.native

}

/**
 * HTTP Provider Service - Use \$httpProvider to change the default behavior of the [[Http \$http]] service.
 * @author lawrence.daniels@gmail.com
 */
@js.native
trait HttpProvider extends Provider[Http] {

  /**
   * Configure $http service to combine processing of multiple http responses received at around the
   * same time via \$rootScope.\$applyAsync. This can result in significant performance improvement for
   * bigger applications that make many HTTP requests concurrently (common during application bootstrap).
   *
   * Defaults to false. If no value is specified, returns the current configured value.
   * @param value If true, when requests are loaded, they will schedule a deferred "apply" on the next tick,
   *              giving time for subsequent requests in a roughly ~10ms window to load and share the same digest cycle.
   * @return If a value is specified, returns the $httpProvider for chaining. otherwise, returns the current configured value.
   */
  def useApplyAsync(value: Boolean): this.type = js.native

  def useApplyAsync(): js.Any = js.native

  /**
   * Object containing default values for all $http requests.
   * @return
   */
  def defaults: js.Dictionary[Any] = js.native

  /**
   * Array containing service factories for all synchronous or asynchronous $http pre-processing of request or
   * postprocessing of responses.
   *
   * These service factories are ordered by request, i.e. they are applied in the same order as the array,
   * on request, but reverse order, on response.
   * @return
   * @see [[https://docs.angularjs.org/api/ng/service/\$http#interceptors]]
   */
  def interceptors: js.Array[js.Any] = js.native

}

/**
 * HTTP Response
 * The response object has these properties:
 * <ul>
 * <li>data – {string|Object} – The response body transformed with the transform functions.</li>
 * <li>status – {number} – HTTP status code of the response.</li>
 * <li>headers – {function([headerName])} – Header getter function.</li>
 * <li>config – {Object} – The configuration object that was used to generate the request.</li>
 * <li>statusText – {string} – HTTP status text of the response.</li>
 * </ul>
 */
@js.native
trait HttpResponse extends js.Object {
  var status: Int = js.native
  var statusText: String = js.native
  var data: js.Any = js.native
  var config: HttpConfig = js.native

  def headers(name: String): String = js.native

}

/**
 * HTTP Error
 * @author lawrence.daniels@gmail.com
 */
case class HttpError(status: HttpStatus, message: String) extends RuntimeException(message)