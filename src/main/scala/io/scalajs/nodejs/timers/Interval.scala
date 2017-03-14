package io.scalajs.nodejs.timers

import io.scalajs.nodejs.clearInterval

import scala.scalajs.js

/**
  * Interval Handle
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

  /**
    * Interval Enrichment
    * @param interval the given [[Interval interval]] handle
    */
  implicit class IntervalEnrichment(val interval: Interval) extends AnyVal {

    @inline
    def clear(): Unit = clearInterval(interval)

  }

}
