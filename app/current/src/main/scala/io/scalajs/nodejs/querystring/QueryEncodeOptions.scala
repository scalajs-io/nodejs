package io.scalajs.nodejs.querystring

import scala.scalajs.js

/**
  * Query String Encode Options
  * @param encodeURIComponent The function to use when converting URL-unsafe characters to percent-encoding in
  *                           the query string. Defaults to querystring.escape().
  */
class QueryEncodeOptions(var encodeURIComponent: js.UndefOr[js.Function] = js.undefined) extends js.Object
