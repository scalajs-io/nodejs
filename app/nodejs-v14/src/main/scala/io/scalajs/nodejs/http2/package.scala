package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.url.URL

import scala.scalajs.js
import scala.scalajs.js.|

package object http2 {
  type Origin = String | URL | HasOrigin
  type Path   = String | Buffer | URL

  implicit final class Http2SessionExtensions[T <: Http2Session](private val instance: T) extends AnyVal {
    @inline def onClose(handler: () => Any): T                           = instance.on("close", handler)
    @inline def onConnect(handler: (Http2Session, net.Socket) => Any): T = instance.on("connect", handler)
    @inline def onError(handler: (Error) => Any): T                      = instance.on("error", handler)
    @inline def onFrameError(handler: (Int, Int, Int) => Any): T         = instance.on("frameError", handler)
    @inline def onGoaway(handler: (Int, Int, Buffer) => Any): T          = instance.on("goaway", handler)
    @inline def onLocalSettings(handler: Http2Settings => Any): T        = instance.on("localSettings", handler)
    @inline def onPing(handler: (Buffer) => Any): T                      = instance.on("ping", handler)
    @inline def onRemoteSettings(handler: (Http2Settings) => Any): T =
      instance.on("remoteSettings", handler)
    @inline def onStream(handler: (Http2Stream, Http2Headers, Int, js.Array[String]) => Any): T =
      instance.on("stream", handler)
    @inline def onTimeout(handler: () => Any): T = instance.on("timeout", handler)
  }

  implicit final class ClientHttp2SessionExtensions[T <: ClientHttp2Session](private val instance: T) extends AnyVal {
    @inline def onAltsvc(handler: (String, String, Int) => Any): T = instance.on("altsvc", handler)
    @inline def onOrigin(handler: (js.Array[String]) => Any): T    = instance.on("origin", handler)
  }

  implicit final class Http2StreamExtensions[T <: Http2Stream](private val instance: T) extends AnyVal {
    @inline def onAborted(handler: () => Any): T                   = instance.on("aborted", handler)
    @inline def onClose(handler: () => Any): T                     = instance.on("close", handler)
    @inline def onError(handler: (Error) => Any): T                = instance.on("error", handler)
    @inline def onFrameError(handler: (Int, Int, Int) => Any): T   = instance.on("frameError", handler)
    @inline def onTimeout(handler: () => Any): T                   = instance.on("timeout", handler)
    @inline def onTrailers(handler: (Http2Headers, Int) => Any): T = instance.on("trailers", handler)
    @inline def onWantTrailers(handler: () => Any): T              = instance.on("wantTrailers", handler)
  }

  implicit final class ClientHttp2StreamExtensions[T <: ClientHttp2Stream](private val instance: T) extends AnyVal {
    @inline def onContinue(handler: () => Any): T                  = instance.on("continue", handler)
    @inline def onHeaders(handler: (Http2Headers, Int) => Any): T  = instance.on("headers", handler)
    @inline def onPush(handler: (Http2Headers, Int) => Any): T     = instance.on("push", handler)
    @inline def onResponse(handler: (Http2Headers, Int) => Any): T = instance.on("response", handler)
  }

  implicit final class Http2SeverExtensions[T <: Http2Server](private val instance: T) extends AnyVal {
    @inline def onCheckContinue(handler: (Http2ServerRequest, Http2ServerResponse) => Any): T =
      instance.on("checkContinue", handler)
    @inline def onRequest(handler: (Http2ServerRequest, Http2ServerResponse) => Any): T =
      instance.on("request", handler)
    @inline def onSession(handler: () => Any): T      = instance.on("session", handler)
    @inline def onSessionError(handler: () => Any): T = instance.on("sessionError", handler)
    @inline def onStream(handler: (Http2Stream, Http2Headers, Int) => Any): T =
      instance.on("stream", handler)
    @inline def onTimeout(handler: () => Any): T = instance.on("timeout", handler)
  }

  implicit final class Http2SecureSeverExtensions[T <: Http2SecureServer](private val instance: T) extends AnyVal {
    @inline def onCheckContinue(handler: (Http2ServerRequest, Http2ServerResponse) => Any): T =
      instance.on("checkContinue", handler)
    @inline def onRequest(handler: (Http2ServerRequest, Http2ServerResponse) => Any): T =
      instance.on("request", handler)
    @inline def onSession(handler: () => Any): T      = instance.on("session", handler)
    @inline def onSessionError(handler: () => Any): T = instance.on("sessionError", handler)
    @inline def onStream(handler: (Http2Stream, Http2Headers, Int) => Any): T =
      instance.on("stream", handler)
    @inline def onTimeout(handler: () => Any): T         = instance.on("timeout", handler)
    @inline def onUnknownProtocol(handler: () => Any): T = instance.on("unknownProtocol", handler)
  }

  implicit final class Http2ServerRequestExtensions[T <: Http2ServerRequest](private val instance: T) extends AnyVal {
    @inline def onAborted(handler: (stream.IReadable) => Any): T = instance.on("aborted", handler)
    @inline def onClose(handler: () => Any): T                   = instance.on("close", handler)
  }

  implicit final class Http2ServerResponseExtensions[T <: Http2ServerResponse](private val instance: T) extends AnyVal {
    @inline def onClose(handler: () => Any): T                   = instance.on("close", handler)
    @inline def onAborted(handler: (stream.IReadable) => Any): T = instance.on("aborted", handler)
  }
}
