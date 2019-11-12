package io.scalajs.nodejs.http2

import scala.scalajs.js

@js.native
trait Http2SessionState extends js.Object {
  def effectiveLocalWindowSize: Int = js.native
  def effectiveRecvDataLength: Int  = js.native
  def nextStreamID: Int             = js.native
  def localWindowSize: Int          = js.native
  def lastProcStreamID: Int         = js.native
  def remoteWindowSize: Int         = js.native
  def outboundQueueSize: Int        = js.native
  def deflateDynamicTableSize: Int  = js.native
  def inflateDynamicTableSize: Int  = js.native
}
