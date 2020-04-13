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

  type RequestCallBack[A <: js.Any] = js.Function3[RequestError, IncomingMessage, A, Any]

  type RequestError = SystemError

  /**
    * Request Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class RequestExtensions(val client: Request) extends AnyVal {

    @inline
    def deleteFuture[A <: js.Any](options: RequestOptions): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.del(options, _))
    }

    @inline
    def deleteFuture[A <: js.Any](url: String): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.del(url, _))
    }

    @inline
    def getFuture[A <: js.Any](options: RequestOptions): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.get(options, _))
    }

    @inline
    def getFuture[A <: js.Any](url: String): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.get(url, _))
    }

    @inline
    def getFuture[A <: js.Any](url: String, options: RequestOptions): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.get(url, options, _))
    }

    @inline
    def headFuture[A <: js.Any](options: RequestOptions): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.head(options, _))
    }

    @inline
    def headFuture[A <: js.Any](url: String): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.head(url, _))
    }

    @inline
    def patchFuture[A <: js.Any](options: RequestOptions): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.patch(options, _))
    }

    @inline
    def patchFuture[A <: js.Any](url: String): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.patch(url, _))
    }

    @inline
    def postFuture[A <: js.Any](options: RequestOptions): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.post(options, _))
    }

    @inline
    def postFuture[A <: js.Any](url: String): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.post(url, _))
    }

    @inline
    def postFuture[A <: js.Any](url: String, options: RequestOptions): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.post(url, options, _))
    }

    @inline
    def putFuture[A <: js.Any](options: RequestOptions): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.put(options, _))
    }

    @inline
    def putFuture[A <: js.Any](url: String): Future[(IncomingMessage, A)] = {
      promiseWithError2[RequestError, IncomingMessage, A](client.put(url, _))
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
