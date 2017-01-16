package io.scalajs.npm.socketio

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Socket.io Server
  * @author lawrence.daniels@gmail.com
  */
@js.native
//@JSImport("socket.io", "Server")
class Server extends IEventEmitter {

  /**
    * Returns the current adapter
    * @return the current adapter
    */
  def adapter(): Adapter = js.native

  /**
    * Sets the adapter v. Defaults to an instance of the Adapter that ships with socket.io which is memory based.
    * @param v the given [[Adapter adapter]]
    */
  def adapter(v: Adapter): Server = js.native

  /**
    * Closes socket.io server.
    *
    * The optional callback function is passed to the server.close([callback]) method of the core net module and is
    * called on error or when all connections are closed. The callback is expected to implement the
    * common single argument err signature (if any).
    * @param callback the callback function
    */
  def close(callback: js.Function1[SocketIOError, Any] = js.native): Unit = js.native

  /**
    * Emits an event to all connected clients.
    * @param name the event name
    * @param args the event arguments
    */
  override def emit(name: String, args: js.Any*): this.type = js.native

  /**
    *
    * @param port
    * @return
    */
  def listen(port: Int | String): this.type = js.native

  /**
    * Initializes and retrieves the given Namespace by its pathname identifier namespace.
    * If the namespace was already initialized it returns it immediately.
    * @param namespace the given namespace
    * @return the [[Namespace]]
    */
  def of(namespace: String): Namespace = js.native

  /**
    *
    * @param v
    * @return
    */
  def origins(v: String): this.type = js.native

  /**
    * Returns the current path.
    * @return the current path.
    */
  def path(): String = js.native

  /**
    * Sets the path v under which engine.io and the static files will be served. Defaults to /socket.io.
    * @param pathString the given path string
    */
  def path(pathString: String): this.type = js.native

  /**
    * The default (/) namespace.
    */
  def sockets: Namespace = js.native

  /**
    *
    * @return
    */
  def serveClient(): Boolean = js.native

  /**
    * If v is true the attached server (see Server#attach) will serve the client files. Defaults to true.
    * This method has no effect after attach is called.
    * @param v
    * @return
    */
  def serveClient(v: Boolean): this.type = js.native

  /**
    * Registers a middleware, which is a function that gets executed for every incoming Packet
    * and receives as parameter the packet and a function to optionally defer execution to
    * the next registered middleware.
    * @param fn the function that gets executed for every incoming Packet
    */
  def use(fn: js.Function): this.type = js.native

}

/**
  * Server Companion
  * @author lawrence.daniels@gmail.com
  */
object Server {

  /**
    * socket.io server enrichment
    * @param server the given [[Server server]]
    */
  implicit class ServerEnrichment(val server: Server) extends AnyVal {

    @inline
    def onConnection(handler: Socket => Any): server.type = server.on("connection", handler)

  }

}