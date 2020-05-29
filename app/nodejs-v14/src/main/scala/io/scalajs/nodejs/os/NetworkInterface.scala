package io.scalajs.nodejs.os

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

/**
  * Represents a Network Interface
  */
@Factory
trait NetworkInterface extends js.Object {
  var address: String
  var netmask: String
  var family: String
  var mac: String
  var scopeid: js.UndefOr[Int] = js.undefined
  var internal: Boolean
}
