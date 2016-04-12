package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js

/**
  * Node.js require function
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Require extends js.Any {

  def apply[T](name: String): T = js.native

}

/**
  * Require Companion
  * @author lawrence.daniels@gmail.com
  */
object Require {
  def require = js.Dynamic.global.require.asInstanceOf[Require]

}