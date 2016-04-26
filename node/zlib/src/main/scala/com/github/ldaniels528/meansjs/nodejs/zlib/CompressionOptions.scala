package com.github.ldaniels528.meansjs.nodejs.zlib

import com.github.ldaniels528.meansjs.nodejs.zlib.Zlib._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Compression Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class CompressionOptions extends js.Object {
  // (default: zlib.Z_NO_FLUSH)
  var flush: js.UndefOr[CompressionFlush] = _

  // (default: zlib.Z_FINISH)
  var finishFlush: js.UndefOr[CompressionFlush] = _

  // (default: 16*1024)
  var chunkSize: js.UndefOr[Int] = _
  var windowBits: js.UndefOr[Int] = _

  // (compression only)
  var level: js.UndefOr[CompressionLevel] = _

  // (compression only)
  var memLevel: js.UndefOr[CompressionLevel] = _

  // (compression only)
  var strategy: js.UndefOr[CompressionStrategy] = _

  // (deflate/inflate only, empty dictionary by default)
  var dictionary: js.UndefOr[js.Dictionary[js.Any]] = _

}

/**
  * Compression Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CompressionOptions {

  def apply(chunkSize: js.UndefOr[Int] = js.undefined,
            dictionary: js.UndefOr[js.Dictionary[js.Any]] = js.undefined,
            flush: js.UndefOr[CompressionFlush] = js.undefined,
            finishFlush: js.UndefOr[CompressionFlush] = js.undefined,
            level: js.UndefOr[CompressionLevel] = js.undefined,
            memLevel: js.UndefOr[CompressionLevel] = js.undefined,
            strategy: js.UndefOr[CompressionStrategy] = js.undefined,
            windowBits: js.UndefOr[Int] = js.undefined) = {
    val options = new CompressionOptions()
    options.chunkSize = chunkSize
    options.dictionary = dictionary
    options.flush = flush
    options.finishFlush = finishFlush
    options.level = level
    options.memLevel = memLevel
    options.strategy = strategy
    options.windowBits = windowBits
    options
  }

}