package io.scalajs.npm.engineio

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.|

@js.native
trait Socket extends IEventEmitter {

  def send(data: String | Buffer): Unit = js.native

}
