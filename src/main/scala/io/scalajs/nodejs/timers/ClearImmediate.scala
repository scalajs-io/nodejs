package io.scalajs.nodejs.timers

import scala.scalajs.js

/**
  * Stops an immediateObject, as created by setImmediate, from triggering.
  * @example clearImmediate(immediateObject)
  */
@js.native
trait ClearImmediate extends js.Object {

  /**
    * Stops an immediateObject, as created by setImmediate, from triggering.
    * @example clearImmediate(immediateObject)
    */
  def apply(immediateObject: Immediate): Unit = js.native

}
