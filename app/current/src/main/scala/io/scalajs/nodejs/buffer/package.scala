package io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.Uint8Array

/**
  * buffer package object
  */
package object buffer {

  /////////////////////////////////////////////////////////////////////////////////
  //      Buffer Extensions
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Buffer Extensions
    */
  implicit final class BufferExtensions(val buffer: Buffer) extends AnyVal {

    /**
      * Syntactic sugar for concatenating a buffer
      *
      * @param aBuffer another buffer
      * @return a new buffer with the concatenated contents of both buffers
      */
    @inline
    def +(aBuffer: Buffer): Buffer = Buffer.concat(js.Array(buffer, aBuffer))

    /**
      * Returns the actual byte length of a string. This is not the same as String.prototype.length since that returns
      * the number of characters in a string.
      *
      * @param encoding the optional encoding (default "utf8")
      */
    @inline
    def byteLength(encoding: String = "utf8"): Int = Buffer.byteLength(buffer, encoding)

    /**
      * Returns the hex-formatted string
      *
      * @return the hex-formatted string
      */
    @inline
    def toHexString: String = buffer.entries().toIterator.flatMap(_.lastOption).map(n => f"$n%02x").mkString
  }

  /**
    * Buffer Extensions
    */
  implicit final class BufferObjExtensions(val unused: Buffer.type) extends AnyVal {
    def transcode(source: Uint8Array, fromEnc: String, toEnc: String): Buffer =
      BufferNamespace.transcode(source, fromEnc, toEnc)
    def INSPECT_MAX_BYTES = BufferNamespace.INSPECT_MAX_BYTES
    def kMaxLength        = BufferNamespace.kMaxLength
    def constants         = io.scalajs.nodejs.buffer.constants
  }

  /**
    * Re-encodes the given `Buffer` or `Uint8Array` instance from one character encoding to another.
    * Returns a new `Buffer` instance.
    *
    * Throws if the `fromEnc` or `toEnc` specify invalid character encodings or if conversion from `fromEnc` to `toEnc``
    * is not permitted.
    *
    * Encodings supported by `buffer.transcode()` are: 'ascii', 'utf8', 'utf16le', 'ucs2', 'latin1', and 'binary'.
    *
    * The transcoding process will use substitution characters if a given byte sequence cannot be adequately
    * represented in the target encoding.
    *
    * @param source  A Buffer instance
    * @param fromEnc The current encoding
    * @param toEnc   To target encoding
    * @return a new Buffer instance.
    * @see [[https://nodejs.org/api/buffer.html#buffer_buffer_transcode_source_fromenc_toenc]]
    */
  def transcode(source: Uint8Array, fromEnc: String, toEnc: String): Buffer =
    BufferNamespace.transcode(source, fromEnc, toEnc)

  /**
    * Returns the maximum number of bytes that will be returned when buf.inspect() is called.
    * This can be overridden by user modules. See util.inspect() for more details on buf.inspect() behavior.
    *
    * Note that this is a property on the buffer module returned by require('buffer'), not on the
    * Buffer global or a Buffer instance.
    */
  val INSPECT_MAX_BYTES = BufferNamespace.INSPECT_MAX_BYTES

  /**
    * On 32-bit architectures, this value is (2^30)-1 (~1GB). On 64-bit architectures, this value is (2^31)-1 (~2GB).F
    * Note that this is a property on the buffer module returned by require('buffer'), not on the Buffer global or a Buffer instance.
    */
  val kMaxLength = BufferNamespace.kMaxLength

  @js.native
  @JSImport("buffer", JSImport.Namespace)
  private object BufferNamespace extends js.Object {
    val INSPECT_MAX_BYTES: Int                                                = js.native
    val kMaxLength: Int                                                       = js.native
    def transcode(source: Uint8Array, fromEnc: String, toEnc: String): Buffer = js.native
  }

  @js.native
  @JSImport("buffer", "constants")
  object constants extends js.Object {

    /**
      * The largest size allowed for a single `Buffer` instance.
      *
      * On 32-bit architectures, this value is `(2^30)-1` (~1GB).
      * On 64-bit architectures, this value is `(2^31)-1` (~2GB).
      *
      * This value is also available as [[Buffer.kMaxLength]].
      */
    val MAX_LENGTH: Int = js.native

    /**
      * The largest length allowed for a single `String` instance.
      *
      * Represents the largest `length` that a `String` primitive can have, counted in UTF-16 code units.
      *
      * This value may depend on the JS engine that is being used.
      */
    val MAX_STRING_LENGTH: Int = js.native
  }

}
