package io.scalajs.nodejs.http2

import scala.scalajs.js

class Http2PushStreamOptions(
    var exclusive: js.UndefOr[Boolean],
    var parent: js.UndefOr[Int]
) extends js.Object
