package io.scalajs.nodejs.timers

import com.thoughtworks.enableIf

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

  def refresh(): Timeout = js.native

  def ref(): Timeout   = js.native
  def unref(): Timeout = js.native
}
