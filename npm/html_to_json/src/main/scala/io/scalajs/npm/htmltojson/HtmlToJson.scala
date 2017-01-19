package io.scalajs.npm
package htmltojson

import io.scalajs.RawOptions
import io.scalajs.nodejs.Error

import scala.language.existentials
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Html-to-Json - Parses HTML strings into objects using flexible, composable filters.
  * @version 0.6.0
  * @see https://www.npmjs.com/package/html-to-json
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HtmlToJson extends js.Object {

  /**
    * Performs many parsing operations against one HTML string. This transforms the HTML into a DOM only once
    * instead of for each filter in the dictionary, which can quickly get expensive in terms of processing.
    * This also allows you to break your filters up into more granular components and mix and match them as you please.
    *
    * The values in the dictionary can be htmlToJson.Parser objects, generated methods from htmlToJson.createMethod,
    * or naked filters that you might normally pass into htmlToJson.parse.
    * @param html       the HTML string
    * @param dictionary a dictionary containing the elements to be processed
    * @param callback   the optional callback
    * @return a [[js.Promise promise]]
    * @example {{{ htmlToJson.batch(html, dictionary, [callback]) -> promise }}}
    */
  def batch[T <: js.Any](html: String, dictionary: js.Dictionary[_], callback: js.Function2[Error, T, Any] = js.native): js.Promise[T] = js.native

  /**
    * Generates a method that wraps the passed filter argument. The generated method takes an HTML string
    * and processes it against that filter.
    * @param filter the given filter array
    * @return
    * @example {{{ htmlToJson.createMethod(filter) -> function (html, [callback]) }}}
    */
  def createMethod[T](filter: js.Array[_], callback: js.Function2[Error, T, Any] = js.native): js.Any = js.native

  /**
    * For the sake of reusability, creates an object with .parse and .request helper methods, which use the passed filter.
    * @param filter the given filter array
    * @return a [[js.Promise promise]]
    * @example {{{ htmlToJson.createParser(filter) }}}
    * @example {{{ new htmlToJson.Parser(filter) }}}
    */
  def createParser[T <: js.Any](filter: js.Array[_]): js.Promise[T] = js.native

  /**
    * The parse() method takes a string of HTML, and a filter, and responds with the filtered data.
    * This supports both callbacks and promises.
    * @example {{{ htmlToJson.parse(html, filter, [callback]) -> promise }}}
    */
  def parse[T <: js.Any](html: String, filter: FilterOptions | RawOptions, callback: js.Function2[Error, T, Any] = js.native): js.Promise[T] = js.native

  /**
    * The request() method takes options for a call to the request library and a filter, then returns the filtered response body.
    * @example {{{ htmlToJson.request(requestOptions, filter, [callback]) -> promise }}}
    */
  def request[T <: js.Any](request: String | RequestOptions, filter: FilterOptions | RawOptions, callback: js.Function2[Error, T, Any] = js.native): js.Promise[T] = js.native

}

/**
  * Html-to-Json Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("html-to-json", JSImport.Namespace)
object HtmlToJson extends HtmlToJson