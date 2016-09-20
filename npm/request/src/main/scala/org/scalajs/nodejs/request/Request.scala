package org.scalajs.nodejs
package request

import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.http.IncomingMessage
import org.scalajs.nodejs.stream.{Readable, Writable}
import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Simplified HTTP request client.
  * @author lawrence.daniels@gmail.com
  * @see [[https://github.com/request/request]]
  * @version 2.72.1
  */
@js.native
trait Request extends NodeModule with EventEmitter {

  def apply(form: RequestOptions | MultipartForm | js.Any): Readable = js.native

  def apply(url: String): Readable = js.native

  def apply(url: String, callback: js.Function): Unit = js.native

  def defaults(options: DefaultOptions | js.Any): this.type = js.native

  def get(form: RequestOptions | MultipartForm | js.Any): Readable = js.native

  def get(url: String): Readable = js.native

  def get(url: String, callback: js.Function): Unit = js.native

  /**
    * POST a form with a callback
    * @param options  the given [[RequestOptions request options]]
    * @param callback the callback function
    */
  def post(options: RequestOptions | js.Any, callback: js.Function): Unit = js.native

  /**
    * Use Request as a Writable stream to easily POST Readable streams (like files, other HTTP requests, or otherwise).
    * @param url the requested URL
    * @return
    */
  def post(url: String): Readable = js.native

  /**
    * Use Request as a Writable stream to easily POST Readable streams (like files, other HTTP requests, or otherwise).
    * @param url the requested URL
    * @return
    */
  def post(url: String, callback: js.Function): Unit = js.native

  def put(url: String): Writable = js.native

  def put(url: String, callback: js.Function): Unit = js.native

}

/**
  * Request Module Companion
  * @author lawrence.daniels@gmail.com
  */
object Request {

  /**
    * Convenience method for retrieving the 'request' module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Request instance
    */
  def apply()(implicit require: NodeRequire) = require[Request]("request")

  /**
    * Request Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class RequestExtensions(val client: Request) extends AnyVal {

    @inline
    def getFuture(url: String) = {
      futureCallbackE2[errors.Error, IncomingMessage, String](client.get(url, _))
    }

    @inline
    def postFuture(url: String) = {
      futureCallbackE2[errors.Error, IncomingMessage, String](client.post(url, _))
    }

    @inline
    def postFuture(options: RequestOptions | js.Any) = {
      futureCallbackE2[errors.Error, IncomingMessage, String](client.post(options, _))
    }

  }

}