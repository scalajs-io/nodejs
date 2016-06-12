package com.github.ldaniels528.meansjs.nodejs

import com.github.ldaniels528.meansjs.nodejs.buffer.Buffer
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * net package object
  */
package object net {

  /**
    * net.Server Events
    * @param server the given [[Server server]]
    */
  implicit class ServerEvents(val server: Server) extends AnyVal {

    /**
      * Emitted when a new connection is made. socket is an instance of net.Socket.
      * @example server.on("close", function () { ... })
      */
    @inline def onClose(callback: () => Any) = server.on("close", callback)

    /**
      * Emitted when a new connection is made. socket is an instance of net.Socket.
      */
    @inline def onConnection(callback: js.Function) = server.on("connection", callback)

    /**
      * Emitted when an error occurs. The 'close' event will be called directly following this event.
      */
    @inline def onError(callback: errors.Error => Any) = server.on("error", callback)

    /**
      * Emitted when the server has been bound after calling server.listen.
      */
    @inline def onListening(callback: js.Function) = server.on("listening", callback)

  }

  /**
    * net.Socket Extensions
    * @param socket the given [[Socket socket]]
    */
  implicit class SocketExtensions(val socket: Socket) extends AnyVal {

    /////////////////////////////////////////////////////////////////////////////////
    //      Futures
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Opens the connection for a given socket.
      * @param path the connection path
      * @return a promise of an outcome
      */
    @inline def connectFuture(path: String) = futureCallbackA1[Unit](socket.connect(path, _))

    /**
      * Opens the connection for a given socket.
      * @param port the port number
      * @return a promise of an outcome
      */
    @inline def connectFuture(port: Int) = futureCallbackA1[Unit](socket.connect(port, _))

    /**
      * Opens the connection for a given socket.
      * @param port the port number
      * @param host the host name or IP
      * @return a promise of an outcome
      */
    @inline def connectFuture(port: Int, host: String) = futureCallbackA1[Unit](socket.connect(port, host, _))

    /////////////////////////////////////////////////////////////////////////////////
    //      Events
    /////////////////////////////////////////////////////////////////////////////////

    /**
      * Emitted once the socket is fully closed. The argument had_error is a boolean which says if the socket was
      * closed due to a transmission error.
      * @param callback - had_error <Boolean> true if the socket had a transmission error.
      * @example socket.on("close", function(had_error) { ... })
      */
    @inline def onClose(callback: Boolean => Any) = socket.on("close", callback)

    /**
      * Emitted when a socket connection is successfully established. See connect().
      * @param callback the callback
      * @example socket.on("connect", function() { ... })
      */
    @inline def onConnect(callback: js.Function) = socket.on("connect", callback)

    /**
      * Emitted when data is received. The argument data will be a Buffer or String. Encoding of data is set by
      * socket.setEncoding(). (See the Readable Stream section for more information.)
      *
      * Note that the data will be lost if there is no listener when a Socket emits a 'data' event.
      * @param callback - <Buffer>
      * @example socket.on("data", function(buffer) { ... })
      */
    @inline def onData(callback: Buffer => Any) = socket.on("data", callback)

    /**
      * Emitted when the write buffer becomes empty. Can be used to throttle uploads.
      *
      * See also: the return values of socket.write()
      * @param callback the callback
      * @example socket.on("drain", function(???) { ... })
      */
    @inline def onDrain(callback: js.Function) = socket.on("drain", callback)

    /**
      * Emitted when the other end of the socket sends a FIN packet.
      *
      * By default (allowHalfOpen == false) the socket will destroy its file descriptor once it has written out its
      * pending write queue. However, by setting allowHalfOpen == true the socket will not automatically end() its
      * side allowing the user to write arbitrary amounts of data, with the caveat that the user is required to end()
      * their side now.
      * @param callback the callback
      * @example socket.on("end", function(???) { ... })
      */
    @inline def onEnd(callback: js.Function) = socket.on("end", callback)

    /**
      * Emitted after resolving the hostname but before connecting. Not applicable to UNIX sockets.
      * @param callback the callback, with the following arguments:
      *                 <ul>
      *                 <li>err <Error> | <Null> The error object. See dns.lookup().</li>
      *                 <li>address <String> The IP address.</li>
      *                 <li>family <String> | <Null> The address type. See dns.lookup().</li>
      *                 <li>host <String> The hostname.</li>
      *                 </ul>
      * @example socket.on("lookup", function(err, address, family, host) { ... })
      */
    @inline def onLookup(callback: (errors.Error, String, String, String) => Any) = socket.on("lookup", callback)

    /**
      * Emitted if the socket times out from inactivity. This is only to notify that the socket has been idle. The user
      * must manually close the connection.
      *
      * See also: socket.setTimeout()
      * @param callback the callback
      * @example socket.on("timeout", function(???) { ... })
      */
    @inline def onTimeout(callback: js.Function) = socket.on("timeout", callback)

  }

}
