package io.scalajs.nodejs.dgram

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
trait Dgram extends js.Object {
  def createSocket(options: SocketOptions, callback: js.Function = js.native): Socket = js.native
  def createSocket(`type`: String, callback: js.Function): Socket                     = js.native
  def createSocket(`type`: String): Socket                                            = js.native
}

class SocketOptions(
    var `type`: String,
    var reuseAddr: js.UndefOr[Boolean] = js.undefined,
    var ipv6Only: js.UndefOr[Boolean] = js.undefined,
    var recvBufferSize: js.UndefOr[Int] = js.undefined,
    var sendBufferSize: js.UndefOr[Int] = js.undefined,
    var lookup: js.UndefOr[js.Function1[String, Any]] = js.undefined
) extends js.Object

@js.native
@JSImport("dgram", JSImport.Namespace)
object Dgram extends Dgram
