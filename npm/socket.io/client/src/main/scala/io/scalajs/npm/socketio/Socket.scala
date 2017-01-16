package io.scalajs.npm.socketio

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js

/**
  * A Socket is the fundamental class for interacting with browser clients. A Socket belongs
  * to a certain Namespace (by default /) and uses an underlying Client to communicate.
  *
  * It should be noted the Socket doesn't relate directly to the actual underlying TCP/IP socket
  * and it is only the name of the class.
  * @author lawrence.daniels@gmail.com
  */
@js.native
class Socket extends IEventEmitter {

  /**
    * A reference to the underlying Client object.
    * @return the [[Client]] object.
    */
  def client: Client = js.native

  /**
    * Sets a modifier for a subsequent event emission that the event data will only be compressed
    * if the value is true. Defaults to true when you don't call the method.
    * @param v
    * @return
    */
  def compress(v: Boolean): Socket = js.native

  /**
    * A reference to the underlying Client transport connection (engine.io Socket object).
    * This allows access to the IO transport layer, which still (mostly) abstracts the actual TCP/IP socket.
    * @return the underlying Client transport connection
    */
  def conn: Socket = js.native

  /**
    * Emits an event identified by the string name to the client. Any other parameters can be included.
    * All data structures are supported, including Buffer. JavaScript functions can't be serialized/deserialized.
    * @param name the event name
    * @param args the event arguments
    */
  override def emit(name: String, args: js.Any*): this.type = js.native

  /**
    * A unique identifier for the session, that comes from the underlying Client.
    * @return the unique identifier
    */
  def id: String = js.native

  /**
    * Same as [[Socket.to()]]
    * @param room
    * @return
    */
  def in(room: String): Socket = js.native

  /**
    * Adds the client to the room, and fires optionally a callback fn with err signature (if any).
    * The client is automatically a member of a room identified with its session id (see Socket#id).
    * The mechanics of joining rooms are handled by the Adapter that has been configured (see Server#adapter above),
    * defaulting to socket.io-adapter.
    * @param name
    * @param fn
    * @return
    */
  def join(name: String, fn: js.Function = js.native): Socket = js.native

  /**
    * Removes the client from room, and fires optionally a callback fn with err signature (if any).
    * @param name
    * @param fn
    * @return
    */
  def leave(name: String, fn: js.Function = js.native): Socket = js.native

  /**
    * A getter proxy that returns the reference to the request that originated the underlying engine.io Client.
    * Useful for accessing request headers such as Cookie or User-Agent.
    * @return
    */
  def request: Request = js.native

  /**
    * A hash of strings identifying the rooms this client is in, indexed by room name.
    * @return A hash of strings
    */
  def rooms: js.Object = js.native

  /**
    * Disconnects this client.
    * @param close If value of close is true, closes the underlying connection.
    *              Otherwise, it just disconnects the namespace.
    */
  def disconnect(close: Boolean): this.type = js.native

  /**
    * Sets a modifier for a subsequent event emission that the event will only be broadcasted to clients
    * that have joined the given room.
    * @param room
    * @return
    */
  def to(room: String): Socket = js.native

}

/**
  * Socket Companion
  * @author lawrence.daniels@gmail.com
  */
object Socket {

  /**
    * Client socket enrichment
    * @param socket the given [[Socket socket]]
    */
  implicit class SocketEnrichment(val socket: Socket) extends AnyVal {

    @inline
    def onConnect(handler: () => Any): socket.type = socket.on("connect", handler)

    /**
      * Fired upon disconnection.
      * @param handler a function containing the reason of the disconnection (either client or server-side)
      */
    @inline
    def onDisconnect(handler: () => Any): socket.type = socket.on("disconnect", handler)

    /**
      * Fired when the client is going to be disconnected (but hasn't left its rooms yet).
      * @param handler a function containing  the reason of the disconnection (either client or server-side)
      */
    @inline
    def onDisconnecting(handler: () => Any): socket.type = socket.on("disconnecting", handler)

    /**
      * Fired when an error occurs.
      * @param handler a function containing error data
      */
    def onError(handler: js.Any => Any): socket.type = socket.on("error", handler)

    @inline
    def onEvent(handler: js.Any => Any): socket.type = socket.on("event", handler)

  }

}