package io.scalajs.nodejs
package tls

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * TLS Certificate
  * @see https://nodejs.org/dist/v7.6.0/docs/api/tls.html#tls_tlssocket_getpeercertificate_detailed
  */
@js.native
trait TLSCertificate extends js.Object {
  def raw: Buffer = js.native

  def subject: Subject                  = js.native
  def issuer: Subject                   = js.native
  def issuerCertificate: TLSCertificate = js.native

  def valid_from: String = js.native
  def valid_to: String   = js.native

  def serialNumber: String                        = js.native
  def fingerprint: String                         = js.native
  def fingerprint256: String                      = js.native
  def ext_key_usage: js.Array[String]             = js.native
  def subjectaltname: String                      = js.native
  def infoAccess: js.Dictionary[js.Array[String]] = js.native

  // For RSA and EC keys
  def pubkey: js.UndefOr[Buffer] = js.native
  def bits: js.UndefOr[Int]      = js.native

  // For RSA keys
  def exponent: js.UndefOr[String] = js.native
  def modulus: js.UndefOr[String]  = js.native

  // For EC keys
  def asn1Curve: js.UndefOr[String] = js.native
  def nitsCurve: js.UndefOr[String] = js.native
}

// TODO: Remove js.Array[String] where possible
@js.native
trait Subject extends js.Object {
  @JSName("C") var country: js.UndefOr[String | js.Array[String]]           = js.native
  @JSName("ST") var stateOrProvince: js.UndefOr[String | js.Array[String]]  = js.native
  @JSName("L") var locality: js.UndefOr[String | js.Array[String]]          = js.native
  @JSName("O") var organization: js.UndefOr[String | js.Array[String]]      = js.native
  @JSName("OU") var organizationUnit: js.UndefOr[String | js.Array[String]] = js.native
  @JSName("CN") var commonName: js.UndefOr[String | js.Array[String]]       = js.native
}
