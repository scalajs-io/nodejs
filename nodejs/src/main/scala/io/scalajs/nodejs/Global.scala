package io.scalajs.nodejs

import io.scalajs.nodejs.timer.{SetInterval, SetTimeout, UnRef, _}

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

  def DTRACE_NET_SERVER_CONNECTION: js.Function = js.native

  def DTRACE_NET_STREAM_END: js.Function = js.native

  def DTRACE_HTTP_SERVER_REQUEST: js.Function = js.native

  def DTRACE_HTTP_SERVER_RESPONSE: js.Function = js.native

  def DTRACE_HTTP_CLIENT_REQUEST: js.Function = js.native

  def DTRACE_HTTP_CLIENT_RESPONSE: js.Function = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Global Constants
  /////////////////////////////////////////////////////////////////////////////////

  /** The name of the directory that the currently executing script resides in. */
  val __dirname: String = js.native

  /**
    * The filename of the code being executed. This is the resolved absolute path of this code file. For a main program
    * this is not necessarily the same filename used in the command line. The value inside a module is the path to that
    * module file.
    */
  val __filename: String = js.native

  /**
    * A reference to the module.exports that is shorter to type. See module system documentation for details on when
    * to use exports and when to use module.exports.
    *
    * exports isn't actually a global but rather local to each module.
    */
  val exports: js.Object = js.native

  /**
    * A reference to the current module. In particular module.exports is used for defining what a module exports and
    * makes available through require().
    *
    * module isn't actually a global but rather local to each module.
    */
  val module: Module = js.native

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
