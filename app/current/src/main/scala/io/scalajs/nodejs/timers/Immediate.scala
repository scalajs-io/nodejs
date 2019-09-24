package io.scalajs.nodejs.timers

import com.thoughtworks.enableIf
import io.scalajs.nodejs.clearImmediate

import scala.scalajs.js

/**
  * Immediate Handle
  */
@js.native
trait Immediate extends js.Object {

  def _onImmediate: js.Function = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs12)
  def hasRef(): Boolean = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def ref(): Immediate = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def unref(): Immediate = js.native
}

/**
  * Immediate Companion
  */
object Immediate {

  /**
    * Immediate Enrichment
    * @param immediate the given [[Immediate immediate]] handle
    */
  implicit class ImmediateEnrichment(val immediate: Immediate) extends AnyVal {

    @inline
    def clear(): Unit = clearImmediate(immediate)

  }

}
