package io.scalajs.npm.aws.s3

import io.scalajs.npm.aws.ConfigBase

import scala.scalajs.js


/**
  * AWS.S3.ClientConfiguration
  */

class ClientConfiguration() extends ConfigBase {

  /**
    * the given AWS API Version (e.g. "2006-03-01")
    */
  var apiVersion: js.UndefOr[String] = js.undefined

}

/**
  * ClientConfiguration Singleton
  * @author lawrence.daniels@gmail.com
  */
object ClientConfiguration {

  def apply(apiVersion: js.UndefOr[String] = js.undefined,
            accessKeyId: js.UndefOr[String] = js.undefined,
            secretAccessKey: js.UndefOr[String] = js.undefined,
            region: js.UndefOr[String] = js.undefined): ClientConfiguration = {
    val config = new ClientConfiguration()
    config.apiVersion = apiVersion
    config.accessKeyId = accessKeyId
    config.secretAccessKey = secretAccessKey
    config.region = region
    config
  }

}