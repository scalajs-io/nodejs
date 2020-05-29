package io.scalajs.nodejs.http

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait AgentOptions extends js.Object {
  var keepAlive: js.UndefOr[Boolean]  = js.undefined
  var keepAliveMsecs: js.UndefOr[Int] = js.undefined
  var maxSockets: js.UndefOr[Double]  = js.undefined
  var maxFreeSockets: js.UndefOr[Int] = js.undefined
  var timeout: js.UndefOr[Int]        = js.undefined
}
