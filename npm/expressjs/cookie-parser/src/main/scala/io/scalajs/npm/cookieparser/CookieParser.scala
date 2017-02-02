package io.scalajs.npm.cookieparser

import io.scalajs.RawOptions
import io.scalajs.npm.cookie.DeserializationOptions
import io.scalajs.npm.express.{Request, Response}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * cookie-parser - cookie parsing with signatures
  * Parse Cookie header and populate req.cookies with an object keyed by the cookie names.
  * Optionally you may enable signed cookie support by passing a secret string, which assigns req.secret
  * so it may be used by other middleware.
  * @version 1.4.3
  * @see https://www.npmjs.com/package/cookie-parser
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CookieParser extends js.Object {

  /**
    *
    * @param secret  a string or array used for signing cookies. This is optional and if not specified,
    *                will not parse signed cookies. If a string is provided, this is used as the secret.
    *                If an array is provided, an attempt will be made to unsign the cookie with each secret in order.
    * @param options an object that is passed to cookie.parse as the second option.
    * @return a middleware function
    */
  def apply(
      secret: String | js.Array[String] = js.native,
      options: DeserializationOptions | RawOptions = js.native): js.Function3[Request, Response, js.Function, Any] =
    js.native

  /**
    * Parse a cookie value as a JSON cookie. This will return the parsed JSON value if it was a JSON cookie,
    * otherwise it will return the passed value.
    * @param str the given cookie value
    * @return the parsed JSON value if it was a JSON cookie, otherwise it will return the passed value
    */
  def JSONCookie(str: String): js.UndefOr[js.Any] = js.native

  /**
    * Given an object, this will iterate over the keys and call JSONCookie on each value.
    * This will return the same object passed in.
    * @param cookies the given object
    * @return the same object passed in
    */
  def JSONCookies(cookies: js.Any): js.Any = js.native

  /**
    * Parse a cookie value as a signed cookie. This will return the parsed unsigned value if it was a signed cookie
    * and the signature was valid, otherwise it will return the passed value.
    * @param str    a cookie value
    * @param secret can be an array or string. If a string is provided, this is used as the secret.
    *               If an array is provided, an attempt will be made to unsign the cookie with each secret in order.
    * @return the passed value.
    */
  def signedCookie(str: String, secret: String | js.Array[String]): js.Any = js.native

  /**
    * Given an object, this will iterate over the keys and check if any value is a signed cookie.
    * If it is a signed cookie and the signature is valid, the key will be deleted from the object and added
    * to the new object that is returned.
    * @param cookies an object
    * @param secret  can be an array or string. If a string is provided, this is used as the secret.
    *                If an array is provided, an attempt will be made to unsign the cookie with each secret in order.
    * @return the new object
    */
  def signedCookies(cookies: js.Any, secret: String | js.Array[String]): js.Any = js.native

}

/**
  * CookieParser Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("cookie-parser", JSImport.Namespace)
object CookieParser extends CookieParser
