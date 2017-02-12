package io.scalajs.util

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.scalajs.js
import scala.scalajs.runtime.wrapJavaScriptException
import scala.util.{Failure, Success}

/**
  * Promise Helper
  * @author lawrence.daniels@gmail.com
  */
object PromiseHelper {

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseCallback0(f: js.Function0[Any] => Unit): Promise[Unit] = {
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
  def promiseCallback1[A](f: js.Function1[A, Any] => Unit): Promise[A] = {
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
  def promiseCallback2[A, B](f: js.Function2[A, B, Any] => Unit): Promise[(A, B)] = {
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
  def promiseCallback3[A, B, C](f: js.Function3[A, B, C, Any] => Unit): Promise[(A, B, C)] = {
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
  def promiseCallback4[A, B, C, D](f: js.Function4[A, B, C, D, Any] => Unit): Promise[(A, B, C, D)] = {
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
  def promiseCallback5[A, B, C, D, E](f: js.Function5[A, B, C, D, E, Any] => Unit): Promise[(A, B, C, D, E)] = {
    val task = Promise[(A, B, C, D, E)]()
    f((a: A, b: B, c: C, d: D, e: E) => task.success((a, b, c, d, e)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError0[Z](f: js.Function1[Z, Any] => Unit): Promise[Unit] = {
    val task = Promise[Unit]()
    f((err: Z) =>
      if (err == null || js.isUndefined(err)) task.success({}) else task.failure(wrapJavaScriptException(err)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError1[Z, A](f: js.Function2[Z, A, Any] => Unit): Promise[A] = {
    val task = Promise[A]()
    f((err: Z, a: A) =>
      if (err == null || js.isUndefined(err)) task.success(a) else task.failure(wrapJavaScriptException(err)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError2[Z, A, B](f: js.Function3[Z, A, B, Any] => Unit): Promise[(A, B)] = {
    val task = Promise[(A, B)]()
    f((err: Z, a: A, b: B) =>
      if (err == null || js.isUndefined(err)) task.success((a, b)) else task.failure(wrapJavaScriptException(err)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError3[Z, A, B, C](f: js.Function4[Z, A, B, C, Any] => Unit): Promise[(A, B, C)] = {
    val task = Promise[(A, B, C)]()
    f((err: Z, a: A, b: B, c: C) =>
      if (err == null || js.isUndefined(err)) task.success((a, b, c)) else task.failure(wrapJavaScriptException(err)))
    task
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError4[Z, A, B, C, D](f: js.Function5[Z, A, B, C, D, Any] => Unit): Promise[(A, B, C, D)] = {
    val task = Promise[(A, B, C, D)]()
    f(
      (err: Z, a: A, b: B, c: C, d: D) =>
        if (err == null || js.isUndefined(err)) task.success((a, b, c, d))
        else task.failure(wrapJavaScriptException(err)))
    task
  }

  ////////////////////////////////////////////////////////////////////////
  //    Monitoring Functions
  ////////////////////////////////////////////////////////////////////////

  def time[T](action: String, task: => Future[T], showHeader: Boolean = false)(
    implicit ec: ExecutionContext): Future[T] = {
    if (showHeader) println(s"$action...")
    val startTime = System.currentTimeMillis()
    task onComplete {
      case Success(_) =>
        val elapsedTime = System.currentTimeMillis - startTime
        println(f"$action took $elapsedTime msecs")
      case Failure(e) =>
        val elapsedTime = System.currentTimeMillis - startTime
        println(f"$action took $elapsedTime msecs")
    }
    task
  }

  /**
    * Time Measurement Extensions
    * @param task the given [[Future task]]
    * @tparam T the return type of the task
    */
  implicit class TimeExtensions[T](val task: Future[T]) extends AnyVal {

    @inline
    def withTimer(action: String, showHeader: Boolean = false)(implicit ec: ExecutionContext): Future[T] = {
      time(action, task, showHeader)
    }

  }

  /**
    * Implicit conversion
    * @author lawrence.daniels@gmail.com
    */
  object Implicits {

    implicit def promise2Future[T](task: js.Promise[T]): Future[T] = task.toFuture

    implicit def promise2Future[T](task: Promise[T]): Future[T] = task.future

  }

}
