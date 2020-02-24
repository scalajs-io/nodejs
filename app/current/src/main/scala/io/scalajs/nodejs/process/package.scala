package io.scalajs.nodejs

import com.thoughtworks.enableIf
import io.scalajs.util.PromiseHelper.promiseWithError1

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.|

package object process {
  // TODO: js.Set
  type EnvironmentFlags = js.Any
  type ExitCode         = Int
  type SendHandle       = net.Socket | net.Server

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
    @inline def onBeforeExit(listener: ExitCode => Any): Process = process.on("beforeExit", listener)

    /**
      * If process is spawned with an IPC channel, 'disconnect' will be emitted when IPC channel is closed.
      * Read more in child_process 'disconnect' event doc.
      * @param listener the event listener function
      * @since 0.7.7
      */
    @inline def onDisconnect(listener: () => Any): Process = process.on("disconnect", listener)

    /**
      * Emitted when the process is about to exit. There is no way to prevent the exiting of the event loop at this point,
      * and once all 'exit' listeners have finished running the process will exit. Therefore you must only perform
      * synchronous operations in this handler. This is a good hook to perform checks on the module's state (like for
      * unit tests). The callback takes one argument, the code the process is exiting with.
      * @param listener the event listener function
      * @example process.on('exit', (code) => { ... })
      * @since 0.1.7
      */
    @inline def onExit(listener: ExitCode => Any): Process = process.on("exit", listener)

    /**
      * Messages sent by ChildProcess.send() are obtained using the 'message' event on the child's process object.
      * @param listener the event listener function
      *                 <ul>
      *                 <li>message: <Object> a parsed JSON object or primitive value</li>
      *                 <li>sendHandle: <Handle object> a net.Socket or net.Server object, or undefined.</li>
      *                 </ul>
      * @since 0.5.10
      */
    @inline def onMessage(listener: (js.Any, js.UndefOr[net.Server | net.Socket]) => Any): Process =
      process.on("message", listener)

    @inline def onMultipleResolves[T](listener: (String, js.Promise[T], js.Any) => Any): Process =
      process.on("multipleResolves", listener)

    /**
      * Emitted whenever a Promise was rejected and an error handler was attached to it (for example with promise.catch())
      * later than after an event loop turn.
      * @param listener the event listener function
      */
    @inline def onRejectionHandled[T](listener: js.Promise[T] => Any): Process =
      process.on("rejectionHandled", listener)

    /**
      * The 'uncaughtException' event is emitted when an exception bubbles all the way back to the event loop. By default,
      * Node.js handles such exceptions by printing the stack trace to stderr and exiting. Adding a handler for the
      * 'uncaughtException' event overrides this default behavior.
      * @param listener the event listener function
      */
    @inline def onUncaughtException(listener: Error => Any): Process = process.on("uncaughtException", listener)

    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline def onUncaughtException(listener: (Error, String) => Any): Process =
      process.on("uncaughtException", listener)

    /**
      * Emitted whenever a Promise is rejected and no error handler is attached to the promise within a turn of the event
      * loop. When programming with promises exceptions are encapsulated as rejected promises. Such promises can be caught
      * and handled using promise.catch() and rejections are propagated through a promise chain. This event is useful for
      * detecting and keeping track of promises that were rejected whose rejections were not handled yet.
      * @param listener the event listener function
      */
    @inline def onUnhandledRejection[T](listener: (js.Any, js.Promise[T]) => Any): Process =
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
    @inline def onWarning(listener: Error => Any): Process = process.on("warning", listener)

    /////////////////////////////////////////////////////////////////////////////////
    //      Signal Events - Emitted when the processes receives a signal.
    //                      See sigaction(2) for a list of standard POSIX signal names
    //                      such as SIGINT, SIGHUP, etc.
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * An easy way to send the SIGINT signal is with Control-C in most terminal programs.
      * @param listener the event listener function
      */
    @inline def onSIGINT(listener: () => Any): Process = process.on("SIGINT", listener)

    /**
      * SIGUSR1 is reserved by Node.js to start the debugger. It's possible to install a listener but that won't stop
      * the debugger from starting.
      * @param listener the event listener function
      */
    @inline def onSIGUSR1(listener: () => Any): Process = process.on("SIGUSR1", listener)

    @inline def onSIGTERM(listener: () => Any): Process  = process.on("SIGTERM", listener)
    @inline def onSIGHUP(listener: () => Any): Process   = process.on("SIGHUP", listener)
    @inline def onSIGBREAK(listener: () => Any): Process = process.on("SIGBREAK", listener)
    @inline def onSIGWINCH(listener: () => Any): Process = process.on("SIGWINCH", listener)
    @inline def onSIGBUS(listener: () => Any): Process   = process.on("SIGBUS", listener)
    @inline def onSIGFPE(listener: () => Any): Process   = process.on("SIGFPE", listener)
    @inline def onSIGSEGV(listener: () => Any): Process  = process.on("SIGSEGV", listener)
    @inline def onSIGILL(listener: () => Any): Process   = process.on("SIGILL", listener)
  }
}
