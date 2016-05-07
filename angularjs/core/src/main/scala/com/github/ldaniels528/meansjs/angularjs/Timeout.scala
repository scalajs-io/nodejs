package com.github.ldaniels528.meansjs.angularjs

import scala.scalajs.js

/**
  * Timeout Service - Angular's wrapper for window.setTimeout.
  * @see [[https://docs.angularjs.org/api/ng/service/\$timeout]]
  */
@js.native
trait Timeout extends js.Object {

  /**
    * Angular's wrapper for window.setTimeout. The fn function is wrapped into a try/catch block
    * and delegates any exceptions to \$exceptionHandler service.
    * @param fn          A function, whose execution should be delayed.
    * @param delay       Delay in milliseconds.
    * @param invokeApply If set to false skips model dirty checking, otherwise will invoke fn within the $apply block (default: true).
    * @param pass        additional parameters to the executed function.
    * @return A promise which will be notified on each iteration.
    */
  def apply(fn: js.Function, delay: Int = 0, invokeApply: Boolean = true, pass: js.Any = js.native): js.Promise[js.Any] = js.native

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
