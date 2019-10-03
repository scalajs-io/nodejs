package io.scalajs.nodejs.http2

import scala.scalajs.js

class Http2RespondWithFDOptions(
    var statCheck: js.UndefOr[js.Function] = js.undefined,
    var waitForTrailers: js.UndefOr[Boolean] = js.undefined,
    var offset: js.UndefOr[Int] = js.undefined,
    var length: js.UndefOr[Int] = js.undefined
) extends js.Object
