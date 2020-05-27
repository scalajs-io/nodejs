package io.scalajs.nodejs.dns

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait DnsOptions extends js.Object {
  var family: js.UndefOr[Int]       = js.undefined
  var hints: js.UndefOr[Int]        = js.undefined
  var all: js.UndefOr[Boolean]      = js.undefined
  var verbatim: js.UndefOr[Boolean] = js.undefined
}
