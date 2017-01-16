package io.scalajs.nodejs.https

import io.scalajs.nodejs.NodeOptions
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.http.RequestOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * HTTPS is the HTTP protocol over TLS/SSL. In Node.js this is implemented as a separate module.
  * @version 7.4.0
  * @see https://nodejs.org/api/https.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Https extends IEventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Global instance of https.Agent for all HTTPS client requests.
    */
  def globalAgent: Agent = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns a new HTTPS web server object. The options is similar to tls.createServer().
    * The requestListener is a function which is automatically added to the 'request' event.
    * @example https.createServer(options[, requestListener])
    */
  def createServer(options: ServerOptions | NodeOptions, requestListener: js.Function): Server = js.native

  /**
    * Returns a new HTTPS web server object. The options is similar to tls.createServer().
    * The requestListener is a function which is automatically added to the 'request' event.
    * @example https.createServer(options[, requestListener])
    */
  def createServer(options: ServerOptions | NodeOptions): Server = js.native

  /**
    * Like http.get() but for HTTPS.
    * @example https.get('https://encrypted.google.com/', (res) => { ... })
    * @see [[io.scalajs.nodejs.http.Http.get()]]
    */
  def get(url: String, callback: js.Function): Unit = js.native

  /**
    * Like http.get() but for HTTPS.
    * @example https.get(options, (res) => { ... })
    * @see [[io.scalajs.nodejs.http.Http.get()]]
    */
  def get(options: RequestOptions | NodeOptions, callback: js.Function): Unit = js.native

  /**
    * Makes a request to a secure web server.
    * @param options can be an object or a string. If options is a string, it is automatically parsed with url.parse().
    * @example http.request(options, callback)
    */
  def request(options: RequestOptions | NodeOptions, callback: js.Function): Unit = js.native

  /**
    * Makes a request to a secure web server.
    * @param url can be an object or a string. If options is a string, it is automatically parsed with url.parse().
    * @example http.request(options, callback)
    */
  def request(url: String, callback: js.Function): Unit = js.native

}

/**
  * Https Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("https", JSImport.Namespace)
object Https extends Https