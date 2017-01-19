package io.scalajs.npm.expressws

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.npm.expressws.WebSocket._

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * WebSocket Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WebSocket extends IEventEmitter {

  def currentPayloadLength: Int = js.native

  def extensions: js.Dictionary[js.Any] = js.native

  def _receiver: Receiver = js.native

  def _sender: Sender = js.native

  def firstFragment: Boolean = js.native

  def compress: Boolean = js.native

  def messageHandlers: js.Array[js.Any] = js.native

  def processing: Boolean = js.native

  def send(message: String | Buffer): js.Any = js.native

}

/**
  * WebSocket Companion
  * @author lawrence.daniels@gmail.com
  */
object WebSocket {

  /**
    * WebSocket Receiver
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Receiver extends IEventEmitter {

  }

  /**
    * WebSocket Sender
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait Sender extends IEventEmitter {

  }

  /**
    * WebSocket Events
    * @param webSocket the given [[WebSocket web socket]]
    */
  implicit class WebSocketEvents(val webSocket: WebSocket) extends AnyVal {

    @inline
    def onMessage(listener: String => Any): webSocket.type = webSocket.on("message", listener)

  }

}