package io.scalajs.nodejs
package tls

import scala.scalajs.js

/**
  * TLS Certificate
  * @see https://nodejs.org/dist/v7.6.0/docs/api/tls.html#tls_tlssocket_getpeercertificate_detailed
  */
@js.native
trait TLSCertificate extends js.Object {

  def subject: js.Any = js.native

  def issuer: js.Any = js.native

  def issuerCertificate: js.Any = js.native

}
