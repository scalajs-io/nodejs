package io.scalajs.nodejs.http

import scala.scalajs.js

class ServerOptions(
    var IncomingMessage: js.UndefOr[js.Function] = js.undefined,
    var ServerResponse: js.UndefOr[js.Function] = js.undefined
) extends js.Object
