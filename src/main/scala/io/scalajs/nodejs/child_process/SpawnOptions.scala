package io.scalajs.nodejs.child_process

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.|

/**
  * Spawn Options
  * @param cwd      <String> Current working directory of the child process
  * @param env      <Object> Environment key-value pairs
  * @param argv0    <String> Explicitly set the value of argv[0] sent to the child process.
  *                 This will be set to command if not specified.
  * @param stdio    <Array> | <String> Child's stdio configuration. (See options.stdio)
  * @param detached <Boolean> Prepare child to run independently of its parent process.
  *                 Specific behavior depends on the platform, see options.detached)
  * @param uid      <Number> Sets the user identity of the process. (See setuid(2).)
  * @param gid      <Number> Sets the group identity of the process. (See setgid(2).)
  * @param shell    <Boolean> | <String> If true, runs command inside of a shell.
  *                 Uses '/bin/sh' on UNIX, and 'cmd.exe' on Windows. A different shell can be specified as a string.
  *                 The shell should understand the -c switch on UNIX, or /d /s /c on Windows. Defaults to false (no shell).
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class SpawnOptions(val cwd: js.UndefOr[String] = js.undefined,
                   val env: js.Any = js.undefined,
                   val argv0: js.UndefOr[String] = js.undefined,
                   val stdio: js.UndefOr[Array[String] | String] = js.undefined,
                   val detached: js.UndefOr[Boolean] = js.undefined,
                   val uid: js.UndefOr[JsNumber] = js.undefined,
                   val gid: js.UndefOr[JsNumber] = js.undefined,
                   val shell: js.UndefOr[Boolean | String] = js.undefined)
    extends js.Object
