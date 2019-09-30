package io.scalajs.nodejs.net

import scala.scalajs.js

class ListenerOptions(
    var host: js.UndefOr[String] = js.undefined,
    var port: js.UndefOr[Int] = js.undefined,
    var path: js.UndefOr[String] = js.undefined,
    var backlog: js.UndefOr[Int] = js.undefined,
    var exclusive: js.UndefOr[Boolean] = js.undefined,
    var readableAll: js.UndefOr[Boolean] = js.undefined,
    var writableAll: js.UndefOr[Boolean] = js.undefined,
    var ipv6Only: js.UndefOr[Boolean] = js.undefined
) extends js.Object
