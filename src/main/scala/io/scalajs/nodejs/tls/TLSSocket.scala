package io.scalajs.nodejs
package tls

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.net.Socket

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, ScalaJSDefined}
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
class TLSSocket(socket: Socket, options: TLSSocketOptions | RawOptions = js.native) extends net.Socket {

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

  /**
    * Returns a string containing the negotiated SSL/TLS protocol version of the current connection.
    * The value 'unknown' will be returned for connected sockets that have not completed the handshaking process.
    * The value null will be returned for server sockets or disconnected client sockets.
    * @return a string containing the negotiated SSL/TLS protocol version
    */
  def getProtocol(): String = js.native

  /**
    * Returns the ASN.1 encoded TLS session or undefined if no session was negotiated.
    * Can be used to speed up handshake establishment when reconnecting to the server.
    * @return the ASN.1 encoded TLS session
    */
  def getSession(): js.UndefOr[String] =  js.native

}

/**
  * TLS Socket Options
  * @param isServer           The SSL/TLS protocol is asymetrical, TLSSockets must know if they are to behave as a
  *                           server or a client. If true the TLS socket will be instantiated as a server. Defaults to false.
  * @param server             <net.Server> An optional net.Server instance.
  * @param requestCert        Whether to authenticate the remote peer by requesting a certificate. Clients always
  *                           request a server certificate. Servers (isServer is true) may optionally set requestCert
  *                           to true to request a client certificate.
  * @param rejectUnauthorized Optional, see tls.createServer()
  * @param NPNProtocols       Optional, see tls.createServer()
  * @param ALPNProtocols      Optional, see tls.createServer()
  * @param SNICallback        Optional, see tls.createServer()
  * @param session            <Buffer> An optional Buffer instance containing a TLS session.
  * @param requestOCSP        <boolean> If true, specifies that the OCSP status request extension will be added to
  *                           the client hello and an 'OCSPResponse' event will be emitted on the socket before
  *                           establishing a secure communication
  * @param secureContext      Optional TLS context object created with tls.createSecureContext(). If a secureContext
  *                           is not provided, one will be created by calling tls.createSecureContext() with no options.
  */
@ScalaJSDefined
class TLSSocketOptions(val isServer: js.UndefOr[Boolean] = js.undefined,
                       val server: js.UndefOr[net.Server] = js.undefined,
                       val requestCert: js.UndefOr[Boolean] = js.undefined,
                       val rejectUnauthorized: js.UndefOr[Boolean] = js.undefined,
                       val NPNProtocols: js.UndefOr[Boolean] = js.undefined,
                       val ALPNProtocols: js.UndefOr[Boolean] = js.undefined,
                       val SNICallback: js.UndefOr[Boolean] = js.undefined,
                       val session: js.UndefOr[Buffer] = js.undefined,
                       val requestOCSP: js.UndefOr[Boolean] = js.undefined,
                       val secureContext: js.UndefOr[js.Any] = js.undefined)
  extends js.Object