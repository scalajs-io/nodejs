package io.scalajs.nodejs.repl

import io.scalajs.RawOptions
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.net.Socket

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * The repl module provides a Read-Eval-Print-Loop (REPL) implementation that is available
  * both as a standalone program or includable in other applications.
  * @see https://nodejs.org/api/repl.html#repl_repl
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait REPL extends IEventEmitter {
  var REPL_MODE_SLOPPY: String = js.native
  var REPL_MODE_STRICT: String = js.native
  var REPL_MODE_MAGIC: String  = js.native

  /**
    * @example repl.start([options])
    */
  def start(options: REPLOptions | RawOptions): REPLServer = js.native

  /**
    * @example repl.start([options])
    */
  def start(prompt: String, socket: Socket): REPLServer = js.native

  /**
    * @example repl.start([options])
    */
  def start(prompt: String): REPLServer = js.native

  /**
    * @example repl.start([options])
    */
  def start(): REPLServer = js.native

}

/**
  * REPL Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("repl", JSImport.Namespace)
object REPL extends REPL
