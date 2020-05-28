package io.scalajs.nodejs.http2

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.http.OnreadObject
import io.scalajs.nodejs.{net, stream}
import io.scalajs.nodejs.tls.{ALPNProtocols, SecureContext, TLSCertificate}
import io.scalajs.nodejs.url.URL
import _root_.net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait Http2ConnectOptions extends js.Object {
  var maxDeflateDynamicTableSize: js.UndefOr[Int]            = js.undefined
  var maxSessionMemory: js.UndefOr[Int]                      = js.undefined
  var maxHeaderListPairs: js.UndefOr[Int]                    = js.undefined
  var maxOutstandingPings: js.UndefOr[Int]                   = js.undefined
  var maxSendHeaderBlockLength: js.UndefOr[Int]              = js.undefined
  var paddingStrategy: js.UndefOr[Int]                       = js.undefined
  var peerMaxConcurrentStreams: js.UndefOr[Int]              = js.undefined
  var selectPadding: js.UndefOr[js.Function2[Int, Int, Int]] = js.undefined
  var settings: js.UndefOr[Http2Settings]                    = js.undefined
  // specific to connect
  var maxReservedRemoteStreams: js.UndefOr[Int]                                            = js.undefined
  var createConnection: js.UndefOr[js.Function2[URL, Http2ConnectOptions, stream.IDuplex]] = js.undefined
  // From net.connect
  // for socket.connect(option)
  var port: js.UndefOr[Int]                         = js.undefined
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
  // From tls.connect
  var socket: js.UndefOr[stream.IDuplex]                                         = js.undefined
  var servername: js.UndefOr[String]                                             = js.undefined
  var checkServerIdentity: js.UndefOr[js.Function2[String, TLSCertificate, Any]] = js.undefined
  var minDHSize: js.UndefOr[Int]                                                 = js.undefined
  // TLSSocketOptions
  var enableTrace: js.UndefOr[Boolean]                                = js.undefined
  var isServer: js.UndefOr[Boolean]                                   = js.undefined
  var server: js.UndefOr[net.Server]                                  = js.undefined
  var requestCert: js.UndefOr[Boolean]                                = js.undefined
  var rejectUnauthorized: js.UndefOr[Boolean]                         = js.undefined
  var NPNProtocols: js.UndefOr[Boolean]                               = js.undefined
  var ALPNProtocols: js.UndefOr[ALPNProtocols]                        = js.undefined
  var SNICallback: js.UndefOr[js.Function2[String, js.Function, Any]] = js.undefined
  var session: js.UndefOr[Buffer]                                     = js.undefined
  var requestOCSP: js.UndefOr[Boolean]                                = js.undefined
  var secureContext: js.UndefOr[SecureContext]                        = js.undefined
}
