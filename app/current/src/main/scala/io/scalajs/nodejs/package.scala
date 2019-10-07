package io.scalajs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.timers._

import scala.concurrent.duration.FiniteDuration
import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * nodejs package object
  */
package object nodejs {

  /////////////////////////////////////////////////////////////////////////////////
  //      Type Definitions
  /////////////////////////////////////////////////////////////////////////////////

  @deprecated("use process.Process instead", "0.9.0")
  type Process = process.Process

  @deprecated("use process.Environment instead", "0.9.0")
  type Environment = process.Environment

  type EventType = String

  /**
    * Represents a file descriptor
    */
  type FileDescriptor = Integer

  type FileIOError = SystemError

  type FileMode = Int

  type FileType = Int

  type Flags = String | Int

  type FsCallback0 = js.Function1[FileIOError, Any]

  type FsCallback1[A] = js.Function2[FileIOError, A, Any]

  type FsCallback2[A, B] = js.Function3[FileIOError, A, B, Any]

  type FsCallback3[A, B, C] = js.Function4[FileIOError, A, B, C, Any]

  type GID = Int

  type UID = Int

  // The handle object can be either a server, a socket (anything with an underlying _handle member), or an object with an fd member that is a valid file descriptor.
  type Handle = js.Function | HasHandle | HasFileDescriptor

  /////////////////////////////////////////////////////////////////////////////////
  //      Built-in Properties
  /////////////////////////////////////////////////////////////////////////////////
  @deprecated("Use console_module.Console. Every module stays each own package.", "0.9.0")
  type Console = console_module.Console

  @deprecated("Use console_module.Console. Every module stays each own package.", "0.9.0")
  type ConsoleDirOptions = console_module.ConsoleDirOptions

  @deprecated("Use console_module.Console. Every module stays each own package.", "0.9.0")
  val console = console_module.Console

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

  @js.native
  @JSGlobal("global")
  @deprecated("Use objects in io.scalajs.nodejs", "0.9.0")
  object global extends Global

  @js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  @JSGlobal("queueMicrotask")
  object queueMicrotask extends js.Function1[js.Function, Unit] {
    override def apply(arg1: js.Function): Unit = js.native
  }

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
  @JSGlobal("setImmediate")
  object setImmediate extends SetImmediate

  @js.native
  @JSGlobal("setInterval")
  object setInterval extends SetInterval

  @js.native
  @JSGlobal("setTimeout")
  object setTimeout extends SetTimeout

  /////////////////////////////////////////////////////////////////////////////////
  //      Implicit Conversions
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Implicit conversion to translate durations into an integer
    * @param duration the given [[FiniteDuration duration]]
    * @return the time in milliseconds as an integer
    */
  @deprecated("Use io.scalajs.util.DurationHelper", "0.9.0")
  implicit def duration2Int(duration: FiniteDuration): Int = duration.toMillis.toInt

  /**
    * Implicit conversion to translate durations into a double
    * @param duration the given [[FiniteDuration duration]]
    * @return the time in milliseconds as a double
    */
  @deprecated("Use io.scalajs.util.DurationHelper", "0.9.0")
  implicit def duration2Double(duration: FiniteDuration): Double = duration.toMillis.toDouble

  /**
    * Implicit conversion to transform Node [[Error]]s to [[Exception]]s
    * @param error the given [[Error]]
    * @return the resulting [[Exception]]
    */
  @deprecated("Use toException extension method from io.scalajs.util.NodeJSConverters._", "0.9.0")
  implicit def error2Exception(error: Error): Exception =
    io.scalajs.util.NodeJSConverters.ErrorExtension(error).toException()
}
