package org.scalajs.angularjs

import org.scalajs.angularjs.Module.EnrichedModule
import org.scalajs.dom.html.{Document, Element}
import org.scalajs.jquery.JQuery

import scala.language.implicitConversions
import scala.scalajs.js

/**
  * AngularJS 1.4.2 Binding
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Angular extends js.Object {

  /**
    * Returns a function which calls function fn bound to self (self becomes the this for fn). You can supply optional
    * args that are prebound to the function. This feature is also known as partial application, as distinguished from
    * function currying.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.bind]]
    */
  def bind(self: js.Object, fn: js.Function, args: js.Array[Any]): js.Function = js.native

  /**
    * @see #bind(js.Object, js.Function, js.Array)
    */
  def bind(self: js.Object, fn: js.Function): js.Function = js.native

  def bootstrap(element: String, modules: js.Array[Any]): Injector = js.native

  def bootstrap(element: String, modules: js.Array[Any], config: AngularConfiguration): Injector = js.native

  def bootstrap(element: String, modules: String): Injector = js.native

  def bootstrap(element: String, modules: String, config: AngularConfiguration): Injector = js.native

  def bootstrap(element: Element, modules: js.Array[Any]): Injector = js.native

  def bootstrap(element: Element, modules: js.Array[Any], config: AngularConfiguration): Injector = js.native

  def bootstrap(element: Element, modules: String): Injector = js.native

  def bootstrap(element: Element, modules: String, config: AngularConfiguration): Injector = js.native

  def bootstrap(element: Document, modules: js.Array[Any]): Injector = js.native

  def bootstrap(element: Document, modules: js.Array[Any], config: AngularConfiguration): Injector = js.native

  def bootstrap(element: Document, modules: String): Injector = js.native

  def bootstrap(element: Document, modules: String, config: AngularConfiguration): Injector = js.native

  def bootstrap(element: JQLite, modules: js.Array[Any]): Injector = js.native

  def bootstrap(element: JQLite, modules: js.Array[Any], config: AngularConfiguration): Injector = js.native

  def bootstrap(element: JQLite, modules: String): Injector = js.native

  def bootstrap(element: JQLite, modules: String, config: AngularConfiguration): Injector = js.native

  def bootstrap(element: JQuery, modules: js.Array[Any]): Injector = js.native

  def bootstrap(element: JQuery, modules: js.Array[Any], config: AngularConfiguration): Injector = js.native

  def bootstrap(element: JQuery, modules: String): Injector = js.native

  def bootstrap(element: JQuery, modules: String, config: AngularConfiguration): Injector = js.native

  /**
    * Creates a deep copy of source, which should be an object or an array.
    * If no destination is supplied, a copy of the object or array is created.
    * If a destination is provided, all of its elements (for arrays) or properties (for objects) are deleted and then all elements/properties from the source are copied to it.
    * If source is not an object or array (inc. null and undefined), source is returned.
    * If source is identical to 'destination' an exception will be thrown.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.copy]]
    */
  def copy(source: js.Any): js.Any = js.native

  def copy(source: js.Any, destination: js.Any): js.Any = js.native

  def element(elem: Element): JQLite = js.native

  def element(jQuery: JQuery): JQLite = js.native

  /**
    * Determines if two objects or two values are equivalent. Supports value types, regular expressions, arrays and objects.
    * Two objects or values are considered equivalent if at least one of the following is true:
    * <ul>
    * <li>Both objects or values pass === comparison.</li>
    * <li>Both objects or values are of the same type and all of their properties are equal by comparing them with angular.equals.</li>
    * <li>Both values are NaN. (In JavaScript, NaN == NaN => false. But we consider two NaN as equal)</li>
    * <li>Both values represent the same regular expression (In JavaScript, /abc/ == /abc/ => false. But we consider two
    * regular expressions as equal when their textual representation matches).</li>
    * </ul>
    * During a property comparison, properties of function type and properties with names that begin with $ are ignored.
    *
    * Scope and DOMWindow objects are being compared only by identify (===).
    * @see [[https://docs.angularjs.org/api/ng/function/angular.equals]]
    */
  def equals(o1: js.Any, o2: js.Any): Boolean = js.native

  /**
    * Extends the destination object dst by copying own enumerable properties from the src object(s) to dst. You can
    * specify multiple src objects. If you want to preserve original objects, you can do so by passing an empty object
    * as the target: var object = angular.extend({}, object1, object2).
    * @see [[https://docs.angularjs.org/api/ng/function/angular.extend]]
    */
  def extend[T](dst: js.Any, src: js.Any): T = js.native

  /**
    * Invokes the iterator function once for each item in obj collection, which can be either an object or an array.
    * The iterator function is invoked with iterator(value, key, obj), where value is the value of an object property
    * or an array element, key is the object property key or array element index and obj is the obj itself. Specifying
    * a context for the function is optional.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.forEach]]
    */
  def forEach(obj: js.Any, iterator: js.Function): Unit = js.native

  /**
    * Invokes the iterator function once for each item in obj collection, which can be either an object or an array.
    * The iterator function is invoked with iterator(value, key, obj), where value is the value of an object property
    * or an array element, key is the object property key or array element index and obj is the obj itself. Specifying
    * a context for the function is optional.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.forEach]]
    */
  def forEach(obj: js.Any, iterator: js.Function, context: js.Any): Unit = js.native

  /**
    * Deserializes a JSON string.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.fromJson]]
    */
  def fromJson[T](s: String): T = js.native

  /**
    * A function that returns its first argument. This function is useful when writing code in the functional style.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.identity]]
    */
  def identity(value: js.Any): js.Any = js.native

  /**
    * Creates an injector object that can be used for retrieving services as well as for dependency injection.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.injector]]
    */
  def injector(modules: js.Array[Any], strictDi: Boolean = false): Injector = js.native

  /**
    * Determines if a reference is an Array.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.isArray]]
    */
  def isArray(value: js.Any): Boolean = js.native

  /**
    * Determines if a value is a date.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.isDate]]
    */
  def isDate(value: js.Any): Boolean = js.native

  /**
    * Determines if a reference is defined.
    * @see https://docs.angularjs.org/api/ng/function/angular.isDefined
    */
  def isDefined(value: js.Any): Boolean = js.native

  /**
    * Determines if a reference is a DOM element (or wrapped jQuery element).
    * @see [[https://docs.angularjs.org/api/ng/function/angular.isElement]]
    */
  def isElement(value: js.Any): Boolean = js.native

  /**
    * Determines if a reference is a Function.
    * @see https://docs.angularjs.org/api/ng/function/angular.isFunction
    */
  def isFunction(value: js.Any): Boolean = js.native

  /**
    * Determines if a reference is a Number.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.isNumber]]
    */
  def isNumber(value: js.Any): Boolean = js.native

  /**
    * Determines if a reference is an Object. Unlike typeof in JavaScript, nulls are not considered to be objects.
    * Note that JavaScript arrays are objects.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.isObject]]
    */
  def isObject(value: js.Any): Boolean = js.native

  /**
    * Determines if a reference is a String.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.isString]]
    */
  def isString(value: js.Any): Boolean = js.native

  /**
    * Determines if a reference is undefined.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.isUndefined]]
    */
  def isUndefined(value: js.Any): Boolean = js.native

  /**
    * Converts the specified string to lowercase
    * @see [[https://docs.angularjs.org/api/ng/function/angular.lowercase]]
    */
  def lowercase(s: String): String = js.native

  /**
    * Deeply extends the destination object dst by copying own enumerable properties from the src object(s) to dst.
    * You can specify multiple src objects. If you want to preserve original objects, you can do so by passing an
    * empty object as the target: var object = angular.merge({}, object1, object2).
    * @see [[https://docs.angularjs.org/api/ng/function/angular.merge]]
    */
  def merge(dst: js.Object, src: js.Object): js.Object = js.native

  def module(name: String): js.UndefOr[Module] = js.native

  def module(name: String, dependencies: js.Array[String]): Module = js.native

  def module(name: String, dependencies: js.Array[String], configFn: js.Array[Any]): Module = js.native

  /**
    * A function that performs no operations. This function can be useful when writing code in the functional style.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.noop]]
    */
  def noop(): Unit = js.native

  /**
    * Use this function to reload the current application with debug information turned on. This takes precedence over
    * a call to \$compileProvider.debugInfoEnabled(false)
    * @see [[https://docs.angularjs.org/api/ng/function/angular.reloadWithDebugInfo]]
    */
  def reloadWithDebugInfo(): Unit = js.native

  /**
    * Serializes input into a JSON-formatted string. Properties with leading \$\$ characters will be stripped since
    * angular uses this notation internally.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.toJson]]
    */
  def toJson(obj: js.Any, pretty: Boolean = false): String = js.native

  /**
    * Converts the specified string to uppercase.
    * @see [[https://docs.angularjs.org/api/ng/function/angular.uppercase]]
    */
  def uppercase(string: String): String = js.native

  /**
    * An object that contains information about the current AngularJS version.
    * @see [[https://docs.angularjs.org/api/ng/object/angular.version]]
    */
  def version(): AngularVersion = js.native

}

/**
  * AngularJS Configuration
  * @author lawrence.daniels@gmail.com
  */
case class AngularConfiguration(strictDi: Boolean = false)

/**
  * An object that contains information about the current AngularJS version.
  * @see [[https://docs.angularjs.org/api/ng/object/angular.version]]
  */
@js.native
trait AngularVersion extends js.Object {
  // Full version string, such as "0.9.18".
  var full: String = js.native

  // Major version number, such as "0".
  var major: Int = js.native

  // Minor version number, such as "9".
  var minor: Int = js.native

  // Dot version number, such as "18".
  var dot: Int = js.native

  // Code name of the release, such as "jiggling-armfat".
  var codeName: String = js.native

}

/**
  * AngularJS Singleton
  * @author lawrence.daniels@gmail.com
  */
object Angular {

  @inline
  implicit def element(elem: Element): JQLite = angular.element(elem)

  @inline
  final implicit class RichAngular(val self: Angular) extends AnyVal {

    import scala.scalajs.js.JSConverters._

    @inline
    def createModule(name: String): EnrichedModule = self.module(name, js.Array())

    @inline
    def createModule(name: String, dependencies: Iterable[String]): EnrichedModule = self.module(name, dependencies.toJSArray)

    @inline
    def createModule(name: String, dependencies: Iterable[String], configFn: DependencySet): EnrichedModule = {
      self.module(name, dependencies.toJSArray, configFn.dependencies)
    }

    @inline
    def bootstrap(element: Element, modules: Iterable[String]) = {
      self.bootstrap(element, modules.toJSArray.asInstanceOf[js.Array[Any]])
    }

    @inline
    def bootstrap(element: Element, modules: Seq[DependencySet]) = {
      self.bootstrap(element, modules.map(_.dependencies).toJSArray.asInstanceOf[js.Array[Any]])
    }

    @inline
    def bootstrap(element: Element, modules: String, config: AngularConfiguration) = {
      self.bootstrap(element, modules, config)
    }

    @inline
    def bootstrap(element: Element, modules: Iterable[String], config: AngularConfiguration) = {
      self.bootstrap(element, modules.toJSArray.asInstanceOf[js.Array[Any]], config)
    }

    @inline
    def bootstrap(element: Element, modules: Seq[DependencySet], config: AngularConfiguration) = {
      self.bootstrap(element, modules.map(_.dependencies).toJSArray.asInstanceOf[js.Array[Any]], config)
    }

  }

}
