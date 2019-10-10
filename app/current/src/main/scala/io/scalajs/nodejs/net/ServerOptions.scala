package io.scalajs.nodejs.net

import scala.scalajs.js

class ServerOptions(var allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
                    var pauseOnConnect: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
