package org.scalajs.nodejs
package zlib

import org.scalajs.nodejs.buffer.Buffer
import org.scalajs.nodejs.errors.Error
import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.util.ScalaJsHelper._

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.|

/**
  * This provides bindings to Gzip/Gunzip, Deflate/Inflate, and DeflateRaw/InflateRaw classes.
  * Each class takes the same options, and is a readable/writable Stream.
  * @see https://nodejs.org/docs/latest/api/zlib.html
  * @version 6.1.0
  */
@js.native
trait Zlib extends NodeModule with EventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  // Allowed flush values
  val Z_NO_FLUSH: CompressionFlush = js.native
  val Z_PARTIAL_FLUSH: CompressionFlush = js.native
  val Z_SYNC_FLUSH: CompressionFlush = js.native
  val Z_FULL_FLUSH: CompressionFlush = js.native
  val Z_FINISH: CompressionFlush = js.native
  val Z_BLOCK: CompressionFlush = js.native
  val Z_TREES: CompressionFlush = js.native

  // Return codes for the compression/decompression functions.
  val Z_OK: CompressionFunction = js.native
  val Z_STREAM_END: CompressionFunction = js.native
  val Z_NEED_DICT: CompressionFunction = js.native
  val Z_ERRNO: CompressionFunction = js.native
  val Z_STREAM_ERROR: CompressionFunction = js.native
  val Z_DATA_ERROR: CompressionFunction = js.native
  val Z_MEM_ERROR: CompressionFunction = js.native
  val Z_BUF_ERROR: CompressionFunction = js.native
  val Z_VERSION_ERROR: CompressionFunction = js.native

  // Compression levels
  val Z_NO_COMPRESSION: CompressionLevel = js.native
  val Z_BEST_SPEED: CompressionLevel = js.native
  val Z_BEST_COMPRESSION: CompressionLevel = js.native
  val Z_DEFAULT_COMPRESSION: CompressionLevel = js.native

  // Compression strategies
  val Z_FILTERED: CompressionStrategy = js.native
  val Z_HUFFMAN_ONLY: CompressionStrategy = js.native
  val Z_RLE: CompressionStrategy = js.native
  val Z_FIXED: CompressionStrategy = js.native
  val Z_DEFAULT_STRATEGY: CompressionStrategy = js.native

  // Possible values of the data_type field
  val Z_BINARY: DataType = js.native
  val Z_TEXT: DataType = js.native
  val Z_ASCII: DataType = js.native
  val Z_UNKNOWN: DataType = js.native

  // The deflate compression method (the only one supported in this version).
  val Z_DEFLATED: DeflateCompressMethod = js.native

  // For initializing zalloc, zfree, opaque.
  val Z_NULL: AllocationType = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Returns a new Deflate object with an options.
    * @example zlib.createDeflate(options)
    */
  def createDeflate(options: CompressionOptions | NodeOptions): Deflate = js.native

  /**
    * Returns a new DeflateRaw object with an options.
    * @example zlib.createDeflateRaw(options)
    */
  def createDeflateRaw(options: CompressionOptions | NodeOptions): DeflateRaw = js.native

  /**
    * Returns a new Gunzip object with an options.
    * @example zlib.createGunzip(options)
    */
  def createGunzip(options: CompressionOptions | NodeOptions): Gunzip = js.native

  /**
    * Returns a new Gzip object with an options.
    * @example zlib.createGzip(options)
    */
  def createGzip(options: CompressionOptions | NodeOptions): Gzip = js.native

  /**
    * Returns a new Inflate object with an options.
    * @example zlib.createInflate(options)
    */
  def createInflate(options: CompressionOptions | NodeOptions): Inflate = js.native

  /**
    * Returns a new InflateRaw object with an options.
    * @example zlib.createInflateRaw(options)
    */
  def createInflateRaw(options: CompressionOptions | NodeOptions): InflateRaw = js.native

  /**
    * Returns a new Unzip object with an options.
    * @example zlib.createUnzip(options)
    */
  def createUnzip(options: CompressionOptions | NodeOptions): Unzip = js.native

  /**
    * Flush pending data. Don't call this frivolously, premature flushes negatively impact the effectiveness of the compression algorithm.
    * @example zlib.flush([kind], callback)
    */
  def flush(kind: CompressionFlush, callback: js.Function): Unit = js.native

  /**
    * Flush pending data. Don't call this frivolously, premature flushes negatively impact the effectiveness of the compression algorithm.
    * @example zlib.flush([kind], callback)
    */
  def flush(callback: js.Function): Unit = js.native

  /**
    * Dynamically update the compression level and compression strategy. Only applicable to deflate algorithm.
    * @example zlib.params(level, strategy, callback)
    */
  def params(level: CompressionLevel, strategy: CompressionStrategy, callback: js.Function): Unit = js.native

  /**
    * Reset the compressor/decompressor to factory defaults. Only applicable to the inflate and deflate algorithms.
    * @example zlib.reset()
    */
  def reset(): Unit = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Convenience Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Compress a Buffer or string with Deflate.
    * @example zlib.deflate(buf[, options], callback)
    */
  def deflate(buf: String | Buffer, options: CompressionOptions | NodeOptions, callback: js.Function): Unit = js.native

  /**
    * Compress a Buffer or string with Deflate.
    * @example zlib.deflate(buf[, options], callback)
    */
  def deflate(buf: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Compress a Buffer or string with Deflate.
    * @example zlib.deflateSync(buf[, options])
    */
  def deflateSync(buf: String | Buffer, options: CompressionOptions | NodeOptions = null): Unit = js.native

  /**
    * Compress a Buffer or string with DeflateRaw.
    * @example zlib.deflateRaw(buf[, options], callback)
    */
  def deflateRaw(buf: String | Buffer, options: CompressionOptions | NodeOptions, callback: js.Function): Unit = js.native

  /**
    * Compress a Buffer or string with DeflateRaw.
    * @example zlib.deflateRaw(buf[, options], callback)
    */
  def deflateRaw(buf: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Gunzip.
    * @example zlib.gunzip(buf[, options], callback)
    */
  def gunzip(buf: String | Buffer, options: CompressionOptions | NodeOptions, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Gunzip.
    * @example zlib.gunzip(buf[, options], callback)
    */
  def gunzip(buf: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Gunzip.
    * @example zlib.gunzipSync(buf[, options])
    */
  def gunzipSync(buf: String | Buffer, options: CompressionOptions | NodeOptions = null): Unit = js.native

  /**
    * Compress a Buffer or string with Gzip.
    * @example zlib.gzip(buf[, options], callback)
    */
  def gzip(buf: String | Buffer, options: CompressionOptions | NodeOptions, callback: js.Function): Unit = js.native

  /**
    * Compress a Buffer or string with Gzip.
    * @example zlib.gzip(buf[, options], callback)
    */
  def gzip(buf: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Compress a Buffer or string with Gzip.
    * @example zlib.gzipSync(buf[, options])
    */
  def gzipSync(buf: String | Buffer, options: CompressionOptions | NodeOptions = null): Unit = js.native

  /**
    * Decompress a Buffer or string with Inflate.
    * @example zlib.inflate(buf[, options], callback)
    */
  def inflate(buf: String | Buffer, options: CompressionOptions | NodeOptions, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Inflate.
    * @example zlib.inflate(buf[, options], callback)
    */
  def inflate(buf: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Inflate.
    * @example zlib.inflateSync(buf[, options])
    */
  def inflateSync(buf: String | Buffer, options: CompressionOptions | NodeOptions = null): Unit = js.native

  /**
    * Decompress a Buffer or string with InflateRaw.
    * @example zlib.inflateRaw(buf[, options], callback)
    */
  def inflateRaw(buf: String | Buffer, options: CompressionOptions | NodeOptions, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with InflateRaw.
    * @example zlib.inflateRaw(buf[, options], callback)
    */
  def inflateRaw(buf: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with InflateRaw.
    * @example zlib.inflateRawSync(buf[, options])
    */
  def inflateRawSync(buf: String | Buffer, options: CompressionOptions | NodeOptions = null): Unit = js.native

  /**
    * Decompress a Buffer or string with Unzip.
    * @example zlib.unzip(buf[, options], callback)
    */
  def unzip(buf: String | Buffer, options: CompressionOptions | NodeOptions, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Unzip.
    * @example zlib.unzip(buf[, options], callback)
    */
  def unzip(buf: String | Buffer, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Unzip.
    * @example zlib.unzipSync(buf[, options])
    */
  def unzipSync(buf: String | Buffer, options: CompressionOptions | NodeOptions = null): Unit = js.native

}

/**
  * Zlib Companion
  * @author lawrence.daniels@gmail.com
  */
object Zlib {

  /**
    * Convenience method for retrieving the tty module
    * @param require the implicit [[NodeRequire require function]]
    * @return the Zlib instance
    */
  def apply()(implicit require: NodeRequire) = require[Zlib]("zlib")

  /**
    * Zlib Extensions
    * @author lawrence.daniels@gmail.com
    */
  final implicit class ZlibExtensions(val zlib: Zlib) extends AnyVal {

    /**
      * Asynchronously compresses a Buffer or string with Deflate.
      */
    @inline
    def deflateFuture(buf: String | Buffer, options: CompressionOptions | NodeOptions = null) = {
      futureCallbackE1[Error, Buffer](zlib.deflate(buf, options, _))
    }

    /**
      * Asynchronously compresses a Buffer or string with DeflateRaw.
      */
    @inline
    def deflateRawFuture(buf: String | Buffer, options: CompressionOptions | NodeOptions = null) = {
      futureCallbackE1[Error, Buffer](zlib.deflateRaw(buf, options, _))
    }

    /**
      * Flush pending data. Don't call this frivolously, premature flushes negatively impact the effectiveness of the compression algorithm.
      */
    @inline
    def flushFuture(kind: CompressionFlush = null) = futureCallbackE1[Error, Buffer](zlib.flush(kind, _))

    /**
      * Compress a Buffer or string with Gzip.
      */
    @inline
    def gzipFuture(buf: String | Buffer, options: CompressionOptions | NodeOptions = null) = {
      futureCallbackE1[Error, Buffer](zlib.gzip(buf, options, _))
    }

    /**
      * Decompress a Buffer or string with Gunzip.
      */
    @inline
    def gunzipFuture(buf: String | Buffer, options: CompressionOptions | NodeOptions = null) = {
      futureCallbackE1[Error, Buffer](zlib.gunzip(buf, options, _))
    }

    /**
      * Decompress a Buffer or string with Inflate.
      */
    @inline
    def inflateFuture(buf: String | Buffer, options: CompressionOptions | NodeOptions = null) = {
      futureCallbackE1[Error, Buffer](zlib.inflate(buf, options, _))
    }

    /**
      * Decompress a Buffer or string with InflateRaw.
      */
    def inflateRawFuture(buf: String | Buffer, options: CompressionOptions | NodeOptions = null) = {
      futureCallbackE1[Error, Buffer](zlib.inflateRaw(buf, options, _))
    }

    /**
      * Dynamically update the compression level and compression strategy. Only applicable to deflate algorithm.
      * @example zlib.params(level, strategy, callback)
      */
    @inline
    def paramsFuture(level: CompressionLevel, strategy: CompressionStrategy) = {
      futureCallbackE1[Error, Buffer](zlib.params(level, strategy, _))
    }

    /**
      * Decompress a Buffer or string with Unzip.
      */
    @inline
    def unzipFuture(buf: String | Buffer, options: CompressionOptions | NodeOptions = null) = {
      futureCallbackE1[Error, Buffer](zlib.unzip(buf, options, _))
    }

  }

}