package io.scalajs.nodejs
package http

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.net.Socket
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.Uint8Array
import scala.scalajs.js.{Any, |}

/**
  * http.ClientRequest - This object is created internally and returned from http.request(). It represents an in-progress
  * request whose header has already been queued. The header is still mutable using the setHeader(name, value),
  * getHeader(name), removeHeader(name) API. The actual header will be sent along with the first data chunk or when
  * closing the connection.
  *
  * To get the response, add a listener for 'response' to the request object. 'response' will be emitted from the request
  * object when the response headers have been received. The 'response' event is executed with one argument which is an
  * instance of http.IncomingMessage.
  *
  * During the 'response' event, one can add listeners to the response object; particularly to listen for the 'data' event.
  * If no 'response' handler is added, then the response will be entirely discarded. However, if you add a 'response'
  * event handler, then you must consume the data from the response object, either by calling response.read() whenever
  * there is a 'readable' event, or by adding a 'data' handler, or by calling the .resume() method. Until the data is
  * consumed, the 'end' event will not fire. Also, until the data is read it will consume memory that can eventually
  * lead to a 'process out of memory' error.
  *
  * Note: Node.js does not check whether Content-Length and the length of the body which has been transmitted are equal or not.
  */
@js.native
@JSImport("http", "ClientRequest")
class ClientRequest extends stream.Writable {
  def aborted: Int | Boolean = js.native

  def connection: net.Socket = js.native

  def finished: Boolean = js.native

  var maxHeadersCount: Int | Null = js.native

  def path: String = js.native

  def socket: net.Socket = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def writableEnded: Boolean = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def writableFinished: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Marks the request as aborting. Calling this will cause remaining data in the response
    * to be dropped and the socket to be destroyed.
    * @see [[https://nodejs.org/api/http.html#http_request_abort]]
    */
  def abort(): Unit = js.native

  /**
    * Flush the request headers.
    *
    * For efficiency reasons, Node.js normally buffers the request headers until you call
    * request.end() or write the first chunk of request data. It then tries hard to pack the
    * request headers and data into a single TCP packet.
    *
    * That's usually what you want (it saves a TCP round-trip) but not when the first data isn't sent
    * until possibly much later. request.flushHeaders() lets you bypass the optimization and kickstart
    * the request.
    * @see [[https://nodejs.org/api/http.html#http_request_flushheaders]]
    */
  def flushHeaders(): Unit = js.native

  def getHeader[T <: js.Any](name: String): T = js.native

  def removeHeader(name: String): Unit = js.native

  def setHeader(name: String, value: js.Any): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setNoDelay() will be called.
    */
  def setNoDelay(noDelay: Int): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setNoDelay() will be called.
    */
  def setNoDelay(noDelay: Boolean = js.native): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setKeepAlive() will be called.
    * @see [[https://nodejs.org/api/http.html#http_request_setsocketkeepalive_enable_initialdelay]]
    */
  def setSocketKeepAlive(enable: Boolean = js.native, initialDelay: Int = js.native): Unit = js.native

  /**
    * Once a socket is assigned to this request and is connected socket.setTimeout() will be called.
    * <ul>
    * <li>timeout {Number} Milliseconds before a request is considered to be timed out.</li>
    * <li>callback {Function} Optional function to be called when a timeout occurs.
    * Same as binding to the timeout event.</li>
    * </ul>
    */
  def setTimeout(timeout: Int, callback: js.Function = js.native): Unit = js.native
}

/**
  * Client Request Companion
  */
object ClientRequest {
  implicit final class ClientRequestExtensions(val client: ClientRequest) extends AnyVal {
    /**
      * Emitted when the request has been aborted by the client. This event is only emitted on the first call to abort().
      */
    @inline
    def onAbort(callback: () => Any): client.type = client.on("abort", callback)

    /**
      * Emitted when the request has been aborted by the server and the network socket has closed.
      */
    @inline
    def onAborted(callback: () => Any): client.type = client.on("aborted", callback)

    /**
      * Emitted each time a server responds to a request with a CONNECT method. If this event is not being listened for,
      * clients receiving a CONNECT method will have their connections closed.
      * - response <http.IncomingMessage>
      * - socket <net.Socket>
      * - head <Buffer>
      */
    @inline
    def onConnect(callback: (IncomingMessage, Socket, Buffer) => Any): client.type = client.on("connect", callback)

    /**
      * Emitted when the server sends a '100 Continue' HTTP response, usually because the request
      * contained 'Expect: 100-continue'. This is an instruction that the client should send the request body.
      */
    @inline
    def onContinue(callback: () => Any): client.type = client.on("continue", callback)

    /**
      * Emitted when a response is received to this request. This event is emitted only once.
      * The response argument will be an instance of http.IncomingMessage.
      * - response <http.IncomingMessage>
      */
    @inline
    def onResponse(callback: IncomingMessage => Any): client.type = client.on("response", callback)

    /**
      * Emitted after a socket is assigned to this request.
      * - socket <net.Socket>
      */
    @inline
    def onSocket(callback: Socket => Any): client.type = client.on("socket", callback)

    /**
      * Emitted each time a server responds to a request with an upgrade. If this event isn't being listened for,
      * clients receiving an upgrade header will have their connections closed.
      * - response <http.IncomingMessage>
      * - socket <net.Socket>
      * - head <Buffer>
      */
    @inline
    def onUpgrade(callback: (IncomingMessage, Socket, Buffer) => Any): client.type = client.on("upgrade", callback)

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
}
