package io.scalajs.nodejs

import io.scalajs.{RawOptions, nodejs}
import io.scalajs.nodejs.http.{RequestOptions, ServerResponse}
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Promise
import scala.scalajs.js
import scala.scalajs.js.|

/**
  * https package object
  * @author lawrence.daniels@gmail.com
  */
package object https {

  /**
    * Https Extensions
    * @author lawrence.daniels@gmail.com
    */
  final implicit class HttpExtensions(val https: Https) extends AnyVal {

    /**
      * Like http.get() but for HTTPS.
      */
    @inline
    def getFuture(options: RequestOptions | RawOptions): Promise[ServerResponse] = {
      promiseCallback1[ServerResponse](https.get(options, _))
    }

    /**
      * Like http.get() but for HTTPS.
      */
    @inline
    def getFuture(url: String): Promise[ServerResponse] = {
      promiseCallback1[ServerResponse](https.get(url, _))
    }

    /**
      * Makes a request to a secure web server.
      */
    @inline
    def requestFuture(options: RequestOptions | RawOptions): Promise[ServerResponse] = {
      promiseWithError1[nodejs.Error, ServerResponse](https.request(options, _))
    }

    /**
      * Makes a request to a secure web server.
      */
    @inline
    def requestFuture(url: String): Promise[ServerResponse] = {
      promiseWithError1[nodejs.Error, ServerResponse](https.request(url, _))
    }

  }

}
