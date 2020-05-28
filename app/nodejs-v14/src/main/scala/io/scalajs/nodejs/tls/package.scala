package io.scalajs.nodejs

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.typedarray.{DataView, TypedArray}
import scala.scalajs.js.|

package object tls {
  type SecureContext = js.Any

  type SecureData = String | js.Array[String] | Buffer | js.Array[Buffer]

  type SecureDataObjectForm = js.Object

  type ALPNProtocols =
    Buffer | TypedArray[_, _] | DataView | js.Array[String] | js.Array[TypedArray[_, _]] | js.Array[DataView]

  implicit final class ServerExtensions[T <: Server](private val instance: T) extends AnyVal {
    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline def onKeylog(handler: (Buffer, TLSSocket) => Any): T = instance.on("keylog", handler)

    @inline def onNewSession(handler: (Buffer, Buffer, js.Function0[Unit]) => Any): T =
      instance.on("newSession", handler)
    @inline def onOCSPRequest(handler: (Buffer, Buffer, js.Function2[Error, js.Any, Unit]) => Any): T =
      instance.on("OCSPRequest", handler)
    @inline def onResumeSession(handler: (Buffer, js.Function2[Error, Buffer, Unit]) => Any): T =
      instance.on("resumeSession", handler)
    @inline def onSecureConnection(handler: (tls.TLSSocket => Any)): T      = instance.on("secureConnection", handler)
    @inline def onTlsClientError(handler: (Error, tls.TLSSocket) => Any): T = instance.on("tlsClientError", handler)
  }

  implicit final class TLSSocketExtensions[T <: TLSSocket](private val instance: T) extends AnyVal {
    @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
    @inline def onKeylog(handler: (Buffer, TLSSocket) => Any): T = instance.on("keylog", handler)

    @inline def onOCSPResponse(handler: (Buffer) => Any): T = instance.on("OCSPResponse", handler)
    @inline def onSecureConnect(handler: () => Any): T      = instance.on("secureConnect", handler)
    @inline def onSession(handler: (Buffer) => Any): T      = instance.on("session", handler)
  }
}
