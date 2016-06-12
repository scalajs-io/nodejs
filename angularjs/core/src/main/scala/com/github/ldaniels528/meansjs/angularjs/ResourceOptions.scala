package com.github.ldaniels528.meansjs.angularjs

import com.github.ldaniels528.meansjs.angularjs.ResourceOptions.MethodOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Resource Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ResourceOptions(var update: js.UndefOr[MethodOptions] = js.undefined) extends js.Object

/**
  * Resource Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ResourceOptions {

  @ScalaJSDefined
  class MethodOptions(var method: String = null) extends js.Object

}