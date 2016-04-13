package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js

/**
  * Node.js Process Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ProcessObject extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * An array containing the command line arguments. The first element will be 'node', the second element will be
    * the name of the JavaScript file. The next elements will be any additional command line arguments.
    * @example process.argv
    */
  def argv: js.Array[String] = js.native

  /**
    * What processor architecture you're running on: 'arm', 'ia32', or 'x64'.
    * @example process.arch
    */
  def arch: String = js.native

  /**
    * An Object containing the JavaScript representation of the configure options that were used to compile
    * the current Node.js executable.
    * @example process.config
    */
  def config: js.Object = js.native

  /**
    * If process.connected is false, it is no longer possible to send messages
    * @example process.connected
    */
  def connected: Boolean = js.native

  /**
    * An object containing the user environment.
    * @example process.env
    */
  def env: js.Dictionary[String] = js.native

  /**
    * This is the set of Node.js-specific command line options from the executable that started the process.
    * These options do not show up in process.argv, and do not include the Node.js executable, the name of
    * the script, or any options following the script name. These options are useful in order to spawn
    * child processes with the same execution environment as the parent.
    * @example process.execArgv
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
    * Alternate way to retrieve require.main. The difference is that if the main module changes at runtime,
    * require.main might still refer to the original main module in modules that were required before the
    * change occurred. Generally it's safe to assume that the two refer to the same module.
    *
    * As with require.main, it will be undefined if there was no entry script.
    * @example process.mainModule
    */
  def mainModule: js.UndefOr[js.Any] = js.native

  /**
    * The PID of the process.
    * @example process.pid
    */
  def pid: Int = js.native

  /**
    * What platform you're running on: 'darwin', 'freebsd', 'linux', 'sunos' or 'win32'
    * @example process.platform
    */
  def platform: String = js.native

  /**
    * An Object containing metadata related to the current release, including URLs for the source tarball
    * and headers-only tarball.
    * @example process.release
    */
  def release: js.Dictionary[String] = js.native

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
  def kill(pid: Int, signal: Int): Unit = js.native

  /**
    * Returns an object describing the memory usage of the Node.js process measured in bytes.
    * @example process.memoryUsage()
    */
  def memoryUsage(): ProcessObject.MemoryUsage = js.native

  /**
    * Once the current event loop turn runs to completion, call the callback function.
    *
    * This is not a simple alias to setTimeout(fn, 0), it's much more efficient. It runs before any
    * additional I/O events (including timers) fire in subsequent ticks of the event loop.
    * @example process.nextTick(callback[, arg][, ...])
    */
  def nextTick(callback: js.Function, args: js.Any*): Unit = js.native

}

/**
  * Process Object Companion
  * @author lawrence.daniels@gmail.com
  */
object ProcessObject {

  /**
    * Memory Usage
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait MemoryUsage extends js.Object {
    var rss: Double = js.native
    var heapTotal: Double = js.native
    var heapUsed: Double = js.native
  }

}
