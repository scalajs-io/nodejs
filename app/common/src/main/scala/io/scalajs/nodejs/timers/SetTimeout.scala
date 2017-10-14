package io.scalajs.nodejs.timers

import scala.scalajs.js

/**
  * Schedules execution of a one-time callback after delay milliseconds. Returns a timeoutObject for possible
  * use with clearTimeout. Additional optional arguments may be passed to the callback.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SetTimeout extends js.Object {

  /**
    * Schedules execution of a one-time callback after delay milliseconds. Returns a timeoutObject for possible
    * use with clearTimeout. Additional optional arguments may be passed to the callback.
    *
    * The callback will likely not be invoked in precisely delay milliseconds. Node.js makes no guarantees about
    * the exact timing of when callbacks will fire, nor of their ordering. The callback will be called as close
    * as possible to the time specified.
    *
    * To follow browser behavior, when using delays larger than 2147483647 milliseconds (approximately 25 days)
    * or less than 1, the timeout is executed immediately, as if the delay was set to 1.
    * @example setTimeout(callback, delay[, arg][, ...])
    */
  def apply(callback: js.Function, delay: Int, args: js.Any*): Timeout = js.native

}
