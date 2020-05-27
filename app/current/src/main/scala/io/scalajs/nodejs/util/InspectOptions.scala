package io.scalajs.nodejs.util

import com.thoughtworks.enableIf
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.|

/** @see [[https://nodejs.org/api/util.html#util_util_inspect_object_options]]
  */
@Factory
trait InspectOptions extends js.Object {

  /** If true, the object's non-enumerable symbols and properties will be included in the
    * formatted result. Defaults to false.
    */
  var showHidden: js.UndefOr[Boolean] = js.undefined

  /** Specifies the number of times to recurse while formatting the object. This is useful
    * for inspecting large complicated objects. Defaults to 2. To make it recurse indefinitely pass null.
    */
  var depth: js.UndefOr[Int] = js.undefined

  /** If true, the output will be styled with ANSI color codes. Defaults to false. Colors are customizable,
    * see Customizing util.inspect colors.
    */
  var colors: js.UndefOr[Boolean] = js.undefined

  /** If false, then custom inspect(depth, opts) functions exported on the object being inspected
    * will not be called. Defaults to true. */
  var customInspect: js.UndefOr[Boolean] = js.undefined

  /** If true, then objects and functions that are Proxy objects will be introspected to show their
    * target and handler objects. Defaults to false.
    */
  var showProxy: js.UndefOr[Boolean] = js.undefined

  /** Specifies the maximum number of array and TypedArray elements to include when formatting.
    * Defaults to 100. Set to null to show all array elements. Set to 0 or negative to show no array elements.
    */
  var maxArrayLength: js.UndefOr[Int] = js.undefined

  /** The length at which an object's keys are split across multiple lines. Set to Infinity to
    * format an object as a single line. Defaults to 60 for legacy compatibility.
    */
  var breakLength: js.UndefOr[Int] = js.undefined

  var compact: js.UndefOr[Boolean | Int] = js.undefined

  var sorted: js.UndefOr[Boolean | js.Function2[String, String, Int]] = js.undefined

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  var getters: js.UndefOr[Boolean | String] = js.undefined

  /** Fot Node.js v14.0.0+ Specifies the maximum number of characters to include when formatting.
    * Set to null or Infinity to show all elements.
    */
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  var maxStringLength: js.UndefOr[Int] = js.undefined
}
