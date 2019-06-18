package io.scalajs.npm.angularjs

import io.scalajs.RawOptions
import io.scalajs.npm.angularjs.ResourceOptions.MethodOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Resource Options
  * @author lawrence.daniels@gmail.com
  */

class ResourceOptions(var update: js.UndefOr[MethodOptions | RawOptions] = js.undefined) extends js.Object

/**
  * Resource Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ResourceOptions {

  class MethodOptions(var method: js.UndefOr[String] = js.undefined) extends js.Object

}