package io.scalajs.nodejs.zlib

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.nodejs.events.IEventEmitter

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

/**
  * This provides bindings to Gzip/Gunzip, Deflate/Inflate, and DeflateRaw/InflateRaw classes.
  * Each class takes the same options, and is a readable/writable Stream.
  * @see https://nodejs.org/docs/latest/api/zlib.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Zlib extends IEventEmitter {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  // Allowed flush values
  val Z_NO_FLUSH: CompressionFlush      = js.native
  val Z_PARTIAL_FLUSH: CompressionFlush = js.native
  val Z_SYNC_FLUSH: CompressionFlush    = js.native
  val Z_FULL_FLUSH: CompressionFlush    = js.native
  val Z_FINISH: CompressionFlush        = js.native
  val Z_BLOCK: CompressionFlush         = js.native
  val Z_TREES: CompressionFlush         = js.native

  // Return codes for the compression/decompression functions.
  val Z_OK: CompressionFunction            = js.native
  val Z_STREAM_END: CompressionFunction    = js.native
  val Z_NEED_DICT: CompressionFunction     = js.native
  val Z_ERRNO: CompressionFunction         = js.native
  val Z_STREAM_ERROR: CompressionFunction  = js.native
  val Z_DATA_ERROR: CompressionFunction    = js.native
  val Z_MEM_ERROR: CompressionFunction     = js.native
  val Z_BUF_ERROR: CompressionFunction     = js.native
  val Z_VERSION_ERROR: CompressionFunction = js.native

  // Compression levels
  val Z_NO_COMPRESSION: CompressionLevel      = js.native
  val Z_BEST_SPEED: CompressionLevel          = js.native
  val Z_BEST_COMPRESSION: CompressionLevel    = js.native
  val Z_DEFAULT_COMPRESSION: CompressionLevel = js.native

  // Compression strategies
  val Z_FILTERED: CompressionStrategy         = js.native
  val Z_HUFFMAN_ONLY: CompressionStrategy     = js.native
  val Z_RLE: CompressionStrategy              = js.native
  val Z_FIXED: CompressionStrategy            = js.native
  val Z_DEFAULT_STRATEGY: CompressionStrategy = js.native

  // Possible values of the data_type field
  val Z_BINARY: DataType  = js.native
  val Z_TEXT: DataType    = js.native
  val Z_ASCII: DataType   = js.native
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
  def createDeflate(options: CompressionOptions | RawOptions): Deflate = js.native

  /**
    * Returns a new DeflateRaw object with an options.
    * @example zlib.createDeflateRaw(options)
    */
  def createDeflateRaw(options: CompressionOptions | RawOptions): DeflateRaw = js.native

  /**
    * Returns a new Gunzip object with an options.
    * @example zlib.createGunzip(options)
    */
  def createGunzip(options: CompressionOptions | RawOptions): Gunzip = js.native

  /**
    * Returns a new Gzip object with an options.
    * @example zlib.createGzip(options)
    */
  def createGzip(options: CompressionOptions | RawOptions): Gzip = js.native

  /**
    * Returns a new Inflate object with an options.
    * @example zlib.createInflate(options)
    */
  def createInflate(options: CompressionOptions | RawOptions): Inflate = js.native

  /**
    * Returns a new InflateRaw object with an options.
    * @example zlib.createInflateRaw(options)
    */
  def createInflateRaw(options: CompressionOptions | RawOptions): InflateRaw = js.native

  /**
    * Returns a new Unzip object with an options.
    * @example zlib.createUnzip(options)
    */
  def createUnzip(options: CompressionOptions | RawOptions): Unzip = js.native

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
  def deflate(buf: Buffer | String, options: CompressionOptions | RawOptions, callback: js.Function): Unit = js.native

  /**
    * Compress a Buffer or string with Deflate.
    * @example zlib.deflate(buf[, options], callback)
    */
  def deflate(buf: Buffer | String, callback: js.Function): Unit = js.native

  /**
    * Compress a Buffer or string with Deflate.
    * @example zlib.deflateSync(buf[, options])
    */
  def deflateSync(buf: Buffer | String, options: CompressionOptions | RawOptions = js.native): Unit = js.native

  /**
    * Compress a Buffer or string with DeflateRaw.
    * @example zlib.deflateRaw(buf[, options], callback)
    */
  def deflateRaw(buf: Buffer | String, options: CompressionOptions | RawOptions, callback: js.Function): Unit =
    js.native

  /**
    * Compress a Buffer or string with DeflateRaw.
    * @example zlib.deflateRaw(buf[, options], callback)
    */
  def deflateRaw(buf: Buffer | String, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Gunzip.
    * @example zlib.gunzip(buf[, options], callback)
    */
  def gunzip(buf: Buffer | String, options: CompressionOptions | RawOptions, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Gunzip.
    * @example zlib.gunzip(buf[, options], callback)
    */
  def gunzip(buf: Buffer | String, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Gunzip.
    * @example zlib.gunzipSync(buf[, options])
    */
  def gunzipSync(buf: Buffer | String, options: CompressionOptions | RawOptions = js.native): Unit = js.native

  /**
    * Compress a Buffer or string with Gzip.
    * @example zlib.gzip(buf[, options], callback)
    */
  def gzip(buf: Buffer | String, options: CompressionOptions | RawOptions, callback: js.Function): Unit = js.native

  /**
    * Compress a Buffer or string with Gzip.
    * @example zlib.gzip(buf[, options], callback)
    */
  def gzip(buf: Buffer | String, callback: js.Function): Unit = js.native

  /**
    * Compress a Buffer or string with Gzip.
    * @example zlib.gzipSync(buf[, options])
    */
  def gzipSync(buf: Buffer | String, options: CompressionOptions | RawOptions = js.native): Unit = js.native

  /**
    * Decompress a Buffer or string with Inflate.
    * @example zlib.inflate(buf[, options], callback)
    */
  def inflate(buf: Buffer | String, options: CompressionOptions | RawOptions, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Inflate.
    * @example zlib.inflate(buf[, options], callback)
    */
  def inflate(buf: Buffer | String, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Inflate.
    * @example zlib.inflateSync(buf[, options])
    */
  def inflateSync(buf: Buffer | String, options: CompressionOptions | RawOptions = js.native): Unit = js.native

  /**
    * Decompress a Buffer or string with InflateRaw.
    * @example zlib.inflateRaw(buf[, options], callback)
    */
  def inflateRaw(buf: Buffer | String, options: CompressionOptions | RawOptions, callback: js.Function): Unit =
    js.native

  /**
    * Decompress a Buffer or string with InflateRaw.
    * @example zlib.inflateRaw(buf[, options], callback)
    */
  def inflateRaw(buf: Buffer | String, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with InflateRaw.
    * @example zlib.inflateRawSync(buf[, options])
    */
  def inflateRawSync(buf: Buffer | String, options: CompressionOptions | RawOptions = js.native): Unit = js.native

  /**
    * Decompress a Buffer or string with Unzip.
    * @example zlib.unzip(buf[, options], callback)
    */
  def unzip(buf: Buffer | String, options: CompressionOptions | RawOptions, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Unzip.
    * @example zlib.unzip(buf[, options], callback)
    */
  def unzip(buf: Buffer | String, callback: js.Function): Unit = js.native

  /**
    * Decompress a Buffer or string with Unzip.
    * @example zlib.unzipSync(buf[, options])
    */
  def unzipSync(buf: Buffer | String, options: CompressionOptions | RawOptions = js.native): Unit = js.native

}

/**
  * Zlib Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("zlib", JSImport.Namespace)
object Zlib extends Zlib
