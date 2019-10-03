package io.scalajs.nodejs.timers

import io.scalajs.nodejs.clearInterval

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

/**
  * Interval Companion
  */
object Interval {

  /**
    * Interval Enrichment
    * @param handle the given [[Interval interval]] handle
    */
  implicit final class IntervalEnrichment(val handle: Interval) extends AnyVal {

    @inline
    def clear(): Unit = clearInterval(handle)

  }

}
