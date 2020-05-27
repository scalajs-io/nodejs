package io.scalajs.nodejs.http2

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait Http2RequestOptions extends js.Object {
  var endStream: js.UndefOr[Boolean]       = js.undefined
  var exclusive: js.UndefOr[Boolean]       = js.undefined
  var parent: js.UndefOr[Int]              = js.undefined
  var weight: js.UndefOr[Int]              = js.undefined
  var waitForTrailers: js.UndefOr[Boolean] = js.undefined
}
