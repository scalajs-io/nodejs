package org.scalajs.nodejs.azure.asm

import org.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Certificate Cloud Credentials Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class CertificateCloudCredentialsOptions(var subscriptionId: String, var pem: js.Any) extends js.Object

/**
  * Cloud Credentials Options
  * @author lawrence.daniels@gmail.com
  */
object CertificateCloudCredentialsOptions {

  def apply(subscriptionId: String, pem: Buffer) = new CertificateCloudCredentialsOptions(subscriptionId, pem)

  def apply(subscriptionId: String, pem: String) = new CertificateCloudCredentialsOptions(subscriptionId, pem)

}