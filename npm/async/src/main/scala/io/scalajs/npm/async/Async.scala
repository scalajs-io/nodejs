package io.scalajs.npm.async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Async is a utility module which provides straight-forward, powerful functions for working with asynchronous
  * JavaScript. Although originally designed for use with Node.js and installable via `npm install --save async`,
  * it can also be used directly in the browser.
  * @version 2.0.1
  * @see http://caolan.github.io/async/
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("async", JSImport.Namespace)
object Async extends Async

/**
  * Async Type Definition
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Async extends js.Object {

  /**
    * Applies the provided arguments to each function in the array, calling callback after all functions have completed.
    * If you only provide the first argument, then it will return a function which lets you pass in the arguments as if
    * it were a single function call.
    * @param functions A collection of asynchronous functions to all call with the same arguments
    * @param args      any number of separate arguments to pass to the function
    * @param callback  the final argument should be the callback, called when all functions have completed processing
    */
  def applyEach(functions: js.Array[js.Function], args: js.Any, callback: js.Function): Unit = js.native

  def applyEach(functions: js.Array[js.Function], args: js.Any, args2: js.Any, callback: js.Function): Unit = js.native

  def applyEach(functions: js.Array[js.Function], args: js.Any, args2: js.Any, args3: js.Any, callback: js.Function): Unit = js.native

  def applyEach(functions: js.Array[js.Function], args: js.Any, args2: js.Any, args3: js.Any, args4: js.Any, callback: js.Function): Unit = js.native

  def applyEach(functions: js.Array[js.Function], args: js.Any, args2: js.Any, args3: js.Any, args4: js.Any, args5: js.Any, callback: js.Function): Unit = js.native

  def applyEach(functions: js.Array[js.Function], args: js.Any, args2: js.Any, args3: js.Any, args4: js.Any, args5: js.Any, args6: js.Any, callback: js.Function): Unit = js.native

  /**
    * Creates a function which is a composition of the passed asynchronous functions. Each function consumes the return
    * value of the function that follows. Composing functions f(), g(), and h() would produce the result of f(g(h())),
    * only this version uses callbacks to obtain the return values.
    * @param functions the asynchronous functions to compose
    * @example compose(fn1, fn2...)
    */
  def compose(functions: js.Function*): AsyncResultCallback = js.native

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
    * @param callback An optional callback which is called when all iteratee functions have finished, or an error occurs.
    */
  def each(coll: js.Array[_ <: js.Any], iteratee: js.Function, callback: AsyncResultCallback = null): Unit = js.native

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
    * @param callback Optional A callback which is called when all iteratee functions have finished, or an error occurs.
    */
  def eachLimit(coll: js.Array[_ <: js.Any], limit: Int, iteratee: js.Function, callback: AsyncResultCallback = null): Unit = js.native

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
    * @param callback An optional callback which is called when all iteratee functions have finished, or an error occurs.
    */
  def eachSeries(coll: js.Array[_ <: js.Any], iteratee: js.Function, callback: AsyncResultCallback = null): Unit = js.native

  /**
    * Returns a new array of all the values in coll which pass an async truth test. This operation is performed in parallel,
    * but the results array will be in the same order as the original.
    * @param coll     A collection to iterate over.
    * @param iteratee iteratee(item, callback) - A truth test to apply to each item in coll. The iteratee is passed a
    *                 callback(err, truthValue) , which must be called with a boolean argument once it has completed.
    *                 Callback arguments changed in 2.0
    * @param callback callback(err, results) - Optional A callback which is called after all the iteratee functions have finished.
    */
  def filter(coll: js.Array[_ <: js.Any], iteratee: js.Function, callback: AsyncResultCallback = null): Unit = js.native

  /**
    * Like each, except that it passes the key (or index) as the second argument to the iteratee.
    * @param coll     A collection to iterate over.
    * @param iteratee iteratee(item, key, callback) - A function to apply to each item in coll. The key is the item's
    *                 key, or index in the case of an array. The iteratee is passed a callback(err) which must be called
    *                 once it has completed. If no error has occurred, the callback should be run without arguments or
    *                 with an explicit null argument.
    * @param callback callback(err) - An optional callback which is called when all iteratee functions have finished, or an error occurs.
    * @example forEachOf(coll, iteratee, [callback])
    */
  def forEachOf(coll: js.Any, iteratee: js.Function, callback: AsyncErrorCallback = null): Unit = js.native

  /**
    * Produces a new collection of values by mapping each value in coll through the iteratee function. The iteratee is
    * called with an item from coll and a callback for when it has finished processing. Each of these callback takes 2
    * arguments: an error, and the transformed item from coll. If iteratee passes an error to its callback, the main
    * callback (for the map function) is immediately called with the error.
    * @param coll     A collection to iterate over.
    * @param iteratee iteratee(item, callback) - A function to apply to each item in coll. The iteratee is passed a
    *                 callback(err, transformed) which must be called once it has completed with an error (which can
    *                 be null) and a transformed item.
    * @param callback callback(err, results) - Optional A callback which is called when all iteratee functions have
    *                 finished, or an error occurs. Results is an array of the transformed items from the coll.
    */
  def map(coll: js.Array[_ <: js.Any], iteratee: js.Function, callback: AsyncResultCallback): Unit = js.native

  /**
    * Run the tasks collection of functions in parallel, without waiting until the previous function has completed.
    * If any of the functions pass an error to its callback, the main callback is immediately called with the value of
    * the error. Once the tasks have completed, the results are passed to the final callback as an array.
    * @param tasks    A collection containing functions to run. Each function is passed a callback(err, result) which it
    *                 must call on completion with an error err (which can be null) and an optional result value.
    * @param callback callback(err, results) - An optional callback to run once all the functions have completed successfully.
    *                 This function gets a results array (or object) containing all the result arguments passed to the task callbacks.
    */
  def parallel(tasks: js.Array[js.Function], callback: AsyncResultCallback = null): Unit = js.native

  /**
    * Creates a queue object with the specified concurrency. Tasks added to the queue are processed in parallel
    * (up to the concurrency limit). If all workers are in progress, the task is queued until one becomes available.
    * Once a worker completes a task, that task's callback is called.
    * @param worker      An asynchronous function for processing a queued task, which must call its callback(err) argument
    *                    when finished, with an optional error as an argument. If you want to handle errors from an individual
    *                    task, pass a callback to q.push(). Invoked with (task, callback).
    * @param concurrency An integer for determining how many worker functions should be run in parallel. If omitted,
    *                    the concurrency defaults to 1. If the concurrency is 0, an error is thrown.
    * @return A queue object to manage the tasks. Callbacks can attached as certain properties to listen for specific
    *         events during the lifecycle of the queue.
    */
  def queue[T](worker: js.Function, concurrency: Int = 1): QueueObject[T] = js.native

  /**
    * The opposite of filter. Removes values that pass an async truth test.
    * @param coll     A collection to iterate over.
    * @param iteratee iteratee(item, callback) - A truth test to apply to each item in coll. The iteratee is passed a
    *                 callback(err, truthValue) , which must be called with a boolean argument once it has completed.
    *                 Callback arguments changed in 2.0
    * @param callback callback(err, results) - Optional A callback which is called after all the iteratee functions have finished.
    * @example reject(coll, iteratee, [callback])
    */
  def reject(coll: js.Any, iteratee: js.Function, callback: AsyncResultCallback = null): Unit = js.native

  /**
    * Version of the compose function that is more natural to read. Each function consumes the return value of the
    * previous function. It is the equivalent of compose with the arguments reversed.
    *
    * Each function is executed with the this binding of the composed function.
    * @param functions the asynchronous functions to compose
    * @example seq(fn1, fn2...)
    */
  def seq(functions: js.Function): AsyncResultCallback = js.native

  def series(tasks: js.Array[js.Function]): Unit = js.native

  /**
    * Calls callback on a later loop around the event loop. In Node.js this just calls setImmediate. In the browser
    * it will use setImmediate if available, otherwise setTimeout(callback, 0), which means other higher priority
    * events may precede the execution of callback.
    *
    * This is used internally for browser-compatibility purposes.
    * @param callback The function to call on a later loop around the event loop.
    * @param args     any number of additional arguments to pass to the callback on the next tick
    */
  def setImmediate(callback: js.Function, args: js.Any*): Unit = js.native

  /**
    * Runs the tasks array of functions in series, each passing their results to the next in the array. However, if any
    * of the tasks pass an error to their own callback, the next function is not executed, and the main callback is
    * immediately called with the error.
    * @param tasks    An array of functions to run, each function is passed a callback(err, result1, result2, ...) it must
    *                 call on completion. The first argument is an error (which can be null) and any further arguments will
    *                 be passed as arguments in order to the next task.
    * @param callback An optional callback to run once all the functions have completed. This will be passed the results
    *                 of the last task's callback (e.g. callback(err, [results])).
    */
  def waterfall(tasks: js.Array[_ <: js.Function], callback: AsyncResultCallback = null): Unit = js.native

}
