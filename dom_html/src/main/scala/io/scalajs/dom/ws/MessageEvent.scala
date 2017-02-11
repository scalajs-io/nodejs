package io.scalajs.dom.ws

import io.scalajs.dom.Event

import scala.scalajs.js

/**
  * Message Event
  * @author lawrence.daniels@gmail.com
  */
@js.native
class MessageEvent() extends Event {

  /**
    * Returns a DOMString, Blob or an ArrayBuffer containing the data send by the emitter.
    */
  def data: String = js.native

  /**
    * TBD
    */
  def origin: String = js.native

}
