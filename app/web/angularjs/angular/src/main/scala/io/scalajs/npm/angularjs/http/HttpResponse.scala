package io.scalajs.npm.angularjs
package http

import scala.scalajs.js

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

}
