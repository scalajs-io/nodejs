package io.scalajs.nodejs.cluster

import io.scalajs.FlexibleOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Cluster Settings
  * @param execArgv    List of string arguments passed to the Node.js executable. Default: process.execArgv.
  * @param exec        File path to worker file. Default: process.argv[1].
  * @param args        String arguments passed to worker. Default: process.argv.slice(2).
  * @param cwd         Current working directory of the worker process. Default: undefined (inherits from parent process).
  * @param silent      Whether or not to send output to parent's stdio. Default: false.
  * @param stdio       Configures the stdio of forked processes. Because the cluster module relies on IPC to function,
  *                    this configuration must contain an 'ipc' entry. When this option is provided, it overrides silent.
  * @param uid         Sets the user identity of the process. (See setuid(2).)
  * @param gid         Sets the group identity of the process. (See setgid(2).)
  * @param inspectPort Sets inspector port of worker. This can be a number, or a function that takes no arguments and
  *                    returns a number. By default each worker gets its own port, incremented from the master's process.debugPort.
  * @param windowsHide Hide the forked processes console window that would normally be created on Windows systems. Default: false.
  * @see [[https://nodejs.org/dist/latest-v12.x/docs/api/cluster.html#cluster_cluster_settings]]
  * @author lawrence.daniels@gmail.com
  */
class ClusterSettings(var execArgv: js.UndefOr[js.Array[String]] = js.undefined,
                      var exec: js.UndefOr[String] = js.undefined,
                      var args: js.UndefOr[js.Array[String]] = js.undefined,
                      var cwd: js.UndefOr[String] = js.undefined,
                      var silent: js.UndefOr[Boolean] = js.undefined,
                      var stdio: js.UndefOr[js.Array[js.Any]] = js.undefined,
                      var uid: js.UndefOr[Int] = js.undefined,
                      var gid: js.UndefOr[Int] = js.undefined,
                      var inspectPort: js.UndefOr[Int | js.Function1[js.Any, Int]] = js.undefined,
                      var windowsHide: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Cluster Settings Companion
  * @author lawrence.daniels@gmail.com
  */
object ClusterSettings extends FlexibleOptions[ClusterSettings]