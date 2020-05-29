package io.scalajs.nodejs.console_module

import io.scalajs.nodejs.stream.IWritable
import io.scalajs.nodejs.util.InspectOptions
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.|

@Factory
trait ConsoleOptions extends js.Object {
  var stdout: IWritable
  var stderr: js.UndefOr[IWritable] = js.undefined

  /** Ignore errors when writing to the underlying streams.
    *  Defaults to `true`.
    */
  var ignoreErrors: js.UndefOr[Boolean] = js.undefined

  /** Set color support for this `Console` instance.
    * Setting to `true` enables coloring while inspecting values,
    * setting to `'auto'` will make color support depend on the value of the `isTTY` property and the value returned by `getColorDepth()` on the respective stream.
    * This option can not be used, if `inspectOptions.colors` is set as well.
    * Defaults to `'auto'`.
    */
  var colorMode: js.UndefOr[Boolean | String] = js.undefined

  /** Specifies options that are passed along to [[io.scalajs.nodejs.util.Util.inspect()]].
    * Node.js v11.7.0.
    */
  var inspectOptions: js.UndefOr[InspectOptions] = js.undefined

  /** Set group indentation. Default: 2.
    * Node.js v14.2.0.
    */
  var groupIndentation: js.UndefOr[Int] = js.undefined
}
