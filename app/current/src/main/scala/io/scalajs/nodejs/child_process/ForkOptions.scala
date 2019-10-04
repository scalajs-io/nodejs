package io.scalajs.nodejs
package child_process

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Fork Options
  * @param cwd      Current working directory of the child process
  * @param detached Prepare child to run independently of its parent process
  *                 Specific behavior depends on the platform (see options.detached).
  * @param env      Environment key-value pairs
  * @param execPath Executable used to create the child process
  * @param execArgv List of string arguments passed to the executable (Default: process.execArgv)
  * @param silent   If true, stdin, stdout, and stderr of the child will be piped to the parent,
  *                 otherwise they will be inherited from the parent, see the 'pipe' and 'inherit' options
  *                 for child_process.spawn()'s stdio for more details (Default: false)
  * @param stdio    Supports the array version of child_process.spawn()'s stdio option. When this
  *                 option is provided, it overrides silent. The array must contain exactly one item with
  *                 value 'ipc' or an error will be thrown. For instance [0, 1, 2, 'ipc'].
  * @param uid      Sets the user identity of the process. (See setuid(2).)
  * @param gid      Sets the group identity of the process. (See setgid(2).)
  */
class ForkOptions(val cwd: js.UndefOr[String] = js.undefined,
                  val detached: js.UndefOr[Boolean] = js.undefined,
                  val env: js.UndefOr[js.Object] = js.undefined,
                  val execPath: js.UndefOr[String] = js.undefined,
                  val execArgv: js.UndefOr[Array[String]] = js.undefined,
                  val silent: js.UndefOr[Boolean] = js.undefined,
                  val stdio: js.UndefOr[String | Array[String]] = js.undefined,
                  val uid: js.UndefOr[UID] = js.undefined,
                  val gid: js.UndefOr[GID] = js.undefined)
    extends js.Object
