package io.scalajs.nodejs.stream

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait FinishedOptions extends js.Object {
  var error: js.UndefOr[Boolean]    = js.undefined
  var readable: js.UndefOr[Boolean] = js.undefined
  var writable: js.UndefOr[Boolean] = js.undefined
}
