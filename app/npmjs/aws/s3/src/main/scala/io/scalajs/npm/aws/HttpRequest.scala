package io.scalajs.npm.aws

import scala.scalajs.js

/**
  * Represents an Http Request
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpRequest extends js.Object {

  /**
    * The part of the path excluding the query string.
    */
  def pathname(): String = js.native

  /**
    * The query string portion of the path.
    */
  def search: String = js.native

  /**
    * The request body payload.
    */
  def body: String = js.native

  /**
    * The endpoint for the request.
    */
  def endpoint: Endpoint = js.native

  /**
    * A map of header keys and their respective values.
    */
  def headers: HttpHeaders = js.native

  /**
    * The HTTP method of the request.
    */
  def method: String = js.native

  /**
    * The path portion of the URI, e.g., "/list/?start=5&num=10".
    */
  def path: String = js.native

}
