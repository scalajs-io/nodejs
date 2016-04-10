package com.github.ldaniels528.meansjs.social.facebook

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Facebook Application Configuration
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait FacebookAppConfig extends js.Object {
  var appId: String
  var status: Boolean
  var xfbml: Boolean
  var version: String
}

/**
  * Facebook Application Configuration Companion Object
  * @author lawrence.daniels@gmail.com
  */
object FacebookAppConfig {

  def apply(appId: String,
            status: Boolean = true,
            xfbml: Boolean = true,
            version: String = "v2.5") = {
    val config = makeNew[FacebookAppConfig]
    config.appId = appId
    config.status = status
    config.xfbml = xfbml
    config.version = version
    config
  }
}
