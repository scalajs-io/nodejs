package com.github.ldaniels528.meansjs.nodejs.http

import com.github.ldaniels528.meansjs.nodejs
import com.github.ldaniels528.meansjs.nodejs.NodeError
import com.github.ldaniels528.meansjs.nodejs.net.Server.ListenerOptions
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.{ExecutionContext, Promise}
import scala.scalajs.js

/**
  * This class inherits from net.Server and has the following additional events
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Server extends nodejs.net.Server {

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
  def connections: Integer

  /**
    * Set this property to reject connections when the server's connection count gets high.
    * It is not recommended to use this option once a socket has been sent to a child with child_process.fork().
    * @example server.maxConnections
    */
  var maxConnections: Int

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the bound address, the address family name and port of the server as reported by the operating system.
    * Useful to find which port was assigned when giving getting an OS-assigned address. Returns an object with
    * three properties, e.g. { port: 12346, family: 'IPv4', address: '127.0.0.1' }
    * @example server.address()
    */
  def address(): Server.IPAddress

  /**
    * Asynchronously get the number of concurrent connections on the server. Works when sockets were sent to forks.
    * Callback should take two arguments err and count.
    * @example server.getConnections(callback)
    */
  def getConnections(callback: js.Function): Unit

  /**
    * Opposite of unref, calling ref on a previously unrefd server will not let the program exit if it's
    * the only server left (the default behavior). If the server is refd calling ref again will have no effect.
    * Returns server.
    * @example server.ref()
    */
  def ref(): this.type

  /**
    * Calling unref on a server will allow the program to exit if this is the only active server in the
    * event system. If the server is already unrefd calling unref again will have no effect.
    * Returns server.
    * @example server.unref()
    */
  def unref(): this.type

}

/**
  * Server Companion
  * @author lawrence.daniels@gmail.com
  */
object Server {
  val EVENT_ERROR = "error"
  val EVENT_LISTENING = "listening"

  /**
    * Server Enrichment
    * @author lawrence.daniels@gmail.com
    */
  implicit class ServerEnrichment(val server: Server) extends AnyVal {

    def closeAsync(implicit ec: ExecutionContext) = {
      val promise = Promise[Unit]()
      server.close((err: NodeError) => {
        if (!isDefined(err)) promise.success({}) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def getConnectionsAsync(implicit ec: ExecutionContext) = {
      val promise = Promise[Int]()
      server.getConnections((err: NodeError, steam: Int) => {
        if (!isDefined(err)) promise.success(steam) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

    def listenAsync(options: ListenerOptions)(implicit ec: ExecutionContext) = {
      val promise = Promise[Unit]()
      server.listen(options, (err: NodeError) => {
        if (!isDefined(err)) promise.success({}) else promise.failure(new RuntimeException(err.toString))
      })
      promise.future
    }

  }

  /**
    * Server IP Address
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait IPAddress extends js.Object {
    var address: js.UndefOr[String]
    var port: js.UndefOr[Int]
  }

}