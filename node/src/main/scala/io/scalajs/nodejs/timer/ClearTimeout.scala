package io.scalajs.nodejs.timer

import scala.scalajs.js

/**
  * Prevents a timeoutObject, as created by setTimeout, from triggering.
  * @example clearTimeout(timeoutObject)
  */
@js.native
trait ClearTimeout extends js.Object {

  /**
    * Prevents a timeoutObject, as created by setTimeout, from triggering.
    * @example clearTimeout(timeoutObject)
    */
  def apply(timeoutObject: Timeout): Unit = js.native

}
