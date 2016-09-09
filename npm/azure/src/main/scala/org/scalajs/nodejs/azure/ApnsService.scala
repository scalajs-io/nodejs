package org.scalajs.nodejs.azure

import org.scalajs.nodejs.errors
import org.scalajs.nodejs.util.ScalaJsHelper._
import org.scalajs.nodejs.util.ScalaJsHelper

import scala.scalajs.js

/**
  * The ApnsService class is used to send notifications using the Apple Push Notification Service (APNS).
  * This service is used to communicate with iOS devi
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ApnsService extends js.Object {

  /**
    * Creates a native registration.
    * @param token    The device token.
    * @param tags     The tags (comma-separated list, no spaces).
    * @param options  The request options
    * @param callback error will contain information if an error occurs; otherwise, response will contain information
    *                 related to this operation.
    */
  def createNativeRegistration(token: String, tags: String, options: js.Any, callback: js.Function): Unit = js.native

  /**
    * Creates a native registration.
    * @param token    The device token.
    * @param tags     The tags (comma-separated list, no spaces).
    * @param callback error will contain information if an error occurs; otherwise, response will contain information
    *                 related to this operation.
    */
  def createNativeRegistration(token: String, tags: String, callback: js.Function): Unit = js.native

  /**
    * Creates a native registration.
    * @param token    The device token.
    * @param tags     The tags (comma-separated list, no spaces).
    * @param options  The request options
    * @param callback error will contain information if an error occurs; otherwise, response will contain information
    *                 related to this operation.
    */
  def createNativeRegistration(token: String, tags: js.Array[String], options: js.Any, callback: js.Function): Unit = js.native

  /**
    * Creates a native registration.
    * @param token    The device token.
    * @param tags     The tags (comma-separated list, no spaces).
    * @param callback error will contain information if an error occurs; otherwise, response will contain information
    *                 related to this operation.
    */
  def createNativeRegistration(token: String, tags: js.Array[String], callback: js.Function): Unit = js.native

  /**
    * Creates or updates a native registration.
    * @param registrationId The registration identifier.
    * @param token          The device token.
    * @param tags           The tags (comma-separated list, no spaces).
    * @param options        The request options
    * @param callback       error will contain information if an error occurs; otherwise, response will contain
    *                       information related to this operation.
    */
  def createOrUpdateNativeRegistration(registrationId: String, token: String, tags: String, options: js.Any, callback: js.Function): Unit = js.native

}

/**
  * APNS Service
  * @author lawrence.daniels@gmail.com
  */
object ApnsService {

  /**
    * APNS Service Extensions
    * @param apns the given [[ApnsService APNS service]]
    */
  implicit class ApnsServiceExtensions(val apns: ApnsService) extends AnyVal {

    /**
      * Creates a native registration.
      * @param token   The device token.
      * @param tags    The tags (comma-separated list, no spaces).
      * @param options The request options
      */
    @inline
    def createNativeRegistrationFuture(token: String, tags: String, options: js.Any = null) = {
      futureCallbackE1[errors.Error, js.Any](apns.createNativeRegistration(token, tags, options, _))
    }

    /**
      * Creates a native registration.
      * @param token   The device token.
      * @param tags    The tags (comma-separated list, no spaces).
      * @param options The request options
      */
    @inline
    def createNativeRegistrationsFuture(token: String, tags: js.Array[String], options: js.Any = null) = {
      futureCallbackE1[errors.Error, js.Any](apns.createNativeRegistration(token, tags, options, _))
    }

  }

}