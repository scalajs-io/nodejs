package com.github.ldaniels528.meansjs.angularjs.http

import com.github.ldaniels528.meansjs.angularjs.angular
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.{Future, Promise}
import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.UndefOr

/**
  * HTTP Response/Promise
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpResponse[+T] extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * HTTP status code of the response.
    */
  def status: StatusCode = js.native

  /**
    * HTTP status text of the response.
    */
  def statusText: String = js.native

  /**
    * The response body transformed with the transform functions (String| Object).
    */
  def data: T = js.native

  /**
    * The configuration object that was used to generate the request.
    */
  def config: HttpConfig = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def headers(name: String): String = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Promise-related Methods
  /////////////////////////////////////////////////////////////////////////////////

  def error(callback: js.Function): HttpResponse[T] = js.native

  def error(callback: js.Function1[js.Any, Any]): HttpResponse[T] = js.native

  def error(callback: js.Function2[js.Any, StatusCode, Any]): HttpResponse[T] = js.native

  def error(callback: js.Function3[js.Any, js.Any, StatusCode, Any]): HttpResponse[T] = js.native

  def error(callback: js.Function4[js.Any, StatusCode, HttpConfig, js.Any, Any]): HttpResponse[T] = js.native

  def error(callback: js.Function5[js.Any, StatusCode, HttpConfig, js.Any, UndefOr[String], Any]): HttpResponse[T] = js.native

  def success(callback: js.Function): HttpResponse[T] = js.native

  def success(callback: js.Function1[T, Any]): HttpResponse[T] = js.native

  def success(callback: js.Function2[T, StatusCode, Any]): HttpResponse[T] = js.native

  def success(callback: js.Function3[T, js.Any, StatusCode, Any]): HttpResponse[T] = js.native

  def success(callback: js.Function4[T, StatusCode, HttpConfig, js.Any, Any]): HttpResponse[T] = js.native

  def success(callback: js.Function5[T, StatusCode, HttpConfig, js.Any, js.Any, Any]): HttpResponse[T] = js.native

  def `then`(success: js.Function1[T, Any], 
             failure: js.Function1[js.Any, Any] = js.native, 
             callback: js.Function = js.native): HttpResponse[T] = js.native

}

/**
  * HTTP Response Companion
  * @author lawrence.daniels@gmail.com
  */
object HttpResponse {

  /**
    * Implicit conversion to transform an HTTP response into a Promise
    * @param response the given [[HttpResponse HTTP response]]
    * @return the [[Promise promise]]
    */
  implicit def promise2future[T](response: HttpResponse[T]): Future[T] = {
    val promise = Promise[T]()
    response
      .success(promise.success _)
      .error((data: js.Any, status: StatusCode, config: HttpConfig, headers: js.Any, statusText: UndefOr[String]) => {
        promise failure new HttpError(status, statusText.flat getOrElse s"Failed to process HTTP request: '${angular.toJson(data)}'")
      })
    promise.future
  }

  /**
    * HTTP Response Extensions
    * @param response the given [[HttpResponse HTTP response]]
    */
  implicit class HttpResponseExtensions[T](val response: HttpResponse[T]) extends AnyVal {

    def toFuture: Future[T] = response

  }

}
