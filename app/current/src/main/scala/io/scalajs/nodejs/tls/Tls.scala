package io.scalajs.nodejs
package tls

import com.thoughtworks.enableIf

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * The tls module provides an implementation of the Transport Layer Security (TLS) and Secure Socket Layer (SSL)
  * protocols that is built on top of OpenSSL.
  * @see https://nodejs.org/dist/v7.6.0/docs/api/tls.html
  */
@js.native
trait Tls extends js.Object {
  def checkServerIdentity(hostname: String, cert: TLSCertificate): js.UndefOr[io.scalajs.nodejs.Error] = js.native

  def connect(options: ConnectOptions, callback: js.Function = js.native): Unit = js.native

  def createSecureContext(options: SecureContextOptions = js.native): SecureContext = js.native

  def createServer(options: ServerOptions, secureConnectionListener: js.Function = js.native): Server = js.native
  def createServer(secureConnectionListener: js.Function): Server                                     = js.native
  def createServer(): Server                                                                          = js.native

  def getCiphers(): js.Array[String] = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def rootCertificates: js.Array[String] = js.native
}

/**
  * TLS Singleton
  */
@js.native
@JSImport("tls", JSImport.Namespace)
object Tls extends Tls {
  def DEFAULT_ECDH_CURVE: String = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def DEFAULT_MAX_VERSION: String = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def DEFAULT_MIN_VERSION: String = js.native
}
