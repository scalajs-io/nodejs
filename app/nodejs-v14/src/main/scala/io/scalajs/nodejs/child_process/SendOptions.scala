package io.scalajs.nodejs.child_process

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait SendOptions extends js.Object {
  var keepOpen: js.UndefOr[Boolean] = js.undefined
}
