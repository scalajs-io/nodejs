package io.scalajs.nodejs.repl

import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.readline.Interface

import scala.scalajs.js

/**
  * REPL Server
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait REPLServer extends IEventEmitter with Interface {

  /**
    * The REPL's context
    */
  val context: REPLContext = js.native

  /**
    * The replServer.defineCommand() method is used to add new .-prefixed commands to the REPL instance.
    * Such commands are invoked by typing a period (.) followed by the keyword. The cmd is either a Function
    * or an object with the following properties:
    * <ul>
    * <li>help (string) Help text to be displayed when .help is entered (Optional).</li>
    * <li>action (Function) The function to execute, optionally accepting a single string argument.</li>
    * </ul>
    * @param keyword The command keyword (without a leading . character).
    * @param cmd     The function to invoke when the command is processed.
    */
  def defineCommand(keyword: String, cmd: js.Function0[Any]): Unit = js.native

  /**
    * The replServer.displayPrompt() method readies the REPL instance for input from the user, printing the
    * configured prompt to a new line in the output and resuming the input to accept new input.
    *
    * When multi-line input is being entered, an ellipsis is printed rather than the 'prompt'.
    * *
    * When preserveCursor is true, the cursor placement will not be reset to 0.
    *
    * The replServer.displayPrompt method is primarily intended to be called from within the action function
    * for commands registered using the replServer.defineCommand() method.
    * @param preserveCursor indicates whether to preserver the cursor (position?)
    */
  def displayPrompt(preserveCursor: Boolean = js.native): Unit = js.native

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
    @inline
    def onExit(callback: js.Function): server.type = server.on("exit", callback)

    /**
      * Emitted when the REPL's context is reset. This happens when you type .clear. If you start the repl
      * with { useGlobal: true } then this event will never be emitted.
      */
    @inline
    def onReset(callback: js.Function): server.type = server.on("reset", callback)

  }

}