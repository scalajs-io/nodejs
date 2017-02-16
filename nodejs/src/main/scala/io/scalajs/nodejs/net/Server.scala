package io.scalajs.nodejs.net

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * net.Server - This class is used to create a TCP or local server.
  * @see https://nodejs.org/api/net.html#net_class_net_server
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Server extends IEventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A Boolean indicating whether or not the server is listening for connections.
    * @example server.listening
    */
  def listening: Boolean = js.native

  /**
    * Limits maximum incoming headers count, equal to 1000 by default. If set to 0 - no limit will be applied.
    * @example server.maxHeadersCount
    */
  var maxHeadersCount: Int = js.native

  /**
    * The number of milliseconds of inactivity before a socket is presumed to have timed out.
    * Note that the socket timeout logic is set up on connection, so changing this value only affects
    * new connections to the server, not any existing connections.
    * Set to 0 to disable any kind of automatic timeout behavior on incoming connections.
    * Default = 120000 (2 minutes)
    * @example server.timeout
    */
  var timeout: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the bound address, the address family name and port of the server as reported by the operating system.
    * Useful to find which port was assigned when giving getting an OS-assigned address. Returns an object with
    * three properties, e.g. { port: 12346, family: 'IPv4', address: '127.0.0.1' }
    * @example server.address()
    */
  def address(): Address = js.native

  /**
    * Stops the server from accepting new connections and keeps existing connections. This function is asynchronous,
    * the server is finally closed when all connections are ended and the server emits a 'close' event. The optional
    * callback will be called once the 'close' event occurs. Unlike that event, it will be called with an Error as
    * its only argument if the server was not open when it was closed.
    * @example server.close([callback])
    */
  def close(callback: js.Function): Unit = js.native

  /**
    * Stops the server from accepting new connections and keeps existing connections. This function is asynchronous,
    * the server is finally closed when all connections are ended and the server emits a 'close' event. The optional
    * callback will be called once the 'close' event occurs. Unlike that event, it will be called with an Error as
    * its only argument if the server was not open when it was closed.
    * @example server.close([callback])
    */
  def close(): Unit = js.native

  /**
    * The port, host, and backlog properties of options, as well as the optional callback function, behave as
    * they do on a call to server.listen(port[, hostname][, backlog][, callback]). Alternatively, the path
    * option can be used to specify a UNIX socket.
    * @example server.listen(options[, callback])
    */
  def listen(options: ListenerOptions, callback: js.Function): Unit = js.native

  /**
    * The port, host, and backlog properties of options, as well as the optional callback function, behave as
    * they do on a call to server.listen(port[, hostname][, backlog][, callback]). Alternatively, the path
    * option can be used to specify a UNIX socket.
    * @example server.listen(options[, callback])
    */
  def listen(options: ListenerOptions): Unit = js.native

  /**
    * @example server.listen(port[, hostname][, backlog][, callback])
    */
  def listen(port: Int, hostname: String, backlog: Int, callback: js.Function): Unit = js.native

  /**
    * @example server.listen(port[, hostname][, backlog][, callback])
    */
  def listen(port: Int, hostname: String, backlog: Int): Unit = js.native

  /**
    * @example server.listen(port[, hostname][, backlog][, callback])
    */
  def listen(port: Int, hostname: String): Unit = js.native

  /**
    * @example server.listen(port[, hostname][, backlog][, callback])
    */
  def listen(port: Int): Unit = js.native

  /**
    * Sets the timeout value for sockets, and emits a 'timeout' event on the Server object, passing the socket
    * as an argument, if a timeout occurs.
    *
    * If there is a 'timeout' event listener on the Server object, then it will be called with the timed-out socket as an argument.
    * By default, the Server's timeout value is 2 minutes, and sockets are destroyed automatically if they time out. However, if you assign a callback to the Server's 'timeout' event, then you are responsible for handling socket timeouts.
    * Returns server.
    */
  def setTimeout(msecs: Int, callback: js.Function): this.type = js.native

}

/**
  * Server Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("net", "Server")
object Server extends js.Object
