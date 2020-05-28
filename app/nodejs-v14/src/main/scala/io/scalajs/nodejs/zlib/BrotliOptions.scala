package io.scalajs.nodejs.zlib

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js

@Factory
trait BrotliOptions extends js.Object {
  var flush: js.UndefOr[Int]                    = js.undefined
  var finishFlush: js.UndefOr[Int]              = js.undefined
  var chunkSize: js.UndefOr[Int]                = js.undefined
  var params: js.UndefOr[js.Dictionary[js.Any]] = js.undefined
}
