package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Node.js require function
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Require extends js.Any {

  def apply[T](name: String): T = js.native

}
