package org.scalajs.nodejs.timer

import scala.scalajs.js

/**
  * Interval Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Interval extends Timeout {

  def _idleStart: js.UndefOr[Int] = js.native

  def _idleTimeout: js.UndefOr[Int] = js.native

  def _idlePrev: Interval.TimerList = js.native

}


/**
  * Interval Companion
  * @author lawrence.daniels@gmail.com
  */
object Interval {

  @js.native
  trait TimerList extends js.Object {

    def _timer: SetTimeout = js.native

    def _unrefed: js.UndefOr[Boolean] = js.native

    def msecs: js.UndefOr[Int] = js.native

  }

}