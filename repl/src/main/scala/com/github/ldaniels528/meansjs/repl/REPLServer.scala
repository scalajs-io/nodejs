package com.github.ldaniels528.meansjs.repl

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter
import com.github.ldaniels528.meansjs.nodejs.readline.Interface

import scala.scalajs.js

/**
  * REPL Server
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait REPLServer extends EventEmitter with Interface {

  /**
    * The REPL's context
    */
  // TODO find document for this property
  val context: js.Dynamic = js.native

  /**
    * Makes a command available in the REPL. The command is invoked by typing a . followed by the keyword.
    * The cmd is an object with the following values:
    * <ul>
    * <li>help - help text to be displayed when .help is entered (Optional).</li>
    * <li>action - a function to execute, potentially taking in a string argument, when the command is invoked,
    * bound to the REPLServer instance (Required).</li>
    * </ul>
    * If a function is provided instead of an object for cmd, it is treated as the action.
    * @example replServer.defineCommand(keyword, cmd)
    */
  def defineCommand(keyword: String, cmd: js.Any): Unit = js.native

  /**
    * Like readline.prompt except also adding indents with ellipses when inside blocks. The preserveCursor argument
    * is passed to readline.prompt. This is used primarily with defineCommand. It's also used internally to render
    * each prompt line.
    * @example replServer.displayPrompt([preserveCursor])
    * @see [[prompt()]]
    */
  def displayPrompt(preserveCursor: Boolean): Unit = js.native

  /**
    * Like readline.prompt except also adding indents with ellipses when inside blocks. The preserveCursor argument
    * is passed to readline.prompt. This is used primarily with defineCommand. It's also used internally to render
    * each prompt line.
    * @example replServer.displayPrompt([preserveCursor])
    * @see [[prompt()]]
    */
  def displayPrompt(): Unit = js.native

}

/**
  * REPL Server Companion
  * @author lawrence.daniels@gmail.com
  */
object REPLServer {

  /**
    * REPL Server Extensions
    * @param server the given [[REPLServer REPL Server]]
    */
  implicit class REPLServerExtensions(val server: REPLServer) extends AnyVal {

    /**
      * Emitted when the user exits the REPL in any of the defined ways. Namely, typing .exit at the repl,
      * pressing Ctrl+C twice to signal SIGINT, or pressing Ctrl+D to signal 'end' on the input stream.
      */
    def onExit(callback: js.Function) = server.on("exit", callback)

    /**
      * Emitted when the REPL's context is reset. This happens when you type .clear. If you start the repl
      * with { useGlobal: true } then this event will never be emitted.
      */
    def onReset(callback: js.Function) = server.on("reset", callback)

  }

}