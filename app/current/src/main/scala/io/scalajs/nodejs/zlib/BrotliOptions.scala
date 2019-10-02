package io.scalajs.nodejs.zlib

import scala.scalajs.js

class BrotliOptions(
    var flush: js.UndefOr[Int] = js.undefined,
    var finishFlush: js.UndefOr[Int] = js.undefined,
    var chunkSize: js.UndefOr[Int] = js.undefined,
    var params: js.UndefOr[js.Dictionary[js.Any]] = js.undefined
) extends js.Object
