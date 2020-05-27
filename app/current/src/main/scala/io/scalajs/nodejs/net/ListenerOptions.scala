package io.scalajs.nodejs.net

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait ListenerOptions extends js.Object {
  var host: js.UndefOr[String]         = js.undefined
  var port: js.UndefOr[Int]            = js.undefined
  var path: js.UndefOr[String]         = js.undefined
  var backlog: js.UndefOr[Int]         = js.undefined
  var exclusive: js.UndefOr[Boolean]   = js.undefined
  var readableAll: js.UndefOr[Boolean] = js.undefined
  var writableAll: js.UndefOr[Boolean] = js.undefined
  var ipv6Only: js.UndefOr[Boolean]    = js.undefined
}
