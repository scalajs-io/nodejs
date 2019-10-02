package io.scalajs.nodejs

import io.scalajs.nodejs.timers._

import scala.scalajs.js

/**
  * In browsers, the top-level scope is the global scope. That means that in browsers if you're in the global scope var
  * something will define a global variable. In Node.js this is different. The top-level scope is not the global scope;
  * var something inside an Node.js module will be local to that module.
  */
@js.native
@deprecated("Use io.scalajs.nodejs package object", "0.9.0")
trait Global extends js.Object {
  @deprecated("Use io.scalajs.nodejs.exports", "0.9.0")
  def exports: js.UndefOr[js.Object] = js.native

  /**
    * A reference to the current module. In particular module.exports is used for defining what a module exports and
    * makes available through require().
    *
    * module isn't actually a global but rather local to each module.
    */
  @deprecated("Use io.scalajs.nodejs.module", "0.9.0")
  def module: Module = js.native

  @deprecated("Use io.scalajs.nodejs.clearImmediate", "0.9.0")
  def clearImmediate: ClearImmediate = js.native

  @deprecated("Use io.scalajs.nodejs.clearInterval", "0.9.0")
  def clearInterval: ClearInterval = js.native

  @deprecated("Use io.scalajs.nodejs.clearTimeout", "0.9.0")
  def clearTimeout: ClearTimeout = js.native

  @deprecated("Use io.scalajs.nodejs.console", "0.9.0")
  def console: console_module.Console = js.native

  @deprecated("Use io.scalajs.nodejs.process", "0.9.0")
  def process: io.scalajs.nodejs.process.Process = js.native

  @deprecated("Use io.scalajs.nodejs.setImmediate", "0.9.0")
  def setImmediate: SetImmediate = js.native

  @deprecated("Use io.scalajs.nodejs.setInterval", "0.9.0")
  def setInterval: SetInterval = js.native

  @deprecated("Use io.scalajs.nodejs.setTimeout", "0.9.0")
  def setTimeout: SetTimeout = js.native

}
