package io.scalajs.npm.toughcookie

import scala.scalajs.js

/**
  * Cookie Store
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CookieStore extends js.Object {

  def version: String = js.native

  def storeType: String = js.native

  def rejectPublicSuffixes: Boolean = js.native

  def cookies: js.Array[Cookie] = js.native

}
