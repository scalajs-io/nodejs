package io.scalajs.nodejs.http

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait GetNameOptions extends js.Object {
  var host: String
  var port: js.UndefOr[Int]            = js.undefined
  var localAddress: js.UndefOr[String] = js.undefined
  var family: js.UndefOr[Int]          = js.undefined
}
