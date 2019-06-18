package io.scalajs.npm.toughcookie

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Tough-Cookie
  * @see https://www.npmjs.com/package/tough-cookie
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("tough-cookie", JSImport.Namespace)
class Cookie(var key: String,
             var value: String,
             var domain: js.UndefOr[String] = js.native,
             var path: js.UndefOr[String] = js.native,
             var host: js.UndefOr[String] = js.native,
             var pathIsDefault: js.UndefOr[Boolean] = js.native,
             var creation: js.Date,
             var lastAccessed: js.UndefOr[js.Date] = js.native) extends js.Object {

  /**
    * Encode to a Cookie header value (i.e. the .key and .value properties joined with '=').
    */
  def cookieString(): String = js.native

  /**
    * Sets the expiry based on a date-string passed through parseDate().
    * If parseDate returns null (i.e. can't parse this date string), .expires
    * is set to "Infinity" (a string) is set.
    */
  def setExpires(expiration: String): Unit = js.native

  /**
    * Sets the maxAge in seconds. Coerces -Infinity to "-Infinity" and Infinity
    * to "Infinity" so it JSON serializes correctly.
    * @param age
    */
  def setMaxAge(age: Double): Unit = js.native

}

/**
  * Cookie Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("tough-cookie", JSImport.Namespace)
object Cookie extends js.Object {

  def fromJSON(string: String): js.Any = js.native

  def parse(header: js.Any): Cookie = js.native

}