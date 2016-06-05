package com.github.ldaniels528.meansjs.nodejs

import com.github.ldaniels528.meansjs.nodejs.buffer.BufferClass
import com.github.ldaniels528.meansjs.nodejs.timer.{SetInterval, SetTimeout, UnRef, _}

import scala.scalajs.js

/**
  * In browsers, the top-level scope is the global scope. That means that in browsers if you're in the global scope var
  * something will define a global variable. In Node.js this is different. The top-level scope is not the global scope;
  * var something inside an Node.js module will be local to that module.
  */
@js.native
trait GlobalObject extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Global Classes
  /////////////////////////////////////////////////////////////////////////////////

  def Buffer: BufferClass = js.native

  def DTRACE_NET_SERVER_CONNECTION: js.Function = js.native

  def DTRACE_NET_STREAM_END: js.Function = js.native

  def DTRACE_HTTP_SERVER_REQUEST: js.Function = js.native

  def DTRACE_HTTP_SERVER_RESPONSE: js.Function = js.native

  def DTRACE_HTTP_CLIENT_REQUEST: js.Function = js.native

  def DTRACE_HTTP_CLIENT_RESPONSE: js.Function = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Global Objects
  /////////////////////////////////////////////////////////////////////////////////

  val clearImmediate: ClearImmediate = js.native

  val clearInterval: ClearInterval = js.native

  val clearTimeout: ClearTimeout = js.native

  val console: Console = js.native

  val process: Process = js.native

  val ref: Ref = js.native

  val setImmediate: SetImmediate = js.native

  val setInterval: SetInterval = js.native

  val setTimeout: SetTimeout = js.native

  val unref: UnRef = js.native

}
