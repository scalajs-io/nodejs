package io.scalajs.nodejs.http2

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.url.URL

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.Uint8Array
import scala.scalajs.js.|

@js.native
trait Http2 extends js.Object {
  def createServer(
      options: Http2ServerOptions,
      onRequestHandler: js.Function2[Http2ServerRequest, Http2ServerResponse, Any] = js.native
  ): Http2Server = js.native

  def createSecureServer(
      options: Http2SecureServerOptions,
      onRequestHandler: js.Function2[Http2ServerRequest, Http2ServerResponse, Any] = js.native
  ): Http2SecureServer = js.native

  def connect(authority: String | URL, options: Http2ConnectOptions, listener: js.Function): ClientHttp2Session =
    js.native

  def constants: Http2Constants = js.native

  def getDefaultSettings(): Http2Settings                    = js.native
  def getPackedSettings(settings: Http2Settings): Buffer     = js.native
  def getUnpackedSettings(buffer: Uint8Array): Http2Settings = js.native
}

@js.native
@JSImport("http2", JSImport.Namespace)
object Http2 extends Http2
