package org.scalajs.nodejs.net

import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.stream.Duplex

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * net.Socket - This object is an abstraction of a TCP or local socket. net.Socket instances implement a duplex Stream
  * interface. They can be created by the user and used as a client (with connect()) or they can be created by Node.js
  * and passed to the user through the 'connection' event of a server.
  * @version 6.2.1
  */
@js.native
trait Socket extends EventEmitter with Duplex {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * net.Socket has the property that socket.write() always works. This is to help users get up and running quickly.
    * The computer cannot always keep up with the amount of data that is written to a socket - the network connection
    * simply might be too slow. Node.js will internally queue up the data written to a socket and send it out over the
    * wire when it is possible. (Internally it is polling on the socket's file descriptor for being writable).
    *
    * The consequence of this internal buffering is that memory may grow. This property shows the number of characters
    * currently buffered to be written. (Number of characters is approximately equal to the number of bytes to be written,
    * but the buffer may contain strings, and the strings are lazily encoded, so the exact number of bytes is not known.)
    *
    * Users who experience large or growing bufferSize should attempt to "throttle" the data flows in their program with
    * pause() and resume().
    */
  var bufferSize: Int = js.native

  /**
    * The amount of received bytes.
    */
  def bytesRead: Int = js.native

  /**
    * The amount of bytes sent.
    */
  def bytesWritten: Int = js.native

  /**
    * If true - socket.connect(options[, connectListener]) was called and haven't yet finished. Will be set to false
    * before emitting connect event and/or calling socket.connect(options[, connectListener])'s callback.
    */
  def connecting: Boolean = js.native

  /**
    * The string representation of the local IP address the remote client is connecting on. For example, if you are
    * listening on '0.0.0.0' and the client connects on '192.168.1.1', the value would be '192.168.1.1'.
    */
  def localAddress: String = js.native

  /**
    * The numeric representation of the local port. For example, 80 or 21.
    */
  def localPort: Int = js.native

  /**
    * The string representation of the remote IP address. For example, '74.125.127.100' or '2001:4860:a005::68'.
    * Value may be undefined if the socket is destroyed (for example, if the client disconnected).
    */
  def remoteAddress: js.UndefOr[String] = js.native

  /**
    * The string representation of the remote IP family. 'IPv4' or 'IPv6'.
    */
  def remoteFamily: String = js.native

  /**
    * The numeric representation of the remote port. For example, 80 or 21.
    */
  def remotePort: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns the bound address, the address family name and port of the socket as reported by the operating system.
    * @return an object with three properties, e.g. { port: 12346, family: 'IPv4', address: '127.0.0.1' }
    */
  def address(): Address = js.native

  /**
    * Opens the connection for a given socket.
    * For TCP sockets, options argument should be an object which specifies:
    * <ul>
    * <li>port: Port the client should connect to (Required).</li>
    * <li>host: Host the client should connect to. Defaults to 'localhost'.</li>
    * <li>localAddress: Local interface to bind to for network connections.</li>
    * <li>localPort: Local port to bind to for network connections.</li>
    * <li>family : Version of IP stack. Defaults to 4.</li>
    * <li>hints: dns.lookup() hints. Defaults to 0.</li>
    * <li>lookup : Custom lookup function. Defaults to dns.lookup.</li>
    * <lu>
    *
    * For local domain sockets, options argument should be an object which specifies:
    * <ul>
    * </li>path: Path the client should connect to (Required).</li>
    * </ul>
    *
    * Normally this method is not needed, as net.createConnection opens the socket. Use this only if you are implementing
    * a custom Socket.
    * This function is asynchronous. When the 'connect' event is emitted the socket is established. If there is a problem
    * connecting, the 'connect' event will not be emitted, the 'error' event will be emitted with the exception.
    * The connectListener parameter will be added as a listener for the 'connect' event.
    * @example socket.connect(path[, connectListener])
    * @example socket.connect(port[, host][, connectListener])
    *          As socket.connect(options[, connectListener]), with options either as either {port: port, host: host} or {path: path}.
    * @param options         the given socket options
    * @param connectListener the optional connect listener
    * @example socket.connect(options[, connectListener])
    */
  def connect(options: ConnectOptions, connectListener: js.Function = null): Unit = js.native

  /**
    * Opens the connection for a given socket.
    * @param port            the port number
    * @param host            the host name or IP
    * @param connectListener the optional connect listener
    * @example socket.connect(port[, host][, connectListener])
    */
  def connect(port: Int, host: String, connectListener: js.Function): Unit = js.native

  /**
    * Opens the connection for a given socket.
    * @param port            the port number
    * @param connectListener the optional connect listener
    * @example socket.connect(port[, host][, connectListener])
    */
  def connect(port: Int, connectListener: js.Function): Unit = js.native

  /**
    * Opens the connection for a given socket.
    * @param port the port number
    * @param host the host name or IP
    * @example socket.connect(port[, host][, connectListener])
    */
  def connect(port: Int, host: String): Unit = js.native

  /**
    * Opens the connection for a given socket.
    * @param port the port number
    * @example socket.connect(port[, host][, connectListener])
    */
  def connect(port: Int): Unit = js.native

  /**
    * Opens the connection for a given socket.
    * @param path            the given connection path
    * @param connectListener the optional connect listener
    * @example socket.connect(path[, connectListener])
    */
  def connect(path: String, connectListener: js.Function): Unit = js.native

  /**
    * Opens the connection for a given socket.
    * @param path the given connection path
    * @example socket.connect(path[, connectListener])
    */
  def connect(path: String): Unit = js.native

  /**
    * Ensures that no more I/O activity happens on this socket. Only necessary in case of errors (parse error or so).
    */
  def destroy(): Unit = js.native

  /**
    * Opposite of unref, calling ref on a previously unrefd socket will not let the program exit if it's the only socket
    * left (the default behavior). If the socket is refd calling ref again will have no effect.
    * @return socket
    */
  def ref(): this.type = js.native

  /**
    * Enable/disable keep-alive functionality, and optionally set the initial delay before the first keepalive probe is
    * sent on an idle socket. enable defaults to false.
    *
    * Set initialDelay (in milliseconds) to set the delay between the last data packet received and the first keepalive
    * probe. Setting 0 for initialDelay will leave the value unchanged from the default (or previous) setting. Defaults to 0.
    * @return socket
    * @example socket.setKeepAlive([enable][, initialDelay])
    */
  def setKeepAlive(enable: Boolean = false, initialDelay: Int = 0): this.type = js.native

  /**
    * Disables the Nagle algorithm. By default TCP connections use the Nagle algorithm, they buffer data before sending
    * it off. Setting true for noDelay will immediately fire off data each time socket.write() is called. noDelay
    * defaults to true.
    * @return socket
    * @example socket.setNoDelay([noDelay])
    */
  def setNoDelay(noDelay: Boolean = true): this.type = js.native

  /**
    * Sets the socket to timeout after timeout milliseconds of inactivity on the socket. By default net.Socket do not have a timeout.
    * When an idle timeout is triggered the socket will receive a 'timeout' event but the connection will not be severed.
    * The user must manually end() or destroy() the socket.
    * If timeout is 0, then the existing idle timeout is disabled.
    * The optional callback parameter will be added as a one time listener for the 'timeout' event.
    * @return socket.
    * @example socket.setTimeout(timeout[, callback])
    */
  def setTimeout(timeout: Int = 0, callback: js.Function = null): this.type = js.native

  /**
    * Calling unref on a socket will allow the program to exit if this is the only active socket in the event system.
    * If the socket is already unrefd calling unref again will have no effect.
    * @return socket.
    */
  def unref(): this.type = js.native

}

/**
  * Socket Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Socket")
object Socket extends SocketClass