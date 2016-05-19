package com.github.ldaniels528.meansjs.angularjs

import scala.concurrent.{Future, Promise}
import scala.language.implicitConversions
import scala.scalajs.js
import scala.util.{Failure, Success, Try}

/**
  * Q Service - A service that helps you run functions asynchronously,
  * and use their return values (or exceptions) when they are done processing.
  * @see [[https://docs.angularjs.org/api/ng/service/\$q]]
  */
@js.native
trait Q extends js.Object {

  /**
    * Creates a Deferred object which represents a task which will finish in the future.
    * @return a new instance of [[QDefer deferred]].
    */
  def defer[T](): QDefer[T] = js.native

  /**
    * Creates a promise that is resolved as rejected with the specified reason.
    * This api should be used to forward rejection in a chain of promises.
    * If you are dealing with the last promise in a promise chain, you don't need to worry about it.
    * When comparing deferreds/promises to the familiar behavior of try/catch/throw, think of reject
    * as the throw keyword in JavaScript. This also means that if you "catch" an error via a promise
    * error callback and you want to forward the error to the promise derived from the current promise,
    * you have to "rethrow" the error by returning a rejection constructed via reject.
    * @param reason Constant, message, exception or an object representing the rejection reason.
    * @return a promise that was already resolved as rejected with the reason.
    */
  def reject[T](reason: js.Any): js.Promise[T] = js.native

  /**
    * Wraps an object that might be a value or a (3rd party) then-able promise into a $q promise.
    * This is useful when you are dealing with an object that might or might not be a promise, or
    * if the promise comes from a source that can't be trusted.
    * @param value Value or a promise
    * @return Returns a promise of the passed value or promise
    */
  def when[T](value: js.Any): js.Promise[T] = js.native

  /**
    * Alias of when to maintain naming consistency with ES6.
    * @param value Value or a promise
    * @return Returns a promise of the passed value or promise
    */
  def resolve[T](value: js.Any): js.Promise[T] = js.native

  /**
    * Combines multiple promises into a single promise that is resolved when all of the input promises are resolved.
    * @param promises An array or hash of promises.
    * @return Returns a single promise that will be resolved with an array/hash of values, each value corresponding
    *         to the promise at the same index/key in the promises array/hash. If any of the promises is resolved with
    *         a rejection, this resulting promise will be rejected with the same rejection value.
    */
  def all[T](promises: js.Array[Any]): js.Promise[T] = js.native

  def all[T](promises: js.Object): js.Promise[T] = js.native

}

/**
  * AngularJS Q Deferral
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait QDefer[T] extends js.Object {

  /**
    * Resolves the derived promise with the value. If the value is a rejection constructed
    * via $q.reject, the promise will be rejected instead.
    * @param value the given resolve value
    */
  def resolve(value: T): Unit = js.native

  /**
    * Rejects the derived promise with the reason. This is equivalent to resolving it with
    * a rejection constructed via $q.reject.
    * @param reason the given reject reason
    */
  def reject(reason: js.Any): Unit = js.native

  /**
    * Provides updates on the status of the promise's execution. This may be called
    * multiple times before the promise is either resolved or rejected.
    * @param value the given notify value
    */
  def notify(value: T): Unit = js.native

  /**
    * Returns the promise
    * @return the promise
    */
  def promise: js.Promise[T] = js.native

}

/**
  * AngularJS Q Deferral Singleton
  * @author lawrence.daniels@gmail.com
  */
object QDefer {

  /**
    * AngularJS Promise to Scala Promise Conversion
    * @param defer the given [[QDefer deferral]]
    * @return a [[Future future]]
    */
  implicit class DeferredPromise[T](defer: QDefer[T]) extends Promise[T] {
    private var completed = false

    override def future: Future[T] = defer.promise.toFuture

    override def isCompleted: Boolean = completed

    override def tryComplete(result: Try[T]): Boolean = {
      if (isCompleted) false
      else {
        result match {
          case Success(r) =>
            defer.resolve(r)
          case Failure(e) =>
            defer.reject(e.getMessage)
        }

        completed = true
        completed
      }
    }
  }

}
