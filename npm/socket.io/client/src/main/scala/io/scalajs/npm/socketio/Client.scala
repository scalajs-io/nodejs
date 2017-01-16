package io.scalajs.npm.socketio

import scala.scalajs.js

/**
  * The Client class represents an incoming transport (engine.io) connection.
  * A Client can be associated with many multiplexed Sockets that belong to different Namespaces.
  */
@js.native
class Client extends js.Object {

  /**
    * A reference to the underlying engine.io Socket connection.
    */
  def conn: Socket = js.native

  /**
    * A getter proxy that returns the reference to the request that originated the engine.io connection.
    * Useful for accessing request headers such as Cookie or User-Agent.
    */
  def request: Request = js.native

}
