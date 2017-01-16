package io.scalajs.nodejs.util

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Inspect Options
  * @param showHidden     If true, the object's non-enumerable symbols and properties will be included in the
  *                       formatted result. Defaults to false.
  * @param depth          Specifies the number of times to recurse while formatting the object. This is useful
  *                       for inspecting large complicated objects. Defaults to 2. To make it recurse indefinitely pass null.
  * @param colors         If true, the output will be styled with ANSI color codes. Defaults to false. Colors are customizable,
  *                       see Customizing util.inspect colors.
  * @param customInspect  If false, then custom inspect(depth, opts) functions exported on the object being inspected
  *                       will not be called. Defaults to true.
  * @param showProxy      If true, then objects and functions that are Proxy objects will be introspected to show their
  *                       target and handler objects. Defaults to false.
  * @param maxArrayLength Specifies the maximum number of array and TypedArray elements to include when formatting.
  *                       Defaults to 100. Set to null to show all array elements. Set to 0 or negative to show no array elements.
  * @param breakLength    The length at which an object's keys are split across multiple lines. Set to Infinity to
  *                       format an object as a single line. Defaults to 60 for legacy compatibility.
  * @see [[https://nodejs.org/api/util.html#util_util_inspect_object_options]]
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class InspectOptions(var showHidden: js.UndefOr[Boolean] = js.undefined,
                     var depth: js.UndefOr[Int] = js.undefined,
                     var colors: js.UndefOr[Boolean] = js.undefined,
                     var customInspect: js.UndefOr[Boolean] = js.undefined,
                     var showProxy: js.UndefOr[Boolean] = js.undefined,
                     var maxArrayLength: js.UndefOr[Int] = js.undefined,
                     var breakLength: js.UndefOr[Int] = js.undefined) extends js.Object

