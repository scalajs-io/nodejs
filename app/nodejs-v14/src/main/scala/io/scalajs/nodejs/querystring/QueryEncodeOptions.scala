package io.scalajs.nodejs.querystring

import scala.scalajs.js

trait QueryEncodeOptions extends js.Object {

  /** The function to use when converting URL-unsafe characters to percent-encoding in
    * the query string. Defaults to querystring.escape().
    */
  var encodeURIComponent: js.UndefOr[js.Function] = js.undefined
}
