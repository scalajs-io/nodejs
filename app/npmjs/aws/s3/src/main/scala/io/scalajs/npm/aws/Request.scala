package io.scalajs.npm.aws

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.{Error, stream}

import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array
import scala.scalajs.js.|

/**
  * AWS.Request - All requests made through the SDK are asynchronous and use a callback interface.
  * Each service method that kicks off a request returns an AWS.Request object that you can use to
  * register callbacks.
  * @see http://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/Request.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Request[T, E] extends IEventEmitter {

  /**
    * Aborts a request, emitting the error and complete events.
    * This feature is not supported in the browser environment of the SDK.
    */
  def abort(): Unit = js.native

  /**
    * Converts the request object into a readable stream that can be read from or piped into a writable stream.
    * The data read from a readable stream contains only the raw HTTP body contents.
    * This feature is not supported in the browser environment of the SDK.
    */
  def createReadStream(): stream.Readable = js.native

  /**
    * Iterates over each page of results given a pageable request, calling the provided callback with each page of data.
    * After all pages have been retrieved, the callback is called with null data.
    * @param callback - The callback that handles the response.
    */
  def eachPage(callback: (E, T) => Boolean): Unit = js.native

  /**
    * Iterates over each page of results given a pageable request, calling the provided callback with each page of data.
    * After all pages have been retrieved, the callback is called with null data.
    * @param callback - The callback that handles the response.
    */
  def eachPage(callback: (E, T, () => Any) => Boolean): Unit = js.native

  /**
    * Returns whether the operation can return multiple pages of response data.
    */
  def isPageable(): Boolean = js.native

  /**
    * Sends the request object.
    * If a callback is supplied, it is called when a response is returned from the service.
    */
  def send(callback: (E, T) => Any = null): Unit = js.native

  /**
    * Returns a 'thenable' promise.
    */
  def promise(): js.Promise[T] = js.native

  /**
    * The time that the request started.
    */
  def startTime: js.Date = js.native

  /**
    * The raw HTTP request object containing request headers and body information sent by the service.
    */
  def httpRequest: HttpRequest = js.native

}

/**
  * AWS.Request Companion
  * @author lawrence.daniels@gmail.com
  */
object Request {

  implicit class RequestEnrichment[T, E](val request: Request[T, E]) extends AnyVal {

    /**
      * Adds a listener that is triggered when a request is being validated.
      * @param listener - Callback to run when the request is being validated.
      */
    @inline
    def onValidate(listener: Request[T, E] => Any): request.type = request.on("validate", listener)

    /**
      * Adds a listener that is triggered when the request payload is being built.
      * @param listener - Callback to run when the request's payload is being built.
      */
    @inline
    def onBuild(listener: Request[T, E] => Any): request.type = request.on("build", listener)

    /**
      * Adds a listener that is triggered when a request is being signed.
      * @param listener - Callback to run when the request is being signed.
      */
    @inline
    def onSign(listener: Request[T, E] => Any): request.type = request.on("sign", listener)

    /**
      * Adds a listener that is triggered when a request is ready to be sent.
      * @param listener - Callback to run when the request is ready to be sent.
      */
    @inline
    def onSend(listener: Response[T, E] => Any): request.type = request.on("send", listener)

    /**
      * Adds a listener that is triggered when a request failed and might need to be retried or redirected.
      * @param listener - Callback to run when the request failed and may be retried.
      */
    @inline
    def onRetry(listener: Response[T, E] => Any): request.type = request.on("retry", listener)

    /**
      * Adds a listener that is triggered on all non-2xx requests so that listeners can extract error details
      * from the response body.
      * @param listener - Callback to run when the request failed.
      */
    @inline
    def onExtractError(listener: Response[T, E] => Any): request.type = request.on("extractError", listener)

    /**
      * Adds a listener that is triggered in successful requests to allow listeners to de-serialize
      * the response body into response.data.
      * @param listener - Callback to run when the request succeeded.
      */
    @inline
    def onExtractData(listener: Response[T, E] => Any): request.type = request.on("extractData", listener)

    /**
      * Adds a listener that is triggered when the request completed successfully.
      * @param listener - Callback to run when the request completed successfully.
      */
    @inline
    def onSuccess(listener: Response[T, E] => Any): request.type = request.on("success", listener)

    /**
      * Adds a listener that is triggered when an error occurs at any point during the request.
      * @param listener - Callback to run when the request errors at any point.
      */
    @inline
    def onError(listener: (AWSError, Response[T, E]) => Any): request.type = request.on("error", listener)

    /**
      * Adds a listener that is triggered whenever a request cycle completes.
      * @param listener - Callback to run when the request cycle completes.
      */
    @inline
    def onComplete(listener: Response[T, E] => Any): request.type = request.on("complete", listener)

    /**
      * Adds a listener that is triggered when headers are sent by the remote server.
      * @param listener - Callback to run when the headers are sent by the remote server.
      */
    @inline
    def onHttpHeaders(listener: (StatusCode, HttpHeaders, Response[T, E], StatusMessage) => Any): request.type = {
      request.on("httpHeaders", listener)
    }

    /**
      * Adds a listener that is triggered when data is sent by the remote server.
      * @param listener - Callback to run when data is sent by the remote server.
      */
    @inline
    def onHttpData(listener: (Buffer | Uint8Array, Response[T, E]) => Any): request.type = {
      request.on("httpData", listener)
    }

    /**
      * Adds a listener that is triggered when the HTTP request has uploaded more data.
      * @param listener - Callback to run when the HTTP request has uploaded more data.
      */
    @inline
    def onHttpUploadProgress(listener: (Progress, Response[T, E]) => Any): request.type = {
      request.on("httpUploadProgress", listener)
    }

    /**
      * Adds a listener that is triggered when the HTTP request has downloaded more data.
      * @param listener - Callback to run when the HTTP request has downloaded more data.
      */
    @inline
    def onHttpDownloadProgress(listener: (Progress, Response[T, E]) => Any): request.type = {
      request.on("httpDownloadProgress", listener)
    }

    /**
      * Adds a listener that is triggered when the HTTP request failed.
      * @param listener - Callback to run when the HTTP request failed.
      */
    @inline
    def onHttpError(listener: (Error, Response[T, E]) => Any): request.type = request.on("httpError", listener)

    /**
      * Adds a listener that is triggered when the server is finished sending data.
      * @param listener - Callback to run when the server is finished sending data.
      */
    @inline
    def onHttpDone(listener: Response[T, E] => Any): request.type = request.on("httpDone", listener)

  }

}