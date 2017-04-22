package io.scalajs

import io.scalajs.nodejs.timers._

import scala.concurrent.duration.FiniteDuration
import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * nodejs package object
  * @author lawrence.daniels@gmail.com
  */
package object nodejs {

  /**
    * Represents a file descriptor
    */
  type FileDescriptor = Integer

  type Environment = js.Dictionary[String]

  /////////////////////////////////////////////////////////////////////////////////
  //      Built-in Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Used to print to stdout and stderr. See the console section.
    */
  @js.native
  @JSGlobal("console")
  object console extends Console(null)

  /**
    * The directory name of the current module. This the same as the path.dirname() of the [[__filename]].
    */
  def __dirname: String = js.Dynamic.global.__dirname.asInstanceOf[String]

  /**
    * The file name of the current module. This is the resolved absolute path of the current module file.
    * For a main program this is not necessarily the same as the file name used in the command line.
    * See [[__dirname]] for the directory name of the current module.
    */
  def __filename: String = js.Dynamic.global.__filename.asInstanceOf[String]

  /**
    * In browsers, the top-level scope is the global scope. That means that in browsers if you're in the global scope
    * var something will define a global variable. In Node.js this is different. The top-level scope is not the global
    * scope; var something inside a Node.js module will be local to that module.
    */
  @js.native
  @JSGlobal("global")
  object global extends Global

  /**
    * The process object. See the process object section.
    */
  @js.native
  @JSGlobal("process")
  object process extends Process

  /////////////////////////////////////////////////////////////////////////////////
  //      Timers
  /////////////////////////////////////////////////////////////////////////////////

  @js.native
  @JSGlobal("clearImmediate")
  object clearImmediate extends ClearImmediate

  @js.native
  @JSGlobal("clearInterval")
  object clearInterval extends ClearInterval

  @js.native
  @JSGlobal("clearTimeout")
  object clearTimeout extends ClearTimeout

  @js.native
  @JSGlobal("ref")
  object ref extends Ref

  @js.native
  @JSGlobal("setImmediate")
  object setImmediate extends SetImmediate

  @js.native
  @JSGlobal("setInterval")
  object setInterval extends SetInterval

  @js.native
  @JSGlobal("setTimeout")
  object setTimeout extends SetTimeout

  @js.native
  @JSGlobal("unref")
  object unref extends UnRef

  /////////////////////////////////////////////////////////////////////////////////
  //      Implicit Conversions
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Implicit conversion to translate durations into an integer
    * @param duration the given [[FiniteDuration duration]]
    * @return the time in milliseconds as an integer
    */
  implicit def duration2Int(duration: FiniteDuration): Int = duration.toMillis.toInt

  /**
    * Implicit conversion to translate durations into a double
    * @param duration the given [[FiniteDuration duration]]
    * @return the time in milliseconds as a double
    */
  implicit def duration2Double(duration: FiniteDuration): Double = duration.toMillis.toDouble

  /**
    * Implicit conversion to transform Node [[Error]]s to [[Exception]]s
    * @param error the given [[Error]]
    * @return the resulting [[Exception]]
    */
  implicit def error2Exception(error: Error): Exception = js.JavaScriptException(error.message)

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
