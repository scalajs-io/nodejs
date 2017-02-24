package io.scalajs.nodejs
package tls

import io.scalajs.nodejs.buffer.Buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * The tls.Server class is a subclass of net.Server that accepts encrypted connections using TLS or SSL.
  * @see https://nodejs.org/dist/v7.6.0/docs/api/tls.html#tls_class_tls_server
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("tls", "Server")
class Server extends net.Server {

  /**
    * The server.addContext() method adds a secure context that will be used if the client request's SNI hostname
    * matches the supplied hostname (or wildcard).
    * @param hostname <string> A SNI hostname or wildcard (e.g. '*')
    * @param context  <Object> An object containing any of the possible properties from the tls.createSecureContext()
    *                 options arguments (e.g. key, cert, ca, etc).
    */
  def addContext(hostname: String, context: js.Any): Unit = js.native

  /**
    * Returns a Buffer instance holding the keys currently used for encryption/decryption of the TLS Session Tickets
    * @return a [[Buffer]]
    */
  def getTicketKeys(): Buffer = js.native

  /**
    * Updates the keys for encryption/decryption of the TLS Session Tickets.
    * @param keys The keys used for encryption/decryption of the TLS Session Tickets.
    */
  def setTicketKeys(keys: Buffer): Unit = js.native

}
