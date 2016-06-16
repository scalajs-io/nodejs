package org.scalajs.nodejs.timer

import scala.scalajs.js

/**
  * If a timer was previously unref()d, then ref() can be called to explicitly request the timer hold the
  * program open. If the timer is already refd calling ref again will have no effect.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Ref extends js.Object {

  /**
    * If a timer was previously unref()d, then ref() can be called to explicitly request the timer hold the
    * program open. If the timer is already refd calling ref again will have no effect.
    *
    * Returns the timer.
    * @example ref()
    */
  def apply(): Timer = js.native

}
