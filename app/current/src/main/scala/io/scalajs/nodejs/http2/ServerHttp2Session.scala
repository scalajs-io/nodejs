package io.scalajs.nodejs.http2

import com.thoughtworks.enableIf

import scala.scalajs.js

@js.native
trait ServerHttp2Session extends Http2Session {
  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def altsvc(alt: String, originOrStream: js.|[Int, Origin]): Unit = js.native

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs10)
  def origin(origins: Origin*): Unit = js.native
}
