package com.github.ldaniels528.meansjs.nodejs.timer

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
  def apply(callback: js.Function, delay: Int, args: js.Array[js.Any]): Interval = js.native

  /**
    * Schedules repeated execution of callback every delay milliseconds. Returns a intervalObject for possible
    * use with clearInterval. Additional optional arguments may be passed to the callback.
    *
    * To follow browser behavior, when using delays larger than 2147483647 milliseconds (approximately 25 days)
    * or less than 1, Node.js will use 1 as the delay.
    * @example setInterval(callback, delay[, arg][, ...])
    */
  def apply(callback: js.Function, delay: Int): Interval = js.native

}

/**
  * Set Interval Companion
  * @author lawrence.daniels@gmail.com
  */
object SetInterval {

  /**
    * Set Interval Enrichment
    * @param command the given [[SetInterval command]] instance
    */
  implicit class SetIntervalEnrichment(val command: SetInterval) extends AnyVal {

    def apply(callback: js.Function, delay: Int, args: js.Any*) = {
      command.apply(callback, delay, js.Array(args: _*))
    }

  }

}