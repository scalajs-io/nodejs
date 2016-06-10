package com.github.ldaniels528.meansjs.nodejs.azure.common

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Token Cloud Credentials
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class TokenCloudCredentialOptions(var subscriptionId: String,
                                  var authorizationScheme: String,
                                  var token: String) extends js.Object

/**
  * Token Cloud Credentials Companion
  * @author lawrence.daniels@gmail.com
  */
object TokenCloudCredentialOptions {

  def apply(subscriptionId: String, authorizationScheme: String, token: String) = {
    new TokenCloudCredentialOptions(subscriptionId, authorizationScheme, token)
  }

}