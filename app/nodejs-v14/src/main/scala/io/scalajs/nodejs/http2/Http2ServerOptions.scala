package io.scalajs.nodejs.http2

import com.thoughtworks.enableIf
import io.scalajs.nodejs.http
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait Http2ServerOptions extends js.Object {
  var maxDeflateDynamicTableSize: js.UndefOr[Int]                               = js.undefined
  var maxSessionMemory: js.UndefOr[Int]                                         = js.undefined
  var maxHeaderListPairs: js.UndefOr[Int]                                       = js.undefined
  var maxOutstandingPings: js.UndefOr[Int]                                      = js.undefined
  var maxSendHeaderBlockLength: js.UndefOr[Int]                                 = js.undefined
  var paddingStrategy: js.UndefOr[Int]                                          = js.undefined
  var peerMaxConcurrentStreams: js.UndefOr[Int]                                 = js.undefined
  var settings: js.UndefOr[Http2Settings]                                       = js.undefined
  var Http1IncomingMessage: js.UndefOr[js.ConstructorTag[http.IncomingMessage]] = js.undefined
  var Http1ServerResponse: js.UndefOr[js.ConstructorTag[http.ServerResponse]]   = js.undefined
  var Http2ServerRequest: js.UndefOr[js.ConstructorTag[Http2ServerRequest]]     = js.undefined
  var Http2ServerResponse: js.UndefOr[js.ConstructorTag[Http2ServerResponse]]   = js.undefined
  var allowHalfOpen: js.UndefOr[Boolean]                                        = js.undefined
  var pauseOnConnect: js.UndefOr[Boolean]                                       = js.undefined

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.ltNodeJs14) var selectPadding
      : js.UndefOr[js.Function2[Int, Int, Int]] = js.undefined
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) var maxSessionRejectedStreams: js.UndefOr[Int] =
    js.undefined
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs12) var maxSessionInvalidFrames: js.UndefOr[Int] =
    js.undefined
}
