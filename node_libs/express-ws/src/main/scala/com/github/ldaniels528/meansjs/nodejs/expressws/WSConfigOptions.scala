package com.github.ldaniels528.meansjs.nodejs.expressws

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Configuration Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class WSConfigOptions extends js.Object {
  var leaveRouterUntouched: Boolean = _
}

/**
  * Configuration Options Companion
  * @author lawrence.daniels@gmail.com
  */
object WSConfigOptions {

  def apply(leaveRouterUntouched: Boolean) = {
    val options = new WSConfigOptions()
    options.leaveRouterUntouched = leaveRouterUntouched
    options
  }
}
