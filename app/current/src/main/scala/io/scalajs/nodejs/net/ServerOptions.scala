package io.scalajs.nodejs.net

import scala.scalajs.js

class ServerOptions(val allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
                    val pauseOnConnect: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
