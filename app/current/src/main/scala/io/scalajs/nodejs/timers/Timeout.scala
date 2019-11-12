package io.scalajs.nodejs.timers

import com.thoughtworks.enableIf
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
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def hasRef(): Boolean = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def refresh(): Timeout = js.native

  def ref(): Timeout   = js.native
  def unref(): Timeout = js.native
}

/**
  * Timeout Companion
  */
object Timeout {
  /**
    * Timeout Enrichment
    * @param handle the given [[Timeout timeout]] handle
    */
  implicit final class TimeoutEnrichment(val handle: Timeout) extends AnyVal {
    @inline
    def clear(): Unit = clearTimeout(handle)
  }
}
