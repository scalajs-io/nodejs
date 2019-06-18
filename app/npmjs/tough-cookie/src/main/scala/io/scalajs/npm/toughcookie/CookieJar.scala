package io.scalajs.npm.toughcookie

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Tough-Cookie Jar
  * @see https://www.npmjs.com/package/tough-cookie
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("tough-cookie", "CookieJar")
class CookieJar(cookieStore: CookieStore = js.native) extends js.Object {

  def getCookies(url: String): js.Array[Cookie] = js.native

  def getCookies(url: String, callback: CookieCallback[js.Array[Cookie]]): js.Array[Cookie] = js.native

  def getCookieString(url: String): String = js.native

  def getCookieString(url: String, callback: CookieCallback[String]): String = js.native

  def setCookie(cookie: Cookie, url: String): Unit = js.native

  def setCookie(cookie: Cookie, url: String, callback: CookieCallback[Cookie]): Unit = js.native

}