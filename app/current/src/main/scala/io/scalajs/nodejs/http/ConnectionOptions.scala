package io.scalajs.nodejs.http

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array
import scala.scalajs.js.|

@Factory
trait ConnectionOptions extends js.Object {
  // for socket.connect(option)
  var port: Int
  var host: js.UndefOr[String]                      = js.undefined
  var localAddress: js.UndefOr[String]              = js.undefined
  var localPort: js.UndefOr[Int]                    = js.undefined
  var family: js.UndefOr[Int]                       = js.undefined
  var hints: js.UndefOr[Int]                        = js.undefined
  var lookup: js.UndefOr[js.Function1[String, Any]] = js.undefined
  var onread: js.UndefOr[OnreadObject]              = js.undefined

  // for IPC connections
  var path: js.UndefOr[String] = js.undefined

  // for new Socket(option)
  var fd: js.UndefOr[Int]                = js.undefined
  var allowHalfOpen: js.UndefOr[Boolean] = js.undefined
  var readable: js.UndefOr[Boolean]      = js.undefined
  var writable: js.UndefOr[Int]          = js.undefined
}
@Factory
trait OnreadObject extends js.Object {
  var buffer: Uint8Array | js.Function0[Uint8Array]
  var callback: js.Function2[Int, Uint8Array, Boolean]
}
