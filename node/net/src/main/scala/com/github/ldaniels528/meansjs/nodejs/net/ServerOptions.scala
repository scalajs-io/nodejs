package com.github.ldaniels528.meansjs.nodejs.net

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Server Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ServerOptions extends js.Object {
  var allowHalfOpen: js.UndefOr[Boolean] = _
  var pauseOnConnect: js.UndefOr[Boolean] = _

}

/**
  * Server Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ServerOptions {

  def apply(allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
            pauseOnConnect: js.UndefOr[Boolean] = js.undefined) = {
    val options = new ServerOptions()
    options.allowHalfOpen = allowHalfOpen
    options.pauseOnConnect = pauseOnConnect
    options
  }

}