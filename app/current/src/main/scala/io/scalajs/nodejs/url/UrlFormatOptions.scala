package io.scalajs.nodejs.url

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait UrlFormatOptions extends js.Object {

  /** true if the serialized URL string should include the username and password, false otherwise. Defaults to true.
    */
  var auth: js.UndefOr[Boolean] = js.undefined

  /** true if the serialized URL string should include the fragment, false otherwise.
    * Defaults to true.
    */
  var fragment: js.UndefOr[Boolean] = js.undefined

  /** true if the serialized URL string should include the search query, false otherwise.
    * Defaults to true.
    */
  var search: js.UndefOr[Boolean] = js.undefined

  /** true if Unicode characters appearing in the host component of the URL string should be encoded
    * directly as opposed to being Punycode encoded. Defaults to false.
    */
  var unicode: js.UndefOr[Boolean] = js.undefined
}
