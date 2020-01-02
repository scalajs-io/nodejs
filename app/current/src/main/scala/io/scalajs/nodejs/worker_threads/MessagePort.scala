package io.scalajs.nodejs.worker_threads

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("worker_threads", "MessageChannel")
class MessagePort extends IEventEmitter with MessagePoster {
  def ref(): Unit   = js.native
  def start(): Unit = js.native
  def unref(): Unit = js.native
}
