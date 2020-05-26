package io.scalajs.nodejs.console_module

import io.scalajs.nodejs.stream.IWritable
import io.scalajs.nodejs.util.InspectOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  *
  * @param stdout
  * @param stderr
  * @param ignoreErrors Ignore errors when writing to the underlying streams. Defaults to `true`.
  * @param colorMode      Set color support for this `Console` instance.
  *                       Setting to `true` enables coloring while inspecting values,
  *                       setting to `'auto'` will make color support depend on the value of the `isTTY` property and the value returned by `getColorDepth()` on the respective stream.
  *                       This option can not be used, if `inspectOptions.colors` is set as well. Defaults to `'auto'`.
  * @param inspectOptions Specifies options that are passed along to [[io.scalajs.nodejs.util.Util.inspect()]].
  *                       Node.js v11.7.0.
  * @param groupIndentation Set group indentation. Default: 2.
  *                       Node.js v14.2.0.
  */
class ConsoleOptions(
    var stdout: IWritable,
    var stderr: js.UndefOr[IWritable] = js.undefined,
    var ignoreErrors: Boolean = true,
    var colorMode: Boolean | String = "auto",
    var inspectOptions: js.UndefOr[InspectOptions] = js.undefined,
    var groupIndentation: js.UndefOr[Int] = js.undefined
) extends js.Object
