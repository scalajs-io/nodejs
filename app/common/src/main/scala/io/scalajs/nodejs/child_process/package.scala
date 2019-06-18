package io.scalajs.nodejs

import io.scalajs.nodejs
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.|

package object child_process {
  type Output = nodejs.buffer.Buffer | String

  implicit final class ChildProcessExtensions(val cp: ChildProcess.type) extends AnyVal {
    @inline
    def execFuture(
        command: String,
        options: js.UndefOr[ExecOptions | io.scalajs.RawOptions] = js.undefined
    ): Future[(Output, Output)] = {
      promiseWithError2[nodejs.Error, Output, Output](cp.exec(command, options, _))
    }
  }

}
