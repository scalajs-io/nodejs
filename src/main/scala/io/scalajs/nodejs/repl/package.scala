package io.scalajs.nodejs

import scala.scalajs.js

/**
  * repl package object
  * @author lawrence.daniels@gmail.com
  */
package object repl {

  type REPLContext = js.Dynamic

  /**
    * REPL Server events
    * @param server the given [[REPLServer instance]]
    */
  final implicit class REPLServerEvents(val server: REPLServer) extends AnyVal {

    @inline
    def contextAs[T]: T = server.context.asInstanceOf[T]

    /**
      * The 'exit' event is emitted when the REPL is exited either by receiving the .exit command as input,
      * the user pressing CTRL-C twice to signal SIGINT, or by pressing CTRL-D to signal 'end' on the input stream.
      * The listener callback is invoked without any arguments.
      * @param listener The listener callback
      */
    @inline
    def onExit(listener: () => Any): server.type = server.on("exit", listener)

    /**
      * The 'reset' event is emitted when the REPL's context is reset. This occurs whenever the .clear command
      * is received as input unless the REPL is using the default evaluator and the repl.REPLServer instance
      * was created with the useGlobal option set to true. The listener callback will be called with a reference
      * to the context object as the only argument.
      * @param listener The listener callback
      */
    @inline
    def onReset(listener: REPLContext => Any): server.type = server.on("reset", listener)

  }

  /**
    * Various behaviors of the Node.js REPL can be customized using the following environment variables:
    * <ul>
    * <li>NODE_REPL_HISTORY</li>
    * <li>NODE_REPL_HISTORY_SIZE</li>
    * <li>NODE_REPL_MODE</li>
    * </ul>
    */
  final implicit class EnvironmentVariableOptions(val env: Environment) extends AnyVal {

    /**
      * When a valid path is given, persistent REPL history will be saved to the specified file rather
      * than .node_repl_history in the user's home directory. Setting this value to "" will disable persistent
      * REPL history. Whitespace will be trimmed from the value.
      */
    @inline
    def NODE_REPL_HISTORY: Option[String] = env.get("NODE_REPL_HISTORY")

    /**
      * Previously in Node.js/io.js v2.x, REPL history was controlled by using a NODE_REPL_HISTORY_FILE environment
      * variable, and the history was saved in JSON format. This variable has now been deprecated, and the old
      * JSON REPL history file will be automatically converted to a simplified plain text format. This new file
      * will be saved to either the user's home directory, or a directory defined by the NODE_REPL_HISTORY variable,
      * as documented in the Environment Variable Options.
      */
    @inline
    @deprecated("Use NODE_REPL_HISTORY instead.", since = "3.0.0")
    def NODE_REPL_HISTORY_FILE: Option[String] = env.get("NODE_REPL_HISTORY_FILE")

    /**
      * Defaults to 1000. Controls how many lines of history will be persisted if history is available.
      * Must be a positive number.
      */
    @inline
    def NODE_REPL_HISTORY_SIZE: Option[Int] = env.get("NODE_REPL_HISTORY_SIZE").map(_.toInt)

    /**
      * May be any of sloppy, strict, or magic. Defaults to magic, which will automatically run "strict mode only"
      * statements in strict mode.
      */
    @inline
    def NODE_REPL_MODE: Option[String] = env.get("NODE_REPL_MODE")

  }

}
