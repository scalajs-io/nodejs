package com.github.ldaniels528.meansjs.nodejs.http

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._
import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * NodeJS Http module
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Http extends NodeModule with EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Global instance of Agent which is used as the default for all http client requests.
    * @example http.globalAgent
    */
  def globalAgent: js.Array[js.Any] = js.native

  /**
    * A list of the HTTP methods that are supported by the parser.
    */
  val METHODS: js.Array[String] = js.native

  /**
    * A collection of all the standard HTTP response status codes, and the short description of each.
    * @example http.STATUS_CODES[404] === 'Not Found'.
    */
  val STATUS_CODES: js.Dictionary[String] = js.native

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
  def createServer(callback: js.Function2[ClientRequest, ServerResponse, Any]): Server = js.native

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

    @inline
    def requestFuture(options: RequestOptions) = callbackWithErrorToFuture[ServerResponse](http.request(options, _))

  }

}
