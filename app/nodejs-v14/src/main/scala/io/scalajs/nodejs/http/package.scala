package io.scalajs.nodejs

import io.scalajs.nodejs
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.net.{ListenerOptions, Socket}
import io.scalajs.nodejs.stream.Duplex
import io.scalajs.util.PromiseHelper._

import scala.concurrent.duration.FiniteDuration
import scala.concurrent.{Future, Promise}
import scala.scalajs.js
import scala.scalajs.js.typedarray.Uint8Array

/**
  * http package object
  */
package object http {

  /**
    * Http Extensions
    */
  implicit final class HttpExtensions(val http: Http) extends AnyVal {

    /**
      * @see [[Http.createServer()]]
      */
    @inline
    def createServerFuture: Future[(Server, ClientRequest, ServerResponse)] = {
      val task           = Promise[(Server, ClientRequest, ServerResponse)]()
      var server: Server = null
      server = http.createServer((request: ClientRequest, response: ServerResponse) => {
        task.success((server, request, response))
      })
      task.future
    }

    /**
      * @see [[Http.get()]]
      */
    @inline
    def getFuture(options: RequestOptions): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](http.get(options, _))
    }

    /**
      * @see [[Http.get()]]
      */
    @inline
    def getFuture(url: String): Future[ServerResponse] = promiseCallback1[ServerResponse](http.get(url, _))

    /**
      * @see [[Http.request()]]
      */
    @inline
    def requestFuture(options: RequestOptions): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](http.request(options, _))
    }

    /**
      * @see [[Http.request()]]
      */
    @inline
    def requestFuture(url: String): Future[ServerResponse] = {
      promiseCallback1[ServerResponse](http.request(url, _))
    }
  }

  implicit final class ServerExtensions[T <: Server](private val server: T) extends AnyVal {

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
    @inline
    def onCheckContinue(callback: (IncomingMessage, ServerResponse) => Any): T = {
      server.on("checkContinue", callback)
    }

    /**
      * Emitted each time a request with an http Expect header is received, where the value is not 100-continue.
      * If this event isn't listened for, the server will automatically respond with a 417 Expectation Failed as appropriate.
      * <b>Note</b> that when this event is emitted and handled, the request event will not be emitted.
      * - request <http.IncomingMessage>
      * - response <http.ServerResponse>
      */
    @inline
    def onCheckExpectation(callback: (IncomingMessage, ServerResponse) => Any): T = {
      server.on("checkExpectation", callback)
    }

    /**
      * If a client connection emits an 'error' event, it will be forwarded here. Listener of this event is
      * responsible for closing/destroying the underlying socket. For example, one may wish to more gracefully
      * close the socket with an HTTP '400 Bad Request' response instead of abruptly severing the connection.
      *
      * Default behavior is to destroy the socket immediately on malformed request.
      * - exception <Error>
      * - socket <stream.Duplex>
      */
    @inline
    def onClientError(callback: (nodejs.Error, Duplex) => Any): T = server.on("clientError", callback)

    /**
      * Emitted when the server closes.
      */
    @inline
    def onClose(handler: () => Any): T = server.on("close", handler)

    /**
      * Emitted each time a client requests an HTTP CONNECT method. If this event is not listened for, then clients
      * requesting a CONNECT method will have their connections closed.
      *
      * After this event is emitted, the request's socket will not have a 'data' event listener, meaning you will need
      * to bind to it in order to handle data sent to the server on that socket.
      * - request <http.IncomingMessage> Arguments for the HTTP request, as it is in the 'request' event
      * - socket <stream.Duplex> Network socket between the server and client
      * - head <Buffer> The first packet of the tunneling stream (may be empty)
      */
    @inline
    def onConnect(handler: (IncomingMessage, Duplex, Buffer) => Any): T = server.on("connect", handler)

    /**
      * When a new TCP stream is established. socket is an object of type net.Socket. Usually users will not want
      * to access this event. In particular, the socket will not emit 'readable' events because of how the protocol
      * parser attaches to the socket. The socket can also be accessed at request.connection.
      * - socket <stream.Duplex>
      */
    @inline
    def onConnection(handler: Duplex => Any): T = server.on("connection", handler)

    /**
      * Emitted each time there is a request. Note that there may be multiple requests per connection (in the case
      * of HTTP Keep-Alive connections).
      * - request <http.IncomingMessage>
      * - response <http.ServerResponse>
      */
    @inline
    def onRequest(handler: (IncomingMessage, ServerResponse) => Any): T = server.on("request", handler)

    /**
      * Emitted each time a client requests an HTTP upgrade. If this event is not listened for, then clients
      * requesting an upgrade will have their connections closed.
      *
      * After this event is emitted, the request's socket will not have a 'data' event listener, meaning you will
      * need to bind to it in order to handle data sent to the server on that socket.
      * - request <http.IncomingMessage> Arguments for the HTTP request, as it is in the 'request' event
      * - socket <stream.Duplex> Network socket between the server and client
      * - head <Buffer> The first packet of the upgraded stream (may be empty)
      */
    @inline
    def onUpgrade(handler: (IncomingMessage, Duplex, Buffer) => Any): T = server.on("upgrade", handler)

    @inline
    def closeFuture(): Future[Unit] = promiseWithError0[SystemError](server.close)

    @inline
    def getConnectionsFuture: Future[Int] = promiseWithError1[SystemError, Int](server.getConnections)

    @inline
    def listenFuture(options: ListenerOptions): Future[Unit] = promiseWithError0[SystemError](server.listen(options, _))
  }

  implicit final class AgentExtensions[T <: Agent](private val agent: T) extends AnyVal {

    /**
      * Produces a socket/stream to be used for HTTP requests. By default, this function is the same
      * as net.createConnection(). However, custom Agents may override this method in case greater
      * flexibility is desired.
      */
    @inline
    def createConnectionFuture(options: ConnectionOptions): Future[js.Any] = {
      promiseWithError1[Error, js.Any](agent.createConnection(options, _))
    }

    @inline def onKeylog(handler: () => Any): T = agent.on("keylog", handler)
  }

  implicit final class ClientRequestExtensions[T <: ClientRequest](private val client: T) extends AnyVal {

    /**
      * Emitted when the request has been aborted by the client. This event is only emitted on the first call to abort().
      */
    @inline
    def onAbort(callback: () => Any): T = client.on("abort", callback)

    /**
      * Emitted each time a server responds to a request with a CONNECT method. If this event is not being listened for,
      * clients receiving a CONNECT method will have their connections closed.
      * - response <http.IncomingMessage>
      * - socket <stream.Duplex>
      * - head <Buffer>
      */
    @inline
    def onConnect(callback: (IncomingMessage, Duplex, Buffer) => Any): T = client.on("connect", callback)

    /**
      * Emitted when the server sends a '100 Continue' HTTP response, usually because the request
      * contained 'Expect: 100-continue'. This is an instruction that the client should send the request body.
      */
    @inline
    def onContinue(callback: () => Any): T = client.on("continue", callback)

    @inline
    def onInformation(callback: Information => Any): T = client.on("information", callback)

    /**
      * Emitted when a response is received to this request. This event is emitted only once.
      * The response argument will be an instance of http.IncomingMessage.
      * - response <http.IncomingMessage>
      */
    @inline
    def onResponse(callback: IncomingMessage => Any): T = client.on("response", callback)

    /**
      * Emitted after a socket is assigned to this request.
      * - socket <net.Socket>
      */
    @inline
    def onSocket(callback: Duplex => Any): T = client.on("socket", callback)

    @inline
    def onTimeout(callback: () => Any): T = client.on("timeout", callback)

    /**
      * Emitted each time a server responds to a request with an upgrade. If this event isn't being listened for,
      * clients receiving an upgrade header will have their connections closed.
      * - response <http.IncomingMessage>
      * - socket <net.Socket>
      * - head <Buffer>
      */
    @inline
    def onUpgrade(callback: (IncomingMessage, Socket, Buffer) => Any): T = client.on("upgrade", callback)

    @inline
    def endFuture(data: Uint8Array): Future[Unit] = {
      promiseWithError0[Error](client.end(data, _))
    }

    @inline
    def endFuture(data: String, encoding: String): Future[Unit] = {
      promiseWithError0[Error](client.end(data, encoding, _))
    }

    @inline
    def writeFuture(chunk: Uint8Array): Future[Unit] = {
      promiseWithError0[Error](client.write(chunk, _))
    }

    @inline
    def writeFuture(chunk: String, encoding: String): Future[Unit] = {
      promiseWithError0[Error](client.write(chunk, encoding, _))
    }
  }

  implicit final class IncomingMessageExtensions[T <: IncomingMessage](private val message: T) extends AnyVal {
    @inline
    def onAborted(callback: () => Any): T = message.on("aborted", callback)

    @inline
    def onClose(callback: () => Any): T = message.on("close", callback)

    @inline
    def setTimeout(duration: FiniteDuration, callback: js.Function): Unit =
      message.setTimeout(duration.toMillis.toDouble, callback)
  }

  /**
    * Server Response Events
    */
  implicit final class ServerResponseExtensions[T <: ServerResponse](private val response: T) extends AnyVal {
    @inline
    def onData(handler: Buffer => Any): T = response.on("data", handler)

    @inline
    def onClose(handler: () => Any): T = response.on("close", handler)

    @inline
    def onFinish(handler: () => Any): T = response.on("finish", handler)

    /**
      * Sets the content-type for the response
      * @param contentType the given MIME type
      */
    @inline
    def setContentType(contentType: String): Unit = response.setHeader("Content-Type", contentType)

    /////////////////////////////////////////////////////////////////////////////////
    //      Response Shortcuts
    /////////////////////////////////////////////////////////////////////////////////

    @inline
    def badRequest(): Unit = response.sendStatus(400)

    @inline
    def forbidden(): Unit = response.sendStatus(403)

    @inline
    def internalServerError(): Unit = response.sendStatus(500)

    @inline
    def notFound(): Unit = response.sendStatus(404)
  }
}
