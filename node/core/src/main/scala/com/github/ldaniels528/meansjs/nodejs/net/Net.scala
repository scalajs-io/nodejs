package com.github.ldaniels528.meansjs.nodejs.net

import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * Scala.js Binding for Node.js Net Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Net extends NodeModule {

  /**
    * @example net.connect(options[, connectListener])
    */
  def connect(options: ClientOptions, callback: js.Function): Client = js.native

  /**
    * @example net.connect(options[, connectListener])
    */
  def connect(options: ClientOptions): Client = js.native

  /**
    * @example net.connect(path[, connectListener])
    */
  def connect(path: String, connectListener: js.Function): Client = js.native

  /**
    * @example net.connect(path[, connectListener])
    */
  def connect(path: String): Client = js.native

  /**
    * @example net.connect(port[, host][, connectListener])
    */
  def connect(port: Int, host: String, connectListener: js.Function): Client = js.native

  /**
    * @example net.connect(port[, host][, connectListener])
    */
  def connect(port: Int, host: String): Client = js.native

  /**
    * @example net.connect(port[, host][, connectListener])
    */
  def connect(port: Int): Client = js.native

  /**
    * A factory function, which returns a new net.Socket and automatically connects with the supplied options.
    * The options are passed to both the net.Socket constructor and the socket.connect method. The connectListener
    * parameter will be added as a listener for the 'connect' event once.
    * @example net.createConnection(options[, connectListener])
    */
  def createConnection(options: ClientOptions, connectListener: js.Function): Client = js.native

  /**
    * A factory function, which returns a new net.Socket and automatically connects with the supplied options.
    * The options are passed to both the net.Socket constructor and the socket.connect method. The connectListener
    * parameter will be added as a listener for the 'connect' event once.
    * @example net.createConnection(options[, connectListener])
    */
  def createConnection(options: ClientOptions): Client = js.native

  /**
    * @example net.createConnection(path[, connectListener])
    */
  def createConnection(path: String, connectListener: js.Function): Client = js.native

  /**
    * @example net.createConnection(path[, connectListener])
    */
  def createConnection(path: String): Client = js.native

  /**
    * @example net.createConnection(port[, host][, connectListener])
    */
  def createConnection(port: Int, host: String, connectListener: js.Function): Client = js.native

  /**
    * @example net.createConnection(port[, host][, connectListener])
    */
  def createConnection(port: Int, host: String): Client = js.native

  /**
    * @example net.createConnection(port[, host][, connectListener])
    */
  def createConnection(port: Int): Client = js.native

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
