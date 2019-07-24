package io.scalajs.nodejs.util

import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}
import scala.scalajs.js.|

/**
  * These functions are in the module 'util'. Use require('util') to access them.
  * The util module is primarily designed to support the needs of Node.js's internal APIs.
  * Many of these utilities are useful for your own programs. If you find that these functions
  * are lacking for your purposes, however, you are encouraged to write your own utilities.
  * We are not interested in any future additions to the util module that are unnecessary
  * for Node.js's internal functionality.
  * @see https://nodejs.org/api/util.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Util extends IEventEmitter {

  /**
    * Takes an async function (or a function that returns a Promise) and returns a function following the
    * error-first callback style, i.e. taking an (err, value) => ... callback as the last argument. In the
    * callback, the first argument will be the rejection reason (or null if the Promise resolved), and the
    * second argument will be the resolved value.
    * @example util.callbackify(original)
    * @param original An async function
    * @return a callback style function
    */
  @JSName("callbackify")
  def callbackifyJS[E <: js.Error, Z](original: js.Promise[Z]): js.Function2[E, Z, Any] = js.native

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
  def inspect(`object`: js.Any, options: InspectOptions = js.native): String = js.native

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
    * Returns true if there is deep strict equality between val1 and val2. Otherwise, returns false.
    * @example util.isDeepStrictEqual(val1, val2)
    * @return true if there is deep strict equality between val1 and val2.
    * @see [[io.scalajs.nodejs.Assert#deepStrictEqual()]]
    * @since 9.0.0
    */
  def isDeepStrictEqual(val1: js.Any, val2: js.Any): Boolean = js.native

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
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[Y, Z](f: js.Function1[CBF[Y, Z], Any]): js.Function0[js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, Y, Z](f: js.Function2[A, CBF[Y, Z], Any]): js.Function1[A, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, Y, Z](f: js.Function3[A, B, CBF[Y, Z], Any]): js.Function2[A, B, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, Y, Z](f: js.Function4[A, B, C, CBF[Y, Z], Any]): js.Function3[A, B, C, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, Y, Z](f: js.Function5[A, B, C, D, CBF[Y, Z], Any]): js.Function4[A, B, C, D, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, Y, Z](f: js.Function6[A, B, C, D, E, CBF[Y, Z], Any]): js.Function5[A, B, C, D, E, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, Y, Z](f: js.Function7[A, B, C, D, E, F, CBF[Y, Z], Any]): js.Function6[A, B, C, D, E, F, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, Y, Z](f: js.Function8[A, B, C, D, E, F, G, CBF[Y, Z], Any]): js.Function7[A, B, C, D, E, F, G, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, Y, Z](f: js.Function9[A, B, C, D, E, F, G, H, CBF[Y, Z], Any]): js.Function8[A, B, C, D, E, F, G, H, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, Y, Z](f: js.Function10[A, B, C, D, E, F, G, H, I, CBF[Y, Z], Any]): js.Function9[A, B, C, D, E, F, G, H, I, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, Y, Z](f: js.Function11[A, B, C, D, E, F, G, H, I, J, CBF[Y, Z], Any]): js.Function10[A, B, C, D, E, F, G, H, I, J, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, Y, Z](f: js.Function12[A, B, C, D, E, F, G, H, I, J, K, CBF[Y, Z], Any]): js.Function11[A, B, C, D, E, F, G, H, I, J, K, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, L, Y, Z](f: js.Function13[A, B, C, D, E, F, G, H, I, J, K, L, CBF[Y, Z], Any]): js.Function12[A, B, C, D, E, F, G, H, I, J, K, L, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, L, M, Y, Z](f: js.Function14[A, B, C, D, E, F, G, H, I, J, K, L, M, CBF[Y, Z], Any]): js.Function13[A, B, C, D, E, F, G, H, I, J, K, L, M, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, L, M, N, Y, Z](f: js.Function15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, CBF[Y, Z], Any]): js.Function14[A, B, C, D, E, F, G, H, I, J, K, L, M, N, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, Y, Z](f: js.Function16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, CBF[Y, Z], Any]): js.Function15[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Y, Z](f: js.Function17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, CBF[Y, Z], Any]): js.Function16[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, Y, Z](f: js.Function18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, CBF[Y, Z], Any]): js.Function17[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, Y, Z](f: js.Function19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, CBF[Y, Z], Any]): js.Function18[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, Y, Z](f: js.Function20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, CBF[Y, Z], Any]): js.Function19[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, Y, Z](f: js.Function21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, CBF[Y, Z], Any]): js.Function20[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, js.Promise[Z]] = js.native

  /**
    * Takes a function following the common error-first callback style, i.e. taking an (err, value) => ... callback
    * as the last argument, and returns a version that returns promises.
    * @example util.promisify(original)
    * @param f the function
    * @return the promise of the callback value
    */
  def promisify[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, Y, Z](f: js.Function22[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U,CBF[Y, Z], Any]): js.Function21[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T,U, js.Promise[Z]] = js.native

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