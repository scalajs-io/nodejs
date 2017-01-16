package io.scalajs.nodejs.cluster

import io.scalajs.util.ScalaJsHelper._
import io.scalajs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Cluster Settings
  */
@js.native
trait ClusterSettings extends js.Object {
  /** <Array> list of string arguments passed to the Node.js executable. (Default=process.execArgv) */
  var execArgv: js.Array[js.Any] = js.native

  /** <String> file path to worker file. (Default=process.argv[1]) */
  var exec: String = js.native

  /** <Array> string arguments passed to worker. (Default=process.argv.slice(2)) */
  var args: js.Array[js.Any] = js.native

  /** <Boolean> whether or not to send output to parent's stdio. (Default=false) */
  var silent: Boolean = js.native

  /** <Number> Sets the user identity of the process. (See setuid(2).) */
  var uid: Integer = js.native

  /* <Number> Sets the group identity of the process. (See setgid(2).) */
  var gid: Integer = js.native
}

/**
  * Cluster Settings Companion
  */
object ClusterSettings {

  def apply(exec: String = null,
            args: js.Array[js.Any] = null,
            silent: Boolean = false) = {
    val settings = New[ClusterSettings]
    settings.exec = exec
    settings.args = args
    settings.silent = silent
    settings
  }

}