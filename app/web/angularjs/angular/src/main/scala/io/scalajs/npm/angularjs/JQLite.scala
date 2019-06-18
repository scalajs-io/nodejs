package io.scalajs.npm.angularjs

import io.scalajs.jquery.JQueryElement

import scala.scalajs.js

/**
  * JQuery Lite
  * @see [[https://docs.angularjs.org/api/ng/function/angular.element]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait JQLite extends JQueryElement {

  ////////////////////////////////////////////////////////////////////////
  //  jQuery/jqLite Extras
  ////////////////////////////////////////////////////////////////////////

  /**
    * Retrieves the controller of the current element or its parent. By default retrieves controller associated
    * with the ngController directive. If name is provided as camelCase directive name, then the controller for
    * this directive will be retrieved
    * @param name the name of the controller
    * @return the [[Controller controller]] instance
    */
  def controller(name: String = js.native): Controller = js.native

  /**
    * Retrieves the injector of the current element or its parent.
    * @return the [[Injector injector]]
    */
  def injector(): Injector = js.native

  /**
    * Retrieves the scope of the current element or its parent. Requires Debug Data to be enabled.
    * @return the [[Scope scope]]
    */
  def scope(): Scope = js.native

  /**
    * Retrieves an isolate scope if one is attached directly to the current element. This getter should be used
    * only on elements that contain a directive which starts a new isolate scope. Calling scope() on this element
    * always returns the original non-isolate scope. Requires Debug Data to be enabled.
    * @return the [[Scope scope]]
    */
  def isolateScope(): Scope = js.native

  /**
    * Same as data(), but walks up the DOM until a value is found or the top parent element is reached.
    * @param key   the given key
    * @param value the given value
    */
  def inheritedData(key: String, value: js.Any): this.type = js.native

  def inheritedData(obj: js.Object): this.type = js.native

  def inheritedData[T <: js.Any](key: String): js.UndefOr[T] = js.native

  def inheritedData(): js.Any = js.native

}

/**
  * JQLite Companion
  * @author lawrence.daniels@gmail.com
  */
object JQLite {

  /**
    * JQLite Enrichment
    * @param jqLite the given [[JQLite]] instance
    */
  implicit class JQLiteEnrichment(val jqLite: JQLite) extends AnyVal {

    @inline
    def controllerAs[T <: Controller](name: String = null): T = jqLite.controller(name).asInstanceOf[T]

    @inline
    def scopeAs[T <: Scope]: T = jqLite.scope().asInstanceOf[T]

    @inline
    def isolateScopeAs[T <: Scope]: T = jqLite.isolateScope().asInstanceOf[T]

  }

}