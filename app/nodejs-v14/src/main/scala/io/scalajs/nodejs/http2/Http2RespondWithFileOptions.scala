package io.scalajs.nodejs.http2

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait Http2RespondWithFileOptions extends js.Object {
  var statCheck: js.UndefOr[js.Function]   = js.undefined
  var onError: js.UndefOr[js.Function]     = js.undefined
  var waitForTrailers: js.UndefOr[Boolean] = js.undefined
  var offset: js.UndefOr[Int]              = js.undefined
  var length: js.UndefOr[Int]              = js.undefined
}
