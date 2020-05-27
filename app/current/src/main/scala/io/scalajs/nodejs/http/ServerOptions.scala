package io.scalajs.nodejs.http

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait ServerOptions extends js.Object {
  var IncomingMessage: js.UndefOr[js.Function] = js.undefined
  var ServerResponse: js.UndefOr[js.Function]  = js.undefined
}
