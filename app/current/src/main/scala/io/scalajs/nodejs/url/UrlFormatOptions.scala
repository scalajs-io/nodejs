package io.scalajs.nodejs.url

import scala.scalajs.js

/**
  * URL Format Options
  *
  * @param auth     true if the serialized URL string should include the username and password, false otherwise. Defaults to true.
  * @param fragment true if the serialized URL string should include the fragment, false otherwise. Defaults to true.
  * @param search   true if the serialized URL string should include the search query, false otherwise. Defaults to true.
  * @param unicode  true if Unicode characters appearing in the host component of the URL string should be encoded
  *                 directly as opposed to being Punycode encoded. Defaults to false.
  */
class UrlFormatOptions(var auth: js.UndefOr[Boolean] = js.undefined,
                       var fragment: js.UndefOr[Boolean] = js.undefined,
                       var search: js.UndefOr[Boolean] = js.undefined,
                       var unicode: js.UndefOr[Boolean] = js.undefined
) extends js.Object
