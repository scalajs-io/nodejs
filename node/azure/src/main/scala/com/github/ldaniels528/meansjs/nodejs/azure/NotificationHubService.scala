package com.github.ldaniels528.meansjs.nodejs.azure

import scala.scalajs.js

/**
  * Azure Notification Hub Service
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NotificationHubService extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * APNS notification
    */
  def apns: ApnsService = js.native

  /**
    * GCM notification
    */
  def gcm: GcmService = js.native

  /**
    * MPNS notification
    */
  def mpns: MpnsService = js.native

  /**
    * WNS notification
    */
  def wns: WnsService = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def send(`type`: js.Any, message: js.Any, callback: js.Function): Unit = js.native

}
