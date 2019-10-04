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

  @deprecated("Use js.Array[T]()", "0.9.0")
  @inline
  def emptyArray[T]: js.Array[T] = js.Array[T]()

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

    @deprecated("Use asDynamic", "0.9.0")
    @inline
    def dynamic: js.Dynamic = asDynamic

    @deprecated("Use isInstanceOf or pattern matching instead", "0.9.0")
    @inline
    def getJSClassName: Option[String] = {
      val keyword = "function "
      val info    = obj.dynamic.constructor.toString()
      (info.indexOf(keyword), info.indexOf('(')) match {
        case (a, b) if a == -1 | b == -1 | a > b => None
        case (a, b)                              => Some(info.substring(a + keyword.length, b))
      }
    }

    @deprecated("No longer provided since danger operation", "0.9.0")
    @inline
    def New[T <: js.Any](args: js.Any*): T =
      js.Dynamic.newInstance(obj.asInstanceOf[js.Dynamic])(args: _*).asInstanceOf[T]

  }

  /**
    * js.Array Extensions
    * @param array the given [[js.Array array]]
    */
  @deprecated("All methods are deprecated", "0.9.0")
  implicit final class JsArrayExtensions[A](val array: js.Array[A]) extends AnyVal {

    @deprecated("Use indexWhere", "0.9.0")
    @inline
    def indexWhereOpt(f: A => Boolean): Option[Int] = array.indexWhere(f) match {
      case -1    => None
      case index => Some(index)
    }

    @deprecated("Use clear", "0.9.0")
    @inline
    def removeAll(): Unit = array.remove(0, array.length)

    @deprecated("Use new instance instead of mutating", "0.9.0")
    @inline
    def replaceWith(items: A*): Int = {
      array.remove(0, array.length)
      array.push(items: _*)
    }
  }

  /**
    * js.Dictionary Extensions
    * @param dict the given [[js.Dictionary dictionary]]
    */
  @deprecated("All methods are deprecated", "0.9.0")
  implicit final class JsDictionaryExtensions[A](val dict: js.Dictionary[A]) extends AnyVal {

    @inline
    @deprecated("Use new instance instead of mutating", "0.9.0")
    def replaceWith(items: (String, A)*): Unit = {
      dict.clear()
      items foreach { case (key, value) => dict(key) = value }
    }
  }

}
