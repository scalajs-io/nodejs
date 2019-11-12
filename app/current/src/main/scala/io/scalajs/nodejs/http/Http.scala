package io.scalajs.nodejs.http

import com.thoughtworks.enableIf
import io.scalajs.nodejs.url.URL

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * To use the HTTP server and client one must require('http').
  *
  * The HTTP interfaces in Node.js are designed to support many features of the protocol which have been
  * traditionally difficult to use. In particular, large, possibly chunk-encoded, messages. The interface
  * is careful to never buffer entire requests or responses--the user is able to stream data.
  * @see https://nodejs.org/api/http.html
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
  def globalAgent: Agent = js.native

  /**
    * A list of the HTTP methods that are supported by the parser.
    */
  val METHODS: js.Array[String] = js.native

  /**
    * A collection of all the standard HTTP response status codes, and the short description of each.
    * @example http.STATUS_CODES[404] === 'Not Found'.
    */
  val STATUS_CODES: StatusCodes = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def createServer(options: ServerOptions, requestListener: js.Function2[ClientRequest, ServerResponse, Any]): Server =
    js.native
  def createServer(requestListener: js.Function2[ClientRequest, ServerResponse, Any] = js.native): Server = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def get(url: String | URL,
          options: RequestOptions,
          callback: js.Function1[ServerResponse, Any] = js.native): ClientRequest        = js.native
  def get(url: String | URL, callback: js.Function1[ServerResponse, Any]): ClientRequest = js.native
  def get(url: String | URL): ClientRequest                                              = js.native
  def get(options: RequestOptions): ClientRequest                                        = js.native
  def get(options: RequestOptions, callback: js.Function): ClientRequest                 = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def maxHeaderSize: Int = js.native

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
  * Http Singleton
  */
@js.native
@JSImport("http", JSImport.Namespace)
object Http extends Http
