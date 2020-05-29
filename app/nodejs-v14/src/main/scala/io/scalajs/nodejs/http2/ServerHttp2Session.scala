package io.scalajs.nodejs.http2

import scala.scalajs.js

@js.native
trait ServerHttp2Session extends Http2Session {
  def altsvc(alt: String, originOrStream: js.|[Int, Origin]): Unit = js.native

  def origin(origins: Origin*): Unit = js.native
}
