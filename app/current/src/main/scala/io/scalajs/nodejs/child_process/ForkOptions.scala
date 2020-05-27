package io.scalajs.nodejs
package child_process

import scala.scalajs.js
import scala.scalajs.js.|

trait ForkOptions extends js.Object {

  /** Current working directory of the child process */
  var cwd: js.UndefOr[String] = js.undefined

  /** Prepare child to run independently of its parent process
    * Specific behavior depends on the platform (see options.detached).
    */
  var detached: js.UndefOr[Boolean] = js.undefined

  /** Environment key-value pairs  */
  var env: js.UndefOr[js.Object] = js.undefined

  /** Executable used to create the child process */
  var execPath: js.UndefOr[String] = js.undefined

  /** List of string arguments passed to the executable (Default: process.execArgv)  */
  var execArgv: js.UndefOr[Array[String]] = js.undefined

  /** From Node.js v13.2.0, v12.16.0.
    * Specify the kind of serialization used for sending messages between processes.
    * Possible values are 'json' and 'advanced'. See Advanced Serialization for more details.
    * Default: 'json'.
    */
  var serialization: js.UndefOr[String] = js.undefined

  /** If true, stdin, stdout, and stderr of the child will be piped to the parent,
    * otherwise they will be inherited from the parent, see the 'pipe' and 'inherit' options
    * for child_process.spawn()'s stdio for more details (Default: false)
    */
  var silent: js.UndefOr[Boolean] = js.undefined

  /** Supports the array version of child_process.spawn()'s stdio option. When this
    * option is provided, it overrides silent. The array must contain exactly one item with
    * value 'ipc' or an error will be thrown. For instance [0, 1, 2, 'ipc'].
    */
  var stdio: js.UndefOr[String | Array[String]] = js.undefined

  /** Sets the user identity of the process. (See setuid(2).)  */
  var uid: js.UndefOr[UID] = js.undefined

  /** Sets the group identity of the process. (See setgid(2).) */
  var gid: js.UndefOr[GID] = js.undefined
}
