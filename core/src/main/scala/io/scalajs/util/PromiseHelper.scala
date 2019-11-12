package io.scalajs.util

import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.runtime.wrapJavaScriptException

/**
  * Promise Helper
  */
object PromiseHelper {
  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseCallback0(f: js.Function0[Any] => Unit): Future[Unit] = {
    val task = Promise[Unit]()
    f(() => task.success({}))
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseCallback1[A](f: js.Function1[A, Any] => Unit): Future[A] = {
    val task = Promise[A]()
    f((a: A) => task.success(a))
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseCallback2[A, B](f: js.Function2[A, B, Any] => Unit): Future[(A, B)] = {
    val task = Promise[(A, B)]()
    f((a: A, b: B) => task.success((a, b)))
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseCallback3[A, B, C](f: js.Function3[A, B, C, Any] => Unit): Future[(A, B, C)] = {
    val task = Promise[(A, B, C)]()
    f((a: A, b: B, c: C) => task.success((a, b, c)))
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseCallback4[A, B, C, D](f: js.Function4[A, B, C, D, Any] => Unit): Future[(A, B, C, D)] = {
    val task = Promise[(A, B, C, D)]()
    f((a: A, b: B, c: C, d: D) => task.success((a, b, c, d)))
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseCallback5[A, B, C, D, E](f: js.Function5[A, B, C, D, E, Any] => Unit): Future[(A, B, C, D, E)] = {
    val task = Promise[(A, B, C, D, E)]()
    f((a: A, b: B, c: C, d: D, e: E) => task.success((a, b, c, d, e)))
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseCallback6[A, B, C, D, E, F](f: js.Function6[A, B, C, D, E, F, Any] => Unit): Future[(A, B, C, D, E, F)] = {
    val task = Promise[(A, B, C, D, E, F)]()
    f((a: A, b: B, c: C, d: D, e: E, f: F) => task.success((a, b, c, d, e, f)))
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseCallback7[A, B, C, D, E, F, G](
      f: js.Function7[A, B, C, D, E, F, G, Any] => Unit
  ): Future[(A, B, C, D, E, F, G)] = {
    val task = Promise[(A, B, C, D, E, F, G)]()
    f((a: A, b: B, c: C, d: D, e: E, f: F, g: G) => task.success((a, b, c, d, e, f, g)))
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseCallback8[A, B, C, D, E, F, G, H](
      f: js.Function8[A, B, C, D, E, F, G, H, Any] => Unit
  ): Future[(A, B, C, D, E, F, G, H)] = {
    val task = Promise[(A, B, C, D, E, F, G, H)]()
    f((a: A, b: B, c: C, d: D, e: E, f: F, g: G, h: H) => task.success((a, b, c, d, e, f, g, h)))
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise.
    * Promise always success and contains true if callback does not receive error, otherwise contains false.
    *
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithErrorAsBoolean[Z](f: js.Function1[Z, Any] => Unit): Future[Boolean] = {
    val task = Promise[Boolean]()
    f(
      (err: Z) => if (err == null || js.isUndefined(err)) task.success(true) else task.success(false)
    )
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError0[Z](f: js.Function1[Z, Any] => Unit): Future[Unit] = {
    val task = Promise[Unit]()
    f(
      (err: Z) =>
        if (err == null || js.isUndefined(err)) task.success({}) else task.failure(wrapJavaScriptException(err))
    )
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError1[Z, A](f: js.Function2[Z, A, Any] => Unit): Future[A] = {
    val task = Promise[A]()
    f(
      (err: Z, a: A) =>
        if (err == null || js.isUndefined(err)) task.success(a) else task.failure(wrapJavaScriptException(err))
    )
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError2[Z, A, B](f: js.Function3[Z, A, B, Any] => Unit): Future[(A, B)] = {
    val task = Promise[(A, B)]()
    f(
      (err: Z, a: A, b: B) =>
        if (err == null || js.isUndefined(err)) task.success((a, b)) else task.failure(wrapJavaScriptException(err))
    )
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError3[Z, A, B, C](f: js.Function4[Z, A, B, C, Any] => Unit): Future[(A, B, C)] = {
    val task = Promise[(A, B, C)]()
    f(
      (err: Z, a: A, b: B, c: C) =>
        if (err == null || js.isUndefined(err)) task.success((a, b, c)) else task.failure(wrapJavaScriptException(err))
    )
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError4[Z, A, B, C, D](f: js.Function5[Z, A, B, C, D, Any] => Unit): Future[(A, B, C, D)] = {
    val task = Promise[(A, B, C, D)]()
    f(
      (err: Z, a: A, b: B, c: C, d: D) =>
        if (err == null || js.isUndefined(err)) task.success((a, b, c, d))
        else task.failure(wrapJavaScriptException(err))
    )
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError5[Z, A, B, C, D, E](f: js.Function6[Z, A, B, C, D, E, Any] => Unit): Future[(A, B, C, D, E)] = {
    val task = Promise[(A, B, C, D, E)]()
    f(
      (err: Z, a: A, b: B, c: C, d: D, e: E) =>
        if (err == null || js.isUndefined(err)) task.success((a, b, c, d, e))
        else task.failure(wrapJavaScriptException(err))
    )
    task.future
  }

  /**
    * Converts a JavaScript-style callback to a Scala.js promise
    * @param f the given callback function
    * @return a Scala.js promise
    */
  @inline
  def promiseWithError6[Z, A, B, C, D, E, F](
      f: js.Function7[Z, A, B, C, D, E, F, Any] => Unit
  ): Future[(A, B, C, D, E, F)] = {
    val task = Promise[(A, B, C, D, E, F)]()
    f(
      (err: Z, a: A, b: B, c: C, d: D, e: E, f: F) =>
        if (err == null || js.isUndefined(err)) task.success((a, b, c, d, e, f))
        else task.failure(wrapJavaScriptException(err))
    )
    task.future
  }
}
