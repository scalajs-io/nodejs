package io.scalajs.nodejs.http2

import scala.scalajs.js

@js.native
trait Http2TimeoutOps extends js.Object {
  def setTimeout(msecs: Int, callback: js.Function): this.type = js.native
  def setTimeout(msecs: Int): this.type                        = js.native
  def setTimeout(callback: js.Function): this.type             = js.native
  def setTimeout(): this.type                                  = js.native
}
