package io.scalajs.npm.angularjs.http

import scala.language.implicitConversions
import scala.scalajs.js

/**
  * The \$http service is a core Angular service that facilitates communication
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
  def apply[T <: js.Any](config: HttpConfig): HttpResponse[T] = js.native

  /**
    * Relative or absolute URL specifying the destination of the request
    * @param url    Relative or absolute URL specifying the destination of the request
    * @param config Optional configuration object
    * @return a [[HttpResponse promise]] of an response
    */
  def get[T <: js.Any](url: String, config: HttpConfig = js.native, headers: js.Dictionary[js.Any] = js.native): HttpResponse[T] = js.native

  /**
    * Shortcut method to perform a DELETE request.
    * @param url    Relative or absolute URL specifying the destination of the request
    * @param data   Request content
    * @param config Optional configuration object
    * @return a [[HttpResponse promise]] of an response
    */
  def delete[T <: js.Any](url: String, data: js.Any = js.native, config: HttpConfig = js.native, headers: js.Dictionary[js.Any] = js.native): HttpResponse[T] = js.native

  /**
    * Shortcut method to perform a HEAD request.
    * @param url    Relative or absolute URL specifying the destination of the request
    * @param config Optional configuration object
    * @return a [[HttpResponse promise]] of an response
    */
  def head[T <: js.Any](url: String, config: HttpConfig = js.native): HttpResponse[T] = js.native

  /**
    * Shortcut method to perform a JSONP request.
    * @param url    Relative or absolute URL specifying the destination of the request
    * @param config Optional configuration object
    * @return a [[HttpResponse promise]] of an response
    */
  def jsonp[T <: js.Any](url: String, config: HttpConfig = js.native): HttpResponse[T] = js.native

  /**
    * Shortcut method to perform a POST request.
    * @param url    Relative or absolute URL specifying the destination of the request
    * @param data   Request content
    * @param config Optional configuration object
    * @return a [[HttpResponse promise]] of an response
    */
  def post[T <: js.Any](url: String, data: js.Any = js.native, config: HttpConfig = js.native, headers: js.Dictionary[js.Any] = js.native, responseType: String = js.native): HttpResponse[T] = js.native

  /**
    * Shortcut method to perform a PUT request.
    * @param url    Relative or absolute URL specifying the destination of the request
    * @param config Optional configuration object
    * @param data   Request content
    * @return a [[HttpResponse promise]] of an response
    */
  def put[T <: js.Any](url: String, data: js.Any = js.native, config: HttpConfig = js.native, headers: js.Dictionary[js.Any] = js.native, responseType: String = js.native): HttpResponse[T] = js.native

  /**
    * Shortcut method to perform a PATCH request.
    * @param url    Relative or absolute URL specifying the destination of the request
    * @param data   Request content
    * @param config Optional configuration object
    * @return a [[HttpResponse promise]] of an response
    */
  def patch[T <: js.Any](url: String, data: js.Any = js.native, config: HttpConfig = js.native, headers: js.Dictionary[js.Any] = js.native, responseType: String = js.native): HttpResponse[T] = js.native

}
