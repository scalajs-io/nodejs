package io.scalajs.nodejs.querystring

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Query String
  * @version 7.4.0
  * @see https://nodejs.org/api/querystring.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("querystring", JSImport.Namespace)
object QueryString extends QueryString

/**
  * Query String Type Definition
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait QueryString extends js.Object {

  /**
    * The querystring.escape() method performs URL percent-encoding on the given str in a manner that is optimized
    * for the specific requirements of URL query strings.
    *
    * The querystring.escape() method is used by querystring.stringify() and is generally not expected to be used
    * directly. It is exported primarily to allow application code to provide a replacement percent-encoding
    * implementation if necessary by assigning querystring.escape to an alternative function.
    * @param str the given string to escape
    * @return
    */
  def escape(str: String): String = js.native

  /**
    * The querystring.parse() method parses a URL query string (str) into a collection of key and value pairs.
    * @param str     The URL query string to parse
    * @param sep     The substring used to delimit key and value pairs in the query string. Defaults to '&'.
    * @param eq      The substring used to delimit keys and values in the query string. Defaults to '='.
    * @param options The given [[QueryDecodeOptions options]]
    * @return a mapping of the key-value pairs
    */
  def parse(str: String, sep: String = js.native, eq: String = js.native, options: QueryDecodeOptions | RawOptions = js.native): js.Dictionary[String] = js.native

  /**
    * The querystring.stringify() method produces a URL query string from a given obj by iterating through the
    * object's "own properties".
    * @param obj     The object to serialize into a URL query string
    * @param sep     The substring used to delimit key and value pairs in the query string. Defaults to '&'.
    * @param eq      The substring used to delimit keys and values in the query string. Defaults to '='.
    * @param options The given [[QueryEncodeOptions options]]
    */
  def stringify(obj: js.Any, sep: String = js.native, eq: String = js.native, options: QueryEncodeOptions | RawOptions = js.native): String = js.native

  /**
    * The querystring.unescape() method performs decoding of URL percent-encoded characters on the given str.
    *
    * The querystring.unescape() method is used by querystring.parse() and is generally not expected to be used directly.
    * It is exported primarily to allow application code to provide a replacement decoding implementation if necessary
    * by assigning querystring.unescape to an alternative function.
    *
    * By default, the querystring.unescape() method will attempt to use the JavaScript built-in decodeURIComponent()
    * method to decode. If that fails, a safer equivalent that does not throw on malformed URLs will be used.
    * @param str the given string to unescape
    * @return
    */
  def unescape(str: String): String = js.native

}
