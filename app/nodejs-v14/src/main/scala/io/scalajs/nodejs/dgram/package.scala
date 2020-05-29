package io.scalajs.nodejs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array
import scala.scalajs.js.|

package object dgram {
  type StringMessage = String | js.Array[String]
  type Message       = BufferMessage | StringMessage
  type BufferMessage = Uint8Array | js.Array[Uint8Array]

  implicit final class SocketExtensions[T <: Socket](private val instance: T) extends AnyVal {
    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline def onConnect(handler: () => Any): T = instance.on("connect", handler)

    @inline def onClose(handler: () => Any): T                            = instance.on("close", handler)
    @inline def onError(handler: (Error) => Any): T                       = instance.on("error", handler)
    @inline def onListening(handler: () => Any): T                        = instance.on("listening", handler)
    @inline def onMessage(handler: (Buffer, RemoteAddressInfo) => Any): T = instance.on("message", handler)
  }
}
