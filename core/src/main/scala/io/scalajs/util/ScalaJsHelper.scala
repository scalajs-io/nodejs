package io.scalajs.util

import io.scalajs.util.JsUnderOrHelper._

import scala.scalajs.js

/**
  * ScalaJS Convenience Helper Functions
  * @author lawrence.daniels@gmail.com
  */
object ScalaJsHelper {

  ////////////////////////////////////////////////////////////////////////
  //    Convenience Functions
  ////////////////////////////////////////////////////////////////////////

  @inline
  def die[T](message: String): T = throw new IllegalStateException(message)

  @inline
  def emptyArray[T]: js.Array[T] = js.Array[T]()

  @inline
  def isDefined(obj: js.Any): Boolean = obj != null && !js.isUndefined(obj)

  @inline
  def New[T <: js.Any]: T = new js.Object().asInstanceOf[T]

  ////////////////////////////////////////////////////////////////////////
  //    Implicit Definitions and Classes
  ////////////////////////////////////////////////////////////////////////

  /**
    * js.Dynamic to Value Extensions
    * @param obj the given [[js.Dynamic object]]
    */
  implicit class JsAnyExtensions(val obj: js.Any) extends AnyVal {

    @inline
    def asUndefOr[T]: js.UndefOr[T] = obj.asInstanceOf[js.UndefOr[T]].flat

    @inline
    def asOpt[T]: Option[T] = obj.asInstanceOf[js.UndefOr[T]].toOption

    @inline
    def dynamic: js.Dynamic = obj.asInstanceOf[js.Dynamic]

    @inline
    def New[T <: js.Any](args: js.Any*): T =
      js.Dynamic.newInstance(obj.asInstanceOf[js.Dynamic])(args: _*).asInstanceOf[T]

  }

  /**
    * js.Array Extensions
    * @param array the given [[js.Array array]]
    */
  implicit class JsArrayExtensions[A](val array: js.Array[A]) extends AnyVal {

    @inline
    def indexWhereOpt(f: A => Boolean): Option[Int] = array.indexWhere(f) match {
      case -1 => None
      case index => Some(index)
    }

    @inline
    def removeAll(): Unit = array.remove(0, array.length)

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
  implicit class JsDictionaryExtensions[A](val dict: js.Dictionary[A]) extends AnyVal {

    @inline
    def replaceWith(items: (String, A)*): Unit = {
      dict.clear()
      items foreach { case (key, value) => dict(key) = value }
    }
  }

}
