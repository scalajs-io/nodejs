package io.scalajs.npm

import io.scalajs.nodejs.Error
import io.scalajs.util.ScalaJsHelper.{futureCallbackE0, futureCallbackE1}

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.Array

/**
  * async package object
  * @author lawrence.daniels@gmail.com
  */
package object async {

  type AsyncErrorCallback = js.Function1[Error, Any]

  type AsyncResultCallback = js.Function

  /**
    * Async Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class AsyncExtensions(val async: Async) extends AnyVal {

    /**
      * Applies the function iteratee to each item in coll, in parallel. The iteratee is called with an item from the
      * list, and a callback for when it has finished. If the iteratee passes an error to its callback, the main callback
      * (for the each function) is immediately called with the error.
      *
      * Note, that since this function applies iteratee to each item in parallel, there is no guarantee that the iteratee
      * functions will complete in order.
      * @param coll     A collection to iterate over.
      * @param iteratee A function to apply to each item in coll. The iteratee is passed a callback(err) which must be
      *                 called once it has completed. If no error has occurred, the callback should be run without arguments
      *                 or with an explicit null argument. The array index is not passed to the iteratee. If you need the
      *                 index, use forEachOf.
      */
    @inline
    def eachFuture[A <: js.Any](coll: js.Array[A])(iteratee: (A, AsyncErrorCallback) => Any): Promise[A] = {
      futureCallbackE1[Error, A](async.each(coll, _))
    }

    /**
      * Applies the function iteratee to each item in coll, in parallel. The iteratee is called with an item from the
      * list, and a callback for when it has finished. If the iteratee passes an error to its callback, the main callback
      * (for the each function) is immediately called with the error.
      *
      * Note, that since this function applies iteratee to each item in parallel, there is no guarantee that the iteratee
      * functions will complete in order.
      * @param coll     A collection to iterate over.
      * @param limit    the limit
      * @param iteratee A function to apply to each item in coll. The iteratee is passed a callback(err) which must be
      *                 called once it has completed. If no error has occurred, the callback should be run without arguments
      *                 or with an explicit null argument. The array index is not passed to the iteratee. If you need the
      *                 index, use forEachOf.
      */
    @inline
    def eachLimitFuture[A <: js.Any](coll: js.Array[A], limit: Int)(iteratee: (A, AsyncErrorCallback) => Any): Promise[A] = {
      futureCallbackE1[Error, A](async.eachLimit(coll, limit, _))
    }

    /**
      * Applies the function iteratee to each item in coll, in parallel. The iteratee is called with an item from the
      * list, and a callback for when it has finished. If the iteratee passes an error to its callback, the main callback
      * (for the each function) is immediately called with the error.
      *
      * Note, that since this function applies iteratee to each item in parallel, there is no guarantee that the iteratee
      * functions will complete in order.
      * @param coll     A collection to iterate over.
      * @param iteratee A function to apply to each item in coll. The iteratee is passed a callback(err) which must be
      *                 called once it has completed. If no error has occurred, the callback should be run without arguments
      *                 or with an explicit null argument. The array index is not passed to the iteratee. If you need the
      *                 index, use forEachOf.
      */
    @inline
    def eachSeriesFuture[A <: js.Any](coll: js.Array[A])(iteratee: (A, AsyncErrorCallback) => Any): Promise[A] = {
      futureCallbackE1[Error, A](async.eachSeries(coll, _))
    }

    /**
      * Returns a new array of all the values in coll which pass an async truth test. This operation is performed in parallel,
      * but the results array will be in the same order as the original.
      * @param coll     A collection to iterate over.
      * @param iteratee iteratee(item, callback) - A truth test to apply to each item in coll. The iteratee is passed a
      *                 callback(err, truthValue) , which must be called with a boolean argument once it has completed.
      *                 Callback arguments changed in 2.0
      */
    @inline
    def filterFuture[A <: js.Any](coll: js.Array[A])(iteratee: (A, AsyncErrorCallback) => Boolean): Promise[Array[A]] = {
      futureCallbackE1[Error, js.Array[A]](async.filter(coll, _))
    }

    /**
      * Like each, except that it passes the key (or index) as the second argument to the iteratee.
      * @param coll     A collection to iterate over.
      * @param iteratee iteratee(item, key, callback) - A function to apply to each item in coll. The key is the item's
      *                 key, or index in the case of an array. The iteratee is passed a callback(err) which must be called
      *                 once it has completed. If no error has occurred, the callback should be run without arguments or
      *                 with an explicit null argument.
      */
    @inline
    def forEachOfFuture[A](coll: js.Array[A])(iteratee: (A, Int, AsyncErrorCallback) => Any): Promise[Unit] = {
      futureCallbackE0[Error](async.forEachOf(coll, iteratee, _))
    }

    /**
      * Like each, except that it passes the key (or index) as the second argument to the iteratee.
      * @param coll     A collection to iterate over.
      * @param iteratee A function to apply to each item in coll. The key is the item's key, or index in the case of an
      *                 array. The iteratee is passed a callback(err) which must be called once it has completed.
      *                 If no error has occurred, the callback should be run without arguments or with an explicit null argument.
      */
    @inline
    def forEachOfFuture[A](coll: js.Dictionary[A])(iteratee: (A, String, AsyncErrorCallback) => Any): Promise[Unit] = {
      futureCallbackE0[Error](async.forEachOf(coll, iteratee, _))
    }

    /**
      * Run the tasks collection of functions in parallel, without waiting until the previous function has completed.
      * If any of the functions pass an error to its callback, the main callback is immediately called with the value of
      * the error. Once the tasks have completed, the results are passed to the final callback as an array.
      * @param tasks A collection containing functions to run. Each function is passed a callback(err, result) which it
      *              must call on completion with an error err (which can be null) and an optional result value.
      */
    @inline
    def parallelFuture[A <: js.Any](tasks: js.Array[js.Function]): Promise[A] = {
      futureCallbackE1[Error, A](async.parallel(tasks, _))
    }

    /**
      * The opposite of filter. Removes values that pass an async truth test.
      * @param coll     A collection to iterate over.
      * @param iteratee iteratee(item, callback) - A truth test to apply to each item in coll. The iteratee is passed a
      *                 callback(err, truthValue) , which must be called with a boolean argument once it has completed.
      *                 Callback arguments changed in 2.0
      */
    @inline
    def rejectFuture[A <: js.Any](coll: js.Array[A])(iteratee: (A, Int) => Any): Promise[A] = {
      futureCallbackE1[Error, A](async.reject(coll, iteratee, _))
    }

    /**
      * The opposite of filter. Removes values that pass an async truth test.
      * @param coll     A collection to iterate over.
      * @param iteratee iteratee(item, callback) - A truth test to apply to each item in coll. The iteratee is passed a
      *                 callback(err, truthValue) , which must be called with a boolean argument once it has completed.
      *                 Callback arguments changed in 2.0
      */
    @inline
    def rejectFuture[A <: js.Any](coll: js.Dictionary[A])(iteratee: (A, String) => Any): Promise[A] = {
      futureCallbackE1[Error, A](async.reject(coll, iteratee, _))
    }

    /**
      * Runs the tasks array of functions in series, each passing their results to the next in the array. However, if any
      * of the tasks pass an error to their own callback, the next function is not executed, and the main callback is
      * immediately called with the error.
      * @param tasks An array of functions to run, each function is passed a callback(err, result1, result2, ...) it must
      *              call on completion. The first argument is an error (which can be null) and any further arguments will
      *              be passed as arguments in order to the next task.
      */
    @inline
    def waterfallFuture[A](tasks: js.Array[_ <: js.Function]): Promise[A] = {
      futureCallbackE1[Error, A](async.waterfall(tasks, _))
    }

  }

}
