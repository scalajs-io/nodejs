package io.scalajs.nodejs.https

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.tls
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.|

@Factory
trait AgentOptions extends js.Object {
  var keepAlive: js.UndefOr[Boolean]                                       = js.undefined
  var keepAliveMsecs: js.UndefOr[Int]                                      = js.undefined
  var maxSockets: js.UndefOr[Double]                                       = js.undefined
  var maxFreeSockets: js.UndefOr[Int]                                      = js.undefined
  var timeout: js.UndefOr[Int]                                             = js.undefined
  var maxCachedSessions: js.UndefOr[Int]                                   = js.undefined
  var servername: js.UndefOr[String]                                       = js.undefined
  var ca: js.UndefOr[tls.SecureData]                                       = js.undefined
  var cert: js.UndefOr[tls.SecureData]                                     = js.undefined
  var ciphers: js.UndefOr[String]                                          = js.undefined
  var clientCertEngine: js.UndefOr[String]                                 = js.undefined
  var crl: js.UndefOr[tls.SecureData]                                      = js.undefined
  var dphram: js.UndefOr[String | Buffer]                                  = js.undefined
  var ecdhCurve: js.UndefOr[String]                                        = js.undefined
  var honorCihperOrder: js.UndefOr[Boolean]                                = js.undefined
  var key: js.UndefOr[tls.SecureData]                                      = js.undefined
  var passphrase: js.UndefOr[String]                                       = js.undefined
  var pfx: js.UndefOr[tls.SecureData | js.Array[tls.SecureDataObjectForm]] = js.undefined
  var rejectUnauthorized: js.UndefOr[Boolean]                              = js.undefined
  var secureOptions: js.UndefOr[Int]                                       = js.undefined
  var secureProtocol: js.UndefOr[String]                                   = js.undefined
  var sessionIdContext: js.UndefOr[String]                                 = js.undefined
}
