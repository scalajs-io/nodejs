package io.scalajs.nodejs.timers

import scala.scalajs.js

/**
  * Interval Handle
  */
@js.native
trait Interval extends js.Object {

  /**
    * Indicates whether the interval has been called
    * @return true, if the interval has already been called
    */
  def _called: Boolean = js.native
}
