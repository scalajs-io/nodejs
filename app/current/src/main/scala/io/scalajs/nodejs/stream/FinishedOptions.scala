package io.scalajs.nodejs.stream

import scala.scalajs.js

class FinishedOptions(
    var error: js.UndefOr[Boolean] = js.undefined,
    var readable: js.UndefOr[Boolean] = js.undefined,
    var writable: js.UndefOr[Boolean] = js.undefined
) extends js.Object
