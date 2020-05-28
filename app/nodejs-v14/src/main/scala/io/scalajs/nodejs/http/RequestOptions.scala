package io.scalajs.nodejs.http

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.tls
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.|

@Factory
trait RequestOptions extends js.Object {
  var agent: js.UndefOr[Agent | Boolean]                                   = js.undefined
  var auth: js.UndefOr[String]                                             = js.undefined
  var createConnection: js.UndefOr[js.Function]                            = js.undefined
  var defaultPort: js.UndefOr[Int]                                         = js.undefined
  var family: js.UndefOr[Int]                                              = js.undefined
  var headers: js.UndefOr[js.Dictionary[js.Any]]                           = js.undefined
  var host: js.UndefOr[String]                                             = js.undefined
  var hostname: js.UndefOr[String]                                         = js.undefined
  var localAddress: js.UndefOr[String]                                     = js.undefined
  var method: js.UndefOr[String]                                           = js.undefined
  var path: js.UndefOr[String]                                             = js.undefined
  var port: js.UndefOr[Int]                                                = js.undefined
  var protocol: js.UndefOr[String]                                         = js.undefined
  var setHost: js.UndefOr[Boolean]                                         = js.undefined
  var socketPath: js.UndefOr[String]                                       = js.undefined
  var timeout: js.UndefOr[Int]                                             = js.undefined
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
  var insecureHTTPParser: js.UndefOr[Int]                                  = js.undefined
  var highWaterMark: js.UndefOr[Int]                                       = js.undefined

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  var maxHeaderSize: js.UndefOr[Int] = js.undefined
}
