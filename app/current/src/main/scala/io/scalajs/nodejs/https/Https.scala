package io.scalajs.nodejs.https

import com.thoughtworks.enableIf
import io.scalajs.nodejs.http.{ClientRequest, RequestOptions, ServerResponse}
import io.scalajs.nodejs.url.URL

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * HTTPS is the HTTP protocol over TLS/SSL. In Node.js this is implemented as a separate module.
  * @see https://nodejs.org/api/https.html
  */
@js.native
trait Https extends js.Object {
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
  def createServer(options: ServerOptions, requestListener: js.Function): Server = js.native
  def createServer(requestListener: js.Function): Server                         = js.native
  def createServer(options: ServerOptions): Server                               = js.native
  def createServer(): Server                                                     = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def get(url: String | URL, options: RequestOptions, callback: js.Function1[ServerResponse, Any]): ClientRequest =
    js.native
  def get(url: String | URL, callback: js.Function1[ServerResponse, Any]): ClientRequest = js.native
  def get(options: RequestOptions, callback: js.Function): ClientRequest                 = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def request(url: String | URL,
              options: RequestOptions,
              callback: js.Function1[ServerResponse, Any] = js.native): Unit              = js.native
  def request(url: String | URL, callback: js.Function1[ServerResponse, Any]): Unit       = js.native
  def request(url: String | URL): Unit                                                    = js.native
  def request(options: RequestOptions): Unit                                              = js.native
  def request(options: RequestOptions, callback: js.Function1[ServerResponse, Any]): Unit = js.native
}

/**
  * Https Singleton
  */
@js.native
@JSImport("https", JSImport.Namespace)
object Https extends Https
