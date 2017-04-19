package io.scalajs.nodejs.timers

import scala.scalajs.js

/**
  * Stops an immediateObject, as created by setImmediate, from triggering.
  * @example clearImmediate(immediateObject)
  */
@js.native
trait ClearImmediate extends js.Object {

  /**
    * Stops an immediate, as created by setImmediate, from triggering.
    * @param handle the immediate handle
    * @example clearImmediate(immediateObject)
    */
  def apply(handle: Immediate): Unit = js.native

}
