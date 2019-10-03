package io.scalajs.nodejs.http2

import scala.scalajs.js

@js.native
trait Http2StreamState extends js.Object {
  def localWindowSize: Int     = js.native
  def state: Int               = js.native
  def localClose: Boolean      = js.native
  def remoteClose: Boolean     = js.native
  def sumDependencyWeight: Int = js.native
  def weight: Int              = js.native
}
