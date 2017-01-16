package io.scalajs.nodejs
package child_process

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * The child_process module provides the ability to spawn child processes in a manner that is similar,
  * but not identical, to popen(3). This capability is primarily provided by the child_process.spawn() function.
  * @version 7.4.0
  * @see https://nodejs.org/api/child_process.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ChildProcess extends js.Object {

  /**
    * Spawns a shell then executes the command within that shell, buffering any generated output.
    * @param command  <String> The command to run, with space-separated arguments
    * @param options  the execution [[ExecOptions options]]
    * @return the [[ChildProcess]]
    * @example {{{ child_process.exec(command[, options][, callback]) }}}
    */
  def exec(command: String, options: ExecOptions | NodeOptions): this.type = js.native

  /**
    * Spawns a shell then executes the command within that shell, buffering any generated output.
    * @param command  <String> The command to run, with space-separated arguments
    * @param callback called with the output when process terminates
    * @return the [[ChildProcess]]
    * @example {{{ child_process.exec(command[, options][, callback]) }}}
    */
  def exec(command: String, callback: js.Function3[Error, Buffer | String, Buffer | String, Any]): this.type = js.native

  /**
    * Spawns a shell then executes the command within that shell, buffering any generated output.
    * @param command  <String> The command to run, with space-separated arguments
    * @param options  the execution [[ExecOptions options]]
    * @param callback called with the output when process terminates
    * @return the [[ChildProcess]]
    * @example {{{ child_process.exec(command[, options][, callback]) }}}
    */
  def exec(command: String, options: ExecOptions | NodeOptions, callback: js.Function3[Error, Buffer | String, Buffer | String, Any]): this.type = js.native


  /**
    * The child_process.fork() method is a special case of child_process.spawn() used specifically to spawn new
    * Node.js processes. Like child_process.spawn(), a ChildProcess object is returned. The returned ChildProcess
    * will have an additional communication channel built-in that allows messages to be passed back and forth between
    * the parent and child. See child.send() for details.
    *
    * It is important to keep in mind that spawned Node.js child processes are independent of the parent with exception
    * of the IPC communication channel that is established between the two. Each process has its own memory, with their
    * own V8 instances. Because of the additional resource allocations required, spawning a large number of child Node.js
    * processes is not recommended.
    *
    * By default, child_process.fork() will spawn new Node.js instances using the process.execPath of the parent process.
    * The execPath property in the options object allows for an alternative execution path to be used.
    *
    * Node.js processes launched with a custom execPath will communicate with the parent process using the
    * file descriptor (fd) identified using the environment variable NODE_CHANNEL_FD on the child process.
    * The input and output on this fd is expected to be line delimited JSON objects.
    *
    * Note: Unlike the fork(2) POSIX system call, child_process.fork() does not clone the current process.
    * @param modulePath <String> The module to run in the child
    * @param args       <Array> List of string arguments
    * @param options    the fork [[ForkOptions options]]
    * @return the [[ChildProcess]]
    * @example {{{ child_process.fork(modulePath[, args][, options]) }}}
    */
  def fork(modulePath: String, args: js.Array[String] = js.native, options: ForkOptions | NodeOptions = js.native): this.type = js.native

  /**
    * The child_process.spawn() method spawns a new process using the given command, with command line arguments
    * in args. If omitted, args defaults to an empty array.
    * @param command <String> The command to run
    * @param args    <Array> List of string arguments
    * @param options the spawn [[SpawnOptions options]]
    * @return the [[ChildProcess]]
    * @example {{{ child_process.spawn(command[, args][, options]) }}}
    */
  def spawn(command: String, args: js.Array[String] = js.native, options: SpawnOptions | NodeOptions = js.native): this.type = js.native

}

/**
  * ChildProcess Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("child_process", JSImport.Namespace)
object ChildProcess extends ChildProcess