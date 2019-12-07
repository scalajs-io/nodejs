package io.scalajs.nodejs
package net

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * net.Server - This class is used to create a TCP or local server.
  * @see https://nodejs.org/api/net.html#net_class_net_server
  */
@js.native
@JSImport("net", "Server")
class Server(options: ServerOptions = js.native) extends IEventEmitter {
  def this(options: ServerOptions, connectionListener: js.Function) = this()
  def this(connectionListener: js.Function) = this()

  /**
    * A Boolean indicating whether or not the server is listening for connections.
    * @example server.listening
    */
  def listening: Boolean = js.native

  /**
    * Set this property to reject connections when the server's connection count gets high.
    * It is not recommended to use this option once a socket has been sent to a child with child_process.fork().
    * @example server.maxConnections
    */
  var maxConnections: js.UndefOr[Int] = js.native

  /**
    * Returns the bound address, the address family name and port of the server as reported by the operating system.
    * Useful to find which port was assigned when giving getting an OS-assigned address. Returns an object with
    * three properties, e.g. { port: 12346, family: 'IPv4', address: '127.0.0.1' }
    * @example server.address()
    */
  def address(): Address | String = js.native

  /**
    * Stops the server from accepting new connections and keeps existing connections. This function is asynchronous,
    * the server is finally closed when all connections are ended and the server emits a 'close' event. The optional
    * callback will be called once the 'close' event occurs. Unlike that event, it will be called with an Error as
    * its only argument if the server was not open when it was closed.
    * @example server.close([callback])
    */
  def close(callback: js.Function1[io.scalajs.nodejs.SystemError, Any] = js.native): Unit = js.native

  /**
    * Asynchronously get the number of concurrent connections on the server. Works when sockets were sent to forks.
    * Callback should take two arguments err and count.
    * @example server.getConnections(callback)
    */
  def getConnections(callback: js.Function2[SystemError, Int, Any]): Unit = js.native

  /**
    * The port, host, and backlog properties of options, as well as the optional callback function, behave as
    * they do on a call to server.listen(port[, hostname][, backlog][, callback]). Alternatively, the path
    * option can be used to specify a UNIX socket.
    * @example server.listen(options[, callback])
    */
  def listen(options: ListenerOptions, callback: js.Function): Unit = js.native
  def listen(options: ListenerOptions): Unit                        = js.native

  def listen(handle: Handle, backlog: Int, callback: js.Function): Unit = js.native
  def listen(handle: Handle, callback: js.Function): Unit               = js.native
  def listen(handle: Handle, backlog: Int): Unit                        = js.native
  def listen(handle: Handle): Unit                                      = js.native

  def listen(port: Int, hostname: String, backlog: Int, callback: js.Function): Unit = js.native
  def listen(port: Int, hostname: String, backlog: Int): Unit                        = js.native
  def listen(port: Int, hostname: String, callback: js.Function): Unit               = js.native
  def listen(port: Int, hostname: String): Unit                                      = js.native
  def listen(port: Int, callback: js.Function): Unit                                 = js.native
  def listen(port: Int): Unit                                                        = js.native
  def listen(callback: js.Function): Unit                                            = js.native
  def listen(): Unit                                                                 = js.native

  /**
    * Opposite of unref, calling ref on a previously unrefd server will not let the program exit if it's
    * the only server left (the default behavior). If the server is refd calling ref again will have no effect.
    * Returns server.
    * @example server.ref()
    */
  def ref(): this.type = js.native

  /**
    * Calling unref on a server will allow the program to exit if this is the only active server in the
    * event system. If the server is already unrefd calling unref again will have no effect.
    * Returns server.
    * @example server.unref()
    */
  def unref(): this.type = js.native
}

/**
  * Server Companion
  */
object Server extends {

  /**
    * Server Events
    * @param server the given [[Server]]
    */
  implicit final class ServerEvents(val server: Server) extends AnyVal {

    /**
      * Emitted when the server closes. Note that if connections exist, this event is not emitted until all
      * connections are ended.
      */
    @inline
    def onClose(handler: () => Any): server.type = server.on("close", handler)

    /**
      * Emitted when a new connection is made. socket is an instance of net.Socket.
      * - <net.Socket> The connection object
      */
    @inline
    def onConnection(handler: Socket => Any): server.type = server.on("connection", handler)

    /**
      * Emitted when an error occurs. The 'close' event will be called directly following this event.
      * See example in discussion of server.listen.
      * - <Error>
      */
    @inline
    def onError(handler: SystemError => Any): server.type = server.on("error", handler)

    /**
      * Emitted when the server has been bound after calling server.listen.
      */
    @inline
    def onListening(handler: () => Any): server.type = server.on("listening", handler)
  }
}
