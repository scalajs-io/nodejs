package io.scalajs.npm.express

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cookie Options
  * @param domain   Domain name for the cookie. Defaults to the domain name of the app.
  * @param encode   A synchronous function used for cookie value encoding. Defaults to encodeURIComponent.
  * @param expires  Expiry date of the cookie in GMT. If not specified or set to 0, creates a session cookie.
  * @param httpOnly Flags the cookie to be accessible only by the web server.
  * @param maxAge   Convenient option for setting the expiry time relative to the current time in milliseconds.
  * @param path     Path for the cookie. Defaults to “/”.
  * @param secure   Marks the cookie to be used with HTTPS only.
  * @param signed   Indicates if the cookie should be signed.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class CookieOptions(var domain: js.UndefOr[String] = js.undefined,
                    var encode: js.UndefOr[js.Function] = js.undefined,
                    var expires: js.UndefOr[js.Date] = js.undefined,
                    var httpOnly: js.UndefOr[Boolean] = js.undefined,
                    var maxAge: js.UndefOr[String] = js.undefined,
                    var path: js.UndefOr[String] = js.undefined,
                    var secure: js.UndefOr[Boolean] = js.undefined,
                    var signed: js.UndefOr[Boolean] = js.undefined) extends js.Object