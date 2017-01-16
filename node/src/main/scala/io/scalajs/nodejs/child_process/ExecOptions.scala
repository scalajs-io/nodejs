package io.scalajs.nodejs
package child_process

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Spawns a shell then executes the command within that shell, buffering any generated output.
  *
  * Note: Never pass unsanitized user input to this function. Any input containing shell meta-characters
  * may be used to trigger arbitrary command execution.
  * @param cwd        <String> Current working directory of the child process
  * @param env        <Object> Environment key-value pairs
  * @param encoding   <String> (Default: 'utf8')
  * @param shell      <String> Shell to execute the command with (Default: '/bin/sh' on UNIX, 'cmd.exe' on Windows,
  *                   The shell should understand the -c switch on UNIX or /d /s /c on Windows. On Windows, command line
  *                   parsing should be compatible with cmd.exe.)
  * @param timeout    <Number> (Default: 0)
  * @param maxBuffer  <Number> largest amount of data (in bytes) allowed on stdout or stderr - if exceeded child process
  *                   is killed (Default: 200*1024)
  * @param killSignal <String> (Default: 'SIGTERM')
  * @param uid        <Number> Sets the user identity of the process. (See setuid(2).)
  * @param gid        <Number> Sets the group identity of the process. (See setgid(2).)
  */
@ScalaJSDefined
class ExecOptions(val cwd: js.UndefOr[String] = js.undefined,
                  val env: js.Any = js.undefined,
                  val encoding: js.UndefOr[String] = js.undefined,
                  val shell: js.UndefOr[String] = js.undefined,
                  val timeout: js.UndefOr[Number] = js.undefined,
                  val maxBuffer: js.UndefOr[Number] = js.undefined,
                  val killSignal: js.UndefOr[String] = js.undefined,
                  val uid: js.UndefOr[Number] = js.undefined,
                  val gid: js.UndefOr[Number] = js.undefined) extends js.Object
