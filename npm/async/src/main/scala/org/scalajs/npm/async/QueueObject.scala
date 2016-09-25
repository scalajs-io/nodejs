package org.scalajs.npm.async

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Queue Object - A queue of tasks for the worker function to complete.
  * @see [[http://caolan.github.io/async/docs.html#.QueueObject]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait QueueObject[T] extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A minimum threshold buffer in order to say that the queue is [[unsaturated]].
    */
  def buffer: Int = js.native

  /**
    * an integer for determining how many worker functions should be run in parallel. This property can be changed
    * after a queue is created to alter the concurrency on-the-fly.
    */
  var concurrency: Int = js.native

  /**
    * A boolean for determining whether the queue is in a paused state.
    */
  def paused: Boolean = js.native

  /**
    * A boolean indicating whether or not any items have been pushed and processed by the queue.
    */
  def started: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Callback Functions
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A callback that is called when the last item from the queue has returned from the worker.
    */
  var drain: js.Function = js.native

  /**
    * A callback that is called when the last item from the queue is given to a worker.
    */
  var empty: js.Function = js.native

  /**
    * A callback that is called when a task errors. Has the signature function(error, task).
    */
  var error: js.Function = js.native

  /**
    * A callback that is called when the number of running workers hits the concurrency limit,
    * and further tasks will be queued.
    */
  var saturated: js.Function = js.native

  /**
    * A callback that is called when the number of running workers is less than the concurrency & buffer limits,
    * and further tasks will not be queued.
    */
  var unsaturated: js.Function = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * @return false if there are items waiting or being processed, or true if not.
    * @example queue.idle()
    */
  def idle(): Boolean = js.native

  /**
    * A function that removes the drain callback and empties remaining tasks from the queue forcing it to go idle.
    * @example queue.kill()
    */
  def kill(): Unit = js.native

  /**
    * @return the number of items waiting to be processed.
    * @example queue.length()
    */
  def length(): Int = js.native

  /**
    * A function that pauses the processing of tasks until resume() is called.
    * @example queue.pause()
    */
  def pause(): Unit = js.native

  /**
    * add a new task to the queue. Calls callback once the worker has finished processing the task. Instead of a
    * single task, a tasks array can be submitted. The respective callback is used for every task in the list.
    * @example queue.push(task, [callback])
    */
  def push(task: T | js.Array[T], callback: js.Function = null): Unit = js.native

  /**
    * A function that resumes the processing of queued tasks when the queue is paused.
    * @example queue.resume()
    */
  def resume(): Unit = js.native

  /**
    * @return the number of items currently being processed.
    * @example queue.running()
    */
  def running(): Boolean = js.native

  /**
    * Add a new task to the front of the queue.sbt pu
    * @example queue.unshift(task, [callback])
    */
  def unshift(task: T, callback: js.Function = null): Unit = js.native

  /**
    * @return the array of items currently being processed.
    * @example queue.workersList()
    */
  def workersList(): js.Array[T] = js.native

}
