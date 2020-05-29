package io.scalajs.nodejs.tls

import io.scalajs.nodejs.buffer.Buffer
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.|

@Factory
trait SecureContextOptions extends js.Object {
  var ca: js.UndefOr[SecureData]                                   = js.undefined
  var cert: js.UndefOr[SecureData]                                 = js.undefined
  var sigalgs: js.UndefOr[String]                                  = js.undefined
  var ciphers: js.UndefOr[String]                                  = js.undefined
  var clientCertEngine: js.UndefOr[String]                         = js.undefined
  var crl: js.UndefOr[SecureData]                                  = js.undefined
  var dphram: js.UndefOr[String | Buffer]                          = js.undefined
  var ecdhCurve: js.UndefOr[String]                                = js.undefined
  var honorCipherOrder: js.UndefOr[Boolean]                        = js.undefined
  var key: js.UndefOr[SecureData]                                  = js.undefined
  var maxVersion: js.UndefOr[String]                               = js.undefined
  var minVersion: js.UndefOr[String]                               = js.undefined
  var passphrase: js.UndefOr[String]                               = js.undefined
  var pfx: js.UndefOr[SecureData | js.Array[SecureDataObjectForm]] = js.undefined
  var secureOptions: js.UndefOr[Int]                               = js.undefined
  var secureProtocol: js.UndefOr[String]                           = js.undefined
  var sessionIdContext: js.UndefOr[String]                         = js.undefined
}
