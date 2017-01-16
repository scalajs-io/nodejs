package io.scalajs.nodejs.net

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * net - The net module provides you with an asynchronous network wrapper. It contains functions for creating both
  * servers and clients (called streams).
  * @version 7.4.0
  * @see https://nodejs.org/api/net.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Net extends IEventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A factory function, which returns a new net.Socket and automatically connects with the supplied options.
    * The options are passed to both the net.Socket constructor and the socket.connect method.
    * The connectListener parameter will be added as a listener for the 'connect' event once.
    * @example net.connect(options[, connectListener])
    */
  def connect(options: ConnectOptions, callback: js.Function): Socket = js.native

  /**
    * A factory function, which returns a new net.Socket and automatically connects with the supplied options.
    * The options are passed to both the net.Socket constructor and the socket.connect method.
    * The connectListener parameter will be added as a listener for the 'connect' event once.
    * @example net.connect(options[, connectListener])
    */
  def connect(options: ConnectOptions): Socket = js.native

  /**
    * A factory function, which returns a new unix net.Socket and automatically connects to the supplied path.
    * The connectListener parameter will be added as a listener for the 'connect' event once.
    * @example net.connect(path[, connectListener])
    */
  def connect(path: String, connectListener: js.Function): Socket = js.native

  /**
    * A factory function, which returns a new unix net.Socket and automatically connects to the supplied path.
    * The connectListener parameter will be added as a listener for the 'connect' event once.
    * @example net.connect(path[, connectListener])
    */
  def connect(path: String): Socket = js.native

  /**
    * A factory function, which returns a new net.Socket and automatically connects to the supplied port and host.
    * If host is omitted, 'localhost' will be assumed.
    * The connectListener parameter will be added as a listener for the 'connect' event once.
    * @example net.connect(port[, host][, connectListener])
    */
  def connect(port: Int, host: String, connectListener: js.Function): Socket = js.native

  /**
    * A factory function, which returns a new net.Socket and automatically connects to the supplied port and host.
    * If host is omitted, 'localhost' will be assumed.
    * The connectListener parameter will be added as a listener for the 'connect' event once.
    * @example net.connect(port[, host][, connectListener])
    */
  def connect(port: Int, host: String): Socket = js.native

  /**
    * A factory function, which returns a new net.Socket and automatically connects to the supplied port and host.
    * If host is omitted, 'localhost' will be assumed.
    * The connectListener parameter will be added as a listener for the 'connect' event once.
    * @example net.connect(port[, host][, connectListener])
    */
  def connect(port: Int): Socket = js.native

  /**
    * A factory function, which returns a new net.Socket and automatically connects with the supplied options.
    * The options are passed to both the net.Socket constructor and the socket.connect method. The connectListener
    * parameter will be added as a listener for the 'connect' event once.
    * @example net.createConnection(options[, connectListener])
    */
  def createConnection(options: ConnectOptions, connectListener: js.Function): Socket = js.native

  /**
    * A factory function, which returns a new net.Socket and automatically connects with the supplied options.
    * The options are passed to both the net.Socket constructor and the socket.connect method. The connectListener
    * parameter will be added as a listener for the 'connect' event once.
    * @example net.createConnection(options[, connectListener])
    */
  def createConnection(options: ConnectOptions): Socket = js.native

  /**
    * @example net.createConnection(path[, connectListener])
    */
  def createConnection(path: String, connectListener: js.Function): Socket = js.native

  /**
    * @example net.createConnection(path[, connectListener])
    */
  def createConnection(path: String): Socket = js.native

  /**
    * @example net.createConnection(port[, host][, connectListener])
    */
  def createConnection(port: Int, host: String, connectListener: js.Function): Socket = js.native

  /**
    * @example net.createConnection(port[, host][, connectListener])
    */
  def createConnection(port: Int, host: String): Socket = js.native

  /**
    * @example net.createConnection(port[, host][, connectListener])
    */
  def createConnection(port: Int): Socket = js.native

  /**
    * @example net.createServer([options][, connectionListener])
    */
  def createServer(options: ServerOptions, connectionListener: js.Function): Server = js.native

  /**
    * @example net.createServer([options][, connectionListener])
    */
  def createServer(options: ServerOptions): Server = js.native

  /**
    * @example net.createServer([options][, connectionListener])
    */
  def createServer(connectionListener: js.Function): Server = js.native

  /**
    * @example net.createServer([options][, connectionListener])
    */
  def createServer(): Server = js.native

  /**
    * Tests if input is an IP address. Returns 0 for invalid strings, returns 4 for IP version 4 addresses,
    * and returns 6 for IP version 6 addresses.
    * @example net.isIP(input)
    */
  def isIP(input: String): Boolean = js.native

  /**
    * Returns true if input is a version 4 IP address, otherwise returns false.
    * @example net.isIPv4(input)
    */
  def isIPv4(input: String): Boolean = js.native

  /**
    * Returns true if input is a version 6 IP address, otherwise returns false.
    * @example net.isIPv6(input)
    */
  def isIPv6(input: String): Boolean = js.native

}

/**
  * Net Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("net", JSImport.Namespace)
object Net extends Net