package com.github.ldaniels528.meansjs.nodejs.http

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import com.github.ldaniels528.meansjs.nodejs.NodeModule

import scala.scalajs.js

/**
  * NodeJS Http module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Http extends NodeModule {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Global instance of Agent which is used as the default for all http client requests.
    * @example http.globalAgent
    */
  def globalAgent: js.Array[js.Any] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(port: Int, host: String): js.Any = js.native

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(port: Int): js.Any = js.native

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(host: String): js.Any = js.native

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(): js.Any = js.native

  /**
    * Returns a new instance of http.Server.
    * @example http.createServer([requestListener])
    */
  def createServer(callback: js.Function2[ClientRequest, ServerResponse, Unit]): Server = js.native

  /**
    * Returns a new instance of http.Server.
    * @example http.createServer([requestListener])
    */
  def createServer(): Server = js.native

  /**
    * Node.js maintains several connections per server to make HTTP requests.
    * This function allows one to transparently issue requests.
    * @example http.request(options[, callback])
    */
  def request(options: RequestOptions, callback: js.Function): Unit = js.native

  /**
    * Node.js maintains several connections per server to make HTTP requests.
    * This function allows one to transparently issue requests.
    * @example http.request(options[, callback])
    */
  def request(options: RequestOptions): Unit = js.native

}

/**
  * Http Companion
  * @author lawrence.daniels@gmail.com
  */
object Http {

  /**
    * Http Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class HttpExtensions(val http: Http) extends AnyVal {

    def requestAsync(options: RequestOptions) = toFuture[ServerResponse](http.request(options, _))

  }

}
