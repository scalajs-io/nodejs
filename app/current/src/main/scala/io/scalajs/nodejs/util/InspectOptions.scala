package io.scalajs.nodejs.util

import scala.scalajs.js
import scala.scalajs.js.|

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
  * @param compact        For Node.js v9.9.0+
  * @param sorted         For Node.js v10.12.0+
  * @param getters        For Node.js v11.5.0+
  * @param maxStringLength Fot Node.js v14.0.0+ Specifies the maximum number of characters to include when formatting. Set to null or Infinity to show all elements.                       @
  *
  * @see [[https://nodejs.org/api/util.html#util_util_inspect_object_options]]
  */
class InspectOptions(var showHidden: js.UndefOr[Boolean] = false,
                     var depth: Int = 2,
                     var colors: Boolean = false,
                     var customInspect: Boolean = true,
                     var showProxy: Boolean = false,
                     var maxArrayLength: js.UndefOr[Int] = 100,
                     var breakLength: Int = 80,
                     var compact: js.UndefOr[Boolean | Int] = 3,
                     var sorted: js.UndefOr[Boolean | js.Function2[String, String, Int]] = js.undefined,
                     var getters: js.UndefOr[Boolean | String] = false,
                     var maxStringLength: js.UndefOr[Int] = js.undefined
) extends js.Object
