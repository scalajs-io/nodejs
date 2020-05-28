package io.scalajs.nodejs.http2

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait Http2Settings extends js.Object {
  var headerTableSize: js.UndefOr[Int]       = js.undefined
  var enablePush: js.UndefOr[Boolean]        = js.undefined
  var initialWindowSize: js.UndefOr[Int]     = js.undefined
  var maxFrameSize: js.UndefOr[Int]          = js.undefined
  var maxConcurrentStreams: js.UndefOr[Int]  = js.undefined
  var maxHeaderListSize: js.UndefOr[Int]     = js.undefined
  var enableConnectProtocol: js.UndefOr[Int] = js.undefined
}
