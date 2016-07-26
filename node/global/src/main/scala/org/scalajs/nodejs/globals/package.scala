package org.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * global package object
  * @author lawrence.daniels@gmail.com
  */
package object globals {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * In browsers, the top-level scope is the global scope. That means that in browsers if you're in the global scope
    * var something will define a global variable. In Node.js this is different. The top-level scope is not the global
    * scope; var something inside a Node.js module will be local to that module.
    */
  @js.native
  @JSName("global")
  object global extends Global

  /**
    * The process object. See the process object section.
    */
  @js.native
  @JSName("process")
  object process extends Process

  /////////////////////////////////////////////////////////////////////////////////
  //      Exit Codes -  Node.js will normally exit with a 0 status code when no more
  //                    async operations are pending. The following status codes are
  //                    used in other cases:
  /////////////////////////////////////////////////////////////////////////////////

  type ExitCode = Int

  /**
    * There was an uncaught exception, and it was not handled by a domain or an 'uncaughtException' event handler.
    */
  val UncaughtFatalException: ExitCode = 1

  /**
    * The JavaScript source code internal in Node.js's bootstrapping process caused a parse error. This is extremely
    * rare, and generally can only happen during development of Node.js itself.
    */
  val InternalJavaScriptParseError: ExitCode = 3

  /**
    * The JavaScript source code internal in Node.js's bootstrapping process failed to return a function value when
    * evaluated. This is extremely rare, and generally can only happen during development of Node.js itself.
    */
  val InternalJavaScriptEvaluationFailure: ExitCode = 4

  /**
    * There was a fatal unrecoverable error in V8. Typically a message will be printed to stderr with the prefix FATAL ERROR.
    */
  val FatalError: ExitCode = 5

  /**
    * There was an uncaught exception, but the internal fatal exception handler function was somehow set to a non-function,
    * and could not be called.
    */
  val NonFunctionInternalExceptionHandler: ExitCode = 6

  /**
    * There was an uncaught exception, and the internal fatal exception handler function itself threw an error while
    * attempting to handle it. This can happen, for example, if a 'uncaughtException' or domain.on('error') handler
    * throws an error.
    */
  val InternalExceptionHandlerRunTimeFailure: ExitCode = 7

  /**
    * Either an unknown option was specified, or an option requiring a value was provided without a value.
    */
  val InvalidArgument: ExitCode = 8

  /**
    * The JavaScript source code internal in Node.js's bootstrapping process threw an error when the bootstrapping
    * function was called. This is extremely rare, and generally can only happen during development of Node.js itself.
    */
  val InternalJavaScriptRunTimeFailure: ExitCode = 10

  /**
    * The --debug and/or --debug-brk options were set, but an invalid port number was chosen.
    */
  val InvalidDebugArgument: ExitCode = 12

  /**
    * If Node.js receives a fatal signal such as SIGKILL or SIGHUP, then its exit code will be 128 plus the value of
    * the signal code. This is a standard Unix practice, since exit codes are defined to be 7-bit integers, and signal
    * exits set the high-order bit, and then contain the value of the signal code.
    */
  val SignalExits: ExitCode = 128

}
