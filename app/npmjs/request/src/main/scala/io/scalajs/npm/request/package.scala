package io.scalajs.npm

import io.scalajs.nodejs.http.IncomingMessage
import io.scalajs.nodejs.{SystemError, stream}
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js

/**
  * request package object
  * @author lawrence.daniels@gmail.com
  */
package object request {

  type RequestBody = js.Any

  type RequestCallBack = js.Function3[RequestError, IncomingMessage, RequestBody, Any]

  type RequestError = SystemError

  /**
    * Request Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class RequestExtensions(val client: Request) extends AnyVal {

    @inline
    def deleteFuture(options: RequestOptions): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.del(options, _))
    }

    @inline
    def deleteFuture(url: String): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.del(url, _))
    }

    @inline
    def getFuture(options: RequestOptions): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.get(options, _))
    }

    @inline
    def getFuture(url: String): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.get(url, _))
    }

    @inline
    def headFuture(options: RequestOptions): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.head(options, _))
    }

    @inline
    def headFuture(url: String): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.head(url, _))
    }

    @inline
    def patchFuture(options: RequestOptions): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.patch(options, _))
    }

    @inline
    def patchFuture(url: String): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.patch(url, _))
    }

    @inline
    def postFuture(options: RequestOptions): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.post(options, _))
    }

    @inline
    def postFuture(url: String): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.post(url, _))
    }

    @inline
    def postFuture(url: String, options: RequestOptions): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.post(url, options, _))
    }

    @inline
    def putFuture(options: RequestOptions): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.put(options, _))
    }

    @inline
    def putFuture(url: String): Future[(IncomingMessage, RequestBody)] = {
      promiseWithError2[RequestError, IncomingMessage, RequestBody](client.put(url, _))
    }

  }

  /**
    * Request Events
    * @author lawrence.daniels@gmail.com
    */
  implicit class RequestEvents(val readable: stream.Readable) extends AnyVal {

    @inline
    def onResponse(handler: IncomingMessage => Any): readable.type = readable.on("response", handler)

  }

}
