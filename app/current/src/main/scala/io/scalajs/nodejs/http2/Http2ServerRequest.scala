package io.scalajs.nodejs.http2

import com.thoughtworks.enableIf
import io.scalajs.nodejs.{net, tls}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("http2", "Http2ServerRequest")
class Http2ServerRequest extends Http2TimeoutOps {
  def authority: String = js.native

  /**
    * Added in Node.js v12.10.0
    * @see v12.10.0
    */
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def complete: Boolean = js.native

  def destroy(error: io.scalajs.nodejs.Error = js.native): Unit = js.native

  def headers: Http2Headers = js.native

  def httpVersion: String = js.native

  def method: String = js.native

  def rawHeaders: js.Array[String] = js.native

  def rawTrailers: js.Array[String] = js.native

  def scheme: js.Array[String] = js.native

  def socket: net.Socket | tls.TLSSocket = js.native

  def stream: Http2Stream = js.native

  def trailers: js.Object = js.native

  def url: String = js.native
}
