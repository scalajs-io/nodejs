package io.scalajs.nodejs.timers

import scala.scalajs.js

/**
  * Prevents a timeoutObject, as created by setTimeout, from triggering.
  * @example clearTimeout(timeoutObject)
  */
@js.native
trait ClearTimeout extends js.Object {

  /**
    * Prevents a timeout, as created by setTimeout, from triggering.
    * @example clearTimeout(timeoutObject)
    */
  def apply(handle: Timeout): Unit = js.native

}
