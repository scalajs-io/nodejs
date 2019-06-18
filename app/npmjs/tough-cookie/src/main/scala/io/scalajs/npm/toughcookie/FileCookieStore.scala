package io.scalajs.npm.toughcookie

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Tough-Cookie File Cookie Store
  * @see https://github.com/mitsuru/tough-cookie-filestore
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("tough-cookie-filestore", JSImport.Namespace)
class FileCookieStore(path: String) extends CookieStore
