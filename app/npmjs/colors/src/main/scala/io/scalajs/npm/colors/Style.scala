package io.scalajs.npm.colors

import scala.scalajs.js

/**
  * Colors Style
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Style extends js.Object {

  def value: js.Function1[String, Colors] = js.native

}
