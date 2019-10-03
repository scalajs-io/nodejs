package io.scalajs.nodejs.http2

import scala.scalajs.js

class Http2Priority(
    var exclusive: js.UndefOr[Boolean],
    var parent: js.UndefOr[Int],
    var weight: js.UndefOr[Int],
    var silent: js.UndefOr[Boolean]
) extends js.Object
