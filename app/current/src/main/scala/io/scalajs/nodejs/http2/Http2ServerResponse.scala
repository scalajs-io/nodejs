package io.scalajs.nodejs.http2

import com.thoughtworks.enableIf
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.{net, tls}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("http2", "Http2ServerResponse")
class Http2ServerResponse extends Http2TimeoutOps {
  def addTrailers(headers: Http2Headers): Unit = js.native

  /**
    * Added in Node.js v12.9.0
    * @see v12.9.0
    */
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def writableEnded: Boolean = js.native

  @deprecated("Use response.socket", "Node.js v13.0.0")
  def connection: net.Socket | tls.TLSSocket = js.native
  def socket: net.Socket | tls.TLSSocket     = js.native
  def stream: Http2Stream                    = js.native

  // TODO: Return type can be this.type when Node.js v8 dropped
  def end(chunk: String | Buffer, callback: js.Function1[Error, Any]): js.UndefOr[this.type]          = js.native
  def end(chunk: String | Buffer): js.UndefOr[this.type]                                              = js.native
  def end(callback: js.Function1[Error, Any]): js.UndefOr[this.type]                                  = js.native
  def end(chunk: String, encoding: String, callback: js.Function1[Error, Any]): js.UndefOr[this.type] = js.native
  def end(chunk: String, encoding: String): js.UndefOr[this.type]                                     = js.native
  def end(): js.UndefOr[this.type]                                                                    = js.native

  def write(chunk: String | Buffer, callback: js.Function1[Error, Any]): Boolean          = js.native
  def write(chunk: String | Buffer): Boolean                                              = js.native
  def write(chunk: String, encoding: String, callback: js.Function1[Error, Any]): Boolean = js.native
  def write(chunk: String, encoding: String): Boolean                                     = js.native

  def writeHead(statusCode: Int, statusMessage: String, http2Headers: Http2Headers): Unit = js.native
  def writeHead(statusCode: Int, http2Headers: Http2Headers): Unit                        = js.native
  def writeHead(statusCode: Int, statusMessage: String): Unit                             = js.native
  def writeHead(statusCode: Int): Unit                                                    = js.native

  def writeContinue(): Unit = js.native

  def createPushResponse(headers: Http2Headers,
                         callback: js.Function2[io.scalajs.nodejs.Error, ServerHttp2Stream, Any]): Unit = js.native

  def getHeader(name: String): String                                 = js.native
  def getHeaderNames(name: String): js.Array[String]                  = js.native
  def getHeaders(): Http2Headers                                      = js.native
  def hasHeader(name: String): Boolean                                = js.native
  def removeHeader(name: String): Unit                                = js.native
  def setHeader(name: String, value: String | js.Array[String]): Unit = js.native

  def finished: Boolean    = js.native
  def headersSent: Boolean = js.native
  def sendDate: Boolean    = js.native

  def statusCode: Int       = js.native
  def statusMessage: String = js.native
}
