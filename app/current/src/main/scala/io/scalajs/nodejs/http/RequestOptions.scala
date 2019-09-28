package io.scalajs.nodejs.http

import scala.scalajs.js
import scala.scalajs.js.|

class RequestOptions(
    var agent: js.UndefOr[Agent | Boolean] = js.undefined,
    var auth: js.UndefOr[String] = js.undefined,
    var createConnection: js.UndefOr[js.Function] = js.undefined,
    var defaultPort: js.UndefOr[Int] = js.undefined,
    var family: js.UndefOr[Int] = js.undefined,
    var headers: js.UndefOr[js.Dictionary[js.Any]] = js.undefined,
    var host: js.UndefOr[String] = js.undefined,
    var hostname: js.UndefOr[String] = js.undefined,
    var localAddress: js.UndefOr[String] = js.undefined,
    var method: js.UndefOr[String] = js.undefined,
    var path: js.UndefOr[String] = js.undefined,
    var port: js.UndefOr[Int] = js.undefined,
    var protocol: js.UndefOr[String] = js.undefined,
    var setHost: js.UndefOr[Boolean] = js.undefined,
    var socketPath: js.UndefOr[String] = js.undefined,
    var timeout: js.UndefOr[Int] = js.undefined
) extends js.Object
