package io.scalajs.npm.request

import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.stream.{Readable, Writable}
import io.scalajs.npm.toughcookie.{Cookie, CookieJar, CookieStore}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * Simplified HTTP request client.
  * @version 2.79.0
  * @see https://github.com/request/request
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Request extends IEventEmitter {

  def apply(options: RequestOptions | MultipartForm): Readable = js.native

  def apply(url: String): Readable = js.native

  def apply[A <: js.Any](url: String, callback: RequestCallBack[A]): Unit = js.native

  def apply[A <: js.Any](url: String, options: RequestOptions, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Function that creates a new cookie.
    * @param cookieString the given cookie string
    * @return the [[Cookie]]
    */
  def cookie(cookieString: String): Cookie = js.native

  /**
    * This method returns a wrapper around the normal request API that defaults
    * to whatever options you pass to it.
    * @param options the given [[RequestOptions default options]]
    * @return a self reference
    */
  def defaults(options: RequestOptions): this.type = js.native

  /**
    * Same as Request(), but defaults to method: "DELETE".
    * @param options  the given [[RequestOptions request options]]
    * @param callback the callback function
    */
  def del[A <: js.Any](options: RequestOptions, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Same as request(), but defaults to method: "DELETE".
    * @param url the requested URL
    * @return a [[Readable readable]]
    */
  def del(url: String): Readable = js.native

  /**
    * Same as request(), but defaults to method: "DELETE".
    * @param url      the requested URL
    * @param callback the callback function
    */
  def del[A <: js.Any](url: String, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Same as Request(), but defaults to method: "DELETE".
    * @param options  the given [[RequestOptions request options]]
    * @param callback the callback function
    */
  def delete[A <: js.Any](options: RequestOptions, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Same as request(), but defaults to method: "DELETE".
    * @param url the requested URL
    * @return a [[Readable readable]]
    */
  def delete(url: String): Readable = js.native

  /**
    * Same as request(), but defaults to method: "DELETE".
    * @param url      the requested URL
    * @param callback the callback function
    */
  def delete[A <: js.Any](url: String, callback: RequestCallBack[A]): Unit = js.native

  def form(values: js.Any): this.type = js.native

  def get[A <: js.Any](options: RequestOptions | MultipartForm, callback: RequestCallBack[A]): Unit = js.native

  def get(options: RequestOptions | MultipartForm): Readable = js.native

  def get(url: String): Readable = js.native

  def get[A <: js.Any](url: String, callback: RequestCallBack[A]): Unit = js.native

  def get[A <: js.Any](url: String, options: RequestOptions, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Same as Request(), but defaults to method: "HEAD".
    * @param options  the given [[RequestOptions request options]]
    * @param callback the callback function
    */
  def head[A <: js.Any](options: RequestOptions, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Same as request(), but defaults to method: "HEAD".
    * @param url the requested URL
    * @return a [[Readable readable]]
    */
  def head(url: String): Readable = js.native

  /**
    * Same as request(), but defaults to method: "HEAD".
    * @param url      the requested URL
    * @param callback the callback function
    */
  def head[A <: js.Any](url: String, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Function that creates a new cookie jar.
    * @param cookieStore the optional custom [[CookieStore]]
    * @return a [[CookieJar]]
    */
  def jar(cookieStore: CookieStore = js.native): CookieJar = js.native

  /**
    * Same as Request(), but defaults to method: "PATCH".
    * @param options  the given [[RequestOptions request options]]
    * @param callback the callback function
    */
  def patch[A <: js.Any](options: RequestOptions, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Same as Request(), but defaults to method: "PATCH".
    * @param url the requested URL
    * @return a [[Writable writable]]
    */
  def patch(url: String): Writable = js.native

  /**
    * Same as Request(), but defaults to method: "PATCH".
    * @param url      the requested URL
    * @param callback the callback function
    */
  def patch[A <: js.Any](url: String, callback: RequestCallBack[A]): Unit = js.native

  /**
    * POST a form with a callback
    * @param options  the given [[RequestOptions request options]]
    * @param callback the callback function
    */
  def post[A <: js.Any](options: RequestOptions, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Use Request as a Writable stream to easily POST Readable streams (like files, other HTTP requests, or otherwise).
    * @param url the requested URL
    * @return a [[Readable readable]]
    */
  def post(url: String): Readable = js.native

  /**
    * Use Request as a Writable stream to easily POST Readable streams (like files, other HTTP requests, or otherwise).
    * @param url the requested URL
    * @return
    */
  def post[A <: js.Any](url: String, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Use Request as a Writable stream to easily POST Readable streams (like files, other HTTP requests, or otherwise).
    * @param url      the requested URL
    * @param options  the given [[RequestOptions request options]]
    * @param callback the callback -> (error, response, body)
    */
  def post[A <: js.Any](url: String, options: RequestOptions, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Same as Request(), but defaults to method: "PUT".
    * @param options  the given [[RequestOptions request options]]
    * @param callback the callback function
    */
  def put[A <: js.Any](options: RequestOptions, callback: RequestCallBack[A]): Unit = js.native

  /**
    * Same as Request(), but defaults to method: "PUT".
    * @param url the requested URL
    * @return
    */
  def put(url: String): Writable = js.native

  /**
    * Same as Request(), but defaults to method: "PUT".
    * @param url      the requested URL
    * @param callback the callback function
    */
  def put[A <: js.Any](url: String, callback: RequestCallBack[A]): Unit = js.native

}

/**
  * Request Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("request", JSImport.Namespace)
object Request extends Request