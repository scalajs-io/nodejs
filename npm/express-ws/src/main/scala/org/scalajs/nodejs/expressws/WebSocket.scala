package org.scalajs.nodejs
package expressws

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.expressws.WebSocket._

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * WebSocket Object
  * @author Lawrence Daniels <lawrence.daniels@gmail.com>
  */
@js.native
trait WebSocket extends EventEmitter {

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
  * @author Lawrence Daniels <lawrence.daniels@gmail.com>
  */
object WebSocket {

  /**
    * WebSocket Receiver
    * @author Lawrence Daniels <lawrence.daniels@gmail.com>
    */
  @js.native
  trait Receiver extends EventEmitter {

  }

  /**
    * WebSocket Sender
    * @author Lawrence Daniels <lawrence.daniels@gmail.com>
    */
  @js.native
  trait Sender extends EventEmitter {

  }

  /**
    * WebSocket Events
    * @param webSocket the given [[WebSocket web socket]]
    */
  implicit class WebSocketEvents(val webSocket: WebSocket) extends AnyVal {

    @inline
    def onMessage(listener: String => Any) = webSocket.on("message", listener)

  }

}