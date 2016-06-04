package com.github.ldaniels528.meansjs.nodejs

import com.github.ldaniels528.meansjs.nodejs.net.{ListenerOptions, Socket}
import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * http package object
  */
package object http {

  /**
    * Server Events
    * @author lawrence.daniels@gmail.com
    */
  implicit class ServerEvents(val server: Server) extends AnyVal {

    /**
      * Emitted each time a request with an http Expect: 100-continue is received. If this event isn't listened for,
      * the server will automatically respond with a 100 Continue as appropriate.
      *
      * Handling this event involves calling response.writeContinue() if the client should continue to send the request
      * body, or generating an appropriate HTTP response (e.g., 400 Bad Request) if the client should not continue to
      * send the request body.
      *
      * Note that when this event is emitted and handled, the 'request' event will not be emitted.
      * @example server.on("checkContinue", function (request, response) { ... })
      */
    @inline
    def onCheckContinue(callback: (ClientRequest, ServerResponse) => Any) = server.on("checkContinue", callback)

    /**
      * If a client connection emits an 'error' event, it will be forwarded here. Listener of this event is responsible
      * for closing/destroying the underlying socket. For example, one may wish to more gracefully close the socket with
      * an HTTP '400 Bad Request' response instead of abruptly severing the connection.
      *
      * Default behavior is to destroy the socket immediately on malformed request.
      *
      * socket is the net.Socket object that the error originated from.
      * @example server.on("clientError", function (exception, socket) { ... })
      */
    @inline
    def onClientError(callback: (js.Error, Socket) => Any) = server.on("clientError", callback)

    @inline
    def onConnect(callback: js.Function) = server.on("connect", callback)

    @inline
    def closeFuture() = futureCallbackE0[js.Error](server.close)

    @inline
    def getConnectionsFuture = futureCallbackE1[js.Error, Int](server.getConnections)

    @inline
    def listenFuture(options: ListenerOptions) = futureCallbackE0[js.Error](server.listen(options, _))

    @inline
    def onRequest(callback: js.Function) = server.on("request", callback)

    @inline
    def onUpgrade(callback: js.Function) = server.on("upgrade", callback)

  }

}
