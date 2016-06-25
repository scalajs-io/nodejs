package org.scalajs.nodejs
package util

import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.fs.Stats

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * These functions are in the module 'util'. Use require('util') to access them.
  * The util module is primarily designed to support the needs of Node.js's internal APIs.
  * Many of these utilities are useful for your own programs. If you find that these functions
  * are lacking for your purposes, however, you are encouraged to write your own utilities.
  * We are not interested in any future additions to the util module that are unnecessary
  * for Node.js's internal functionality.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Util extends NodeModule with EventEmitter {

  /**
    * Deprecated predecessor of console.error.
    * @example util.debug(string)
    */
  @deprecated("Use console.debug() instead.", "4.x")
  def debug(string: String): js.Any = js.native

  /**
    * This is used to create a function which conditionally writes to stderr based on the existence of a NODE_DEBUG
    * environment variable. If the section name appears in that environment variable, then the returned function will
    * be similar to console.error(). If not, then the returned function is a no-op.
    * @example util.debuglog(section)
    */
  def debuglog(section: String): js.Function = js.native

  /**
    * Marks that a method should not be used any more.
    * @example util.deprecate(function, string)
    */
  def deprecate(function: js.Function, string: String): js.Any = js.native

  /**
    * Deprecated predecessor of console.error.
    * @example util.error([...])
    */
  @deprecated("Use console.error() instead.", "4.x")
  def error(varargs: js.Any*): js.Any = js.native

  /**
    * Returns a formatted string using the first argument as a printf-like format.
    * @example util.format(format[, ...])
    */
  def format(format: js.Any*): String = js.native

  /**
    * Inherit the prototype methods from one constructor into another. The prototype of constructor will be set to a
    * new object created from superConstructor.
    *
    * As an additional convenience, superConstructor will be accessible through the constructor.super_ property.
    * @example util.inherits(constructor, superConstructor)
    */
  def inherits(constructor: js.Any, superConstructor: js.Any): js.Any = js.native

  /**
    * Return a string representation of object, which is useful for debugging.
    * @example util.inspect(object[, options])
    */
  def inspect(`object`: js.Any, options: InspectOptions | NodeOptions = null): Stats = js.native

  /**
    * Returns true if the given "object" is an Array. Otherwise, returns false.
    * <p/><b>NOTE</b>Internal alias for Array.isArray.
    * @example util.isArray(object)
    */
  def isArray(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Boolean. Otherwise, returns false.
    * @example util.isBoolean(object)
    */
  def isBoolean(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Buffer. Otherwise, returns false.
    * @example util.isBuffer(object)
    */
  def isBuffer(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Date. Otherwise, returns false.
    * @example util.isDate(object)
    */
  def isDate(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is an Error. Otherwise, returns false.
    * @example util.isError(object)
    */
  def isError(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Function. Otherwise, returns false.
    * @example util.isFunction(object)
    */
  def isFunction(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is strictly null. Otherwise, returns false.
    * @example util.isNull(object)
    */
  def isNull(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is null or undefined. Otherwise, returns false.
    * @example util.isNullOrUndefined(object)
    */
  def isNullOrUndefined(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Number. Otherwise, returns false.
    * @example util.isNumber(object)
    */
  def isNumber(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is strictly an Object and not a Function. Otherwise, returns false.
    * @example util.isObject(object)
    */
  def isObject(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a primitive type. Otherwise, returns false.
    * @example util.isPrimitive(object)
    */
  def isPrimitive(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a RegExp. Otherwise, returns false.
    * @example util.isRegExp(object)
    */
  def isRegExp(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a String. Otherwise, returns false.
    * @example util.isString(object)
    */
  def isString(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Symbol. Otherwise, returns false.
    * @example util.isSymbol(object)
    */
  def isSymbol(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is undefined. Otherwise, returns false.
    * @example util.isUndefined(object)
    */
  def isUndefined(`object`: js.Any): Boolean = js.native

  /**
    * Output with timestamp on stdout.
    * @example util.log(string)
    */
  def log(message: String): Unit = js.native

  /**
    * Deprecated predecessor of console.log.
    * @example util.print([...])
    */
  @deprecated("Use console.log() instead", "4.x")
  def print(args: js.Array[js.Any]): Unit = js.native

  /**
    * Deprecated predecessor of stream.pipe().
    * @example util.pump(readableStream, writableStream[, callback])
    */
  @deprecated("Use ReadableStream.pipe(WritableStream)", "4.x")
  def pump(readableStream: js.Any, writableStream: js.Any, callback: js.Function): Unit = js.native

  /**
    * Deprecated predecessor of console.log.
    * @example util.puts([...])
    */
  @deprecated("Use console.log() instead", "4.x")
  def puts(args: js.Array[js.Any]): Unit = js.native

}

/**
  * Util Companion
  * @author lawrence.daniels@gmail.com
  */
object Util {

  /**
    * Convenience method for retrieving the util module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Util instance
    */
  def apply()(implicit require: NodeRequire) = require[Util]("util")

}