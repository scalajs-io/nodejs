package io.scalajs.nodejs.http

import io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * http.Server - This class inherits from net.Server and has the following additional events
  * @version 6.2.1
  */
@js.native
@JSImport("http", "Server")
class Server extends nodejs.net.Server {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The number of concurrent connections on the server. This becomes null when sending a socket to a
    * child with child_process.fork(). To poll forks and get current number of active connections use
    * asynchronous server.getConnections instead.
    * @example server.connections
    */
  @deprecated("Use getConnections() instead", "4.x")
  def connections: Integer = js.native

  /**
    * Set this property to reject connections when the server's connection count gets high.
    * It is not recommended to use this option once a socket has been sent to a child with child_process.fork().
    * @example server.maxConnections
    */
  var maxConnections: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Asynchronously get the number of concurrent connections on the server. Works when sockets were sent to forks.
    * Callback should take two arguments err and count.
    * @example server.getConnections(callback)
    */
  def getConnections(callback: js.Function): Unit = js.native

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
