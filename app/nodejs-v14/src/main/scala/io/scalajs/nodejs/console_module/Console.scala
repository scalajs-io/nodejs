package io.scalajs.nodejs.console_module

import io.scalajs.nodejs.stream.IWritable

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSImport}

/**
  * The console module provides a simple debugging console that is similar to the JavaScript console mechanism
  * provided by web browsers.
  *
  * The module exports two specific components:
  * <ul>
  * <li>A `Console` class with methods such as `console.log()`,` console.error()` and `console.warn()` that can be used
  * to write to any Node.js stream.</li>
  * <li>A global `console` instance configured to write to `process.stdout` and `process.stderr`.
  * The global `console` can be used without calling `require('console')`.</li>
  * </ul>
  *
  * Warning: The global console object's methods are neither consistently synchronous like the browser APIs
  * they resemble, nor are they consistently asynchronous like all other Node.js streams.
  * See the note on process I/O for more information.
  *
  * @see https://nodejs.org/api/console.html
  */
@js.native
@JSImport("console", "Console")
class Console protected () extends js.Object {
  def this(stdout: IWritable, stderr: IWritable = js.native, ignoreErrors: Boolean = true) = this()

  def this(options: ConsoleOptions) = this()

  /**
    * A simple assertion test that verifies whether `value` is truthy.
    * If it is not, an `AssertionError` is thrown.
    * If provided, the error `message` is formatted using `util.format()` and used as the error message.
    * @param value The value tested for being truthy
    * @param message The error message
    * @param optionalParams The arguments passed to `message`
    */
  def assert(value: js.Any, message: String, optionalParams: Any*): Unit = js.native

  /**
    * A simple assertion test that verifies whether `value` is truthy.
    * If it is not, an `AssertionError` is thrown.
    * If provided, the error `message` is formatted using `util.format()` and used as the error message.
    * @param value The value tested for being truthy
    * @param optionalParams The arguments passed to the error message
    */
  def assert(value: js.Any, optionalParams: Any*): Unit = js.native

  /**
    * When `stdout` is a TTY, calling `console.clear()` will attempt to clear the TTY.
    * When `stdout` is not a TTY, this method does nothing.
    *
    * The specific operation of `console.clear()` can vary across operating systems and terminal types.
    * For most Linux operating systems, `console.clear()` operates similarly to the clear shell command.
    * On Windows, `console.clear()` will clear only the output in the current terminal viewport for the Node.js binary.
    */
  def clear(): Unit = js.native

  /**
    * Maintains an internal counter specific to `label` and outputs to `stdout` the number of times `console.count()` has been called with the given `label`.
    * @param label The display label for the counter. Default: 'default'.
    */
  def count(label: String = js.native): Unit = js.native

  /**
    * Resets the internal counter specific to `label`.
    * @param label The display label for the counter. Default: 'default'.
    */
  def countReset(label: String = js.native): Unit = js.native

  /**
    * The `console.debug()` function is an alias for `console.log()`.
    * @param message
    * @param optionalParams
    */
  def debug(message: js.Any, optionalParams: Any*): Unit = js.native

  /**
    * Uses [[io.scalajs.nodejs.util.Util.inspect()]] on `obj` and prints the resulting string to `stdout`.
    * This function bypasses any custom `inspect()` function defined on `obj`.
    */
  def dir(obj: js.Any, options: ConsoleDirOptions = js.native): Unit = js.native

  /**
    * This method calls[[log()]] passing it the arguments received.
    * Please note that this method does not produce any XML formatting
    */
  def dirxml(data: js.Any*): Unit = js.native

  /**
    * Prints to `stderr` with newline.
    * Multiple arguments can be passed, with the first used as the primary message and all additional used as
    * substitution values similar to `printf(3)` (the arguments are all passed to [[io.scalajs.nodejs.util.Util.format()]].
    *
    * If formatting elements (e.g. `%d`) are not found in the first string then[[io.scalajs.nodejs.util.Util.inspect()]]
    * is called on each argument and the resulting string values are concatenated. See [[io.scalajs.nodejs.util.Util.format()]]
    * for more information.
    *
    * @param message
    * @param optionalParams
    */
  def error(message: js.Any, optionalParams: Any*): Unit = js.native

  /**
    * Increases indentation of subsequent lines by two spaces.
    *
    * If one or more `label`s are provided, those are printed first without the additional indentation.
    *
    * @param label
    */
  def group(label: Any*): Unit = js.native

  /**
    * An alias for [[group()]]
    * @param label
    */
  def groupCollapsed(label: js.Any*): Unit = js.native

  /**
    * Decreases indentation of subsequent lines by two spaces.
    */
  def groupEnd(): Unit = js.native

  /**
    * The `console.info()` function is an alias for [[log()]].
    */
  def info(message: js.Any, optionalParams: js.Any*): Unit = js.native

  /**
    * Prints to `stdout` with newline.
    * Multiple arguments can be passed, with the first used as the primary message and all additional used as
    * substitution values similar to `printf(3)` (the arguments are all passed to `util.format()`).
    */
  def log(message: js.Any, optionalParams: Any*): Unit = js.native

  /**
    * Try to construct a table with the columns of the properties of `tabularData` (or use `properties`) and
    * rows of `tabularData` and log it.
    * Falls back to just logging the argument if it can’t be parsed as tabular.
    * @param tabularData
    * @param properties Alternate properties for constructing the table.
    */
  def table(tabularData: js.Any, properties: js.Array[String] = js.native): Unit = js.native

  /**
    * Starts a timer that can be used to compute the duration of an operation.
    * Timers are identified by a unique `label`.
    * Use the same `label` when calling [[timeEnd()]] to stop the timer and output the elapsed time in milliseconds to
    * `stdout`.
    * Timer durations are accurate to the sub-millisecond.
    */
  def time(label: String = js.native): Unit = js.native

  /**
    * Stops a timer that was previously started by calling [[time()]] and prints the result to `stdout`.
    */
  def timeEnd(label: String = js.native): Unit = js.native

  /**
    * Stops a timer that was previously started by calling [[time()]] and prints the result to `.stdout`.`
    */
  def timeLog(label: String, data: js.Any*): Unit = js.native

  /**
    * Prints to `stderr` the string `'Trace: '`, followed by the [[io.scalajs.nodejs.util.Util.format()]] formatted
    * message and stack trace to the current position in the code.
    */
  def trace(message: js.Any, optionalParams: js.Any*): Unit = js.native

  /**
    * The `console.warn()` function is an alias for [[error()]
    */
  def warn(message: js.Any, optionalParams: js.Any*): Unit = js.native

  /**
    * This method does not display anything unless used in the inspector.
    * The `console.profile()` method starts a JavaScript CPU profile with an optional label until [[profileEnd()]] is called.
    * The profile is then added to the **Profile** panel of the inspector.
    */
  def profile(label: String = js.native): Unit = js.native

  /**
    * This method does not display anything unless used in the inspector.
    * Stops the current JavaScript CPU profiling session if one has been started and prints the report to the **Profiles** panel of the inspector.
    * See [[profile()]] for an example.
    *
    * If this method is called without a label, the most recently started profile is stopped.
    */
  def profileEnd(label: String = js.native): Unit = js.native

  /**
    * This method does not display anything unless used in the inspector.
    * The `console.timeStamp()` method adds an event with the label `'label'` to the **Timeline** panel of the inspector.
    */
  def timeStamp(label: String = js.native): Unit = js.native
}

/**
  * A global `Console` instance configured to write to [[io.scalajs.nodejs.process.Process.stdout]] and [[io.scalajs.nodejs.process.Process.stderr]].
  */
@js.native
@JSGlobal("console")
object Console extends Console
