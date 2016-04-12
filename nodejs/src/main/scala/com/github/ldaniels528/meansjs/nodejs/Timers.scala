package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js

/**
  * Timers
  * @author lawrence.daniels@gmail.com
  */
@js.native
object Timers extends js.Object {

  /**
    * Stops an immediateObject, as created by setImmediate, from triggering.
    * @example clearImmediate(immediateObject)
    */
  def clearImmediate(immediateObject: js.Any): Unit = js.native

  /**
    * Stops an intervalObject, as created by setInterval, from triggering.
    * @example clearInterval(intervalObject)
    */
  def clearInterval(intervalObject: js.Any): Unit = js.native

  /**
    * Prevents a timeoutObject, as created by setTimeout, from triggering.
    * @example clearTimeout(timeoutObject)
    */
  def clearTimeout(timeoutObject: js.Any): Unit = js.native

  /**
    * If a timer was previously unref()d, then ref() can be called to explicitly request the timer hold the
    * program open. If the timer is already refd calling ref again will have no effect.
    * Returns the timer.
    */
  def ref(): Unit = js.native

  /**
    * Schedules "immediate" execution of callback after I/O events' callbacks and before timers set
    * by setTimeout and setInterval are triggered. Returns an immediateObject for possible use with
    * clearImmediate. Additional optional arguments may be passed to the callback.
    *
    * Callbacks for immediates are queued in the order in which they were created. The entire callback
    * queue is processed every event loop iteration. If an immediate is queued from inside an executing
    * callback, that immediate won't fire until the next event loop iteration.
    * @example setImmediate(callback[, arg][, ...])
    */
  def setImmediate(callback: js.Function, arg: js.Any, args: js.Any*): Unit = js.native

}
