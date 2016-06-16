package org.scalajs.nodejs.util

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Inspect Options
  * @author lawrence.daniels@gmail.com
  * @see [[https://nodejs.org/api/util.html#util_util_inspect_object_options]]
  */
@ScalaJSDefined
class InspectOptions(var showHidden: js.UndefOr[Boolean] = js.undefined,
                     var depth: js.UndefOr[Number] = js.undefined,
                     var colors: js.UndefOr[Boolean] = js.undefined,
                     var customInspect: js.UndefOr[Boolean] = js.undefined) extends js.Object

