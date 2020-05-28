package io.scalajs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.timers._

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

  type FsRecursiveCallback0 = js.Function2[FileIOError, fs.Path, Any]

  type GID = Int

  type UID = Int

  // The handle object can be either a server, a socket (anything with an underlying _handle member), or an object with an fd member that is a valid file descriptor.
  type Handle = js.Function | HasHandle | HasFileDescriptor

  /////////////////////////////////////////////////////////////////////////////////
  //      Built-in Properties
  /////////////////////////////////////////////////////////////////////////////////

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

  implicit final class ErrorExtensions(val error: Error) extends AnyVal {
    @inline
    def toException(): Exception = js.JavaScriptException(error.message)
  }
}
