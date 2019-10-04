package io.scalajs.nodejs
package child_process

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Spawns a shell then executes the command within that shell, buffering any generated output.
  *
  * Note: Never pass unsanitized user input to this function. Any input containing shell meta-characters
  * may be used to trigger arbitrary command execution.
  * @param cwd        Current working directory of the child process
  * @param env        Environment key-value pairs
  * @param encoding   (Default: 'utf8')
  * @param shell      Shell to execute the command with (Default: '/bin/sh' on UNIX, 'cmd.exe' on Windows,
  *                   The shell should understand the -c switch on UNIX or /d /s /c on Windows. On Windows, command line
  *                   parsing should be compatible with cmd.exe.)
  * @param timeout    (Default: 0)
  * @param maxBuffer  largest amount of data (in bytes) allowed on stdout or stderr - if exceeded child process
  *                   is killed (Default: 200*1024)
  * @param killSignal (Default: 'SIGTERM')
  * @param uid        Sets the user identity of the process. (See setuid(2).)
  * @param gid        Sets the group identity of the process. (See setgid(2).)
  * @param windowsHide Hide the subprocess console window that would normally be created on Windows systems. Default: `false`.
  * @param windowsVerbatimArguments No quoting or escaping of arguments is done on Windows.
  *                                 Ignored on Unix. This is set to true automatically when shell is specified and is CMD. Default: false.
  */
class ExecOptions(val cwd: js.UndefOr[String] = js.undefined,
                  val env: js.UndefOr[js.Object] = js.undefined,
                  val encoding: js.UndefOr[String] = js.undefined,
                  val shell: js.UndefOr[Boolean | String] = js.undefined,
                  val timeout: js.UndefOr[Int] = js.undefined,
                  val maxBuffer: js.UndefOr[Int] = js.undefined,
                  val killSignal: js.UndefOr[KillSignal] = js.undefined,
                  val uid: js.UndefOr[UID] = js.undefined,
                  val gid: js.UndefOr[GID] = js.undefined,
                  val windowsHide: js.UndefOr[Boolean] = js.undefined,
                  val windowsVerbatimArguments: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
