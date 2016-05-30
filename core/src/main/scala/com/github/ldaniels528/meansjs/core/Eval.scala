package com.github.ldaniels528.meansjs.core

import scala.scalajs.js

/**
  * JavaScript eval() Function
  * @author lawrence.daniels@gmail.com
  */
trait Eval extends js.Object {

  def apply(expression: String): js.Any = js.native

}