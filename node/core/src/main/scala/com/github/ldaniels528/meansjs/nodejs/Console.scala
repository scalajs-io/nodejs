package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js

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
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Console extends js.Object {

  /**
    * A simple assertion test that verifies whether value is truthy. If it is not, an AssertionError is thrown.
    * If provided, the error message is formatted using util.format() and used as the error message.
    * @example console.assert(value[, message][, ...])
    */
  def assert(value: js.Any, message: String, args: js.Any*): Unit = js.native

  /**
    * A simple assertion test that verifies whether value is truthy. If it is not, an AssertionError is thrown.
    * If provided, the error message is formatted using util.format() and used as the error message.
    * @example console.assert(value[, message][, ...])
    */
  def assert(value: js.Any, args: js.Any*): Unit = js.native

  /**
    * Uses util.inspect() on obj and prints the resulting string to stdout.
    * This function bypasses any custom inspect() function defined on obj
    * @example console.dir(obj[, options])
    */
  def dir(obj: js.Any, options: ConsoleDirOptions): Unit = js.native

  /**
    * Uses util.inspect() on obj and prints the resulting string to stdout.
    * This function bypasses any custom inspect() function defined on obj
    * @example console.dir(obj[, options])
    */
  def dir(obj: js.Any): Unit = js.native

  /**
    * Prints to stderr with newline. Multiple arguments can be passed, with the first used as the primary message and
    * all additional used as substitution values similar to printf(3) (the arguments are all passed to util.format()).
    * @param data the given data arguments
    * @example console.error([data][, ...])
    */
  def error(data: js.Any, args: js.Any*): Unit = js.native

  /**
    * The console.info() function is an alias for console.log().
    * @example console.info([data][, ...])
    */
  def info(data: js.Any, args: js.Any*): Unit = js.native

  /**
    * Prints to stdout with newline. Multiple arguments can be passed, with the first used as the primary message and
    * all additional used as substitution values similar to printf(3) (the arguments are all passed to util.format()).
    * @param data the given data arguments
    * @example console.log([data][, ...])
    */
  def log(data: js.Any, args: js.Any*): Unit = js.native

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
    * Prints to stderr the string 'Trace :', followed by the util.format() formatted message and stack trace to the
    * current position in the code.
    * @example console.trace(message[, ...])
    */
  def trace(message: String, args: js.Any*): Unit = js.native

  /**
    * Prints to stdout with newline. Multiple arguments can be passed, with the first used as the primary message and
    * all additional used as substitution values similar to printf(3) (the arguments are all passed to util.format()).
    * @param data the given data arguments
    * @example console.log([data][, ...])
    */
  def warn(data: js.Any, args: js.Any*): Unit = js.native

}
