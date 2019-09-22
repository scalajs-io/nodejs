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
  def kill(signal: js.UndefOr[KillSignal] = js.native): Unit = js.native
  def ref(): Unit                                            = js.native
  def unref(): Unit                                          = js.native
  // TODO: Are those available in limited scenario?
  //def disconnect(): Unit = js.native
  //def send(message: js.Any, sendHandle: Handle = js.native, options: SendOptions | RawOptions = js.native, callback: js.Function1[nodejs.Error, Any] = js.native): Boolean = js.native

  val channel: js.UndefOr[js.Object] = js.native
  val connected: Boolean             = js.native
  val killed: Boolean                = js.native
  val pid: Int                       = js.native
  val stderr: stream.Readable        = js.native
  val stdin: stream.Writable         = js.native
  val stdio: js.Array[IEventEmitter] = js.native
  val stdout: stream.Readable        = js.native
}

/**
  * @see https://nodejs.org/api/child_process.html
  */
@JSImport("child_process", JSImport.Namespace)
@js.native
object ChildProcess extends scala.scalajs.js.Object {
  def exec(
      args: String,
      options: ExecOptions | io.scalajs.RawOptions = js.native,
      callback: js.Function3[
        nodejs.Error,
        Output,
        Output,
        Any
      ]
  ): ChildProcess = js.native

  def execFile(
      file: String,
      args: js.Array[String] = js.native,
      options: ExecOptions | io.scalajs.RawOptions = js.native,
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

  def execFileSync(
      file: String,
      args: js.Array[String] = js.native,
      options: ExecFileSyncOptions | io.scalajs.RawOptions = js.native
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
      options: SpawnSyncOptions | io.scalajs.RawOptions = js.native
  ): SpawnSyncResult = js.native

}
