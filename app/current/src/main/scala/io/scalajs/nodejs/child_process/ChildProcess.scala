package io.scalajs.nodejs
package child_process

import io.scalajs.nodejs
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * The child_process module provides the ability to spawn child processes in a manner that is similar,
  * but not identical, to popen(3). This capability is primarily provided by the child_process.spawn() function.
  *
  * @see https://nodejs.org/api/child_process.html
  */
@js.native
trait ChildProcess extends IEventEmitter {
  def kill(signal: js.UndefOr[Int | String] = js.native): Unit = js.native
}

/**
  * @see https://nodejs.org/api/child_process.html
  */
@JSImport("child_process", JSImport.Namespace)
@js.native
object ChildProcess extends scala.scalajs.js.Object {
  def exec(
      command: String,
      options: js.UndefOr[ExecOptions | io.scalajs.RawOptions] = js.undefined,
      callback: js.Function3[
        nodejs.Error,
        Output,
        Output,
        Any
      ]
  ): ChildProcess = js.native

  def execSync(
      command: String,
      options: ExecOptions | io.scalajs.RawOptions = js.native
  ): Output = js.native

  def fork(
      modulePath: String,
      args: js.Array[String] = js.native,
      options: ForkOptions | io.scalajs.RawOptions = js.native
  ): ChildProcess = js.native

  def spawn(
      command: String,
      args: js.Array[String] = js.native,
      options: SpawnOptions | io.scalajs.RawOptions = js.native
  ): ChildProcess = js.native

  def spawnSync(
      command: String,
      args: js.Array[String] = js.native,
      options: SpawnOptions | io.scalajs.RawOptions = js.native
  ): SpawnResult = js.native

  def spawnSync(
      command: String,
      options: SpawnOptions | io.scalajs.RawOptions
  ): SpawnResult = js.native
}
