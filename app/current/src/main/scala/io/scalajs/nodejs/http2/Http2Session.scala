package io.scalajs.nodejs.http2

import com.thoughtworks.enableIf
import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.{Error, net, tls}

import scala.scalajs.js
import scala.scalajs.js.typedarray.{DataView, TypedArray}
import scala.scalajs.js.|

@js.native
trait Http2Session extends IEventEmitter {
  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def alpnProtocol: js.UndefOr[String] = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def close(callback: js.Function = js.native): Unit = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def closed: Boolean = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def connecting: Boolean = js.native

  def destroy(error: Error, code: Int): Unit = js.native
  def destroy(code: Int): Unit               = js.native
  def destroy(error: Error): Unit            = js.native
  def destroy(): Unit                        = js.native

  def destroyed: Boolean = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def encrypted: Boolean = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def goaway(code: Int, lastStreamID: Int, opaqueData: TypedArray[_, _] | DataView): Unit = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def goaway(code: Int, lastStreamID: Int): Unit = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def goaway(code: Int): Unit = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def goaway(): Unit = js.native

  def localSettings: Http2Settings  = js.native
  def remoteSettings: Http2Settings = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def originSet: js.UndefOr[js.Array[String]]

  def pendingSettingsAck: Boolean = js.native

  def ping(payload: TypedArray[_, _] | DataView, callback: js.Function): Boolean = js.native

  def ping(callback: js.Function): Boolean = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def ref(): Unit = js.native

  def setTimeout(msec: Int, callback: js.Function): Unit = js.native

  def socket: net.Socket | tls.TLSSocket = js.native

  def state: Http2SessionState = js.native

  def settings(settings: Http2Settings = js.native,
               callback: js.Function3[Error, Http2Settings, Int, Any] = js.native): Unit = js.native

  def `type`: Int = js.native

  @enableIf(io.scalajs.nodejs.CompilerSwitches.gteNodeJs10)
  def unref(): Unit = js.native
}
