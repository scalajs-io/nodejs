package io.scalajs.nodejs.zlib

import io.scalajs.nodejs.stream

import scala.scalajs.js

/**
  * Not exported by the zlib module.
  * It is documented here because it is the base class of the compressor/decompressor classes.
  *
  * This class inherits from stream.Transform, allowing zlib objects to be used in pipes and
  * similar stream operations.
  */
@js.native
trait ZlibBase extends stream.Transform {
  def bytesWritten: Double = js.native

  def close(callback: js.Function = js.native): Unit = js.native

  def flush(kind: CompressionFlush, callback: js.Function): Unit = js.native
  def flush(callback: js.Function): Unit                         = js.native

  def params(level: CompressionLevel, strategy: CompressionStrategy, callback: js.Function): Unit = js.native

  def reset(): Unit = js.native
}
