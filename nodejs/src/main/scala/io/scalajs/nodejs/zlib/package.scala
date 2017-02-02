package io.scalajs.nodejs

import io.scalajs.RawOptions
import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.ScalaJsHelper.futureCallbackE1

import scala.concurrent.Promise
import scala.scalajs.js.|

/**
  * zlib package object
  * @author lawrence.daniels@gmail.com
  */
package object zlib {

  type AllocationType        = Integer
  type CompressionFlush      = Integer
  type CompressionFunction   = Integer
  type CompressionLevel      = Integer
  type CompressionStrategy   = Integer
  type DataType              = Integer
  type DeflateCompressMethod = Integer

  /**
    * Zlib Extensions
    * @author lawrence.daniels@gmail.com
    */
  final implicit class ZlibExtensions(val zlib: Zlib) extends AnyVal {

    /**
      * Asynchronously compresses a Buffer or string with Deflate.
      */
    @inline
    def deflateFuture(buf: String | Buffer, options: CompressionOptions | RawOptions = null): Promise[Buffer] = {
      futureCallbackE1[Error, Buffer](zlib.deflate(buf, options, _))
    }

    /**
      * Asynchronously compresses a Buffer or string with DeflateRaw.
      */
    @inline
    def deflateRawFuture(buf: String | Buffer, options: CompressionOptions | RawOptions = null): Promise[Buffer] = {
      futureCallbackE1[Error, Buffer](zlib.deflateRaw(buf, options, _))
    }

    /**
      * Flush pending data. Don't call this frivolously, premature flushes negatively impact the effectiveness of the compression algorithm.
      */
    @inline
    def flushFuture(kind: CompressionFlush = null): Promise[Buffer] =
      futureCallbackE1[Error, Buffer](zlib.flush(kind, _))

    /**
      * Compress a Buffer or string with Gzip.
      */
    @inline
    def gzipFuture(buf: String | Buffer, options: CompressionOptions | RawOptions = null): Promise[Buffer] = {
      futureCallbackE1[Error, Buffer](zlib.gzip(buf, options, _))
    }

    /**
      * Decompress a Buffer or string with Gunzip.
      */
    @inline
    def gunzipFuture(buf: String | Buffer, options: CompressionOptions | RawOptions = null): Promise[Buffer] = {
      futureCallbackE1[Error, Buffer](zlib.gunzip(buf, options, _))
    }

    /**
      * Decompress a Buffer or string with Inflate.
      */
    @inline
    def inflateFuture(buf: String | Buffer, options: CompressionOptions | RawOptions = null): Promise[Buffer] = {
      futureCallbackE1[Error, Buffer](zlib.inflate(buf, options, _))
    }

    /**
      * Decompress a Buffer or string with InflateRaw.
      */
    def inflateRawFuture(buf: String | Buffer, options: CompressionOptions | RawOptions = null): Promise[Buffer] = {
      futureCallbackE1[Error, Buffer](zlib.inflateRaw(buf, options, _))
    }

    /**
      * Dynamically update the compression level and compression strategy. Only applicable to deflate algorithm.
      * @example zlib.params(level, strategy, callback)
      */
    @inline
    def paramsFuture(level: CompressionLevel, strategy: CompressionStrategy): Promise[Buffer] = {
      futureCallbackE1[Error, Buffer](zlib.params(level, strategy, _))
    }

    /**
      * Decompress a Buffer or string with Unzip.
      */
    @inline
    def unzipFuture(buf: String | Buffer, options: CompressionOptions | RawOptions = null): Promise[Buffer] = {
      futureCallbackE1[Error, Buffer](zlib.unzip(buf, options, _))
    }

  }

}
