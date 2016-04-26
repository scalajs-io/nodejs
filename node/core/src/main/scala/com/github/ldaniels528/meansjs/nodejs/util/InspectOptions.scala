package com.github.ldaniels528.meansjs.nodejs.util

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Inspect Options
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/util.html#util_util_inspect_object_options]]
  */
@ScalaJSDefined
class InspectOptions extends js.Object {
  var showHidden: js.UndefOr[Boolean] = _
  var depth: js.UndefOr[Number] = _
  var colors: js.UndefOr[Boolean] = _
  var customInspect: js.UndefOr[Boolean] = _
}

/**
  * Inspect Options Companion
  * @author lawrence.daniels@gmail.com
  */
object InspectOptions {

  def apply(showHidden: js.UndefOr[Boolean] = js.undefined,
            depth: js.UndefOr[Number] = js.undefined,
            colors: js.UndefOr[Boolean] = js.undefined,
            customInspect: js.UndefOr[Boolean] = js.undefined) = {
    val options = new InspectOptions()
    options.showHidden = showHidden
    options.depth = depth
    options.colors = colors
    options.customInspect = customInspect
    options
  }

}
