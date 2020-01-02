package io.scalajs.nodejs.cluster

import io.scalajs.nodejs.{GID, UID}

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Cluster Settings
  */
@js.native
trait ClusterSettings extends js.Object {

  /** <Array> list of string arguments passed to the Node.js executable. (Default=process.execArgv) */
  var execArgv: js.Array[String] = js.native

  /** <String> file path to worker file. (Default=process.argv[1]) */
  var exec: String = js.native

  /** <Array> string arguments passed to worker. (Default=process.argv.slice(2)) */
  var args: js.Array[String] = js.native

  /** <Boolean> whether or not to send output to parent's stdio. (Default=false) */
  var silent: Boolean = js.native

  /** <Number> Sets the user identity of the process. (See setuid(2).) */
  var uid: UID = js.native

  /** <Number> Sets the group identity of the process. (See setgid(2).) */
  var gid: GID = js.native

  var stdio: js.Array[js.Any] = js.native

  var inspectPort: Int | js.Function = js.native

  var cwd: String = js.native

  var windowsHide: Boolean = js.native
}

/**
  * Cluster Settings Companion
  */
object ClusterSettings {
  def apply(execArgv: js.Array[String] = null,
            exec: String = null,
            args: js.Array[String] = null,
            silent: Boolean = false,
            stdio: js.Array[js.Any] = null,
            inspectPort: Int | js.Function = null,
            cwd: String = null,
            windowsHide: Boolean = false): ClusterSettings = {
    val settings = js.Dynamic.literal()
    settings.updateDynamic("execArgv")(execArgv)
    settings.updateDynamic("exec")(exec)
    settings.updateDynamic("args")(args)
    settings.updateDynamic("silent")(silent)
    settings.updateDynamic("stdio")(stdio)
    settings.updateDynamic("inspectPort")(inspectPort.asInstanceOf[js.Any])
    settings.updateDynamic("cwd")(cwd)
    settings.updateDynamic("windowsHide")(windowsHide)
    settings.asInstanceOf[ClusterSettings]
  }
}
