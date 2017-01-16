package io.scalajs.nodejs.util

import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.fs.Stats
import io.scalajs.nodejs.{NodeOptions, stream}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * These functions are in the module 'util'. Use require('util') to access them.
  * The util module is primarily designed to support the needs of Node.js's internal APIs.
  * Many of these utilities are useful for your own programs. If you find that these functions
  * are lacking for your purposes, however, you are encouraged to write your own utilities.
  * We are not interested in any future additions to the util module that are unnecessary
  * for Node.js's internal functionality.
  * @version 7.4.0
  * @see https://nodejs.org/api/util.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Util extends IEventEmitter {

  /**
    * Deprecated predecessor of console.error.
    * @example util.debug(string)
    */
  @deprecated("Use console.debug() instead.", "4.0.0")
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
  @deprecated("Use console.error() instead.", "4.0.0")
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
    * The util.inspect() method returns a string representation of object that is primarily useful for debugging.
    * Additional options may be passed that alter certain aspects of the formatted string.
    * @param `object` any JavaScript primitive or Object.
    * @param options  the given [[InspectOptions inspect options]]
    * @example util.inspect(object[, options])
    */
  def inspect(`object`: js.Any, options: InspectOptions | NodeOptions = js.native): Stats = js.native

  /**
    * Returns true if the given "object" is an Array. Otherwise, returns false.
    * <p/><b>NOTE</b>Internal alias for Array.isArray.
    * @example util.isArray(object)
    */
  @deprecated("Internal alias for Array.isArray.", "4.0.0")
  def isArray(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Boolean. Otherwise, returns false.
    * @example util.isBoolean(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isBoolean(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Buffer. Otherwise, returns false.
    * @example util.isBuffer(object)
    */
  @deprecated("Use Buffer.isBuffer() instead.", "4.0.0")
  def isBuffer(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Date. Otherwise, returns false.
    * @example util.isDate(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isDate(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is an Error. Otherwise, returns false.
    * @example util.isError(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isError(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Function. Otherwise, returns false.
    * @example util.isFunction(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isFunction(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is strictly null. Otherwise, returns false.
    * @example util.isNull(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isNull(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is null or undefined. Otherwise, returns false.
    * @example util.isNullOrUndefined(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isNullOrUndefined(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Number. Otherwise, returns false.
    * @example util.isNumber(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isNumber(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is strictly an Object and not a Function. Otherwise, returns false.
    * @example util.isObject(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isObject(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a primitive type. Otherwise, returns false.
    * @example util.isPrimitive(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isPrimitive(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a RegExp. Otherwise, returns false.
    * @example util.isRegExp(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isRegExp(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a String. Otherwise, returns false.
    * @example util.isString(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isString(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is a Symbol. Otherwise, returns false.
    * @example util.isSymbol(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isSymbol(`object`: js.Any): Boolean = js.native

  /**
    * Returns true if the given "object" is undefined. Otherwise, returns false.
    * @example util.isUndefined(object)
    */
  @deprecated("Alternative not specified", "4.0.0")
  def isUndefined(`object`: js.Any): Boolean = js.native

  /**
    * Output with timestamp on stdout.
    * @example util.log(string)
    */
  @deprecated("Use a third party module instead.", "6.0.0")
  def log(message: String): Unit = js.native

  /**
    * Deprecated predecessor of console.log.
    * @example util.print([...])
    */
  @deprecated("Use console.log() instead", "0.11.3")
  def print(args: js.Array[js.Any]): Unit = js.native

  /**
    * Deprecated predecessor of stream.pipe().
    * @example util.pump(readableStream, Writable[, callback])
    */
  @deprecated("Use ReadableStream.pipe(Writable)", "4.0.0")
  def pump(readableStream: stream.Readable, Writable: stream.Writable, callback: js.Function): Unit = js.native

  /**
    * Deprecated predecessor of console.log.
    * @example util.puts([...])
    */
  @deprecated("Use console.log() instead.", "0.11.3")
  def puts(args: js.Array[String] | String*): Unit = js.native

  /**
    * The util._extend() method was never intended to be used outside of internal Node.js modules.
    * The community found and used it anyway. It is deprecated and should not be used in new code.
    * JavaScript comes with very similar built-in functionality through Object.assign().
    * @example util._extend(target, source)
    */
  @deprecated("Use Object.assign() instead.", "6.0.0")
  def _extend[A <: js.Any, B <: js.Any, C <: js.Any](target: A, source: B): C = js.native

}

/**
  * Util Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("util", JSImport.Namespace)
object Util extends Util