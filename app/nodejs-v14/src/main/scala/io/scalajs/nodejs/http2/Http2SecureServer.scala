package io.scalajs.nodejs.http2

import io.scalajs.nodejs.tls

import scala.scalajs.js

@js.native
trait Http2SecureServer extends tls.Server with Http2TimeoutOps
