package org.scalajs.nodejs.timer

import scala.scalajs.js

/**
  * Schedules repeated execution of callback every delay milliseconds. Returns a intervalObject for possible
  * use with clearInterval. Additional optional arguments may be passed to the callback.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SetInterval extends js.Object {

  /**
    * Schedules repeated execution of callback every delay milliseconds. Returns a intervalObject for possible
    * use with clearInterval. Additional optional arguments may be passed to the callback.
    *
    * To follow browser behavior, when using delays larger than 2147483647 milliseconds (approximately 25 days)
    * or less than 1, Node.js will use 1 as the delay.
    * @example setInterval(callback, delay[, arg][, ...])
    */
  def apply(callback: js.Function, delay: Int, args: js.Any*): Interval = js.native

}
