package io.scalajs.nodejs.querystring

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Query String Encode Options
  * @param encodeURIComponent The function to use when converting URL-unsafe characters to percent-encoding in
  *                           the query string. Defaults to querystring.escape().
  * @author lawrence.daniels@gmail.com
  */
class QueryEncodeOptions(var encodeURIComponent: js.UndefOr[js.Function] = js.undefined) extends js.Object

/**
  * Query Encode Options Companion
  * @author lawrence.daniels@gmail.com
  */
object QueryEncodeOptions extends FlexibleOptions[QueryEncodeOptions]