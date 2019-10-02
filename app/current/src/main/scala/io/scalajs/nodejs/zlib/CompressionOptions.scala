package io.scalajs.nodejs.zlib

import scala.scalajs.js
import scala.scalajs.js.typedarray.{ArrayBuffer, DataView, TypedArray}
import scala.scalajs.js.|

/**
  * Compression Options
  * @param chunkSize   (default: 16*1024)
  * @param dictionary  (deflate/inflate only, empty dictionary by default)
  * @param flush       (default: zlib.Z_NO_FLUSH)
  * @param finishFlush (default: zlib.Z_FINISH)
  * @param level       (compression only)
  * @param memLevel    (compression only)
  * @param strategy    (compression only)
  * @param windowBits  ???
  */
class CompressionOptions(var flush: js.UndefOr[CompressionFlush] = js.undefined,
                         var finishFlush: js.UndefOr[CompressionFlush] = js.undefined,
                         var chunkSize: js.UndefOr[Int] = js.undefined,
                         var windowBits: js.UndefOr[Int] = js.undefined,
                         var level: js.UndefOr[CompressionLevel] = js.undefined,
                         var memLevel: js.UndefOr[CompressionLevel] = js.undefined,
                         var strategy: js.UndefOr[CompressionStrategy] = js.undefined,
                         var dictionary: js.UndefOr[TypedArray[_, _] | DataView | ArrayBuffer] = js.undefined,
                         var info: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
