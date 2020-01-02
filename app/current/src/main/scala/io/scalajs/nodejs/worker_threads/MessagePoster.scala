package io.scalajs.nodejs.worker_threads

import scala.scalajs.js

@js.native
trait MessagePoster extends js.Object {
  def postMessage(value: js.Any): Unit = js.native

  def postMessage(value: js.Any, transferList: js.Array[js.|[js.typedarray.ArrayBuffer, MessagePort]]): Unit = js.native
}
