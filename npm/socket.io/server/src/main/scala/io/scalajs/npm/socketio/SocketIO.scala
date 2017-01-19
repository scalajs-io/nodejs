package io.scalajs.npm.socketio

import io.scalajs.nodejs.http.{Server => HttpServer}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Socket.io - Realtime application framework (Node.JS server)
  * @version 1.7.2
  * @see https://github.com/socketio/socket.io
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SocketIO extends js.Object {

  def apply(server: HttpServer = js.native, options: ServerSocketOptions = js.native): Server = js.native

}

/**
  * SocketIO Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("socket.io", JSImport.Namespace)
object SocketIO extends SocketIO