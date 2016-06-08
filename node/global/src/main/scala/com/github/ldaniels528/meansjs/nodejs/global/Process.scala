package com.github.ldaniels528.meansjs.nodejs.global

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter
import com.github.ldaniels528.meansjs.nodejs.{errors, tty}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

/**
  * The process object is a global object and can be accessed from anywhere. It is an instance of EventEmitter.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Process extends EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

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

  /**
    * An Object containing the JavaScript representation of the configure options that were used to compile
    * the current Node.js executable.
    */
  def config: js.Dictionary[js.Any] = js.native

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
  def env: js.Dictionary[String] = js.native

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

  /**
    * The PID of the process.
    * @example process.pid
    */
  def pid: Int = js.native

  /**
    * What platform you're running on: 'darwin', 'freebsd', 'linux', 'sunos' or 'win32'
    */
  def platform: String = js.native

  /**
    * An Object containing metadata related to the current release, including URLs for the source tarball
    * and headers-only tarball.
    * @since 3.0.0
    */
  def release: Process.ReleaseInfo = js.native

  /**
    * process.stderr and process.stdout are unlike other streams in Node.js in that they cannot be
    * closed (end() will throw), they never emit the finish event and that writes can block when output
    * is redirected to a file (although disks are fast and operating systems normally employ write-back
    * caching so it should be a very rare occurrence indeed.)
    */
  def stderr: tty.WriteStream = js.native

  /**
    * A Readable Stream for stdin (on fd 0).
    */
  def stdin: tty.ReadStream = js.native

  /**
    * process.stderr and process.stdout are unlike other streams in Node.js in that they cannot be
    * closed (end() will throw), they never emit the finish event and that writes can block when output
    * is redirected to a file (although disks are fast and operating systems normally employ write-back
    * caching so it should be a very rare occurrence indeed.)
    */
  def stdout: tty.WriteStream = js.native

  /**
    * Getter/setter to set what is displayed in ps.
    * When used as a setter, the maximum length is platform-specific and probably short.
    * On Linux and OS X, it's limited to the size of the binary name plus the length of the command line
    * arguments because it overwrites the argv memory.
    * v0.8 allowed for longer process title strings by also overwriting the environ memory but that was
    * potentially insecure/confusing in some (rather obscure) cases.
    */
  var title: js.Any = js.native

  /**
    * A compiled-in property that exposes NODE_VERSION.
    */
  def version: String = js.native

  /**
    * A property exposing version strings of Node.js and its dependencies.
    */
  def versions: Process.VersionInfo = js.native

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

  /**
    * The process.emitWarning() method can be used to emit custom or application specific process warnings.
    * These can be listened for by adding a handler to the process.on('warning') event.
    * @param warning The warning to emit (String | Error)
    * @param name    When warning is a String, name is the name to use for the warning. Default: Warning.
    * @param ctor    When warning is a String, ctor is an optional function used to limit the generated stack trace.
    *                Default process.emitWarning
    * @example process.emitWarning(warning[, name][, ctor])
    */
  def emitWarning(warning: js.Any, name: String = null, ctor: js.Function = null): Unit = js.native

  /**
    * Ends the process with the specified code. If omitted, exit uses the 'success' code 0.
    * @example process.exit([code])
    */
  def exit(code: Int = 0): Unit = js.native

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
    * @example process.hrtime()
    */
  def hrtime(): js.Array[Int] = js.native

  /**
    * Reads /etc/group and initializes the group access list, using all groups of which the user is a member.
    * This is a privileged operation, meaning you need to be root or have the CAP_SETGID capability.
    * @example process.initgroups(user, extra_group)
    */
  def initgroups(user: String, extra_group: String): js.Array[Int] = js.native

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
  def kill(pid: Int, signal: String = null): Unit = js.native

  /**
    * Returns an object describing the memory usage of the Node.js process measured in bytes.
    * @example process.memoryUsage()
    */
  def memoryUsage(): Process.MemoryUsage = js.native

  /**
    * Once the current event loop turn runs to completion, call the callback function.
    *
    * This is not a simple alias to setTimeout(fn, 0), it's much more efficient. It runs before any
    * additional I/O events (including timers) fire in subsequent ticks of the event loop.
    * @example process.nextTick(callback[, arg][, ...])
    */
  def nextTick(callback: js.Function, args: js.Any*): Unit = js.native

  /**
    * TODO find documentation
    */
  def openStdin(): tty.ReadStream = js.native

  /**
    * When Node.js is spawned with an IPC channel attached, it can send messages to its parent process
    * using process.send(). Each will be received as a 'message' event on the parent's ChildProcess object.
    *
    * <p/><b>Note</b>: this function uses JSON.stringify() internally to serialize the message.
    * If Node.js was not spawned with an IPC channel, process.send() will be undefined.
    * @example {{{ process.send(message[, sendHandle[, options]][, callback]) }}}
    * @since 0.5.9
    */
  def send(message: js.Any, sendHandle: js.Any, options: Process.TransferOptions, callback: js.Function): Boolean = js.native

  /**
    * When Node.js is spawned with an IPC channel attached, it can send messages to its parent process
    * using process.send(). Each will be received as a 'message' event on the parent's ChildProcess object.
    *
    * <p/><b>Note</b>: this function uses JSON.stringify() internally to serialize the message.
    * If Node.js was not spawned with an IPC channel, process.send() will be undefined.
    * @example {{{ process.send(message[, sendHandle[, options]][, callback]) }}}
    * @since 0.5.9
    */
  def send(message: js.Any, sendHandle: js.Any, options: Process.TransferOptions): Boolean = js.native

  /**
    * When Node.js is spawned with an IPC channel attached, it can send messages to its parent process
    * using process.send(). Each will be received as a 'message' event on the parent's ChildProcess object.
    *
    * <p/><b>Note</b>: this function uses JSON.stringify() internally to serialize the message.
    * If Node.js was not spawned with an IPC channel, process.send() will be undefined.
    * @example {{{ process.send(message[, sendHandle[, options]][, callback]) }}}
    * @since 0.5.9
    */
  def send(message: js.Any, sendHandle: js.Any, callback: js.Function): Boolean = js.native

  /**
    * When Node.js is spawned with an IPC channel attached, it can send messages to its parent process
    * using process.send(). Each will be received as a 'message' event on the parent's ChildProcess object.
    *
    * <p/><b>Note</b>: this function uses JSON.stringify() internally to serialize the message.
    * If Node.js was not spawned with an IPC channel, process.send() will be undefined.
    * @example {{{ process.send(message[, sendHandle[, options]][, callback]) }}}
    * @since 0.5.9
    */
  def send(message: js.Any, callback: js.Function): Boolean = js.native

  /**
    * When Node.js is spawned with an IPC channel attached, it can send messages to its parent process
    * using process.send(). Each will be received as a 'message' event on the parent's ChildProcess object.
    *
    * <p/><b>Note</b>: this function uses JSON.stringify() internally to serialize the message.
    * If Node.js was not spawned with an IPC channel, process.send() will be undefined.
    * @example {{{ process.send(message[, sendHandle[, options]][, callback]) }}}
    * @since 0.5.9
    */
  def send(message: js.Any): Boolean = js.native

  /**
    * Sets the effective group identity of the process. This accepts either a numerical ID or a groupname string.
    * If a groupname is specified, this method blocks while resolving it to a numerical ID.
    * @example process.setegid(id)
    * @since 2.0.0
    */
  def setegid(id: Int): Unit = js.native

  /**
    * Sets the effective user identity of the process. This accepts either a numerical ID or a username string.
    * If a username is specified, this method blocks while resolving it to a numerical ID.
    * @example process.seteuid(id)
    */
  def seteuid(id: Int): Unit = js.native

  /**
    * Sets the group identity of the process. This accepts either a numerical ID or a groupname string.
    * If a groupname is specified, this method blocks while resolving it to a numerical ID.
    * @example process.setgid(id)
    */
  def setgid(id: Int): Unit = js.native

  /**
    * Sets the supplementary group IDs. This is a privileged operation, meaning you need to be root or have the
    * CAP_SETGID capability. The list can contain group IDs, group names or both.
    * @example process.setgroups(groups)
    */
  def setgroups[T](groups: js.Array[T]): Unit = js.native

  /**
    * Sets the user identity of the process. This accepts either a numerical ID or a username string.
    * If a username is specified, this method blocks while resolving it to a numerical ID.
    * @example process.setuid(id)
    */
  def setuid(id: Int): Unit = js.native

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

/**
  * Process Object Companion
  * @author lawrence.daniels@gmail.com
  */
object Process {

  /**
    * Process Environment Extensions
    * @param env the given environment dictionary
    */
  implicit class ProcessEnvExtensions(val env: js.Dictionary[String]) extends AnyVal {

    def HOME = env.get("HOME").orUndefined

    def NODE_ENV = env.get("NODE_ENV").orUndefined

    def PATH = env.get("PATH").orUndefined

    def SHELL = env.get("SHELL").orUndefined

    def TERM = env.get("TERM").orUndefined

    def TMPDIR = env.get("TMPDIR").orUndefined

    def USER = env.get("USER").orUndefined

  }

  /**
    * Process Object Extensions
    * @param process the given [[Process process]]
    */
  implicit class ProcessExtensions(val process: Process) extends AnyVal {

    /////////////////////////////////////////////////////////////////////////////////
    //      Extensions
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * @see [[Process.send()]]
      */
    @inline
    def sendFuture(message: js.Any, sendHandle: js.Any, options: Process.TransferOptions) = {
      futureCallbackE1[errors.Error, Boolean](process.send(message, sendHandle, options, _))
    }

    /**
      * @see [[Process.send()]]
      */
    @inline
    def sendFuture(message: js.Any, sendHandle: js.Any) = {
      futureCallbackE1[errors.Error, Boolean](process.send(message, sendHandle, _))
    }

    /**
      * @see [[Process.send()]]
      */
    @inline
    def sendFuture(message: js.Any) = {
      futureCallbackE1[errors.Error, Boolean](process.send(message, _))
    }

    /////////////////////////////////////////////////////////////////////////////////
    //      Events
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * This event is emitted when Node.js empties its event loop and has nothing else to schedule. Normally, Node.js
      * exits when there is no work scheduled, but a listener for 'beforeExit' can make asynchronous calls, and cause
      * Node.js to continue.
      *
      * 'beforeExit' is not emitted for conditions causing explicit termination, such as process.exit() or uncaught
      * exceptions, and should not be used as an alternative to the 'exit' event unless the intention is to schedule
      * more work.
      * @param listener the event listener function
      * @since 0.11.12
      */
    def onBeforeExit(listener: js.Function) = process.on("beforeExit", listener)

    /**
      * If process is spawned with an IPC channel, 'disconnect' will be emitted when IPC channel is closed.
      * Read more in child_process 'disconnect' event doc.
      * @param listener the event listener function
      * @since 0.7.7
      */
    def onDisconnect(listener: js.Function) = process.on("disconnect", listener)

    /**
      * Emitted when the process is about to exit. There is no way to prevent the exiting of the event loop at this point,
      * and once all 'exit' listeners have finished running the process will exit. Therefore you must only perform
      * synchronous operations in this handler. This is a good hook to perform checks on the module's state (like for
      * unit tests). The callback takes one argument, the code the process is exiting with.
      * @param listener the event listener function
      * @example process.on('exit', (code) => { ... })
      * @since 0.1.7
      */
    def onExit(listener: ExitCode => Any) = process.on("exit", listener)

    /**
      * Messages sent by ChildProcess.send() are obtained using the 'message' event on the child's process object.
      * @param listener the event listener function
      *                 <ul>
      *                 <li>message: <Object> a parsed JSON object or primitive value</li>
      *                 <li>sendHandle: <Handle object> a net.Socket or net.Server object, or undefined.</li>
      *                 </ul>
      * @since 0.5.10
      */
    def onMessage(listener: js.Function) = process.on("message", listener)

    /**
      * Emitted whenever a Promise was rejected and an error handler was attached to it (for example with promise.catch())
      * later than after an event loop turn.
      * @param listener the event listener function
      */
    def onRejectionHandled(listener: js.Function) = process.on("rejectionHandled", listener)

    /**
      * The 'uncaughtException' event is emitted when an exception bubbles all the way back to the event loop. By default,
      * Node.js handles such exceptions by printing the stack trace to stderr and exiting. Adding a handler for the
      * 'uncaughtException' event overrides this default behavior.
      * @param listener the event listener function
      */
    def onUncaughtException(listener: errors.Error => Any) = process.on("uncaughtException", listener)

    /**
      * Emitted whenever a Promise is rejected and no error handler is attached to the promise within a turn of the event
      * loop. When programming with promises exceptions are encapsulated as rejected promises. Such promises can be caught
      * and handled using promise.catch() and rejections are propagated through a promise chain. This event is useful for
      * detecting and keeping track of promises that were rejected whose rejections were not handled yet.
      * @param listener the event listener function
      */
    def onUnhandledRejection[T](listener: (String, js.Promise[T]) => Any) = process.on("unhandledRejection", listener)

    /**
      * A process warning is similar to an error in that it describes exceptional conditions that are being brought to
      * the user's attention. However, warnings are not part of the normal Node.js and JavaScript error handling flow.
      * Node.js can emit warnings whenever it detects bad coding practices that could lead to sub-optimal application
      * performance, bugs or security vulnerabilities.
      *
      * The event handler for 'warning' events is called with a single warning argument whose value is an Error object.
      * @param listener the event listener function
      */
    def onWarning(listener: Warning => Any) = process.on("warning", listener)

    /////////////////////////////////////////////////////////////////////////////////
    //      Signal Events - Emitted when the processes receives a signal.
    //                      See sigaction(2) for a list of standard POSIX signal names
    //                      such as SIGINT, SIGHUP, etc.
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * An easy way to send the SIGINT signal is with Control-C in most terminal programs.
      * @param listener the event listener function
      */
    def onSIGINT(listener: () => Any) = process.on("SIGINT", listener)

    /**
      * SIGUSR1 is reserved by Node.js to start the debugger. It's possible to install a listener but that won't stop
      * the debugger from starting.
      * @param listener the event listener function
      */
    def onSIGUSR1(listener: () => Any) = process.on("SIGUSR1", listener)

  }

  /**
    * Memory Usage
    */
  @js.native
  trait MemoryUsage extends js.Object {
    var rss: Double = js.native
    var heapTotal: Double = js.native
    var heapUsed: Double = js.native
  }

  /**
    * Release Information
    */
  @js.native
  trait ReleaseInfo extends js.Object {
    var name: String = js.native
    var sourceUrl: String = js.native
    var headersUrl: String = js.native
    var libUrl: String = js.native
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
  trait VersionInfo extends js.Object {
    var http_parser: js.UndefOr[String] = js.native
    var node: js.UndefOr[String] = js.native
    var v8: js.UndefOr[String] = js.native
    var uv: js.UndefOr[String] = js.native
    var zlib: js.UndefOr[String] = js.native
    var ares: js.UndefOr[String] = js.native
    var modules: js.UndefOr[String] = js.native
    var icu: js.UndefOr[String] = js.native
    var openssl: js.UndefOr[String] = js.native
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

}
