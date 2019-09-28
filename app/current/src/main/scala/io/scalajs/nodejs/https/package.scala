package io.scalajs.nodejs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.http.{RequestOptions, ServerResponse}
import io.scalajs.util.PromiseHelper._
import io.scalajs.nodejs.url.URL

import scala.concurrent.Future
import scala.scalajs.js.|

/**
  * https package object
  */
package object https {

  /**
    * Https Extensions
    */
  final implicit class HttpExtensions(val https: Https) extends AnyVal {

    /**
      * Like http.get() but for HTTPS.
      */
    @inline
    def getFuture(options: RequestOptions): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.get(options, _))
    }

    /**
      * Like http.get() but for HTTPS.
      */
    @inline
    def getFuture(url: String): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.get(url, _))
    }

    /**
      * Makes a request to a secure web server.
      */
    @inline
    def requestFuture(options: RequestOptions): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.request(options, _))
    }

    /**
      * Makes a request to a secure web server.
      */
    @inline
    def requestFuture(url: String | URL): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.request(url, _))
    }

    @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
    @inline
    def requestFuture(url: String | URL, options: RequestOptions): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](https.request(url, options, _))
    }

  }

}
