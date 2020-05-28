package io.scalajs.nodejs

import io.scalajs.nodejs.buffer.Buffer
import io.scalajs.util.PromiseHelper._

import scala.concurrent.Future
import scala.scalajs.js.typedarray.{ArrayBuffer, DataView, TypedArray}
import scala.scalajs.js.|

/**
  * zlib package object
  */
package object zlib {
  type Data                  = String | TypedArray[_, _] | DataView | ArrayBuffer
  type AllocationType        = Int
  type CompressionFlush      = Int
  type CompressionFunction   = Int
  type CompressionLevel      = Int
  type CompressionStrategy   = Int
  type DataType              = Int
  type DeflateCompressMethod = Int

  /**
    * Zlib Extensions
    */
  implicit final class ZlibExtensions[T <: Zlib](private val zlib: T) extends AnyVal {

    /**
      * Asynchronously compresses a Buffer or string with Deflate.
      */
    @inline
    def deflateFuture(buffer: Data, options: CompressionOptions = null): Future[Buffer] = {
      promiseWithError1[Error, Buffer](zlib.deflate(buffer, options, _))
    }

    /**
      * Asynchronously compresses a Buffer or string with DeflateRaw.
      */
    @inline
    def deflateRawFuture(buffer: Data, options: CompressionOptions = null): Future[Buffer] = {
      promiseWithError1[Error, Buffer](zlib.deflateRaw(buffer, options, _))
    }

    /**
      * Compress a Buffer or string with Gzip.
      */
    @inline
    def gzipFuture(buffer: Data, options: CompressionOptions = null): Future[Buffer] = {
      promiseWithError1[Error, Buffer](zlib.gzip(buffer, options, _))
    }

    /**
      * Decompress a Buffer or string with Gunzip.
      */
    @inline
    def gunzipFuture(buffer: Data, options: CompressionOptions = null): Future[Buffer] = {
      promiseWithError1[Error, Buffer](zlib.gunzip(buffer, options, _))
    }

    /**
      * Decompress a Buffer or string with Inflate.
      */
    @inline
    def inflateFuture(buffer: Data, options: CompressionOptions = null): Future[Buffer] = {
      promiseWithError1[Error, Buffer](zlib.inflate(buffer, options, _))
    }

    /**
      * Decompress a Buffer or string with InflateRaw.
      */
    def inflateRawFuture(buffer: Data, options: CompressionOptions = null): Future[Buffer] = {
      promiseWithError1[Error, Buffer](zlib.inflateRaw(buffer, options, _))
    }

    /**
      * Decompress a Buffer or string with Unzip.
      */
    @inline
    def unzipFuture(buffer: Data, options: CompressionOptions = null): Future[Buffer] = {
      promiseWithError1[Error, Buffer](zlib.unzip(buffer, options, _))
    }
  }
}
