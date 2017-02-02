package io.scalajs.npm.angularjs

import scala.scalajs.js

/**
  * Interval Service - Angular's wrapper for window.setInterval.
  * @see [[https://docs.angularjs.org/api/ng/service/\$interval]]
  */
@js.native
trait Interval extends js.Object {

  /**
    * Angular's wrapper for window.setInterval. The fn function is executed every delay milliseconds.
    * @param fn          A function that should be called repeatedly.
    * @param delay       Number of milliseconds between each function call.
    * @param count       Number of times to repeat. If not set, or 0, will repeat indefinitely (default: 0).
    * @param invokeApply If set to false skips model dirty checking, otherwise will invoke fn within the $apply block (default: true).
    * @param pass        additional parameters to the executed function.
    * @return A promise which will be notified on each iteration.
    */
  def apply(fn: js.Function,
            delay: Int = 0,
            count: Int = 0,
            invokeApply: Boolean = true,
            pass: js.Any = js.native): js.Promise[js.Any] = js.native

  /**
    * Cancels a task associated with the promise.
    * @param promise returned by the $interval function.
    * @return true if the task was successfully canceled.
    */
  def cancel(promise: js.UndefOr[js.Promise[js.Any]] = js.undefined): Boolean = js.native

  /**
    * Synchronously flushes the queue of deferred functions.
    * @param delay Delay in milliseconds.
    */
  def flush(delay: Int = 0): Unit = js.native

  /**
    * Verifies that there are no pending tasks that need to be flushed.
    */
  def verifyNoPendingTasks(): Boolean = js.native

}
