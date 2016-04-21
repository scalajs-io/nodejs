package com.github.ldaniels528.meansjs.nodejs.timer

import scala.scalajs.js

/**
  * Schedules "immediate" execution of callback after I/O events' callbacks and before timers set
  * by setTimeout and setInterval are triggered. Returns an immediateObject for possible use with
  * clearImmediate. Additional optional arguments may be passed to the callback.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SetImmediate extends js.Object {

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
  def apply(callback: js.Function, args: js.Array[js.Any]): Immediate = js.native

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
  def apply(callback: js.Function): Immediate = js.native

}

/**
  * Set Immediate Companion
  * @author lawrence.daniels@gmail.com
  */
object SetImmediate {

  /**
    * Set Immediate Extensions
    * @param command the given [[SetImmediate command]] instance
    */
  implicit class SetImmediateExtensions(val command: SetImmediate) extends AnyVal {

    def apply(callback: js.Function, args: js.Any*) = {
      command.apply(callback, js.Array(args: _*))
    }

  }

}