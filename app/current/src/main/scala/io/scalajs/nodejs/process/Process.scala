package io.scalajs.nodejs.process

import com.thoughtworks.{enableIf, enableMembersIf}
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.tty.{ReadStream, WriteStream}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * The process object is a global object and can be accessed from anywhere. It is an instance of EventEmitter.
  */
@js.native
trait Process extends IEventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  def allowedNodeEnvironmentFlags: EnvironmentFlags = js.native

  /**
    * What processor architecture you're running on: 'arm', 'ia32', or 'x64'.
    * @example process.arch
    */
  def arch: String = js.native

  /**
    * An array containing the command line arguments. The first element will be 'node', the second element will be
    * the name of the JavaScript file. The next elements will be any additional command line arguments.
    * @example process.argv
    */
  def argv: js.Array[String] = js.native

  def argv0: String = js.native

  def channel: js.UndefOr[js.Object] = js.native

  /**
    * An Object containing the JavaScript representation of the configure options that were used to compile
    * the current Node.js executable.
    */
  def config: ProcessConfig = js.native

  /**
    * If process.connected is false, it is no longer possible to send messages
    * @example process.connected
    */
  def connected: js.UndefOr[Boolean] = js.native

  /**
    * Returns the debug port
    */
  def debugPort: Integer = js.native

  /**
    * An object containing the user environment.
    */
  def env: Environment = js.native

  /**
    * This is the set of Node.js-specific command line options from the executable that started the process.
    * These options do not show up in process.argv, and do not include the Node.js executable, the name of
    * the script, or any options following the script name. These options are useful in order to spawn
    * child processes with the same execution environment as the parent.
    * @since 0.7.7
    */
  def execArgv: js.Array[String] = js.native

  /**
    * This is the absolute pathname of the executable that started the process.
    * @example process.execPath
    */
  def execPath: String = js.native

  /**
    * A number which will be the process exit code, when the process either exits gracefully, or is exited
    * via process.exit() without specifying a code.
    *
    * Specifying a code to process.exit(code) will override any previous setting of process.exitCode.
    * @example process.exitCode
    */
  def exitCode: Int = js.native

  /**
    * TODO find documentation for this property
    */
  def features: js.Dictionary[Boolean] = js.native

  /**
    * Alternate way to retrieve require.main. The difference is that if the main module changes at runtime,
    * require.main might still refer to the original main module in modules that were required before the
    * change occurred. Generally it's safe to assume that the two refer to the same module.
    *
    * As with require.main, it will be undefined if there was no entry script.
    */
  def mainModule: js.UndefOr[js.Any] = js.native

  /**
    * Returns the loaded module list
    */
  def moduleLoadList: js.Array[String] = js.native

  def noDeprecation: js.UndefOr[Boolean] = js.native

  /**
    * The PID of the process.
    * @example process.pid
    */
  def pid: Int = js.native

  def ppid: Int = js.native

  /**
    * What platform you're running on: 'darwin', 'freebsd', 'linux', 'sunos' or 'win32'
    */
  def platform: String = js.native

  /**
    * An Object containing metadata related to the current release, including URLs for the source tarball
    * and headers-only tarball.
    * @since 3.0.0
    */
  def release: ReleaseInfo = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def report: js.UndefOr[Reporter] = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def resourceUsage(): ResourceUsage = js.native

  /**
    * process.stderr and process.stdout are unlike other streams in Node.js in that they cannot be
    * closed (end() will throw), they never emit the finish event and that writes can block when output
    * is redirected to a file (although disks are fast and operating systems normally employ write-back
    * caching so it should be a very rare occurrence indeed.)
    */
  def stderr: WriteStream = js.native

  /**
    * A Readable Stream for stdin (on fd 0).
    */
  def stdin: ReadStream = js.native

  /**
    * process.stderr and process.stdout are unlike other streams in Node.js in that they cannot be
    * closed (end() will throw), they never emit the finish event and that writes can block when output
    * is redirected to a file (although disks are fast and operating systems normally employ write-back
    * caching so it should be a very rare occurrence indeed.)
    */
  def stdout: WriteStream = js.native

  /**
    * Getter/setter to set what is displayed in ps.
    * When used as a setter, the maximum length is platform-specific and probably short.
    * On Linux and OS X, it's limited to the size of the binary name plus the length of the command line
    * arguments because it overwrites the argv memory.
    * v0.8 allowed for longer process title strings by also overwriting the environ memory but that was
    * potentially insecure/confusing in some (rather obscure) cases.
    */
  var title: String = js.native

  def throwDeprecation: js.UndefOr[Boolean] = js.native

  def traceDeprecation: js.UndefOr[Boolean] = js.native

  /**
    * A compiled-in property that exposes NODE_VERSION.
    */
  def version: String = js.native

  /**
    * A property exposing version strings of Node.js and its dependencies.
    */
  def versions: ComponentVersion = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * This causes Node.js to emit an abort. This will cause Node.js to exit and generate a core file.
    * @example process.abort()
    */
  def abort(): Unit = js.native

  /**
    * Changes the current working directory of the process or throws an exception if that fails.
    * @example process.chdir(directory)
    */
  def chdir(directory: String): Unit = js.native

  def cpuUsage(previousValue: CpuUsage = js.native): CpuUsage = js.native

  /**
    * Returns the current working directory of the process.
    * @example process.cwd()
    */
  def cwd(): String = js.native

  /**
    * Close the IPC channel to the parent process, allowing this child to exit gracefully once there are no
    * other connections keeping it alive.
    *
    * Identical to the parent process's ChildProcess.disconnect().
    * If Node.js was not spawned with an IPC channel, process.disconnect() will be undefined.
    * @example process.disconnect()
    */
  def disconnect(): js.Any = js.native

  def dlopen(module: io.scalajs.nodejs.Module, filename: String, flags: Int = js.native): Unit = js.native

  def emitWarning(warning: io.scalajs.nodejs.Error): Unit = js.native
  def emitWarning(warning: String,
                  `type`: String = js.native,
                  code: String = js.native,
                  ctor: js.Function = js.native): Unit            = js.native
  def emitWarning(warning: String, options: WarningOptions): Unit = js.native

  /**
    * Ends the process with the specified code. If omitted, exit uses the 'success' code 0.
    * @example process.exit([code])
    */
  def exit(code: Int = js.native): Unit = js.native

  /**
    * Gets the effective group identity of the process. This is the numerical group id, not the group name.
    * <p/><b>Note</b>: this function is only available on POSIX platforms (i.e. not Windows, Android)
    * @example process.getegid()
    */
  def getegid(): Int = js.native

  /**
    * Gets the effective user identity of the process. This is the numerical userid, not the username.
    * <p/><b>Note</b>: this function is only available on POSIX platforms (i.e. not Windows, Android)
    * @example process.geteuid()
    */
  def geteuid(): Int = js.native

  /**
    * Gets the group identity of the process. This is the numerical group id, not the group name.
    * <p/><b>Note</b>: this function is only available on POSIX platforms (i.e. not Windows, Android)
    * @example process.getgid()
    */
  def getgid(): Int = js.native

  /**
    * Returns an array with the supplementary group IDs. POSIX leaves it unspecified if the effective
    * group ID is included but Node.js ensures it always is.
    * @example process.getgroups()
    */
  def getgroups(): js.Array[Int] = js.native

  /**
    * Gets the user identity of the process. (See getuid(2).) This is the numerical userid, not the username.
    * <p/><b>Note</b>: this function is only available on POSIX platforms (i.e. not Windows, Android)
    * @example process.getuid()
    */
  def getuid(): Int = js.native

  /**
    * Returns the current high-resolution real time in a [seconds, nanoseconds] tuple Array. It is relative to an
    * arbitrary time in the past. It is not related to the time of day and therefore not subject to clock drift.
    * The primary use is for measuring performance between intervals.
    * @example process.hrtime([time])
    */
  val hrtime: HrTime = js.native

  /**
    * Reads /etc/group and initializes the group access list, using all groups of which the user is a member.
    * This is a privileged operation, meaning you need to be root or have the CAP_SETGID capability.
    * @example process.initgroups(user, extra_group)
    */
  def initgroups(user: String | Int, extra_group: String | Int): js.Array[Int] = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def hasUncaughtExceptionCaptureCallback(): Boolean = js.native

  /**
    * Send a signal to a process. pid is the process id and signal is the string describing the signal to send.
    * Signal names are strings like SIGINT or SIGHUP. If omitted, the signal will be SIGTERM. See Signal Events
    * and kill(2) for more information.
    *
    * Will throw an error if target does not exist, and as a special case, a signal of 0 can be used to test for
    * the existence of a process. Windows platforms will throw an error if the pid is used to kill a process group.
    *
    * <p/><b>Note</b> that even though the name of this function is process.kill, it is really just a signal sender,
    * like the kill system call. The signal sent may do something other than kill the target process.
    * @example process.kill(pid[, signal])
    */
  def kill(pid: Int, signal: String | Int = js.native): Unit = js.native

  /**
    * Returns an object describing the memory usage of the Node.js process measured in bytes.
    * @example process.memoryUsage()
    */
  def memoryUsage(): MemoryUsage = js.native

  /**
    * Once the current event loop turn runs to completion, call the callback function.
    *
    * This is not a simple alias to setTimeout(fn, 0), it's much more efficient. It runs before any
    * additional I/O events (including timers) fire in subsequent ticks of the event loop.
    * @example process.nextTick(callback[, arg][, ...])
    */
  def nextTick(callback: js.Function0[Any], args: js.Any*): Unit = js.native

  /**
    * TODO find documentation
    */
  def openStdin(): ReadStream = js.native

  /**
    * When Node.js is spawned with an IPC channel attached, it can send messages to its parent process
    * using process.send(). Each will be received as a 'message' event on the parent's ChildProcess object.
    *
    * <p/><b>Note</b>: this function uses JSON.stringify() internally to serialize the message.
    * If Node.js was not spawned with an IPC channel, process.send() will be undefined.
    * @example {{{ process.send(message[, sendHandle[, options]][, callback]) }}}
    * @since 0.5.9
    */
  def send(message: js.Any,
           sendHandle: SendHandle,
           options: TransferOptions,
           callback: js.Function = js.native): Boolean                                 = js.native
  def send(message: js.Any, sendHandle: SendHandle, options: TransferOptions): Boolean = js.native
  def send(message: js.Any, sendHandle: SendHandle, callback: js.Function): Boolean    = js.native
  def send(message: js.Any, sendHandle: SendHandle): Boolean                           = js.native
  def send(message: js.Any, callback: js.Function): Boolean                            = js.native
  def send(message: js.Any): Boolean                                                   = js.native

  /**
    * Sets the effective group identity of the process. This accepts either a numerical ID or a groupname string.
    * If a groupname is specified, this method blocks while resolving it to a numerical ID.
    * @example process.setegid(id)
    * @since 2.0.0
    */
  def setegid(id: String | Int): Unit = js.native

  /**
    * Sets the effective user identity of the process. This accepts either a numerical ID or a username string.
    * If a username is specified, this method blocks while resolving it to a numerical ID.
    * @example process.seteuid(id)
    */
  def seteuid(id: String | Int): Unit = js.native

  /**
    * Sets the group identity of the process. This accepts either a numerical ID or a groupname string.
    * If a groupname is specified, this method blocks while resolving it to a numerical ID.
    * @example process.setgid(id)
    */
  def setgid(id: String | Int): Unit = js.native

  /**
    * Sets the supplementary group IDs. This is a privileged operation, meaning you need to be root or have the
    * CAP_SETGID capability. The list can contain group IDs, group names or both.
    * @example process.setgroups(groups)
    */
  def setgroups(groups: js.Array[Int] | js.Array[String] | js.Array[String | Int]): Unit = js.native

  /**
    * Sets the user identity of the process. This accepts either a numerical ID or a username string.
    * If a username is specified, this method blocks while resolving it to a numerical ID.
    * @example process.setuid(id)
    */
  def setuid(id: String | Int): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def setUncaughtExceptionCaptureCallback(callback: js.Function = js.native): Unit = js.native

  /**
    * Sets or reads the process's file mode creation mask. Child processes inherit the mask from the parent process.
    * Returns the old mask if mask argument is given, otherwise returns the current mask.
    * @example process.umask([mask])
    */
  def umask(mask: Int): Int = js.native

  /**
    * Sets or reads the process's file mode creation mask. Child processes inherit the mask from the parent process.
    * Returns the old mask if mask argument is given, otherwise returns the current mask.
    * @example process.umask([mask])
    */
  def umask(): Int = js.native

  /**
    * Number of seconds Node.js has been running.
    * @example process.uptime()
    */
  def uptime(): Int = js.native

}

@js.native
@JSGlobal("process")
object Process extends Process

/**
  * Memory Usage
  */
@js.native
trait MemoryUsage extends js.Object {
  var rss: Int       = js.native
  var heapTotal: Int = js.native
  var heapUsed: Int  = js.native
  var external: Int  = js.native
}

@js.native
trait ReleaseInfo extends js.Object {
  var name: String               = js.native
  var sourceUrl: String          = js.native
  var headersUrl: String         = js.native
  var libUrl: js.UndefOr[String] = js.native
  var lts: js.UndefOr[String]    = js.native
}

/**
  * Transfer Options
  */
@js.native
trait TransferOptions extends js.Object {
  // TODO what are the transfer options?
}

/**
  * Version Information
  */
@js.native
trait ComponentVersion extends js.Object {
  var node: String        = js.native
  var uv: String          = js.native
  var zlib: String        = js.native
  var ares: String        = js.native
  var modules: String     = js.native
  var http_parser: String = js.native
  var openssl: String     = js.native
  var icu: String         = js.native
  var unicode: String     = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  var v8: String = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  var brotli: String = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  var nghttp2: String = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  var napi: String = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  var llhttp: String = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  var cldr: String = js.native
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  var tz: String = js.native
}

/**
  * Warning
  */
@js.native
trait Warning extends js.Object {

  /**
    * The name of the warning (currently Warning by default).
    */
  var name: String = js.native

  /**
    * A system-provided description of the warning.
    */
  var message: String = js.native

  /**
    * A stack trace to the location in the code where the warning was issued.
    */
  var stack: js.Any = js.native
}

@js.native
trait CpuUsage extends js.Object {
  val user: Int   = js.native
  val system: Int = js.native
}

class WarningOptions(
    var `type`: js.UndefOr[String] = js.undefined,
    var code: js.UndefOr[String] = js.undefined,
    var detail: js.UndefOr[String] = js.undefined,
    var ctor: js.UndefOr[js.Function] = js.undefined
) extends js.Object {}

@js.native
trait HrTime extends js.Function1[js.Array[Int], js.Array[Int]] with js.Function0[js.Array[Int]] {
  // TODO: js.BigInt
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def bigint(): js.Any = js.native
}

@enableMembersIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
@js.native
trait ResourceUsage extends js.Object {
  var userCPUTime: Int                = js.native
  var systemCPUTime: Int              = js.native
  var maxRSS: Int                     = js.native
  var sharedMemorySize: Int           = js.native
  var unsharedDataSize: Int           = js.native
  var unsharedStackSize: Int          = js.native
  var minorPageFault: Int             = js.native
  var majorPageFault: Int             = js.native
  var swappedOut: Int                 = js.native
  var fsRead: Int                     = js.native
  var fsWrite: Int                    = js.native
  var ipcSent: Int                    = js.native
  var ipcReceived: Int                = js.native
  var signalsCount: Int               = js.native
  var voluntaryContextSwitches: Int   = js.native
  var involuntaryContextSwitches: Int = js.native
}
