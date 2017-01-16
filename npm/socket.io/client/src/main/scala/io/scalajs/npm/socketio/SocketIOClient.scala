package io.scalajs.npm.socketio

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Socket.io-client
  * @version 1.7.2
  * @see https://www.npmjs.com/package/socket.io-client
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SocketIOClient extends js.Object {

  def apply(url: String, options: SocketOptions | js.Any = js.native): Socket = js.native

}

/**
  * Socket.io-client Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("socket.io-client", JSImport.Namespace)
object SocketIOClient extends SocketIOClient