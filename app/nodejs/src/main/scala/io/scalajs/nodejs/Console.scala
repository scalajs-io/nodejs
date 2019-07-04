package io.scalajs.nodejs

import io.scalajs.nodejs.stream.Writable

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * The console module provides a simple debugging console that is similar to the JavaScript console mechanism
  * provided by web browsers.
  *
  * The module exports two specific components:
  * <ul>
  * <li>A Console class with methods such as console.log(), console.error() and console.warn() that can be used to
  * write to any Node.js stream.</li>
  * <li>A global console instance configured to write to stdout and stderr. Because this object is global, it can be
  * used without calling require('console').</li>
  * </ul>
  * @see https://nodejs.org/api/console.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("console", "Console")
class Console(stdout: Writable, stderr: Writable = js.native, ignoreErrors: Boolean = js.native) extends js.Object {

  def this(options: ConsoleOptions) = this(null, null)

  /**
    * A simple assertion test that verifies whether value is truthy. If it is not, an AssertionError is thrown.
    * If provided, the error message is formatted using util.format() and used as the error message.
    * @example console.assert(value[, message][, ...])
    */
  def assert(value: js.Any, message: String*): Unit = js.native

  /**
    * When stdout is a TTY, calling console.clear() will attempt to clear the TTY. When stdout is not a TTY,
    * this method does nothing.
    *
    * Note: The specific operation of console.clear() can vary across operating systems and terminal types.
    * For most Linux operating systems, console.clear() operates similarly to the clear shell command.
    * On Windows, console.clear() will clear only the output in the current terminal viewport for the Node.js binary.
    */
  def clear(): Unit = js.native

  /**
    * Maintains an internal counter specific to label and outputs to stdout the number of times console.count()
    * has been called with the given label.
    * @param label the display label for the counter. Defaults to 'default'.
    */
  def count(label: String = js.native): Unit = js.native

  /**
    * Resets the internal counter specific to label.
    * @param label the display label for the counter. Defaults to 'default'.
    */
  def countReset(label: String = js.native): Unit = js.native

  /**
    * The console.debug() function is an alias for console.log().
    * @param data the data/object
    * @param args the optional arguments
    * @example console.debug(data[, ...args])
    */
  def debug(data: js.Any, args: js.Any*): Unit = js.native

  /**
    * Uses util.inspect() on obj and prints the resulting string to stdout.
    * This function bypasses any custom inspect() function defined on obj
    * @example console.dir(obj[, options])
    */
  def dir(obj: js.Any, options: ConsoleDirOptions = js.native): Unit = js.native

  /**
    * This method calls console.log() passing it the arguments received. Please note that this method does not produce
    * any XML formatting.
    * @param data the data/object
    * @example console.dirxml(...data)
    */
  def dirxml(data: js.Any*): Unit = js.native

  /**
    * Prints to stderr with newline. Multiple arguments can be passed, with the first used as the primary message and
    * all additional used as substitution values similar to printf(3) (the arguments are all passed to util.format()).
    * @param args the given data and/or arguments
    * @example console.error([data][, ...])
    */
  def error(args: js.Any*): Unit = js.native

  /**
    * Increases indentation of subsequent lines by two spaces.
    * If one or more labels are provided, those are printed first without the additional indentation.
    * @param label the labels
    */
  def group(label: js.Any*): Unit = js.native

  /**
    * An alias for console.group().
    */
  def groupCollapsed(): Unit = js.native

  /**
    * Decreases indentation of subsequent lines by two spaces.
    */
  def groupEnd(): Unit = js.native

  /**
    * The console.info() function is an alias for console.log().
    * @example console.info([data][, ...])
    */
  def info(data: js.Any, args: Any*): Unit = js.native

  /**
    * Prints to stdout with newline. Multiple arguments can be passed, with the first used as the primary message and
    * all additional used as substitution values similar to printf(3) (the arguments are all passed to util.format()).
    * @param args the given data and/or arguments
    * @example console.log([data][, ...])
    */
  def log(args: Any*): Unit = js.native

  /**
    * Try to construct a table with the columns of the properties of tabularData (or use properties) and rows of
    * tabularData and log it. Falls back to just logging the argument if it can’t be parsed as tabular.
    * @param tabularData the tabular data
    * @param properties  Alternate properties for constructing the table.
    * @example console.table(tabularData[, properties])
    * @example {{{
    * console.table([{ a: 1, b: 'Y' }, { a: 'Z', b: 2 }]);
    * // ┌─────────┬─────┬─────┐
    * // │ (index) │  a  │  b  │
    * // ├─────────┼─────┼─────┤
    * // │    0    │  1  │ 'Y' │
    * // │    1    │ 'Z' │  2  │
    * // └─────────┴─────┴─────┘
    *
    * console.table([{ a: 1, b: 'Y' }, { a: 'Z', b: 2 }], ['a']);
    * // ┌─────────┬─────┐
    * // │ (index) │  a  │
    * // ├─────────┼─────┤
    * // │    0    │  1  │
    * // │    1    │ 'Z' │
    * // └─────────┴─────┘
    * }}}
    */
  def table(tabularData: js.Any, properties: String*): Unit = js.native

  /**
    * Starts a timer that can be used to compute the duration of an operation. Timers are identified by a unique label.
    * Use the same label when you call console.timeEnd() to stop the timer and output the elapsed time in milliseconds
    * to stdout. Timer durations are accurate to the sub-millisecond.
    * @example console.time(label)
    */
  def time(label: String): Unit = js.native

  /**
    * Stops a timer that was previously started by calling console.time() and prints the result to stdout
    * @example console.timeEnd(label)
    */
  def timeEnd(label: String): Unit = js.native

  /**
    * For a timer that was previously started by calling console.time(), prints the elapsed time and other
    * data arguments to stdout:
    * @example {{{
    *   console.time('process');
    *   const value = expensiveProcess1(); // Returns 42
    *   console.timeLog('process', value);
    *   // Prints "process: 365.227ms 42".
    *   doExpensiveProcess2(value);
    *   console.timeEnd('process');
    * }}}
    * @param args the label and/or data
    * @example console.timeLog([label][, ...data])
    */
  def timeLog(args: js.Any*): Unit = js.native

  /**
    * Prints to stderr the string 'Trace :', followed by the util.format() formatted message and stack trace to the
    * current position in the code.
    * @example console.trace(message[, ...])
    */
  def trace(message: String, args: Any*): Unit = js.native

  /**
    * Prints to stdout with newline. Multiple arguments can be passed, with the first used as the primary message and
    * all additional used as substitution values similar to printf(3) (the arguments are all passed to util.format()).
    * @param args the given data and/or arguments
    * @example console.log([data][, ...])
    */
  def warn(args: Any*): Unit = js.native

}

/**
  * Console Options
  * @param stdout         a [[Writable]] representing STDOUT
  * @param stderr         a [[Writable]] representing STDERR
  * @param ignoreErrors   Ignore errors when writing to the underlying streams. Default: true.
  * @param colorMode      Set color support for this Console instance. Setting to true enables coloring while
  *                       inspecting values, setting to 'auto' will make color support depend on the value of the
  *                       isTTY property and the value returned by getColorDepth() on the respective stream. This
  *                       option can not be used, if inspectOptions.colors is set as well. Default: 'auto'.
  * @param inspectOptions Specifies options that are passed along to util.inspect().
  */
class ConsoleOptions(var stdout: js.UndefOr[Writable] = js.undefined,
                     var stderr: js.UndefOr[Writable] = js.undefined,
                     var ignoreErrors: js.UndefOr[Boolean] = js.undefined,
                     var colorMode: js.UndefOr[Boolean | String] = js.undefined,
                     var inspectOptions: js.Any = js.undefined) extends js.Object

/**
  * Console Dir Options
  * @param showHidden if true then the object's non-enumerable and symbol properties will be shown too. Defaults to false.
  * @param depth      tells util.inspect() how many times to recurse while formatting the object. This is useful for
  *                   inspecting large complicated objects. Defaults to 2. To make it recurse indefinitely, pass null.
  * @param colors     if true, then the output will be styled with ANSI color codes. Defaults to false. Colors are customizable;
  *                   see customizing util.inspect() colors.
  */
class ConsoleDirOptions(var showHidden: js.UndefOr[Boolean] = js.undefined,
                        var depth: js.UndefOr[Int] = js.undefined,
                        var colors: js.UndefOr[Boolean] = js.undefined) extends js.Object