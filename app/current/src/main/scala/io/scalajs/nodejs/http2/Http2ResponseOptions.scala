package io.scalajs.nodejs.http2

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait Http2ResponseOptions extends js.Object {
  var endStream: js.UndefOr[Boolean]       = js.undefined
  var waitForTrailers: js.UndefOr[Boolean] = js.undefined
}
