package io.scalajs.nodejs.http

import com.thoughtworks.enableIf
import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait ServerOptions extends js.Object {
  var IncomingMessage: js.UndefOr[js.Function] = js.undefined
  var ServerResponse: js.UndefOr[js.Function]  = js.undefined
  var insecureHTTPParser: js.UndefOr[Boolean]  = js.undefined

  @enableIf(io.scalajs.nodejs.internal.CompilerSwitches.gteNodeJs14)
  var maxHeaderSize: js.UndefOr[Int] = js.undefined
}
