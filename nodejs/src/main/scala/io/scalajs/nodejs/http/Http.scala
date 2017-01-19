package io.scalajs.nodejs.http

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * To use the HTTP server and client one must require('http').
  *
  * The HTTP interfaces in Node.js are designed to support many features of the protocol which have been
  * traditionally difficult to use. In particular, large, possibly chunk-encoded, messages. The interface
  * is careful to never buffer entire requests or responses--the user is able to stream data.
  * @version 7.4.0
  * @see https://nodejs.org/api/http.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Http extends IEventEmitter {

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
  def createServer[A <: ClientRequest, B <: ServerResponse](callback: js.Function2[A, B, Any]): Server = js.native

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
  def get(url: String, callback: js.Function1[ServerResponse, Any]): Unit = js.native

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
  * Http Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("http", JSImport.Namespace)
object Http extends Http