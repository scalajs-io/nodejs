package io.scalajs.nodejs.https

import scala.scalajs.js

class AgentOptions(
    var keepAlive: js.UndefOr[Boolean] = js.undefined,
    var keepAliveMsecs: js.UndefOr[Int] = js.undefined,
    var maxSockets: js.UndefOr[Double] = js.undefined,
    var maxFreeSockets: js.UndefOr[Int] = js.undefined,
    var timeout: js.UndefOr[Int] = js.undefined,
    var maxCachedSessions: js.UndefOr[Int],
    var Int: js.UndefOr[String]
) extends js.Object
