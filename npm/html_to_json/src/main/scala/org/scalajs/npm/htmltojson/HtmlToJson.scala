package org.scalajs.npm.htmltojson

import org.scalajs.nodejs._
import org.scalajs.npm.htmltojson.HtmlToJson.{FilterOptions, ParseOptions, RequestOptions}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * Html-to-Json - Parses HTML strings into objects using flexible, composable filters.
  * @author Lawrence Daniels <lawrence.daniels@gmail.com>
  */
@js.native
trait HtmlToJson extends NodeModule {

  /**
    * The parse() method takes a string of HTML, and a filter, and responds with the filtered data.
    * This supports both callbacks and promises.
    * @example htmlToJson.parse(html, filter, [callback]) -> promise
    */
  def parse[T](html: String, options: ParseOptions): js.Promise[T] = js.native

  /**
    * The parse() method takes a string of HTML, and a filter, and responds with the filtered data.
    * This supports both callbacks and promises.
    * @example htmlToJson.parse(html, filter, [callback]) -> promise
    */
  def parse[T](html: String, options: ParseOptions, callback: js.Function2[errors.Error, T, Any]): Unit = js.native

  /**
    * The request() method takes options for a call to the request library and a filter, then returns the filtered response body.
    * @example request(requestOptions, filter, [callback]) -> promise
    */
  def request[T](url: String, filter: FilterOptions): js.Promise[T] = js.native

  /**
    * The request() method takes options for a call to the request library and a filter, then returns the filtered response body.
    * @example request(requestOptions, filter, [callback]) -> promise
    */
  def request[T](options: RequestOptions | js.Any, filter: FilterOptions): js.Promise[T] = js.native

  /**
    * The request() method takes options for a call to the request library and a filter, then returns the filtered response body.
    * @example request(requestOptions, filter, [callback]) -> promise
    */
  def request[T](options: RequestOptions | js.Any, filter: FilterOptions, callback: js.Function2[errors.Error, T, Any]): Unit = js.native

}

/**
  * Html-to-Json Companion
  * @author Lawrence Daniels <lawrence.daniels@gmail.com>
  */
object HtmlToJson {

  @inline
  def apply()(implicit require: NodeRequire) = require[HtmlToJson]("html-to-json")

  /**
    * Html-to-Json Document Options
    */
  @ScalaJSDefined
  class FilterOptions(var text: js.Function = null) extends js.Object

  /**
    * Html-to-Json Parse Options
    */
  @ScalaJSDefined
  class ParseOptions() extends js.Object

  /**
    * Html-to-Json Request Options
    */
  @ScalaJSDefined
  class RequestOptions() extends js.Object

}