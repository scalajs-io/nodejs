package org.scalajs.nodejs
package https

import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.http.{RequestOptions, ServerResponse}
import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * HTTPS is the HTTP protocol over TLS/SSL. In Node.js this is implemented as a separate module.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Https extends NodeModule with EventEmitter {

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
    * @see [[org.scalajs.nodejs.http.Http.get()]]
    */
  def get(url: String, callback: js.Function): Unit = js.native

  /**
    * Like http.get() but for HTTPS.
    * @example https.get(options, (res) => { ... })
    * @see [[org.scalajs.nodejs.http.Http.get()]]
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
  * Https Companion
  * @author lawrence.daniels@gmail.com
  */
object Https {

  /**
    * Convenience method for retrieving the https module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Https instance
    */
  def apply()(implicit require: NodeRequire) = require[Https]("https")

  /**
    * Https Extensions
    * @author lawrence.daniels@gmail.com
    */
  final implicit class HttpExtensions(val https: Https) extends AnyVal {

    /**
      * Like http.get() but for HTTPS.
      */
    @inline
    def getFuture(options: RequestOptions | NodeOptions) = futureCallbackA1[ServerResponse](https.get(options, _))

    /**
      * Like http.get() but for HTTPS.
      */
    @inline
    def getFuture(url: String) = futureCallbackA1[ServerResponse](https.get(url, _))

    /**
      * Makes a request to a secure web server.
      */
    @inline
    def requestFuture(options: RequestOptions | NodeOptions) = futureCallbackE1[js.Error, ServerResponse](https.request(options, _))

    /**
      * Makes a request to a secure web server.
      */
    @inline
    def requestFuture(url: String) = futureCallbackE1[js.Error, ServerResponse](https.request(url, _))

  }

}
