package io.scalajs.npm.rx

import scala.scalajs.js

/**
  * Scheduler Class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SchedulerClass extends js.Object {

  /**
    * Gets a scheduler that schedules work via a timed callback based upon platform.
    *
    * For all schedule calls, it defaults to:
    * <ul>
    * <li>Node.js: uses setImmediate for newer builds, and process.nextTick for older versions.</li>
    * Browser: depending on platform may use setImmediate, MessageChannel, window.postMessage and for older versions
    * of IE, it will default to script.onreadystatechanged, else falls back to window.setTimeout.</li>
    * <li>For all relative and absolute scheduling, it defaults to using window.setTimeout.</li>
    * </ul>
    * @see [[Rx.Scheduler.`default`]]
    */
  def async: Scheduler = js.native

  /**
    * Gets a scheduler that schedules work as soon as possible on the current thread.
    * This implementation does not support relative and absolute scheduling due to thread blocking required.
    * @example Rx.Scheduler.currentThread
    */
  def currentThread: Scheduler = js.native

  /**
    * Gets a scheduler that schedules work via a timed callback based upon platform. An alias exists as [[Rx.Scheduler.async]].
    *
    * For all schedule calls, it defaults to:
    * <ul>
    * <li>Node.js: uses setImmediate for newer builds, and process.nextTick for older versions.</li>
    * Browser: depending on platform may use setImmediate, MessageChannel, window.postMessage and for older versions
    * of IE, it will default to script.onreadystatechanged, else falls back to window.setTimeout.</li>
    * <li>For all relative and absolute scheduling, it defaults to using window.setTimeout.</li>
    * </ul>
    */
  def `default`: Scheduler = js.native

  /**
    * Gets a scheduler that schedules work immediately on the current thread.
    * @example Rx.Scheduler.immediate
    */
  def immediate: Scheduler = js.native

  /**
    * Determines whether the given object is a Scheduler instance.
    * @param obj (Any): The object to determine whether it is a Scheduler instance.
    * @return (Boolean): Whether the given object is a Scheduler.
    */
  def isScheduler(obj: js.Any): Boolean = js.native

  /**
    * Normalizes the specified time span value to a positive value.
    * @param timeSpan (Number): The time span value to normalize.
    * @return (Number): The specified time span value if it is zero or positive; otherwise, 0
    * @example Rx.Scheduler.normalize(timeSpan)
    */
  def normalize(timeSpan: TimeSpan): TimeSpan = js.native

}
