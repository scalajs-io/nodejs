package io.scalajs.nodejs.dns

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait TtlOptions extends js.Object {
  var ttl: js.UndefOr[Boolean] = js.undefined
}
