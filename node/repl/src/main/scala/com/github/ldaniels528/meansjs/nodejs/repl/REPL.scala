package com.github.ldaniels528.meansjs.nodejs.repl

import com.github.ldaniels528.meansjs.nodejs.{NodeModule, NodeRequire}
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter
import com.github.ldaniels528.meansjs.nodejs.net.Socket

import scala.scalajs.js

/**
  * NodeJS REPL module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait REPL extends NodeModule with EventEmitter {
  var REPL_MODE_SLOPPY: String = js.native
  var REPL_MODE_STRICT: String = js.native
  var REPL_MODE_MAGIC: String = js.native

  /**
    * @example repl.start([options])
    */
  def start(options: REPLOptions): REPLServer = js.native

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
  * REPL Companion
  * @author lawrence.daniels@gmail.com
  */
object REPL {

  /**
    * Convenience method for retrieving the repl module
    * @param require the implicit [[NodeRequire require function]]
    * @return the REPL instance
    */
  def apply()(implicit require: NodeRequire) = require[REPL]("repl")

}