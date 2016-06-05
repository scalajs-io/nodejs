package com.github.ldaniels528.meansjs.angularjs

import com.github.ldaniels528.meansjs.angularjs.ResourceOptions.MethodOptions
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Resource Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ResourceOptions extends js.Object {
  var update: MethodOptions = js.native
}

/**
  * Resource Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ResourceOptions {

  @ScalaJSDefined
  class MethodOptions(var method: String = null) extends js.Object

  def apply(update: MethodOptions) = {
    val options = New[ResourceOptions]
    options.update = update
    options
  }

}