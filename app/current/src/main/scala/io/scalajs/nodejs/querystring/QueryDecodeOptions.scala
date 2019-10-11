package io.scalajs.nodejs.querystring

import scala.scalajs.js

/**
  * Query String Decode Options
  * @param decodeURIComponent The function to use when decoding percent-encoded characters in the query string.
  *                           Defaults to querystring.unescape().
  * @param maxKeys            Specifies the maximum number of keys to parse. Defaults to 1000. Specify 0 to remove
  *                           key counting limitations. The querystring.parse() method parses a URL query string (str)
  *                           into a collection of key and value pairs.
  */
class QueryDecodeOptions(var decodeURIComponent: js.UndefOr[js.Function] = js.undefined,
                         var maxKeys: js.UndefOr[Int] = js.undefined)
    extends js.Object
