package org.scalajs.nodejs.os

import scala.scalajs.js

/**
  * Represents a Network Interface
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait NetworkInterface extends js.Object {
  var address: String = js.native
  var netmask: String = js.native
  var family: String = js.native
  var mac: String = js.native
  var internal: Boolean = js.native
}
