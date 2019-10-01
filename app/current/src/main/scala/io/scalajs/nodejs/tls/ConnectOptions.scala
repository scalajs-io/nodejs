package io.scalajs.nodejs.tls

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.{net, stream}

import scala.scalajs.js

class ConnectOptions(
    var host: js.UndefOr[String] = js.undefined,
    var port: js.UndefOr[Int] = js.undefined,
    var path: js.UndefOr[String] = js.undefined,
    var socket: js.UndefOr[stream.IDuplex] = js.undefined,
    var allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
    var servername: js.UndefOr[String] = js.undefined,
    var checkServerIdentity: js.UndefOr[js.Function2[String, TLSCertificate, Any]] = js.undefined,
    var minDHSize: js.UndefOr[Int] = js.undefined,
    // TLSSocketOptions
    var enableTrace: js.UndefOr[Boolean] = js.undefined,
    var isServer: js.UndefOr[Boolean] = js.undefined,
    var server: js.UndefOr[net.Server] = js.undefined,
    var requestCert: js.UndefOr[Boolean] = js.undefined,
    var rejectUnauthorized: js.UndefOr[Boolean] = js.undefined,
    var NPNProtocols: js.UndefOr[Boolean] = js.undefined,
    var ALPNProtocols: js.UndefOr[ALPNProtocols] = js.undefined,
    var SNICallback: js.UndefOr[js.Function2[String, js.Function, Any]] = js.undefined,
    var session: js.UndefOr[Buffer] = js.undefined,
    var requestOCSP: js.UndefOr[Boolean] = js.undefined,
    var secureContext: js.UndefOr[SecureContext] = js.undefined
) extends js.Object
