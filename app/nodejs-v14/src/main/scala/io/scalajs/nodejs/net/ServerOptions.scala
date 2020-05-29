package io.scalajs.nodejs.net

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait ServerOptions extends js.Object {
  var allowHalfOpen: js.UndefOr[Boolean]  = js.undefined
  var pauseOnConnect: js.UndefOr[Boolean] = js.undefined
}
