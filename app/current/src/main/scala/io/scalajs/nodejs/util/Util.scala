package io.scalajs.nodejs.util

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * These functions are in the module 'util'. Use require('util') to access them.
  * The util module is primarily designed to support the needs of Node.js's internal APIs.
  * Many of these utilities are useful for your own programs. If you find that these functions
  * are lacking for your purposes, however, you are encouraged to write your own utilities.
  * We are not interested in any future additions to the util module that are unnecessary
  * for Node.js's internal functionality.
  * @see https://nodejs.org/api/util.html
  */
@js.native
trait Util extends js.Object {

  /**
    * This is used to create a function which conditionally writes to stderr based on the existence of a NODE_DEBUG
    * environment variable. If the section name appears in that environment variable, then the returned function will
    * be similar to console.error(). If not, then the returned function is a no-op.
    * @example util.debuglog(section)
    */
  def debuglog(section: String): js.Function = js.native

  /**
    * Marks that a method should not be used any more.
    * @example util.deprecate(function, message)
    */
  def deprecate(function: js.Function, message: String, code: String = js.native): js.Any = js.native

  /**
    * Returns a formatted string using the first argument as a printf-like format.
    * @example util.format(format[, ...])
    */
  def format(format: String, args: js.Any*): String = js.native

  def formatWithOptions(inspectOptions: InspectOptions, format: String, args: js.Any*): String = js.native

  def getSystemErrorName(err: Int): String = js.native

  /**
    * Inherit the prototype methods from one constructor into another. The prototype of constructor will be set to a
    * new object created from superConstructor.
    *
    * As an additional convenience, superConstructor will be accessible through the constructor.super_ property.
    * @example util.inherits(constructor, superConstructor)
    */
  def inherits(constructor: js.Any, superConstructor: js.Any): js.Any = js.native

  val inspect: InspectObject = js.native

  def callbackify[T](original: js.Function): js.Function2[js.Any, T, Any] = js.native

  val promisify: PromisifyObject = js.native

  val types: UtilTypes = js.native

  def isDeepStrictEqual(val1: js.Any, val2: js.Any): Boolean = js.native
}

/**
  * Util Singleton
  */
@js.native
@JSImport("util", JSImport.Namespace)
object Util extends Util

@js.native
trait InspectObject extends js.Function2[js.Any, InspectOptions, String] with js.Function1[js.Any, String] {
  var defaultOptions: InspectOptions = js.native
  var styles: js.Dictionary[String]  = js.native

  val custom: js.Symbol = js.native
}

@js.native
trait PromisifyObject extends js.Function1[js.Function, js.Function] {
  val custom: js.Symbol = js.native
}

@js.native
trait UtilTypes extends js.Object {
  def isAnyArrayBuffer(value: js.Any): Boolean            = js.native
  def isArgumentsObject(value: js.Any): Boolean           = js.native
  def isArrayBuffer(value: js.Any): Boolean               = js.native
  def isAsyncFunction(value: js.Any): Boolean             = js.native
  def isBigInt64Array(value: js.Any): Boolean             = js.native
  def isBigUint64Array(value: js.Any): Boolean            = js.native
  def isBooleanObject(value: js.Any): Boolean             = js.native
  def isBoxedPrimitive(value: js.Any): Boolean            = js.native
  def isDataView(value: js.Any): Boolean                  = js.native
  def isDate(value: js.Any): Boolean                      = js.native
  def isExternal(value: js.Any): Boolean                  = js.native
  def isFloat32Array(value: js.Any): Boolean              = js.native
  def isFloat64Array(value: js.Any): Boolean              = js.native
  def isGeneratorFunction(value: js.Any): Boolean         = js.native
  def isGeneratorObject(value: js.Any): Boolean           = js.native
  def isInt8Array(value: js.Any): Boolean                 = js.native
  def isInt16Array(value: js.Any): Boolean                = js.native
  def isInt32Array(value: js.Any): Boolean                = js.native
  def isMap(value: js.Any): Boolean                       = js.native
  def isMapIterator(value: js.Any): Boolean               = js.native
  def isModuleNamespaceObject(value: js.Any): Boolean     = js.native
  def isNativeError(value: js.Any): Boolean               = js.native
  def isNumberObject(value: js.Any): Boolean              = js.native
  def isPromise(value: js.Any): Boolean                   = js.native
  def isProxy(value: js.Any): Boolean                     = js.native
  def isRegExp(value: js.Any): Boolean                    = js.native
  def isSet(value: js.Any): Boolean                       = js.native
  def isSetIterator(value: js.Any): Boolean               = js.native
  def isSharedArrayBuffer(value: js.Any): Boolean         = js.native
  def isStringObject(value: js.Any): Boolean              = js.native
  def isSymbolObject(value: js.Any): Boolean              = js.native
  def isTypedArray(value: js.Any): Boolean                = js.native
  def isUint8Array(value: js.Any): Boolean                = js.native
  def isUint8ClampedArray(value: js.Any): Boolean         = js.native
  def isUint16Array(value: js.Any): Boolean               = js.native
  def isUint32Array(value: js.Any): Boolean               = js.native
  def isWeakMap(value: js.Any): Boolean                   = js.native
  def isWeakSet(value: js.Any): Boolean                   = js.native
  def isWebAssemblyCompiledModule(value: js.Any): Boolean = js.native
}
