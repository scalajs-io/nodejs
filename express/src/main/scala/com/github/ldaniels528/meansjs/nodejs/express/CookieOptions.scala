package com.github.ldaniels528.meansjs.nodejs.express

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Cookie Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CookieOptions extends js.Object {
  /** Domain name for the cookie. Defaults to the domain name of the app. */
  var domain: js.UndefOr[String]

  /** A synchronous function used for cookie value encoding. Defaults to encodeURIComponent. */
  var encode: js.UndefOr[js.Function]

  /** Expiry date of the cookie in GMT. If not specified or set to 0, creates a session cookie. */
  var expires: js.UndefOr[js.Date]

  /** Flags the cookie to be accessible only by the web server. */
  var httpOnly: js.UndefOr[Boolean]

  /** Convenient option for setting the expiry time relative to the current time in milliseconds. */
  var maxAge: js.UndefOr[String]

  /** Path for the cookie. Defaults to “/”. */
  var path: js.UndefOr[String]

  /** Marks the cookie to be used with HTTPS only. */
  var secure: js.UndefOr[Boolean]

  /** Indicates if the cookie should be signed. */
  var signed: js.UndefOr[Boolean]
}

/**
  * Cookie Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CookieOptions {

  def apply(domain: js.UndefOr[String] = js.undefined,
            encode: js.UndefOr[js.Function] = js.undefined,
            expires: js.UndefOr[js.Date] = js.undefined,
            httpOnly: js.UndefOr[Boolean] = js.undefined,
            maxAge: js.UndefOr[String] = js.undefined,
            path: js.UndefOr[String] = js.undefined,
            secure: js.UndefOr[Boolean] = js.undefined,
            signed: js.UndefOr[Boolean] = js.undefined) = {
    val options = makeNew[CookieOptions]
    options.domain = domain
    options.encode = encode
    options.expires = expires
    options.httpOnly = httpOnly
    options.maxAge = maxAge
    options.path = path
    options.secure = secure
    options.signed = signed
    options
  }

}
