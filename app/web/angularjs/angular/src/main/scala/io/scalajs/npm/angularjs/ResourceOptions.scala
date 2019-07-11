package io.scalajs.npm.angularjs

import io.scalajs.FlexibleOptions
import io.scalajs.npm.angularjs.ResourceOptions.MethodOptions

import scala.scalajs.js

/**
  * Resource Options
  * @author lawrence.daniels@gmail.com
  */
class ResourceOptions(var update: js.UndefOr[MethodOptions] = js.undefined) extends js.Object

/**
  * Resource Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ResourceOptions extends FlexibleOptions[ResourceOptions] {

  /**
    * Method Options
    * @author lawrence.daniels@gmail.com
    */
  class MethodOptions(var method: js.UndefOr[String] = js.undefined) extends js.Object

  /**
    * Method Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object MethodOptions extends FlexibleOptions[MethodOptions]

}