package org.scalajs.dom.browser

import scala.scalajs.js

/**
  * JavaScript eval() Function
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Eval extends js.Object {

  def apply(expression: String): js.Any = js.native

}