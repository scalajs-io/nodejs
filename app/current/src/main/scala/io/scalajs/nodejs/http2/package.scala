package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.url.URL

import scala.scalajs.js
import scala.scalajs.js.|

package object http2 {
  type Origin = String | URL | HasOrigin
  type Path   = String | Buffer | URL

  implicit final class Http2SessionExtension(val instance: Http2Session) extends AnyVal {
    @inline def onClose(handler: () => Any): instance.type                           = instance.on("close", handler)
    @inline def onConnect(handler: (Http2Session, net.Socket) => Any): instance.type = instance.on("connect", handler)
    @inline def onError(handler: (Error) => Any): instance.type                      = instance.on("error", handler)
    @inline def onFrameError(handler: (Int, Int, Int) => Any): instance.type         = instance.on("frameError", handler)
    @inline def onGoaway(handler: (Int, Int, Buffer) => Any): instance.type          = instance.on("goaway", handler)
    @inline def onLocalSettings(handler: Http2Settings => Any): instance.type        = instance.on("localSettings", handler)
    @inline def onPing(handler: (Buffer) => Any): instance.type                      = instance.on("ping", handler)
    @inline def onRemoteSettings(handler: (Http2Settings) => Any): instance.type =
      instance.on("remoteSettings", handler)
    @inline def onStream(handler: (Http2Stream, Http2Headers, Int, js.Array[String]) => Any): instance.type =
      instance.on("stream", handler)
    @inline def onTimeout(handler: () => Any): instance.type = instance.on("timeout", handler)
  }

  implicit final class ClientHttp2SessionExtension(val instance: ClientHttp2Session) extends AnyVal {
    @inline def onAltsvc(handler: (String, String, Int) => Any): instance.type = instance.on("altsvc", handler)
    @inline def onOrigin(handler: (js.Array[String]) => Any): instance.type    = instance.on("origin", handler)
  }

  implicit final class Http2StreamExtension(val instance: Http2Stream) extends AnyVal {
    @inline def onAborted(handler: () => Any): instance.type                   = instance.on("aborted", handler)
    @inline def onClose(handler: () => Any): instance.type                     = instance.on("close", handler)
    @inline def onError(handler: (Error) => Any): instance.type                = instance.on("error", handler)
    @inline def onFrameError(handler: (Int, Int, Int) => Any): instance.type   = instance.on("frameError", handler)
    @inline def onTimeout(handler: () => Any): instance.type                   = instance.on("timeout", handler)
    @inline def onTrailers(handler: (Http2Headers, Int) => Any): instance.type = instance.on("trailers", handler)
    @inline def onWantTrailers(handler: () => Any): instance.type              = instance.on("wantTrailers", handler)
  }

  implicit final class ClientHttp2StreamExtension(val instance: ClientHttp2Stream) extends AnyVal {
    @inline def onContinue(handler: () => Any): instance.type                  = instance.on("continue", handler)
    @inline def onHeaders(handler: (Http2Headers, Int) => Any): instance.type  = instance.on("headers", handler)
    @inline def onPush(handler: (Http2Headers, Int) => Any): instance.type     = instance.on("push", handler)
    @inline def onResponse(handler: (Http2Headers, Int) => Any): instance.type = instance.on("response", handler)
  }

  implicit final class Http2SeverExtension(val instance: Http2Server) extends AnyVal {
    @inline def onCheckContinue(handler: (Http2ServerRequest, Http2ServerResponse) => Any): instance.type =
      instance.on("checkContinue", handler)
    @inline def onRequest(handler: (Http2ServerRequest, Http2ServerResponse) => Any): instance.type =
      instance.on("request", handler)
    @inline def onSession(handler: () => Any): instance.type      = instance.on("session", handler)
    @inline def onSessionError(handler: () => Any): instance.type = instance.on("sessionError", handler)
    @inline def onStream(handler: (Http2Stream, Http2Headers, Int) => Any): instance.type =
      instance.on("stream", handler)
    @inline def onTimeout(handler: () => Any): instance.type = instance.on("timeout", handler)
  }

  implicit final class Http2SecureSeverExtension(val instance: Http2SecureServer) extends AnyVal {
    @inline def onCheckContinue(handler: (Http2ServerRequest, Http2ServerResponse) => Any): instance.type =
      instance.on("checkContinue", handler)
    @inline def onRequest(handler: (Http2ServerRequest, Http2ServerResponse) => Any): instance.type =
      instance.on("request", handler)
    @inline def onSession(handler: () => Any): instance.type      = instance.on("session", handler)
    @inline def onSessionError(handler: () => Any): instance.type = instance.on("sessionError", handler)
    @inline def onStream(handler: (Http2Stream, Http2Headers, Int) => Any): instance.type =
      instance.on("stream", handler)
    @inline def onTimeout(handler: () => Any): instance.type         = instance.on("timeout", handler)
    @inline def onUnknownProtocol(handler: () => Any): instance.type = instance.on("unknownProtocol", handler)
  }

  implicit final class Http2ServerRequestExtension(val instance: Http2ServerRequest) extends AnyVal {
    @inline def onAborted(handler: (stream.IReadable) => Any): instance.type = instance.on("aborted", handler)
    @inline def onClose(handler: () => Any): instance.type                   = instance.on("close", handler)
  }

  implicit final class Http2ServerResponseExtension(val instance: Http2ServerResponse) extends AnyVal {
    @inline def onClose(handler: () => Any): instance.type                   = instance.on("close", handler)
    @inline def onAborted(handler: (stream.IReadable) => Any): instance.type = instance.on("aborted", handler)
  }
}
