package io.scalajs.nodejs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.tty.{ReadStream, WriteStream}
import io.scalajs.util.PromiseHelper.promiseWithError1

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.|

package object process {
  // TODO: js.Set
  type EnvironmentFlags = js.Any
  type ExitCode         = Int
  type SendHandle       = net.Socket | net.Server

  @deprecated("use Process object instead", "0.9.0")
  def allowedNodeEnvironmentFlags: EnvironmentFlags = Process.allowedNodeEnvironmentFlags
  @deprecated("use Process object instead", "0.9.0")
  def arch: String = Process.arch
  @deprecated("use Process object instead", "0.9.0")
  def argv: js.Array[String] = Process.argv
  @deprecated("use Process object instead", "0.9.0")
  def argv0: String = Process.argv0
  @deprecated("use Process object instead", "0.9.0")
  def channel: js.UndefOr[js.Object] = Process.channel
  @deprecated("use Process object instead", "0.9.0")
  def config: ProcessConfig = Process.config
  @deprecated("use Process object instead", "0.9.0")
  def connected: js.UndefOr[Boolean] = Process.connected
  @deprecated("use Process object instead", "0.9.0")
  def debugPort: Integer = Process.debugPort
  @deprecated("use Process object instead", "0.9.0")
  def env: Environment = Process.env
  @deprecated("use Process object instead", "0.9.0")
  def execArgv: js.Array[String] = Process.execArgv
  @deprecated("use Process object instead", "0.9.0")
  def execPath: String = Process.execPath
  @deprecated("use Process object instead", "0.9.0")
  def exitCode: Int = Process.exitCode
  @deprecated("use Process object instead", "0.9.0")
  def features: js.Dictionary[Boolean] = Process.features
  @deprecated("use Process object instead", "0.9.0")
  def mainModule: js.UndefOr[js.Any] = Process.mainModule
  @deprecated("use Process object instead", "0.9.0")
  def moduleLoadList: js.Array[String] = Process.moduleLoadList
  @deprecated("use Process object instead", "0.9.0")
  def pid: Int = Process.pid
  @deprecated("use Process object instead", "0.9.0")
  def platform: String = Process.platform
  @deprecated("use Process object instead", "0.9.0")
  def release: ReleaseInfo = Process.release
  @deprecated("use Process object instead", "0.9.0")
  def stderr: WriteStream = Process.stderr
  @deprecated("use Process object instead", "0.9.0")
  def stdin: ReadStream = Process.stdin
  @deprecated("use Process object instead", "0.9.0")
  def stdout: WriteStream = Process.stdout
  @deprecated("use Process object instead", "0.9.0")
  def title: String = Process.title
  @deprecated("use Process object instead", "0.9.0")
  def version: String = Process.version
  @deprecated("use Process object instead", "0.9.0")
  def versions: ComponentVersion = Process.versions

  @deprecated("use Process object instead", "0.9.0")
  def abort(): Unit = Process.abort()
  @deprecated("use Process object instead", "0.9.0")
  def chdir(directory: String): Unit = Process.chdir(directory)
  @deprecated("use Process object instead", "0.9.0")
  def cwd(): String = Process.cwd()
  @deprecated("use Process object instead", "0.9.0")
  def disconnect(): js.Any = Process.disconnect()
  @deprecated("use Process object instead", "0.9.0")
  def emitWarning(warning: String, name: String = null, code: String = null, ctor: js.Function = null): Unit =
    Process.emitWarning(warning, name, code, ctor)
  @deprecated("use Process object instead", "0.9.0")
  def exit(code: Int = 0): Unit = Process.exit(code)
  @deprecated("use Process object instead", "0.9.0")
  def getegid(): Int = Process.getegid()
  @deprecated("use Process object instead", "0.9.0")
  def geteuid(): Int = Process.geteuid()
  @deprecated("use Process object instead", "0.9.0")
  def getgid(): Int = Process.getgid()
  @deprecated("use Process object instead", "0.9.0")
  def getgroups(): js.Array[Int] = Process.getgroups()
  @deprecated("use Process object instead", "0.9.0")
  def getuid(): Int = Process.getuid()
  @deprecated("use Process object instead", "0.9.0")
  def hrtime(time: js.Array[Int] = null): js.Array[Int] = Process.hrtime(time)
  @deprecated("use Process object instead", "0.9.0")
  def initgroups(user: String, extra_group: String): js.Array[Int] = Process.initgroups(user, extra_group)
  @deprecated("use Process object instead", "0.9.0")
  def kill(pid: Int, signal: String = null): Unit = Process.kill(pid, signal)
  @deprecated("use Process object instead", "0.9.0")
  def memoryUsage(): MemoryUsage = Process.memoryUsage()
  @deprecated("use Process object instead", "0.9.0")
  def nextTick(callback: js.Function0[Any], args: js.Any*): Unit = Process.nextTick(callback, args)
  @deprecated("use Process object instead", "0.9.0")
  def openStdin(): ReadStream = Process.openStdin()
  @deprecated("use Process object instead", "0.9.0")
  def send(message: js.Any, sendHandle: SendHandle, options: TransferOptions, callback: js.Function): Boolean =
    Process.send(message, sendHandle, options, callback)
  @deprecated("use Process object instead", "0.9.0")
  def send(message: js.Any, sendHandle: SendHandle, options: TransferOptions): Boolean =
    Process.send(message, sendHandle, options)
  @deprecated("use Process object instead", "0.9.0")
  def send(message: js.Any, sendHandle: SendHandle, callback: js.Function): Boolean =
    Process.send(message, sendHandle, callback)
  @deprecated("use Process object instead", "0.9.0")
  def send(message: js.Any, callback: js.Function): Boolean = Process.send(message, callback)
  @deprecated("use Process object instead", "0.9.0")
  def send(message: js.Any): Boolean = Process.send(message)
  @deprecated("use Process object instead", "0.9.0")
  def setegid(id: Int): Unit = Process.setegid(id)
  @deprecated("use Process object instead", "0.9.0")
  def seteuid(id: Int): Unit = Process.seteuid(id)
  @deprecated("use Process object instead", "0.9.0")
  def setgid(id: Int): Unit = Process.setgid(id)
  @deprecated("use Process object instead", "0.9.0")
  def setgroups(groups: js.Array[Int] | js.Array[String] | js.Array[String | Int]): Unit = Process.setgroups(groups)
  @deprecated("use Process object instead", "0.9.0")
  def setuid(id: Int): Unit = Process.setuid(id)
  @deprecated("use Process object instead", "0.9.0")
  def umask(mask: Int): Int = Process.umask(mask)
  @deprecated("use Process object instead", "0.9.0")
  def umask(): Int = Process.umask()
  @deprecated("use Process object instead", "0.9.0")
  def uptime(): Int = Process.uptime()

  /**
    * Process Object Extensions
    * @param process the given [[Process process]]
    */
  implicit final class ProcessExtensions(private val process: Process) extends AnyVal {
    @inline
    def sendFuture(message: js.Any, sendHandle: SendHandle, options: TransferOptions): Future[Boolean] = {
      promiseWithError1[Error, Boolean](process.send(message, sendHandle, options, _))
    }

    @inline
    def sendFuture(message: js.Any, sendHandle: SendHandle): Future[Boolean] = {
      promiseWithError1[Error, Boolean](process.send(message, sendHandle, _))
    }

    @inline
    def sendFuture(message: js.Any): Future[Boolean] = {
      promiseWithError1[Error, Boolean](process.send(message, _))
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
    def onBeforeExit(listener: ExitCode => Any): Process = process.on("beforeExit", listener)

    /**
      * If process is spawned with an IPC channel, 'disconnect' will be emitted when IPC channel is closed.
      * Read more in child_process 'disconnect' event doc.
      * @param listener the event listener function
      * @since 0.7.7
      */
    def onDisconnect(listener: () => Any): Process = process.on("disconnect", listener)

    /**
      * Emitted when the process is about to exit. There is no way to prevent the exiting of the event loop at this point,
      * and once all 'exit' listeners have finished running the process will exit. Therefore you must only perform
      * synchronous operations in this handler. This is a good hook to perform checks on the module's state (like for
      * unit tests). The callback takes one argument, the code the process is exiting with.
      * @param listener the event listener function
      * @example process.on('exit', (code) => { ... })
      * @since 0.1.7
      */
    def onExit(listener: ExitCode => Any): Process = process.on("exit", listener)

    /**
      * Messages sent by ChildProcess.send() are obtained using the 'message' event on the child's process object.
      * @param listener the event listener function
      *                 <ul>
      *                 <li>message: <Object> a parsed JSON object or primitive value</li>
      *                 <li>sendHandle: <Handle object> a net.Socket or net.Server object, or undefined.</li>
      *                 </ul>
      * @since 0.5.10
      */
    def onMessage(listener: (js.Any, js.UndefOr[net.Server | net.Socket]) => Any): Process =
      process.on("message", listener)

    @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
    def onMultipleResolves[T](listener: (String, js.Promise[T], js.Any) => Any): Process =
      process.on("multipleResolves", listener)

    /**
      * Emitted whenever a Promise was rejected and an error handler was attached to it (for example with promise.catch())
      * later than after an event loop turn.
      * @param listener the event listener function
      */
    def onRejectionHandled[T](listener: js.Promise[T] => Any): Process = process.on("rejectionHandled", listener)

    /**
      * The 'uncaughtException' event is emitted when an exception bubbles all the way back to the event loop. By default,
      * Node.js handles such exceptions by printing the stack trace to stderr and exiting. Adding a handler for the
      * 'uncaughtException' event overrides this default behavior.
      * @param listener the event listener function
      */
    def onUncaughtException(listener: Error => Any): Process = process.on("uncaughtException", listener)

    @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs12)
    def onUncaughtException(listener: (Error, String) => Any): Process = process.on("uncaughtException", listener)

    /**
      * Emitted whenever a Promise is rejected and no error handler is attached to the promise within a turn of the event
      * loop. When programming with promises exceptions are encapsulated as rejected promises. Such promises can be caught
      * and handled using promise.catch() and rejections are propagated through a promise chain. This event is useful for
      * detecting and keeping track of promises that were rejected whose rejections were not handled yet.
      * @param listener the event listener function
      */
    def onUnhandledRejection[T](listener: (js.Any, js.Promise[T]) => Any): Process =
      process.on("unhandledRejection", listener)

    /**
      * A process warning is similar to an error in that it describes exceptional conditions that are being brought to
      * the user's attention. However, warnings are not part of the normal Node.js and JavaScript error handling flow.
      * Node.js can emit warnings whenever it detects bad coding practices that could lead to sub-optimal application
      * performance, bugs or security vulnerabilities.
      *
      * The event handler for 'warning' events is called with a single warning argument whose value is an Error object.
      * @param listener the event listener function
      */
    def onWarning(listener: Warning => Any): Process = process.on("warning", listener)

    /////////////////////////////////////////////////////////////////////////////////
    //      Signal Events - Emitted when the processes receives a signal.
    //                      See sigaction(2) for a list of standard POSIX signal names
    //                      such as SIGINT, SIGHUP, etc.
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * An easy way to send the SIGINT signal is with Control-C in most terminal programs.
      * @param listener the event listener function
      */
    def onSIGINT(listener: () => Any): Process = process.on("SIGINT", listener)

    /**
      * SIGUSR1 is reserved by Node.js to start the debugger. It's possible to install a listener but that won't stop
      * the debugger from starting.
      * @param listener the event listener function
      */
    def onSIGUSR1(listener: () => Any): Process = process.on("SIGUSR1", listener)

    def onSIGTERM(listener: () => Any): Process  = process.on("SIGTERM", listener)
    def onSIGHUP(listener: () => Any): Process   = process.on("SIGHUP", listener)
    def onSIGBREAK(listener: () => Any): Process = process.on("SIGBREAK", listener)
    def onSIGWINCH(listener: () => Any): Process = process.on("SIGWINCH", listener)
    def onSIGBUS(listener: () => Any): Process   = process.on("SIGBUS", listener)
    def onSIGFPE(listener: () => Any): Process   = process.on("SIGFPE", listener)
    def onSIGSEGV(listener: () => Any): Process  = process.on("SIGSEGV", listener)
    def onSIGILL(listener: () => Any): Process   = process.on("SIGILL", listener)
  }

}
