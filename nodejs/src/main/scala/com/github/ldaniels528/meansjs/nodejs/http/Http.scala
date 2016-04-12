package com.github.ldaniels528.meansjs.nodejs.http

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Scala.js Binding for Node.js Http Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Http extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Global instance of Agent which is used as the default for all http client requests.
    * @example http.globalAgent
    */
  def globalAgent: js.Array[js.Any]

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(port: Int, host: String): js.Any

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(port: Int): js.Any

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(host: String): js.Any

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(): js.Any

  /**
    * Returns a new instance of http.Server.
    * @example http.createServer([requestListener])
    */
  def createServer(callback: js.Function2[ClientRequest, ServerResponse, Unit]): Server

  /**
    * Returns a new instance of http.Server.
    * @example http.createServer([requestListener])
    */
  def createServer(): Server

  /**
    * Node.js maintains several connections per server to make HTTP requests.
    * This function allows one to transparently issue requests.
    * @example http.request(options[, callback])
    */
  def request(options: Http.RequestOptions, callback: js.Function1[ServerResponse, Unit]): Unit

  /**
    * Node.js maintains several connections per server to make HTTP requests.
    * This function allows one to transparently issue requests.
    * @example http.request(options[, callback])
    */
  def request(options: Http.RequestOptions): Unit

}

/**
  * Http Companion
  * @author lawrence.daniels@gmail.com
  */
object Http {

  /**
    * Client Request Options
    * @author lawrence.daniels@gmail.com
    */
  @js.native
  trait RequestOptions extends js.Object {
    /** Protocol to use. Defaults to 'http:'. */
    var protocol: js.UndefOr[String]

    /** Alias for host. To support url.parse() hostname is preferred over host. */
    var host: js.UndefOr[String]

    /** Alias for host. To support url.parse() hostname is preferred over host. */
    var hostname: js.UndefOr[String]

    /** IP address family to use when resolving host and hostname. Valid values are 4 or 6. When unspecified, both IP v4 and v6 will be used. */
    var family: js.UndefOr[String]

    /** Port of remote server. Defaults to 80. */
    var port: js.UndefOr[Int]

    /** Local interface to bind for network connections. */
    var localAddress: js.UndefOr[String]

    /** Unix Domain Socket (use one of host:port or socketPath). */
    var socketPath: js.UndefOr[String]

    /** A string specifying the HTTP request method. Defaults to 'GET'. */
    var method: js.UndefOr[String]

    /** Request path. Defaults to '/'. Should include query string if any. E.G. '/index.html?page=12'. An exception is thrown when the request path contains illegal characters. Currently, only spaces are rejected but that may change in the future. */
    var path: js.UndefOr[String]

    /** An object containing request headers. */
    var headers: js.UndefOr[js.Object]

    /** Basic authentication i.e. 'user:password' to compute an Authorization header. */
    var auth: js.UndefOr[String]

    /** Controls Agent behavior. When an Agent is used request will default to Connection: keep-alive. Possible values: */
    var agent: js.UndefOr[String]

    /**
      * A function that produces a socket/stream to use for the request when the agent option is not used.
      * This can be used to avoid creating a custom Agent class just to override the default createConnection function.
      * @see [[Agent.createConnection() ]]
      */
    var createConnection: js.UndefOr[js.Function]
  }

  /**
    * Client Request Options Companion
    * @author lawrence.daniels@gmail.com
    */
  object RequestOptions {

    def apply(protocol: js.UndefOr[String] = js.undefined,
              host: js.UndefOr[String] = js.undefined,
              hostname: js.UndefOr[String] = js.undefined,
              family: js.UndefOr[String] = js.undefined,
              port: js.UndefOr[Int] = js.undefined,
              localAddress: js.UndefOr[String] = js.undefined,
              socketPath: js.UndefOr[String] = js.undefined,
              method: js.UndefOr[String] = js.undefined,
              path: js.UndefOr[String] = js.undefined,
              headers: js.UndefOr[js.Object] = js.undefined,
              auth: js.UndefOr[String] = js.undefined,
              agent: js.UndefOr[String] = js.undefined) = {
      val options = makeNew[RequestOptions]
      options.protocol = protocol
      options.host = host
      options.hostname = hostname
      options.family = family
      options.port = port
      options.localAddress = localAddress
      options.socketPath = socketPath
      options.method = method
      options.path = path
      options.headers = headers
      options.auth = auth
      options.agent = agent
      options
    }

  }

}
