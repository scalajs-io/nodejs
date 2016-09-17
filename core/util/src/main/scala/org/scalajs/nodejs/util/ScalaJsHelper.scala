package org.scalajs.nodejs.util

import org.scalajs.sjs.JsUnderOrHelper._

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
  //    Concurrency Functions
  ////////////////////////////////////////////////////////////////////////

  implicit def promise2Future[T](task: js.Promise[T]): Future[T] = task.toFuture

  implicit def promise2Future[T](task: Promise[T]): Future[T] = task.future

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def futureCallbackA0(f: js.Function0[Any] => Unit): Promise[Unit] = {
    val task = Promise[Unit]()
    f(() => task.success({}))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def futureCallbackA1[A](f: js.Function1[A, Any] => Unit): Promise[A] = {
    val task = Promise[A]()
    f((a: A) => task.success(a))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def futureCallbackA2[A, B](f: js.Function2[A, B, Any] => Unit): Promise[(A, B)] = {
    val task = Promise[(A, B)]()
    f((a: A, b: B) => task.success((a, b)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def futureCallbackA3[A, B, C](f: js.Function3[A, B, C, Any] => Unit): Promise[(A, B, C)] = {
    val task = Promise[(A, B, C)]()
    f((a: A, b: B, c: C) => task.success((a, b, c)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def futureCallbackA4[A, B, C, D](f: js.Function4[A, B, C, D, Any] => Unit): Promise[(A, B, C, D)] = {
    val task = Promise[(A, B, C, D)]()
    f((a: A, b: B, c: C, d: D) => task.success((a, b, c, d)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def futureCallbackE0[E <: js.Any](f: js.Function1[E, Any] => Unit): Promise[Unit] = {
    val task = Promise[Unit]()
    f((err: E) => if (!isDefined(err)) task.success({}: Unit) else task.failure(wrapJavaScriptException(err)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def futureCallbackE1[E <: js.Any, R](f: js.Function2[E, R, Any] => Unit): Promise[R] = {
    val task = Promise[R]()
    f((err: E, result: R) => if (!isDefined(err)) task.success(result) else task.failure(wrapJavaScriptException(err)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def futureCallbackE2[E <: js.Any, A, B](f: js.Function3[E, A, B, Any] => Unit): Promise[(A, B)] = {
    val task = Promise[(A, B)]()
    f((err: E, a: A, b: B) => if (!isDefined(err)) task.success(a -> b) else task.failure(wrapJavaScriptException(err)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def futureCallbackE3[E <: js.Any, A, B, C](f: js.Function4[E, A, B, C, Any] => Unit): Promise[(A, B, C)] = {
    val task = Promise[(A, B, C)]()
    f((err: E, a: A, b: B, c: C) => if (!isDefined(err)) task.success((a, b, c)) else task.failure(wrapJavaScriptException(err)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def futureCallbackE4[E <: js.Any, A, B, C, D](f: js.Function5[E, A, B, C, D, Any] => Unit): Promise[(A, B, C, D)] = {
    val task = Promise[(A, B, C, D)]()
    f((err: E, a: A, b: B, c: C, d: D) => if (!isDefined(err)) task.success((a, b, c, d)) else task.failure(wrapJavaScriptException(err)))
    task
  }

  ////////////////////////////////////////////////////////////////////////
  //    Convenience Functions
  ////////////////////////////////////////////////////////////////////////

  @inline def die[T](message: String): T = throw new IllegalStateException(message)

  @inline def emptyArray[T] = js.Array[T]()

  @inline def isDefined(obj: js.Any) = obj != null && !js.isUndefined(obj)

  @inline def New[T <: js.Any] = new js.Object().asInstanceOf[T]

  ////////////////////////////////////////////////////////////////////////
  //    Implicit Definitions and Classes
  ////////////////////////////////////////////////////////////////////////

  /**
    * js.Dynamic to Value Extensions
    * @param obj the given [[js.Dynamic object]]
    */
  implicit class JsAnyExtensions(val obj: js.Any) extends AnyVal {

    @inline def asUndefOr[T] = obj.asInstanceOf[js.UndefOr[T]].flat

    @inline def asOpt[T] = obj.asInstanceOf[js.UndefOr[T]].toOption

    @inline def dynamic = obj.asInstanceOf[js.Dynamic]

    @inline def New[T <: js.Any](args: js.Any*): T = js.Dynamic.newInstance(obj.asInstanceOf[js.Dynamic])(args: _*).asInstanceOf[T]

  }

  /**
    * js.Array Extensions
    * @param array the given [[js.Array array]]
    */
  implicit class JsArrayExtensions[A](val array: js.Array[A]) extends AnyVal {

    @inline def indexWhereOpt(f: A => Boolean): Option[Int] = array.indexWhere(f) match {
      case -1 => None
      case index => Some(index)
    }

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

    @inline
    def replaceWith(items: (String, A)*) = {
      dict.clear()
      items foreach { case (key, value) => dict(key) = value }
    }
  }

}

