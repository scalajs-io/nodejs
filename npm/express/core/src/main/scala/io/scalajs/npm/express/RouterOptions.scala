package io.scalajs.npm.express

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Router Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class RouterOptions(var caseSensitive: js.UndefOr[Boolean] = js.undefined,
                    var mergeParams: js.UndefOr[Boolean] = js.undefined,
                    var strict: js.UndefOr[Boolean] = js.undefined) extends js.Object