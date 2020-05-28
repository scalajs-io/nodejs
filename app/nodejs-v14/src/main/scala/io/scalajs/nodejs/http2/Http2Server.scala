package io.scalajs.nodejs.http2

import io.scalajs.nodejs.net

import scala.scalajs.js

@js.native
trait Http2Server extends net.Server with Http2TimeoutOps
