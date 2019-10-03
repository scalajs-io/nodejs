package io.scalajs.nodejs.http2

import scala.scalajs.js

class Http2ResponseOptions(
    var endStream: js.UndefOr[Boolean] = js.undefined,
    var waitForTrailers: js.UndefOr[Boolean] = js.undefined
) extends js.Object
