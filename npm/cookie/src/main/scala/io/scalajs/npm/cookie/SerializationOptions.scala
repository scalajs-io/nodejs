package io.scalajs.npm.cookie

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * Cookie Deserialization Options
  * @param domain   Specifies the value for the Domain Set-Cookie attribute. By default, no domain is set,
  *                 and most clients will consider the cookie to apply to only the current domain.
  * @param encode   Specifies a function that will be used to encode a cookie's value. Since value of a cookie
  *                 has a limited character set (and must be a simple string), this function can be used to
  *                 encode a value into a string suited for a cookie's value.
  *
  *                 The default function is the global ecodeURIComponent, which will encode a JavaScript string
  *                 into UTF-8 byte sequences and then URL-encode any that fall outside of the cookie range.
  * @param expires  Specifies the Date object to be the value for the Expires Set-Cookie attribute. By default,
  *                 no expiration is set, and most clients will consider this a "non-persistent cookie" and will
  *                 delete it on a condition like exiting a web browser application.
  *
  *                 Note: the cookie storage model specification states that if both expires and magAge are set,
  *                 then maxAge takes precedence, but it is possible not all clients by obey this, so if both
  *                 are set, they should point to the same date and time.
  * @param httpOnly Specifies the boolean value for the [HttpOnly Set-Cookie attribute][rfc-6266-5.2.6].
  *                 When truthy, the HttpOnly attribute is set, otherwise it is not. By default, the HttpOnly
  *                 attribute is not set.
  *
  *                 Note: be careful when setting this to true, as compliant clients will not allow client-side
  *                 JavaScript to see the cookie in document.cookie.
  * @param maxAge   Specifies the number (in seconds) to be the value for the Max-Age Set-Cookie attribute.
  *                 The given number will be converted to an integer by rounding down. By default, no maximum age is set.
  *
  *                 Note: the cookie storage model specification states that if both expires and magAge are set,
  *                 then maxAge takes precedence, but it is possiblke not all clients by obey this, so if both are set,
  *                 they should point to the same date and time.
  * @param path     Specifies the value for the Path Set-Cookie attribute. By default, the path is considered
  *                 the "default path". By default, no maximum age is set, and most clients will consider this a
  *                 "non-persistent cookie" and will delete it on a condition like exiting a web browser application.
  * @param sameSite Specifies the boolean or string to be the value for the SameSite Set-Cookie attribute.
  *                 <ul>
  *                 <li>true will set the SameSite attribute to Strict for strict same site enforcement.</li>
  *                 <li>false will not set the SameSite attribute.</li>
  *                 <li>'lax' will set the SameSite attribute to Lax for lax same site enforcement.</li>
  *                 <li>'strict' will set the SameSite attribute to Strict for strict same site enforcement.</li>
  *                 </ul>
  *                 More information about the different enforcement levels can be found in the specification
  *                 [[https://tools.ietf.org/html/draft-west-first-party-cookies-07#section-4.1.1]]
  *
  *                 Note: This is an attribute that has not yet been fully standardized, and may change in the future.
  *                 This also means many clients may ignore this attribute until they understand it.
  * @param secure   Specifies the boolean value for the [Secure Set-Cookie attribute][rfc-6266-5.2.5].
  *                 When truthy, the Secure attribute is set, otherwise it is not. By default, the Secure attribute
  *                 is not set.
  *
  *                 note be careful when setting this to true, as compliant clients will not send the cookie back to
  *                 the server in the future if the browser does not have an HTTPS connection.
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class SerializationOptions(var domain: js.UndefOr[String] = js.undefined,
                           var encode: js.UndefOr[js.Function] = js.undefined,
                           var expires: js.UndefOr[String] = js.undefined,
                           var httpOnly: js.UndefOr[Boolean] = js.undefined,
                           var maxAge: js.UndefOr[JsNumber] = js.undefined,
                           var path: js.UndefOr[String] = js.undefined,
                           var sameSite: js.UndefOr[Boolean | String] = js.undefined,
                           var secure: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
