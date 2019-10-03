package io.scalajs.nodejs.worker_threads

import com.thoughtworks.enableMembersIf

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@enableMembersIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
@js.native
@JSImport("worker_threads", "MessageChannel")
class MessageChannel extends js.Object {
  def port1: MessagePort = js.native
  def port2: MessagePort = js.native
}
