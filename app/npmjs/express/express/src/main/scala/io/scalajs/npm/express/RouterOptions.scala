package io.scalajs.npm.express

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Router Options
  * @param caseSensitive
  * @param mergeParams
  * @param strict
  */
class RouterOptions(var caseSensitive: js.UndefOr[Boolean] = js.undefined,
                    var mergeParams: js.UndefOr[Boolean] = js.undefined,
                    var strict: js.UndefOr[Boolean] = js.undefined)
  extends js.Object

/**
  * Router Options Companion
  * @author lawrence.daniels@gmail.com
  */
object RouterOptions extends FlexibleOptions[RouterOptions]