package io.scalajs.nodejs

import io.scalajs.nodejs
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.typedarray.{DataView, TypedArray}
import scala.scalajs.js.|

package object child_process {
  type Output = nodejs.buffer.Buffer | String
  type Input  = String | nodejs.buffer.Buffer | TypedArray[_, _] | DataView
  type StdIo = String | js.Array[String] | js.Array[io.scalajs.nodejs.FileDescriptor] | js.Array[
    String | io.scalajs.nodejs.FileDescriptor
  ]
  type KillSignal = Int | String

  implicit final class ChildProcessExtensions(private val cp: ChildProcess.type) extends AnyVal {
    @inline
    def execFuture(
        command: String,
        options: js.UndefOr[ExecOptions | io.scalajs.RawOptions] = js.undefined
    ): Future[(Output, Output)] = {
      promiseWithError2[nodejs.Error, Output, Output](cp.exec(command, options.orNull, _))
    }

    @inline
    def execFileFuture(
        file: String,
        args: js.UndefOr[js.Array[String]] = js.undefined,
        options: js.UndefOr[ExecOptions | io.scalajs.RawOptions] = js.undefined
    ): Future[(Output, Output)] = {
      promiseWithError2[nodejs.Error, Output, Output](cp.execFile(file, args.orNull, options.orNull, _))
    }

    // TODO: spawn, fork
  }
}
