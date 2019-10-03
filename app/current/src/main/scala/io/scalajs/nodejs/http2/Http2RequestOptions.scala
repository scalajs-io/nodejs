package io.scalajs.nodejs.http2

import scala.scalajs.js

class Http2RequestOptions(
    var endStream: js.UndefOr[Boolean] = js.undefined,
    var exclusive: js.UndefOr[Boolean] = js.undefined,
    var parent: js.UndefOr[Int] = js.undefined,
    var weight: js.UndefOr[Int] = js.undefined,
    var waitForTrailers: js.UndefOr[Boolean] = js.undefined
) extends js.Object
