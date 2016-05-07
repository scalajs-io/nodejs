package com.github.ldaniels528.meansjs.util

import scala.concurrent.{Future, Promise}
import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.runtime.wrapJavaScriptException

/**
  * ScalaJS Convenience Helper Functions
  * @author lawrence.daniels@gmail.com
  */
object ScalaJsHelper {

  ////////////////////////////////////////////////////////////////////////
  //    Convenience Functions
  ////////////////////////////////////////////////////////////////////////

  implicit def promise2Future[T](promise: js.Promise[T]): Future[T] = promise.toFuture

  implicit def exception2JsError(cause: Throwable): js.Error = js.Error(cause.getMessage)

  /**
    * Converts a JavaScript-style callback to a Scala-style future
    * @param f the given callback function
    * @return a Scala-style future
    */
  @inline
  def callbackToFuture[A](f: js.Function => Unit): Future[A] = {
    val promise = Promise[A]()
    f((result: A) => promise.success(result))
    promise.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala-style future
    * @param f the given callback function
    * @return a Scala-style future
    */
  @inline
  def callbackWithErrorToFuture[A](f: js.Function => Any): Future[A] = {
    val promise = Promise[A]()
    f((err: js.Any, result: A) => if (!isDefined(err)) promise.success(result) else promise.failure(wrapJavaScriptException(err)))
    promise.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala-style future
    * @param f the given callback function
    * @return a Scala-style future
    */
  @inline
  def futureCallbackA2[A, B](f: js.Function2[A, B, Any] => Any): Future[(A, B)] = {
    val promise = Promise[(A, B)]()
    f((valueA: A, valueB: B) => promise.success((valueA, valueB)))
    promise.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala-style future
    * @param f the given callback function
    * @return a Scala-style future
    */
  @inline
  def futureCallbackE0[E](f: js.Function1[E, Any] => Any): Future[Unit] = {
    val promise = Promise[Unit]()
    f((err: E) => if (err == null) promise.success({}: Unit) else promise.failure(wrapJavaScriptException(err)))
    promise.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala-style future
    * @param f the given callback function
    * @return a Scala-style future
    */
  @inline
  def futureCallbackE1[E, R](f: js.Function2[E, R, Any] => Any): Future[R] = {
    val promise = Promise[R]()
    f((err: E, result: R) => if (err == null) promise.success(result) else promise.failure(wrapJavaScriptException(err)))
    promise.future
  }

  @inline
  def die[T](message: String): T = throw new IllegalStateException(message)

  @inline
  def emptyArray[T] = js.Array[T]()

  @inline
  def isDefined(obj: js.Any) = obj != null && !js.isUndefined(obj)

  @inline
  def New[T <: js.Any] = new js.Object().asInstanceOf[T]

  ////////////////////////////////////////////////////////////////////////
  //    Implicit Definitions and Classes
  ////////////////////////////////////////////////////////////////////////

  /**
    * js.Dynamic to Value Extensions
    * @param obj the given [[js.Dynamic object]]
    */
  implicit class JsAnyExtensions(val obj: js.Any) extends AnyVal {

    @inline
    def New[T <: js.Any](args: js.Any*): T = {
      js.Dynamic.newInstance(obj.asInstanceOf[js.Dynamic])(args: _*).asInstanceOf[T]
    }

    @inline def asOpt[T] = obj.asInstanceOf[js.UndefOr[T]].toOption

    @inline def dynamic = obj.asInstanceOf[js.Dynamic]

  }

  /**
    * js.Array Extensions
    * @param array the given [[js.Array array]]
    */
  implicit class JsArrayExtensions[A](val array: js.Array[A]) extends AnyVal {

    @inline def removeAll(): Unit = array.remove(0, array.length)

    @inline def replaceWith(items: A*) = {
      array.remove(0, array.length)
      array.push(items: _*)
    }
  }

  /**
    * js.Dictionary Extensions
    * @param dict the given [[js.Dictionary dictionary]]
    */
  implicit class JsDictionaryExtensions[A](val dict: js.Dictionary[A]) extends AnyVal {

    @inline def replaceWith(items: (String, A)*) = {
      dict.clear()
      items foreach { case (key, value) => dict(key) = value }
    }
  }

  /**
    * Option Extensions
    * @param valueA the given [[Option option]]
    */
  implicit class OptionExtensions[T](val valueA: Option[T]) extends AnyVal {

    @inline def ?==(valueB: js.UndefOr[T]): Boolean = valueA.exists(v => valueB.exists(_ == v))

    @inline def ?==(valueB: Option[T]): Boolean = valueA.exists(valueB.contains)

    @inline def ??(optB: => Option[T]): Option[T] = if (valueA.isDefined) valueA else optB

    @inline def orDie(message: String): Option[T] = if (valueA.isDefined) valueA else throw new IllegalArgumentException(message)

  }

  /**
    * UndefOr Extensions
    * @param valueA the given [[js.UndefOr undefined or otherwise value]]
    */
  implicit class UndefOrExtensions[T](val valueA: js.UndefOr[T]) extends AnyVal {

    @inline def ?==(valueB: js.UndefOr[T]): Boolean = valueA.exists(valueB.contains)

    @inline def ?==(valueB: Option[T]): Boolean = valueA.exists(valueB.contains)

    @inline def ??(optB: => js.UndefOr[T]): js.UndefOr[T] = if (valueA.isDefined) valueA else optB

    @inline def contains(value: T): Boolean = valueA.exists(_ == value)

    @inline def orDie(message: String): js.UndefOr[T] = if (valueA.isDefined) valueA else throw new IllegalArgumentException(message)

  }

}

