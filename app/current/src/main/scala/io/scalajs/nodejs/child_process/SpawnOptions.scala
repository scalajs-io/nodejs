package io.scalajs.nodejs.child_process

import scala.scalajs.js
import scala.scalajs.js.|

trait SpawnOptions extends js.Object {

  /** Current working directory of the child process */
  var cwd: js.UndefOr[String] = js.undefined

  /** Environment key-value pairs */
  var env: js.UndefOr[js.Object] = js.undefined

  /** Explicitly set the value of argv[0] sent to the child process.
    * This will be set to command if not specified.
    */
  var argv0: js.UndefOr[String] = js.undefined

  /** Child's stdio configuration. (See options.stdio) */
  var stdio: js.UndefOr[StdIo] = js.undefined

  /** Prepare child to run independently of its parent process.
    * Specific behavior depends on the platform, see options.detached)
    */
  var detached: js.UndefOr[Boolean] = js.undefined

  /**  Sets the user identity of the process. (See setuid(2).) */
  var uid: js.UndefOr[Int] = js.undefined

  /** Sets the group identity of the process. (See setgid(2).)  */
  var gid: js.UndefOr[Int] = js.undefined

  /** If true, runs command inside of a shell.
    * Uses '/bin/sh' on UNIX, and 'cmd.exe' on Windows. A different shell can be specified as a string.
    * The shell should understand the -c switch on UNIX, or /d /s /c on Windows. Defaults to false (no shell).
    */
  var shell: js.UndefOr[Boolean | String] = js.undefined

  /** No quoting or escaping of arguments is done on Windows.
    * Ignored on Unix. This is set to true automatically when shell is specified and is CMD. Default: false.
    */
  var windowsVerbatimArguments: js.UndefOr[Boolean] = js.undefined

  /** Hide the subprocess console window that would normally be created on Windows systems.
    * Default: `false`.
    */
  var windowsHide: js.UndefOr[Boolean] = js.undefined
}
