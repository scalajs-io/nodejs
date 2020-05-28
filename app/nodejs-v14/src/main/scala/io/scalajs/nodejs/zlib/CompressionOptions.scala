package io.scalajs.nodejs.zlib

import net.exoego.scalajs.types.util.Factory

import scala.scalajs.js
import scala.scalajs.js.typedarray.{ArrayBuffer, DataView, TypedArray}
import scala.scalajs.js.|

@Factory
trait CompressionOptions extends js.Object {
  var flush: js.UndefOr[CompressionFlush] = js.undefined

  var finishFlush: js.UndefOr[CompressionFlush] = js.undefined

  var chunkSize: js.UndefOr[Int] = js.undefined

  var windowBits: js.UndefOr[Int] = js.undefined

  /**  (compression only)
    */
  var level: js.UndefOr[CompressionLevel] = js.undefined

  /**  (compression only)
    */
  var memLevel: js.UndefOr[CompressionLevel] = js.undefined

  /**  (compression only)
    */
  var strategy: js.UndefOr[CompressionStrategy] = js.undefined

  /**
    * deflate/inflate only, empty dictionary by default
    */
  var dictionary: js.UndefOr[TypedArray[_, _] | DataView | ArrayBuffer] = js.undefined

  var info: js.UndefOr[Boolean] = js.undefined
}
