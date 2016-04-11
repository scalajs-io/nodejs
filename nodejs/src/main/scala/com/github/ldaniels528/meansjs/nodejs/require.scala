package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Node.js require function
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("require")
object require extends js.GlobalScope {

  def apply[T <: js.Any](name: String): T = js.native

}
