package io.scalajs.nodejs.querystring

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait QueryDecodeOptions extends js.Object {

  /** The function to use when decoding percent-encoded characters in the query string.
    * Defaults to querystring.unescape().
    */
  var decodeURIComponent: js.UndefOr[js.Function] = js.undefined

  /** Specifies the maximum number of keys to parse. Defaults to 1000. Specify 0 to remove key counting limitations.
    * The querystring.parse() method parses a URL query string into a collection of key and value pairs.
    */
  var maxKeys: js.UndefOr[Int] = js.undefined
}
