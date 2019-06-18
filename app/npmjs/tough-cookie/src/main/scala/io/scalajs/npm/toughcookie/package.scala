package io.scalajs.npm

import io.scalajs.nodejs.Error

import scala.scalajs.js

/**
  * toughcookie package object
  * @author lawrence.daniels@gmail.com
  */
package object toughcookie {

  type CookieCallback[T] = js.Function2[Error, T, Any]

}
