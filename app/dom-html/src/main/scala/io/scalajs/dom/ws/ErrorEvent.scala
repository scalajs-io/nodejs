package io.scalajs.dom.ws

import io.scalajs.dom.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * A MessageEvent is the interface representing a message received by a target,
  * being a WebSocket or a WebRTC RTCDataChannel.
  */
@js.native
@JSGlobal("ErrorEvent")
class ErrorEvent() extends Event {

  def message: String = js.native

}
