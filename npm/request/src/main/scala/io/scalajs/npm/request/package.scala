package io.scalajs.npm

import io.scalajs.nodejs.Error
import io.scalajs.nodejs.http.IncomingMessage
import io.scalajs.util.ScalaJsHelper.futureCallbackE2

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.|

/**
  * request package object
  * @author lawrence.daniels@gmail.com
  */
package object request {

  /**
    * Request Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class RequestExtensions(val client: Request) extends AnyVal {

    @inline
    def getFuture(url: String): Promise[(IncomingMessage, String)] = {
      futureCallbackE2[Error, IncomingMessage, String](client.get(url, _))
    }

    @inline
    def postFuture(url: String): Promise[(IncomingMessage, String)] = {
      futureCallbackE2[Error, IncomingMessage, String](client.post(url, _))
    }

    @inline
    def postFuture(options: RequestOptions | js.Any): Promise[(IncomingMessage, String)] = {
      futureCallbackE2[Error, IncomingMessage, String](client.post(options, _))
    }

  }

}
