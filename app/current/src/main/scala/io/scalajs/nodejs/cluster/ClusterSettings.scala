package io.scalajs.nodejs.cluster

import com.thoughtworks.enableIf
import net.exoego.scalajs.types.util.Factory

import io.scalajs.nodejs.{GID, UID}

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Cluster Settings
  */
@Factory
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

  /**
    * Specify the kind of serialization used for sending messages between processes.
    * Possible values are 'json' and 'advanced'. See Advanced Serialization for more details.
    * Default: 'json'.
    *
    * From Node.js v13.2.0, v12.16.0.
    */
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  var serialization: String = js.native

  /** <Number> Sets the user identity of the process. (See setuid(2).) */
  var uid: UID = js.native

  /** <Number> Sets the group identity of the process. (See setgid(2).) */
  var gid: GID = js.native

  var stdio: js.Array[js.Any] = js.native

  var inspectPort: Int | js.Function = js.native

  var cwd: String = js.native

  var windowsHide: Boolean = js.native
}
