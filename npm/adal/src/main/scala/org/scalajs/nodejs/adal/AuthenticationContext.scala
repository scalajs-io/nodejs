package org.scalajs.nodejs.adal

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * Authentication Context
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AuthenticationContext extends js.Object {

  def acquireTokenWithAuthorizationCode(authorizationCode: String, redirectUri: String, resourceId: String, clientId: String, clientSecret: String, callback: js.Function): Unit = js.native

  def acquireTokenWithClientCredentials(resourceId: String, clientId: String, clientSecret: String, callback: js.Function): Unit = js.native

  def acquireTokenWithUsernamePassword(resourceId: String, userName: String, password: String, clientId: String, callback: js.Function): Unit = js.native

}

/**
  * Authentication Context Companion
  * @author lawrence.daniels@gmail.com
  */
object AuthenticationContext {

  /**
    * Authentication Context Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class AuthenticationContextExtensions(val context: AuthenticationContext) extends AnyVal {

    @inline
    def acquireTokenWithAuthorizationCodeFuture(authorizationCode: String, redirectUri: String, resourceId: String, clientId: String, clientSecret: String) = {
      futureCallbackE1[errors.Error, AuthenticationResponse](context.acquireTokenWithAuthorizationCode(authorizationCode, redirectUri, resourceId, clientId, clientSecret, _))
    }

    @inline
    def acquireTokenWithClientCredentialsFuture(resourceId: String, clientId: String, clientSecret: String) = {
      futureCallbackE1[errors.Error, AuthenticationResponse](context.acquireTokenWithClientCredentials(resourceId, clientId, clientSecret, _))
    }

    @inline
    def acquireTokenWithUsernamePasswordFuture(resourceId: String, userName: String, password: String, clientId: String) = {
      futureCallbackE1[errors.Error, AuthenticationResponse](context.acquireTokenWithUsernamePassword(resourceId, userName, password, clientId, _))
    }

  }

}