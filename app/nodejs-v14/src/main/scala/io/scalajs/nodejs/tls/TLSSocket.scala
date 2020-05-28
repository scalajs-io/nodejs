package io.scalajs.nodejs
package tls

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer
import _root_.net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * The tls.TLSSocket is a subclass of net.Socket that performs transparent encryption of written data
  * and all required TLS negotiation.
  *
  * Instances of tls.TLSSocket implement the duplex Stream interface.
  * @param socket  An instance of [[net.Socket]]
  * @param options the optional settings
  */
@js.native
@JSImport("tls", "TLSSocket")
class TLSSocket(socket: stream.IDuplex, options: TLSSocketOptions = js.native) extends net.Socket {
  def authorizationError: js.UndefOr[Boolean] = js.native

  def authorized: Boolean = js.native

  def disableRenegotiation(): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def enableTrace(): Unit = js.native

  def encrypted: Boolean = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def getCertificate(): TLSCertificate = js.native

  /**
    * Returns an object representing the peer's certificate. The returned object has some properties corresponding to
    * the fields of the certificate.
    *
    * If the full certificate chain was requested, each certificate will include a issuerCertificate property
    * containing an object representing its issuer's certificate.
    * @param detailed Include the full certificate chain if true, otherwise include just the peer's certificate.
    * @return the peer certificate
    */
  def getPeerCertificate(detailed: String): TLSCertificate = js.native

  def getPeerFinished(): js.UndefOr[Buffer] = js.native

  /**
    * Returns a string containing the negotiated SSL/TLS protocol version of the current connection.
    * The value 'unknown' will be returned for connected sockets that have not completed the handshaking process.
    * The value null will be returned for server sockets or disconnected client sockets.
    * @return a string containing the negotiated SSL/TLS protocol version
    */
  def getProtocol(): String | Null = js.native

  /**
    * Returns the ASN.1 encoded TLS session or undefined if no session was negotiated.
    * Can be used to speed up handshake establishment when reconnecting to the server.
    * @return the ASN.1 encoded TLS session
    */
  def getSession(): js.UndefOr[Buffer] = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def getSharedSigalgs(): js.Array[String] = js.native

  def getTLSTicket(): Buffer = js.native

  def isSessionReused(): Boolean = js.native

  def renegotiate(options: RenegotiateOptions, callback: js.Function1[io.scalajs.nodejs.Error, Any]): Boolean =
    js.native

  def setMaxSendFragment(size: Int): Boolean = js.native
}

@Factory
trait TLSSocketOptions extends js.Object {
  var enableTrace: js.UndefOr[Boolean] = js.undefined

  /** The SSL/TLS protocol is asymetrical, TLSSockets must know if they are to behave as a
    * server or a client. If true the TLS socket will be instantiated as a server. Defaults to false.
    */
  var isServer: js.UndefOr[Boolean] = js.undefined

  /** An optional net.Server instance. */
  var server: js.UndefOr[net.Server] = js.undefined

  /** Whether to authenticate the remote peer by requesting a certificate. Clients always request a server
    * certificate. Servers (isServer is true) may optionally set requestCert o true to request a client certificate.
    */
  var requestCert: js.UndefOr[Boolean] = js.undefined

  /** Optional, see tls.createServer()  */
  var rejectUnauthorized: js.UndefOr[Boolean] = js.undefined

  /** Optional, see tls.createServer()  */
  var NPNProtocols: js.UndefOr[Boolean] = js.undefined

  /** Optional, see tls.createServer()  */
  var ALPNProtocols: js.UndefOr[ALPNProtocols] = js.undefined

  /** Optional, see tls.createServer()  */
  var SNICallback: js.UndefOr[js.Function2[String, js.Function, Any]] = js.undefined

  /** An optional Buffer instance containing a TLS session. */
  var session: js.UndefOr[Buffer] = js.undefined

  /** If true, specifies that the OCSP status request extension will be added to the client hello and an
    * 'OCSPResponse' event will be emitted on the socket before establishing a secure communication
    */
  var requestOCSP: js.UndefOr[Boolean] = js.undefined

  /** Optional TLS context object created with tls.createSecureContext(). If a secureContext
    * is not provided, one will be created by calling tls.createSecureContext() with no options.
    */
  var secureContext: js.UndefOr[SecureContext] = js.undefined
}
@Factory
trait RenegotiateOptions extends js.Object {
  var rejectUnauthorized: js.UndefOr[Boolean] = js.undefined
  var requestCert: js.UndefOr[Boolean]        = js.undefined
}
