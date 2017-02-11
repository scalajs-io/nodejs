package io.scalajs.dom.html.browser

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
class Console extends js.Object {

  /**
    * Prints to stderr with newline. Multiple arguments can be passed, with the first used as the primary message and
    * all additional used as substitution values similar to printf(3) (the arguments are all passed to util.format()).
    * @param data the given data arguments
    * @example console.error([data][, ...])
    */
  def error(data: js.Any, args: Any*): Unit = js.native

  /**
    * The console.info() function is an alias for console.log().
    * @example console.info([data][, ...])
    */
  def info(data: js.Any, args: Any*): Unit = js.native

  /**
    * Prints to stdout with newline. Multiple arguments can be passed, with the first used as the primary message and
    * all additional used as substitution values similar to printf(3) (the arguments are all passed to util.format()).
    * @param data the given data arguments
    * @example console.log([data][, ...])
    */
  def log(data: js.Any, args: Any*): Unit = js.native

  /**
    * Prints to stdout with newline. Multiple arguments can be passed, with the first used as the primary message and
    * all additional used as substitution values similar to printf(3) (the arguments are all passed to util.format()).
    * @param data the given data arguments
    * @example console.log([data][, ...])
    */
  def warn(data: js.Any, args: Any*): Unit = js.native

}
