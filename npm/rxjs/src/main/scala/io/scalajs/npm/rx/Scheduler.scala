package io.scalajs.npm.rx

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Represents a Scheduler
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Scheduler extends js.Object {

  /**
    * Returns a scheduler that wraps the original scheduler, adding exception handling for scheduled actions.
    * @param handler (Function): Handler that's run if an exception is caught. The error will be rethrown if the handler returns false.
    * @return (Scheduler): Wrapper around the original scheduler, enforcing exception handling.
    * @example Rx.Scheduler.prototype.catch(handler)
    */
  def `catch`(handler: js.Function): this.type = js.native

  /**
    * Gets the current time according to the Scheduler implementation.
    * @return (Number): The current time according to the Scheduler implementation.
    * @example Rx.Scheduler.prototype.now()
    */
  def now(): AbsoluteTime = js.native

  /**
    * Schedules an action to be executed with state.
    * @param state  (Any): State passed to the action to be executed.
    * @param action (Function): Action to execute with the following arguments:
    *               <ul>
    *               <li>scheduler: (Scheduler) - The current Scheduler</li>
    *               <li>state: (Any) - The current state</xli>
    *               </ul>
    * @return (Disposable): The disposable object used to cancel the scheduled action (best effort).
    * @example Rx.Scheduler.prototype.schedule(state, action)
    */
  def schedule(state: js.Any, action: js.Function): Disposable = js.native

  /**
    * Schedules an action to be executed at the specified relative due time. Note this only works with the built-in
    * Rx.Scheduler.default scheduler, as the rest will throw an exception as the framework does not allow for blocking.
    * @param state   (Any): State passed to the action to be executed.
    * @param dueTime (Number | Date): Relative or absolute time at which to execute the action.
    * @param action  (Function): Action to execute with the following arguments:
    *                <ul>
    *                <li>scheduler: (Scheduler) - The current Scheduler</li>
    *                <li>state: (Any) - The current state</li>
    *                </ul>
    * @return (Disposable): The disposable object used to cancel the scheduled action (best effort).
    * @example Rx.Scheduler.prototype.scheduleFuture(state, dueTime, action)
    */
  def scheduleFuture(state: js.Any, dueTime: RelativeTime | js.Date, action: js.Function): Disposable = js.native

  /**
    * Schedules an action to be executed with state.
    * @param state  (Any): State passed to the action to be executed.
    * @param action (Function): Action to execute with the following arguments:
    *               <ul>
    *               <li>state: (Any) - The current state</li>
    *               <li>recurse: (Function) - The action to execute for recursive actions which takes the form of
    *               recurse(newState) where the new state is passed to be executed again</li>
    *               </ul>
    * @return (Disposable): The disposable object used to cancel the scheduled action (best effort).
    * @example Rx.Scheduler.prototype.scheduleRecursive(state, action)
    */
  def scheduleRecursive(state: js.Any, action: js.Function): Disposable = js.native

  /**
    * Schedules an action to be executed recursively at a specified absolute or relative due time. Note this only works
    * with the built-in Rx.Scheduler.timeout scheduler, as the rest will throw an exception as the framework does not
    * allow for blocking.
    * @param state   (Any): State passed to the action to be executed.
    * @param dueTime (Number): Absolute time at which to execute the action for the first time.
    * @param action  (Function): Action to execute with the following arguments:
    *                <ul>
    *                <li>state: (Any) - The current state</li>
    *                <li>recurse: (Function) - The action to execute for recursive actions which takes the form of
    *                recurse(newState, dueTime)</li>
    *                </ul>
    * @return (Disposable): The disposable object used to cancel the scheduled action (best effort).
    * @example Rx.Scheduler.prototype.scheduleRecursiveFuture(state, dueTime, action)
    */
  def scheduleRecursiveFuture(state: js.Any, dueTime: AbsoluteTime, action: js.Function): Disposable = js.native

  /**
    * Schedules a periodic piece of work by dynamically discovering the scheduler's capabilities. The periodic task
    * will be scheduled using window.setInterval for the base implementation.
    * @param state  (Any): State passed to the action to be executed.
    * @param period (Number): Period for running the work periodically in ms.
    * @param action (Function): Action to execute with the following parameters. Note that the return value from this
    *               function becomes the state in the next execution of the action.
    *               <ul>
    *               <li>state: Any - The state passed in</li>
    *               </ul>
    * @return (Disposable): The disposable object used to cancel the scheduled action (best effort).
    * @example Rx.Scheduler.prototype.schedulePeriodic(state, period, action)
    */
  def schedulePeriodic(state: js.Any, period: Period, action: js.Function): Disposable = js.native


}
