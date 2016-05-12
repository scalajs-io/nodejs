package com.github.ldaniels528.meansjs.nodejs.request

import com.github.ldaniels528.meansjs.nodejs.NodeModule
import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter
import com.github.ldaniels528.meansjs.nodejs.http.IncomingMessage
import com.github.ldaniels528.meansjs.nodejs.stream.{Readable, Writable}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.runtime._

/**
  * Simplified HTTP request client.
  * @author lawrence.daniels@gmail.com
  * @see [[https://github.com/request/request]]
  * @version 2.72.1
  */
@js.native
trait Request extends NodeModule with EventEmitter {

  def apply(url: String): Readable = js.native

  def apply(url: String, callback: js.Function): Unit = js.native

  def defaults(options: js.Any): this.type = js.native

  def get(url: String): Readable = js.native

  def get(url: String, callback: js.Function): Unit = js.native

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
    * Request Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class RequestExtensions(val request: Request) extends AnyVal {

    def getAsync(url: String) = {
      val promise = Promise[(IncomingMessage, String)]()
      request.get(url, (error: String, response: IncomingMessage, body: String) => {
        if (!isDefined(error)) promise.success((response, body)) else promise.failure(wrapJavaScriptException(error))
      })
      promise.future
    }

  }

}