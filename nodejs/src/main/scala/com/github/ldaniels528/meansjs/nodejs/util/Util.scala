package com.github.ldaniels528.meansjs.nodejs.util

import com.github.ldaniels528.meansjs.nodejs.fs.StatTime
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

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
trait Util extends js.Object {

  /**
    * Return a string representation of object, which is useful for debugging.
    * @example util.inspect(object[, options])
    */
  def inspect(`object`: js.Any, options: Util.InspectOptions): StatTime

  /**
    * Returns true if the given "object" is an Array. Otherwise, returns false.
    * <p/><b>NOTE</b>Internal alias for Array.isArray.
    * @example util.isArray(object)
    */
  def isArray(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is a Boolean. Otherwise, returns false.
    * @example util.isBoolean(object)
    */
  def isBoolean(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is a Buffer. Otherwise, returns false.
    * @example util.isBuffer(object)
    */
  def isBuffer(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is a Date. Otherwise, returns false.
    * @example util.isDate(object)
    */
  def isDate(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is an Error. Otherwise, returns false.
    * @example util.isError(object)
    */
  def isError(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is a Function. Otherwise, returns false.
    * @example util.isFunction(object)
    */
  def isFunction(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is strictly null. Otherwise, returns false.
    * @example util.isNull(object)
    */
  def isNull(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is null or undefined. Otherwise, returns false.
    * @example util.isNullOrUndefined(object)
    */
  def isNullOrUndefined(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is a Number. Otherwise, returns false.
    * @example util.isNumber(object)
    */
  def isNumber(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is strictly an Object and not a Function. Otherwise, returns false.
    * @example util.isObject(object)
    */
  def isObject(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is a primitive type. Otherwise, returns false.
    * @example util.isPrimitive(object)
    */
  def isPrimitive(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is a RegExp. Otherwise, returns false.
    * @example util.isRegExp(object)
    */
  def isRegExp(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is a String. Otherwise, returns false.
    * @example util.isString(object)
    */
  def isString(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is a Symbol. Otherwise, returns false.
    * @example util.isSymbol(object)
    */
  def isSymbol(`object`: js.Any): Boolean

  /**
    * Returns true if the given "object" is undefined. Otherwise, returns false.
    * @example util.isUndefined(object)
    */
  def isUndefined(`object`: js.Any): Boolean

  /**
    * Output with timestamp on stdout.
    * @example util.log(string)
    */
  def log(message: String): Unit

  /**
    * Deprecated predecessor of console.log.
    * @example util.print([...])
    */
  @deprecated("Use console.log() instead", "4.x")
  def print(args: js.Array[js.Any]): Unit

  /**
    * Deprecated predecessor of stream.pipe().
    * @example util.pump(readableStream, writableStream[, callback])
    */
  @deprecated("Use ReadableStream.pipe(WritableStream)", "4.x")
  def pump(readableStream: js.Any, writableStream: js.Any, callback: js.Function): Unit

  /**
    * Deprecated predecessor of console.log.
    * @example util.puts([...])
    */
  @deprecated("Use console.log() instead", "4.x")
  def puts(args: js.Array[js.Any]): Unit

}

/**
  * Util Companion
  * @author lawrence.daniels@gmail.com
  */
object Util {

  /**
    * Inspect Options
    * @author lawrence.daniels@gmail.com
    * @see [[https://nodejs.org/api/util.html#util_util_inspect_object_options]]
    */
  @js.native
  trait InspectOptions extends js.Object {
    var showHidden: js.UndefOr[Boolean]
    var depth: js.UndefOr[Number]
    var colors: js.UndefOr[Boolean]
    var customInspect: js.UndefOr[Boolean]
  }

  /**
    * Inspect Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object InspectOptions {

    def apply(showHidden: js.UndefOr[Boolean] = js.undefined,
              depth: js.UndefOr[Number] = js.undefined,
              colors: js.UndefOr[Boolean] = js.undefined,
              customInspect: js.UndefOr[Boolean] = js.undefined) = {
      val options = makeNew[InspectOptions]
      options.showHidden = showHidden
      options.depth = depth
      options.colors = colors
      options.customInspect = customInspect
      options
    }

  }

}