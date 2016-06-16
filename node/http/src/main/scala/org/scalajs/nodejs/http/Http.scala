package org.scalajs.nodejs.http

import org.scalajs.nodejs.{NodeModule, NodeRequire}
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.{NodeModule, NodeRequire}
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.util.ScalaJsHelper

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
  def globalAgent: Agent = js.native

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
  def createClient(port: Int, host: String): Client = js.native

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(port: Int): Client = js.native

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(host: String): Client = js.native

  /**
    * Constructs a new HTTP client. port and host refer to the server to be connected to.
    * @example http.createClient([port][, host])
    */
  @deprecated("Use request() instead", "4.x")
  def createClient(): Client = js.native

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
    * Since most requests are GET requests without bodies, Node.js provides this convenience method. The only difference
    * between this method and http.request() is that it sets the method to GET and calls req.end() automatically.
    * @example http.get('https://encrypted.google.com/', (res) => { ... })
    */
  def get(url: String, callback: js.Function): Unit = js.native

  /**
    * Since most requests are GET requests without bodies, Node.js provides this convenience method. The only difference
    * between this method and http.request() is that it sets the method to GET and calls req.end() automatically.
    * @example http.get(options, (res) => { ... })
    */
  def get(options: RequestOptions, callback: js.Function): Unit = js.native

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

  /**
    * Node.js maintains several connections per server to make HTTP requests.
    * This function allows one to transparently issue requests.
    * @example http.request(options[, callback])
    */
  def request(url: String, callback: js.Function): Unit = js.native

  /**
    * Node.js maintains several connections per server to make HTTP requests.
    * This function allows one to transparently issue requests.
    * @example http.request(options[, callback])
    */
  def request(url: String): Unit = js.native

}

/**
  * Http Companion
  * @author lawrence.daniels@gmail.com
  */
object Http {

  /**
    * Convenience method for retrieving the http module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Http instance
    */
  def apply()(implicit require: NodeRequire) = require[Http]("http")

  /**
    * Http Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class HttpExtensions(val http: Http) extends AnyVal {

    /**
      * Since most requests are GET requests without bodies, Node.js provides this convenience method. The only difference
      * between this method and http.request() is that it sets the method to GET and calls req.end() automatically.
      * @example http.get(options, (res) => { ... })
      */
    @inline
    def getFuture(options: RequestOptions) = futureCallbackA1[ServerResponse](http.get(options, _))

    /**
      * Since most requests are GET requests without bodies, Node.js provides this convenience method. The only difference
      * between this method and http.request() is that it sets the method to GET and calls req.end() automatically.
      * @example http.get(options, (res) => { ... })
      */
    @inline
    def getFuture(url: String) = futureCallbackA1[ServerResponse](http.get(url, _))

    /**
      * Node.js maintains several connections per server to make HTTP requests.
      * This function allows one to transparently issue requests.
      */
    @inline
    def requestFuture(options: RequestOptions) = futureCallbackE1[js.Error, ServerResponse](http.request(options, _))

    /**
      * Node.js maintains several connections per server to make HTTP requests.
      * This function allows one to transparently issue requests.
      */
    @inline
    def requestFuture(url: String) = futureCallbackE1[js.Error, ServerResponse](http.request(url, _))

  }

}
