package io.scalajs.npm.aws

import io.scalajs.nodejs.Error

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * AWS Error
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("aws-sdk", "AWSError")
class AWSError extends Error {
  /**
    * A unique short code representing the error that was emitted.
    */
  val code: String = js.native

  /**
    * A longer human readable error message.
    */
  override val message: String = js.native

  /**
    * Whether the error message is retryable.
    */
  val retryable: Boolean = js.native

  /**
    * In the case of a request that reached the service, this value contains the response status code.
    */
  val statusCode: Int = js.native

  /**
    * The date time object when the error occurred.
    */
  val time: js.Date = js.native

  /**
    * Set when a networking error occurs to easily identify the endpoint of the request.
    */
  val hostname: String = js.native

  /**
    * Set when a networking error occurs to easily identify the region of the request.
    */
  val region: String = js.native

  /**
    * Amount of time (in seconds) that the request waited before being resent.
    */
  val retryDelay: Int = js.native

  /**
    * The unique request ID associated with the response.
    */
  val requestId: String = js.native

  /**
    * Second request ID associated with the response from S3.
    */
  val extendedRequstId: String = js.native

  /**
    * CloudFront request ID associated with the response.
    */
  val cfId: String = js.native
}
