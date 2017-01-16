package io.scalajs.npm.jsdom

import scala.scalajs.js

/**
  * Cookie Jar
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CookieJar extends js.Object {
  var enableLooseMode: Boolean = js.native

}
