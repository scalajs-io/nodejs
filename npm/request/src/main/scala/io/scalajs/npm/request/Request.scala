package io.scalajs.npm.request

import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.stream.{Readable, Writable}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Simplified HTTP request client.
  * @version 2.72.1
  * @see https://github.com/request/request
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Request extends IEventEmitter {

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
  * Request Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("request", JSImport.Namespace)
object Request extends Request