package io.scalajs.nodejs.http2

import com.thoughtworks.enableIf
import io.scalajs.nodejs.stream

import scala.scalajs.js

@js.native
trait Http2Stream extends stream.Duplex {
  def aborted: Boolean = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12)
  def bufferSize: Int = js.native

  def close(code: Int, callback: js.Function = js.native): Unit = js.native

  def closed: Boolean = js.native

  def endAfterHeaders: Boolean = js.native

  def id: js.UndefOr[Int] = js.native

  def pending: Boolean = js.native

  def priority(options: Http2Priority): Unit = js.native

  def rstCode: Int = js.native

  def sentHeaders: Http2Headers = js.native

  def sentInfoHeaders: js.Array[Http2Headers] = js.native

  def sentTrailers: Http2Headers = js.native

  def session: Http2Session = js.native

  def setTimeout(msecs: Int, callback: js.Function): Unit = js.native

  def state: Http2StreamState = js.native

  def sendTrailers(headers: Http2Headers): Unit = js.native
}
