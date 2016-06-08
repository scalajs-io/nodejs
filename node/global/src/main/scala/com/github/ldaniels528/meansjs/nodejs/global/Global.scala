package com.github.ldaniels528.meansjs.nodejs.global

import com.github.ldaniels528.meansjs.nodejs.Console
import com.github.ldaniels528.meansjs.nodejs.buffer.BufferClass
import com.github.ldaniels528.meansjs.nodejs.timer.{SetInterval, SetTimeout, UnRef, _}

import scala.scalajs.js

/**
  * In browsers, the top-level scope is the global scope. That means that in browsers if you're in the global scope var
  * something will define a global variable. In Node.js this is different. The top-level scope is not the global scope;
  * var something inside an Node.js module will be local to that module.
  */
@js.native
trait Global extends js.Object {

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

  def clearImmediate: ClearImmediate = js.native

  def clearInterval: ClearInterval = js.native

  def clearTimeout: ClearTimeout = js.native

  def console: Console = js.native

  def process: Process = js.native

  def ref: Ref = js.native

  def setImmediate: SetImmediate = js.native

  def setInterval: SetInterval = js.native

  def setTimeout: SetTimeout = js.native

  def unref: UnRef = js.native

}
