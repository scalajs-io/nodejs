package io.scalajs.nodejs

import scala.scalajs.js

/**
  * repl package object
  */
package object repl {

  type REPLContext = js.Dynamic

  /**
    * REPL Server events
    * @param server the given [[REPLServer instance]]
    */
  implicit final class REPLServerEvents(val server: REPLServer) extends AnyVal {

    @inline
    def contextAs[T]: T = server.context.asInstanceOf[T]

    /**
      * The 'exit' event is emitted when the REPL is exited either by receiving the .exit command as input,
      * the user pressing CTRL-C twice to signal SIGINT, or by pressing CTRL-D to signal 'end' on the input stream.
      * The listener callback is invoked without any arguments.
      * @param listener The listener callback
      */
    @inline
    def onExit(listener: () => Any): REPLServer = server.on("exit", listener)

    /**
      * The 'reset' event is emitted when the REPL's context is reset. This occurs whenever the .clear command
      * is received as input unless the REPL is using the default evaluator and the repl.REPLServer instance
      * was created with the useGlobal option set to true. The listener callback will be called with a reference
      * to the context object as the only argument.
      * @param listener The listener callback
      */
    @inline
    def onReset(listener: REPLContext => Any): REPLServer = server.on("reset", listener)

  }

  /**
    * Various behaviors of the Node.js REPL can be customized using the following environment variables:
    * <ul>
    * <li>NODE_REPL_HISTORY</li>
    * <li>NODE_REPL_HISTORY_SIZE</li>
    * <li>NODE_REPL_MODE</li>
    * </ul>
    */
  implicit final class EnvironmentVariableOptions(private val env: process.Environment) extends AnyVal {

    /**
      * When a valid path is given, persistent REPL history will be saved to the specified file rather
      * than .node_repl_history in the user's home directory. Setting this value to "" will disable persistent
      * REPL history. Whitespace will be trimmed from the value.
      */
    @inline
    def NODE_REPL_HISTORY: Option[String] = env("NODE_REPL_HISTORY").toOption

    /**
      * Defaults to 1000. Controls how many lines of history will be persisted if history is available.
      * Must be a positive number.
      */
    @inline
    def NODE_REPL_HISTORY_SIZE: Option[Int] = env("NODE_REPL_HISTORY_SIZE").map(_.toInt).toOption

    /**
      * May be any of sloppy, strict, or magic. Defaults to magic, which will automatically run "strict mode only"
      * statements in strict mode.
      */
    @inline
    def NODE_REPL_MODE: Option[String] = env("NODE_REPL_MODE").toOption

  }

}
