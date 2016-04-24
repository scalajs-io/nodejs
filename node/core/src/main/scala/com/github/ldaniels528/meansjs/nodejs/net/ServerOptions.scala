package com.github.ldaniels528.meansjs.nodejs.net

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Server Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ServerOptions extends js.Object {
  var allowHalfOpen: js.UndefOr[Boolean] = js.native
  var pauseOnConnect: js.UndefOr[Boolean] = js.native

}

/**
  * Server Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ServerOptions {

  def apply(allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
            pauseOnConnect: js.UndefOr[Boolean] = js.undefined) = {
    val options = makeNew[ServerOptions]
    options.allowHalfOpen = allowHalfOpen
    options.pauseOnConnect = pauseOnConnect
    options
  }

}