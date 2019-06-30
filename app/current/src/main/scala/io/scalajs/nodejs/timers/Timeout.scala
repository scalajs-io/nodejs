package io.scalajs.nodejs.timers

import io.scalajs.nodejs.clearTimeout

import scala.scalajs.js

/**
  * Timeout Handle
  */
@js.native
trait Timeout extends js.Object {

  /**
    * Indicates whether the timeout has been called
    * @return true, if the timeout has already been called
    */
  def _called: Boolean = js.native

}

/**
  * Timeout Companion
  */
object Timeout {

  /**
    * Timeout Enrichment
    * @param handle the given [[Timeout timeout]] handle
    */
  implicit class TimeoutEnrichment(val handle: Timeout) extends AnyVal {

    @inline
    def clear(): Unit = clearTimeout(handle)

  }

}
