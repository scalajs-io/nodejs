package io.scalajs.nodejs.http2

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait Http2Priority extends js.Object {
  var exclusive: js.UndefOr[Boolean] = js.undefined
  var parent: js.UndefOr[Int]        = js.undefined
  var weight: js.UndefOr[Int]        = js.undefined
  var silent: js.UndefOr[Boolean]    = js.undefined
}
