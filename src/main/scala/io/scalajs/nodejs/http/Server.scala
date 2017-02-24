package io.scalajs.nodejs
package http

import io.scalajs.nodejs
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.net.Socket

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * http.Server - This class inherits from net.Server and has the following additional events
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("http", "Server")
class Server extends net.Server

/**
  * Server Companion
  * @author lawrence.daniels@gmail.com
  */
object Server {

  /**
    * Server Events
    * @param server the given [[Server]]
    */
  implicit class ServerEvents(val server: Server) extends AnyVal {

    /**
      * Emitted each time a request with an HTTP Expect: 100-continue is received. If this event is not listened for,
      * the server will automatically respond with a 100 Continue as appropriate.
      *
      * Handling this event involves calling response.writeContinue() if the client should continue to send the request
      * body, or generating an appropriate HTTP response (e.g. 400 Bad Request) if the client should not continue to
      * send the request body.
      * - request <http.IncomingMessage>
      * - response <http.ServerResponse>
      */
    def onCheckContinue(callback: (IncomingMessage, ServerResponse) => Any): server.type = {
      server.on("checkContinue", callback)
    }

    /**
      * Emitted each time a request with an http Expect header is received, where the value is not 100-continue.
      * If this event isn't listened for, the server will automatically respond with a 417 Expectation Failed as appropriate.
      * <b>Note</b> that when this event is emitted and handled, the request event will not be emitted.
      * - request <http.ClientRequest>
      * - response <http.ServerResponse>
      */
    @inline
    def onCheckExpectation(callback: (ClientRequest, ServerResponse) => Any): server.type = {
      server.on("checkExpectation", callback)
    }

    /**
      * If a client connection emits an 'error' event, it will be forwarded here. Listener of this event is
      * responsible for closing/destroying the underlying socket. For example, one may wish to more gracefully
      * close the socket with an HTTP '400 Bad Request' response instead of abruptly severing the connection.
      *
      * Default behavior is to destroy the socket immediately on malformed request.
      * - exception <Error>
      * - socket <net.Socket>
      */
    @inline
    def onClientError(callback: (nodejs.Error, Socket) => Any): server.type = {
      server.on("clientError", callback)
    }

    /**
      * Emitted when the server closes.
      */
    @inline
    def onClose(handler: () => Any): server.type = server.on("close", handler)

    /**
      * Emitted each time a client requests an HTTP CONNECT method. If this event is not listened for, then clients
      * requesting a CONNECT method will have their connections closed.
      *
      * After this event is emitted, the request's socket will not have a 'data' event listener, meaning you will need
      * to bind to it in order to handle data sent to the server on that socket.
      * - request <http.IncomingMessage> Arguments for the HTTP request, as it is in the 'request' event
      * - socket <net.Socket> Network socket between the server and client
      * - head <Buffer> The first packet of the tunneling stream (may be empty)
      */
    @inline
    def onConnect(handler: (IncomingMessage, Socket, Buffer) => Any): server.type = server.on("connect", handler)

    /**
      * When a new TCP stream is established. socket is an object of type net.Socket. Usually users will not want
      * to access this event. In particular, the socket will not emit 'readable' events because of how the protocol
      * parser attaches to the socket. The socket can also be accessed at request.connection.
      * - socket <net.Socket>
      */
    @inline
    def onConnection(handler: Socket => Any): server.type = server.on("connection", handler)

    /**
      * Emitted each time there is a request. Note that there may be multiple requests per connection (in the case
      * of HTTP Keep-Alive connections).
      * - request <http.IncomingMessage>
      * - response <http.ServerResponse>
      */
    @inline
    def onRequest(handler: (IncomingMessage, ServerResponse) => Any): server.type = server.on("request", handler)

    /**
      * Emitted each time a client requests an HTTP upgrade. If this event is not listened for, then clients
      * requesting an upgrade will have their connections closed.
      *
      * After this event is emitted, the request's socket will not have a 'data' event listener, meaning you will
      * need to bind to it in order to handle data sent to the server on that socket.
      * - request <http.IncomingMessage> Arguments for the HTTP request, as it is in the 'request' event
      * - socket <net.Socket> Network socket between the server and client
      * - head <Buffer> The first packet of the upgraded stream (may be empty)
      */
    @inline
    def onUpgrade(handler: (IncomingMessage, Socket, Buffer) => Any): server.type = server.on("upgrade", handler)

  }


}