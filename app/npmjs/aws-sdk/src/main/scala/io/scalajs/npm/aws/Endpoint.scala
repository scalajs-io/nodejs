package io.scalajs.npm.aws

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * AWS.Endpoint
  * @see http://docs.aws.amazon.com/AWSJavaScriptSDK/latest/AWS/Endpoint.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("aws-sdk", "Endpoint")
class Endpoint(endpoint: String) extends js.Object {

  /**
    * The host portion of the endpoint including the port, e.g., example.com:80.
    */
  var host: String = js.native

  /**
    * The host portion of the endpoint, e.g., example.com.
    */
  var hostname: String = js.native

  /**
    * The full URL of the endpoint.
    */
  var href: String = js.native

  /**
    * The port of the endpoint.
    */
  var port: Int = js.native

  /**
    * The protocol (http or https) of the endpoint URL.
    */
  var protocol: String = js.native

}
