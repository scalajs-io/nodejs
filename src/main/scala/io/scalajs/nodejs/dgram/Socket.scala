package io.scalajs.nodejs
package dgram

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.net.Address

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * The dgram.Socket object is an EventEmitter that encapsulates the datagram functionality.
  *
  * New instances of dgram.Socket are created using dgram.createSocket(). The new keyword is not
  * to be used to create dgram.Socket instances.
  */
@js.native
@JSImport("dgram", "Socket")
class Socket extends IEventEmitter {

  /**
    * Tells the kernel to join a multicast group at the given multicastAddress and multicastInterface using the
    * IP_ADD_MEMBERSHIP socket option. If the multicastInterface argument is not specified, the operating system
    * will choose one interface and will add membership to it. To add membership to every available interface,
    * call addMembership multiple times, once per interface.
    * @param multicastAddress   the multicast address
    * @param multicastInterface the multicast interface
    * @example addMembership(multicastAddress[, multicastInterface])
    */
  def addMembership(multicastAddress: String, multicastInterface: String = js.native): Unit = js.native

  /**
    * Returns an object containing the address information for a socket. For UDP sockets,
    * this object will contain address, family and port properties.
    * @return an [[Address object]] containing the address
    */
  def address(): Address = js.native

  /**
    * For UDP sockets, causes the dgram.Socket to listen for datagram messages on a named port and optional address.
    * If port is not specified or is 0, the operating system will attempt to bind to a random port. If address is not
    * specified, the operating system will attempt to listen on all addresses. Once binding is complete, a 'listening'
    * event is emitted and the optional callback function is called.
    * @param port     the port
    * @param address  the address
    * @param callback the callback
    * @example bind([port][, address][, callback])
    */
  def bind(port: Int, address: String, callback: js.Function): Unit = js.native

  /**
    * For UDP sockets, causes the dgram.Socket to listen for datagram messages on a named port and optional address.
    * If port is not specified or is 0, the operating system will attempt to bind to a random port. If address is not
    * specified, the operating system will attempt to listen on all addresses. Once binding is complete, a 'listening'
    * event is emitted and the optional callback function is called.
    * @param options  the optional settings
    * @param callback the callback
    * @example bind(options[, callback])
    */
  def bind(options: RawOptions, callback: js.Function): Unit = js.native

  /**
    * For UDP sockets, causes the dgram.Socket to listen for datagram messages on a named port and optional address.
    * If port is not specified or is 0, the operating system will attempt to bind to a random port. If address is not
    * specified, the operating system will attempt to listen on all addresses. Once binding is complete, a 'listening'
    * event is emitted and the optional callback function is called.
    * @param options the optional settings
    * @example bind(options[, callback])
    */
  def bind(options: RawOptions): Unit = js.native

  /**
    * Broadcasts a datagram on the socket. The destination port and address must be specified.
    *
    * The msg argument contains the message to be sent. Depending on its type, different behavior can apply.
    * If msg is a Buffer, the offset and length specify the offset within the Buffer where the message begins
    * and the number of bytes in the message, respectively. If msg is a String, then it is automatically converted
    * to a Buffer with 'utf8' encoding. With messages that contain multi-byte characters, offset and length will
    * be calculated with respect to byte length and not the character position. If msg is an array, offset and
    * length must not be specified.
    * @param msg      Message to be sent (<Buffer> | <String> | <Array>)
    * @param offset   Optional. Offset in the buffer where the message starts.
    * @param length   Optional. Number of bytes in the message.
    * @param port     Destination port.
    * @param address  Destination hostname or IP address.
    * @param callback Optional. Called when the message has been sent.
    * @example send(msg, [offset, length,] port, address[, callback])
    */
  def send(msg: Buffer | String | js.Array[Buffer] | js.Array[String],
           offset: Int = js.native,
           length: Int = js.native,
           port: Int,
           address: String,
           callback: js.Function): Unit = js.native

  /**
    * Sets or clears the SO_BROADCAST socket option. When set to true, UDP packets may be sent to a
    * local interface's broadcast address.
    * @param flag the flag to set
    */
  def setBroadcast(flag: Boolean): Unit = js.native

}
