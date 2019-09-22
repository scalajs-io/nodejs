package io.scalajs.nodejs.cluster

import scala.scalajs.js
import scala.scalajs.js.|

@js.native
trait Address extends js.Object {

  def address: String = js.native

  def port: Int = js.native

  /**
    * The addressType is one of:
    * 4 (TCPv4)
    * 6 (TCPv6)
    * -1 (unix domain socket)
    * "udp4" or "udp6" (UDP v4 or v6)
    */
  def addressType: String | Int = js.native

}
