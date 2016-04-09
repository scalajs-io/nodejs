package com.github.ldaniels528.nodesjs.angularjs.core

import scala.scalajs.js

/**
 * Injector Service - is used to retrieve object instances as defined by provider,
 * instantiate types, invoke methods, and load modules.
 * @see [[https://docs.angularjs.org/api/auto/service/\$injector]]
 */
@js.native
trait Injector extends js.Object {

  /**
   * Return an instance of the service.
   * @param name The name of the instance to retrieve.
   * @param caller An optional string to provide the origin of the function call for error messages.
   * @tparam T the wrapped object type
   * @return The instance.
   */
  def get[T](name: String, caller: String = js.native): js.UndefOr[T] = js.native

  /**
   * Invoke the method and supply the method arguments from the \$injector.
   * @param fn The injectable function to invoke. Function parameters are injected according to the \$inject Annotation rules.
   * @param self The this for the invoked method.
   * @param locals Optional object. If preset then any argument names are read from this object first,
   *               before the \$injector is consulted.
   * @return the value returned by the invoked fn function.
   */
  def invoke(fn: js.Function, self: js.Object = js.native, locals: js.Object = js.native): js.Any = js.native

  /**
   * Allows the user to query if the particular service exists.
   * @param name Name of the service to query.
   * @return true if injector has given service.
   */
  def has(name: String): Boolean = js.native

  /**
   * Create a new instance of JS type. The method takes a constructor function, invokes the new operator,
   * and supplies all of the arguments to the constructor function as specified by the constructor annotation.
   * @param `type` Annotated constructor function.
   * @param locals Optional object. If preset then any argument names are read from this object first,
   *               before the $injector is consulted.
   * @return new instance of Type.
   */
  def instantiate[T <: js.Object](`type`: js.Function, locals: js.Object = js.native): T = js.native

  /**
   * Returns an array of service names which the function is requesting for injection. This API is used by the
   * injector to determine which services need to be injected into the function when the function is invoked.
   * There are three ways in which the function can be annotated with the needed dependencies.
   * @param fn Function for which dependent service names need to be retrieved as described above.
   * @param strictDi Disallow argument name annotation inference (default: false).
   */
  def annotate(fn: js.Function, strictDi: Boolean = js.native): js.Array[String] = js.native

  //def annotate(fn: js.Array[js.Any], strictDi: Boolean = js.native): js.Array[String] = js.native

}

