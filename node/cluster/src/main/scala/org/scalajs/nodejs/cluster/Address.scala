package org.scalajs.nodejs.cluster

import scala.scalajs.js

/**
  * Address
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Address extends js.Object {

  def address: String = js.native

  def port: Integer = js.native

  /**
    * The addressType is one of:
    * 4 (TCPv4)
    * 6 (TCPv6)
    * -1 (unix domain socket)
    * "udp4" or "udp6" (UDP v4 or v6)
    */
  def addressType: js.Any = js.native

}
