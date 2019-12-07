package io.scalajs.nodejs
package dgram

import com.thoughtworks.enableIf
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.net.Address

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * The dgram.Socket object is an EventEmitter that encapsulates the datagram functionality.
  *
  * New instances of dgram.Socket are created using dgram.createSocket(). The new keyword is not
  * to be used to create dgram.Socket instances.
  */
@js.native
@JSImport("dgram", "Socket")
class Socket private[this] () extends IEventEmitter {

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
  def bind(port: Int, address: String, callback: js.Function0[Any]): Unit = js.native
  def bind(port: Int, address: String): Unit                              = js.native
  def bind(port: Int, callback: js.Function0[Any]): Unit                  = js.native
  def bind(address: String, callback: js.Function0[Any]): Unit            = js.native
  def bind(port: Int): Unit                                               = js.native
  def bind(callback: js.Function0[Any]): Unit                             = js.native
  def bind(address: String): Unit                                         = js.native

  /**
    * For UDP sockets, causes the dgram.Socket to listen for datagram messages on a named port and optional address.
    * If port is not specified or is 0, the operating system will attempt to bind to a random port. If address is not
    * specified, the operating system will attempt to listen on all addresses. Once binding is complete, a 'listening'
    * event is emitted and the optional callback function is called.
    * @param options  the optional settings
    * @param callback the callback
    * @example bind(options[, callback])
    */
  def bind(options: BindOptions, callback: js.Function = js.native): Unit = js.native

  def close(callback: js.Function = js.native): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def connect(port: Int, address: String = js.native, callback: js.Function0[Any] = js.native): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def disconnect(): Unit = js.native

  def dropMembership(multicastAddress: String, multicastInterface: String = js.native): Unit = js.native

  def getRecvBufferSize(): Int = js.native
  def getSendBufferSize(): Int = js.native

  def ref(): this.type = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def remoteAddress(): RemoteAddress = js.native

  def send(msg: BufferMessage, offset: Int, length: Int, port: Int, address: String, callback: js.Function): Unit =
    js.native
  def send(msg: BufferMessage, offset: Int, length: Int, port: Int, address: String): Unit             = js.native
  def send(msg: BufferMessage, offset: Int, length: Int, port: Int, callback: js.Function): Unit       = js.native
  def send(msg: BufferMessage, offset: Int, length: Int, address: String, callback: js.Function): Unit = js.native
  def send(msg: BufferMessage, offset: Int, length: Int, port: Int): Unit                              = js.native
  def send(msg: BufferMessage, offset: Int, length: Int, address: String): Unit                        = js.native
  def send(msg: BufferMessage, offset: Int, length: Int, callback: js.Function): Unit                  = js.native
  def send(msg: BufferMessage, offset: Int, length: Int): Unit                                         = js.native

  def send(msg: Message, port: Int, address: String, callback: js.Function): Unit = js.native
  def send(msg: Message, address: String, callback: js.Function): Unit            = js.native
  def send(msg: Message, port: Int, callback: js.Function): Unit                  = js.native
  def send(msg: Message, port: Int, address: String): Unit                        = js.native
  def send(msg: Message, callback: js.Function): Unit                             = js.native
  def send(msg: Message, port: Int): Unit                                         = js.native
  def send(msg: Message, address: String): Unit                                   = js.native
  def send(msg: Message): Unit                                                    = js.native

  /**
    * Sets or clears the SO_BROADCAST socket option. When set to true, UDP packets may be sent to a
    * local interface's broadcast address.
    * @param flag the flag to set
    */
  def setBroadcast(flag: Boolean): Unit = js.native

  def setMulticastInterface(multicastInterface: String): Unit = js.native
  def setMulticastLoopback(flag: Boolean): Unit               = js.native
  def setMulticastTTL(ttl: Int): Unit                         = js.native
  def setRecvBufferSize(size: Int): Unit                      = js.native
  def setSendBufferSize(size: Int): Unit                      = js.native
  def setTTL(ttl: Int): Unit                                  = js.native
  def unref(): this.type                                      = js.native
}

class BindOptions(
    var port: js.UndefOr[Int] = js.undefined,
    var address: js.UndefOr[String] = js.undefined,
    var exclusive: js.UndefOr[Boolean] = js.undefined,
    var fd: js.UndefOr[Int] = js.undefined
) extends js.Object {}

@js.native
trait RemoteAddress extends js.Object {
  var address: String = js.native
  var family: String  = js.native
  var port: Int       = js.native
}
