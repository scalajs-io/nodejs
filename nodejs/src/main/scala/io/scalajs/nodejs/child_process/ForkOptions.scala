package io.scalajs.nodejs
package child_process

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Fork Options
  * @param cwd      <String> Current working directory of the child process
  * @param env      <Object> Environment key-value pairs
  * @param execPath <String> Executable used to create the child process
  * @param execArgv <Array> List of string arguments passed to the executable (Default: process.execArgv)
  * @param silent   <Boolean> If true, stdin, stdout, and stderr of the child will be piped to the parent,
  *                 otherwise they will be inherited from the parent, see the 'pipe' and 'inherit' options
  *                 for child_process.spawn()'s stdio for more details (Default: false)
  * @param stdio    <Array> Supports the array version of child_process.spawn()'s stdio option. When this
  *                 option is provided, it overrides silent. The array must contain exactly one item with
  *                 value 'ipc' or an error will be thrown. For instance [0, 1, 2, 'ipc'].
  * @param uid      <Number> Sets the user identity of the process. (See setuid(2).)
  * @param gid      <Number> Sets the group identity of the process. (See setgid(2).)
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ForkOptions(val cwd: js.UndefOr[String] = js.undefined,
                  val env: js.Any = js.undefined,
                  val execPath: js.UndefOr[String] = js.undefined,
                  val execArgv: js.UndefOr[Array[String]] = js.undefined,
                  val silent: js.UndefOr[Boolean] = js.undefined,
                  val stdio: js.UndefOr[Array[String]] = js.undefined,
                  val uid: js.UndefOr[JsNumber] = js.undefined,
                  val gid: js.UndefOr[JsNumber] = js.undefined) extends js.Object
