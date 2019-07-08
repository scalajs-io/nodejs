package io.scalajs.social.facebook

import scala.scalajs.js

/**
  * Facebook Application Configuration
  * @author lawrence.daniels@gmail.com
  */
class FacebookAppConfig(var appId: String, var status: Boolean, var xfbml: Boolean, var version: String) extends js.Object

/**
  * Facebook Application Configuration Companion Object
  * @author lawrence.daniels@gmail.com
  */
object FacebookAppConfig {

  def apply(appId: String, status: Boolean = true, xfbml: Boolean = true, version: String = "v2.5") = new FacebookAppConfig(
    appId = appId,
    status = status,
    xfbml = xfbml,
    version = version
  )

}
