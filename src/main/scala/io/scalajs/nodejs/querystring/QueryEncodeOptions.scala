package io.scalajs.nodejs.querystring

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Query String Encode Options
  * @param encodeURIComponent The function to use when converting URL-unsafe characters to percent-encoding in
  *                           the query string. Defaults to querystring.escape().
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class QueryEncodeOptions(val encodeURIComponent: js.UndefOr[js.Function] = js.undefined) extends js.Object
