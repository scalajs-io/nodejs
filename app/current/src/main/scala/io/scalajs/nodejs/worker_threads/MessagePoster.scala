package io.scalajs.nodejs.worker_threads

import com.thoughtworks.enableMembersIf

import scala.scalajs.js

@enableMembersIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
@js.native
trait MessagePoster extends js.Object {

  def postMessage(value: js.Any): Unit = js.native

  def postMessage(value: js.Any, transferList: js.Array[js.|[js.typedarray.ArrayBuffer, MessagePort]]): Unit = js.native

}
