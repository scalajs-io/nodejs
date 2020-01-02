package io.scalajs.nodejs.worker_threads

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("worker_threads", "Worker")
class Worker(filename: String, workerOptions: WorkerOptions = js.native) extends js.Object with MessagePoster {
  def ref(): Unit   = js.native
  def unref(): Unit = js.native

  // TODO: No need to UnderOr when Node.js v10 dropepd
  def terminate(): js.UndefOr[js.Promise[Unit]] = js.native

  def threadId: Int = js.native

  def stderr: io.scalajs.nodejs.stream.Readable            = js.native
  def stdout: io.scalajs.nodejs.stream.Readable            = js.native
  def stdin: js.|[io.scalajs.nodejs.stream.Writable, Null] = js.native
}
