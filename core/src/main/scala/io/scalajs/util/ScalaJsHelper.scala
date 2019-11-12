package io.scalajs.util

import scala.scalajs.js

/**
  * ScalaJS Convenience Helper Functions
  */
object ScalaJsHelper {
  ////////////////////////////////////////////////////////////////////////
  //    Convenience Functions
  ////////////////////////////////////////////////////////////////////////

  @inline
  def die[T](message: String): T = throw new IllegalStateException(message)

  @inline
  def isDefined(obj: js.Any): Boolean = obj != null && !js.isUndefined(obj)

  ////////////////////////////////////////////////////////////////////////
  //    Implicit Definitions and Classes
  ////////////////////////////////////////////////////////////////////////

  /**
    * js.Dynamic to Value Extensions
    * @param obj the given [[js.Dynamic object]]
    */
  implicit final class JsAnyExtensions(val obj: js.Any) extends AnyVal {
    @inline
    def asUndefOr[T]: js.UndefOr[T] = obj.asInstanceOf[js.UndefOr[T]]

    @inline
    def asOpt[T]: Option[T] = obj.asInstanceOf[js.UndefOr[T]].toOption

    @inline
    def asDynamic: js.Dynamic = obj.asInstanceOf[js.Dynamic]
  }
}
