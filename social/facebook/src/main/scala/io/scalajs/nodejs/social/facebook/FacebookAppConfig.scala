package io.scalajs.nodejs.social.facebook

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Facebook Application Configuration
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FacebookAppConfig extends js.Object {
  var appId: String   = _
  var status: Boolean = _
  var xfbml: Boolean  = _
  var version: String = _
}

/**
  * Facebook Application Configuration Companion Object
  * @author lawrence.daniels@gmail.com
  */
object FacebookAppConfig {

  def apply(appId: String, status: Boolean = true, xfbml: Boolean = true, version: String = "v2.5") = {
    val config = new FacebookAppConfig()
    config.appId = appId
    config.status = status
    config.xfbml = xfbml
    config.version = version
    config
  }
}
