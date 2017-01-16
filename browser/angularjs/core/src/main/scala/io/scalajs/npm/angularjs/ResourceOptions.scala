package io.scalajs.npm.angularjs

import io.scalajs.npm.angularjs.ResourceOptions.MethodOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * Resource Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ResourceOptions(var update: js.UndefOr[MethodOptions | AngularOptions] = js.undefined) extends js.Object

/**
  * Resource Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ResourceOptions {

  @ScalaJSDefined
  class MethodOptions(var method: js.UndefOr[String] = js.undefined) extends js.Object

}