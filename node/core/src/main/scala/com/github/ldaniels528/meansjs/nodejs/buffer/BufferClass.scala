package com.github.ldaniels528.meansjs.nodejs.buffer

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.typedarray.ArrayBuffer

/**
  * Prior to the introduction of TypedArray in ECMAScript 2015 (ES6), the JavaScript language had no mechanism
  * for reading or manipulating streams of binary data. The Buffer class was introduced as part of the Node.js API
  * to make it possible to interact with octet streams in the context of things like TCP streams and file system operations.
  *
  * Now that TypedArray has been added in ES6, the Buffer class implements the Uint8Array API in a manner that is more
  * optimized and suitable for Node.js' use cases.
  *
  * Instances of the Buffer class are similar to arrays of integers but correspond to fixed-sized, raw memory
  * allocations outside the V8 heap. The size of the Buffer is established when it is created and cannot be resized.
  *
  * The Buffer class is a global within Node.js, making it unlikely that one would need to ever use require('buffer').
  * @version 6.2.1
  */
@js.native
trait BufferClass extends js.Object {

  /**
    * Allocates a new Buffer of size bytes. If fill is undefined, the Buffer will be zero-filled.
    * @example {{{ Buffer.alloc(size[, fill[, encoding]]) }}}
    */
  def alloc(size: Int, fill: Int, encoding: String): Buffer = js.native

  /**
    * Allocates a new Buffer of size bytes. If fill is undefined, the Buffer will be zero-filled.
    * @example {{{ Buffer.alloc(size[, fill[, encoding]]) }}}
    */
  def alloc(size: Int, encoding: String = null): Buffer = js.native

  /**
    * Calling Buffer.alloc(size) can be significantly slower than the alternative Buffer.allocUnsafe(size) but ensures
    * that the newly created Buffer instance contents will never contain sensitive data.
    * @param size the allocated size.
    * @example Buffer.allocUnsafe(size)
    */
  def allocUnsafe(size: Int): Buffer = js.native

  /**
    * Allocates a new non-zero-filled and non-pooled Buffer of size bytes. The size must be less than or equal to the
    * value of require('buffer').kMaxLength (on 64-bit architectures, kMaxLength is {{{ (2^31)-1). }}} Otherwise, a RangeError
    * is thrown. A zero-length Buffer will be created if a size less than or equal to 0 is specified.
    *
    * The underlying memory for Buffer instances created in this way is not initialized. The contents of the newly
    * created Buffer are unknown and may contain sensitive data. Use buf.fill(0) to initialize such Buffer instances to zeroes.
    *
    * When using Buffer.allocUnsafe() to allocate new Buffer instances, allocations under 4KB are, by default, sliced
    * from a single pre-allocated Buffer. This allows applications to avoid the garbage collection overhead of creating
    * many individually allocated Buffers. This approach improves both performance and memory usage by eliminating the
    * need to track and cleanup as many Persistent objects.
    *
    * However, in the case where a developer may need to retain a small chunk of memory from a pool for an indeterminate
    * amount of time, it may be appropriate to create an un-pooled Buffer instance using Buffer.allocUnsafeSlow() then
    * copy out the relevant bits.
    * @param size the allocated size.
    * @example Buffer.allocUnsafeSlow(size)
    */
  def allocUnsafeSlow(size: Int): Buffer = js.native

  /**
    * Returns the actual byte length of a string. This is not the same as String.prototype.length since that returns
    * the number of characters in a string.
    * @param string   <String> | <Buffer> | <TypedArray> | <DataView> | <ArrayBuffer>
    * @param encoding the optional encoding (default "utf8")
    * @example Buffer.byteLength(string[, encoding])
    */
  def byteLength(string: js.Any, encoding: String = "utf8"): Int = js.native

  /**
    * Compares buf1 to buf2 typically for the purpose of sorting arrays of Buffers.
    * This is equivalent is calling buf1.compare(buf2).
    */
  def compare(buf1: Buffer, buf2: Buffer): Int = js.native

  /**
    * Returns a new Buffer which is the result of concatenating all the Buffers in the list together.
    * If the list has no items, or if the totalLength is 0, then a new zero-length Buffer is returned.
    * If totalLength is not provided, it is calculated from the Buffers in the list. This, however, adds an additional
    * loop to the function, so it is faster to provide the length explicitly.
    * @param list        the list of Buffer objects to concat
    * @param totalLength the optional total length
    * @example Buffer.concat(list[, totalLength])
    */
  def concat(list: js.Array[Buffer], totalLength: Int): Buffer = js.native

  /**
    * Returns a new Buffer which is the result of concatenating all the Buffers in the list together.
    * If the list has no items, or if the totalLength is 0, then a new zero-length Buffer is returned.
    * If totalLength is not provided, it is calculated from the Buffers in the list. This, however, adds an additional
    * loop to the function, so it is faster to provide the length explicitly.
    * @param list the list of Buffer objects to concat
    * @example Buffer.concat(list[, totalLength])
    */
  def concat(list: js.Array[Buffer]): Buffer = js.native

  /**
    * When passed a reference to the .buffer property of a TypedArray instance, the newly created Buffer
    * will share the same allocated memory as the TypedArray.
    * @example {{{ Buffer.from(arrayBuffer[, byteOffset[, length]]) }}}
    **/
  def from(arrayBuffer: ArrayBuffer, byteOffset: Int, length: Int): Buffer = js.native

  /**
    * When passed a reference to the .buffer property of a TypedArray instance, the newly created Buffer
    * will share the same allocated memory as the TypedArray.
    * @example {{{ Buffer.from(arrayBuffer[, byteOffset[, length]]) }}}
    **/
  def from(arrayBuffer: ArrayBuffer, byteOffset: Int): Buffer = js.native

  /**
    * When passed a reference to the .buffer property of a TypedArray instance, the newly created Buffer
    * will share the same allocated memory as the TypedArray.
    * @example {{{ Buffer.from(arrayBuffer[, byteOffset[, length]]) }}}
    **/
  def from(arrayBuffer: ArrayBuffer): Buffer = js.native

  /**
    * Allocates a new Buffer using an array of octets.
    * @example Buffer.from(array)
    */
  def from(array: js.Array[Int]): Buffer = js.native

  /**
    * Creates a new Buffer containing the given JavaScript string str. If provided, the encoding parameter identifies
    * the strings character encoding.
    * @param str      the source string
    * @param encoding the given encoding
    * @return a new Buffer
    */
  def from(str: String, encoding: String): Buffer = js.native

  def from(str: String): Buffer = js.native

  def isBuffer(value: js.Any): Boolean = js.native

  def isEncoding(encoding: String): Boolean = js.native

}

/**
  * Buffer Class Companion
  * @author lawrence.daniels@gmail.com
  */
object BufferClass {

  /**
    * Buffer Class Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class BufferClassExtensions(val `class`: BufferClass) extends AnyVal {

    /**
      * new Buffer(size)
      */
    @inline
    def apply(size: Int) = `class`.New[Buffer](size)

    /**
      * new Buffer(str, [encoding])
      */
    @inline
    @deprecated("Use Buffer.from(str[, encoding]) instead.", since = "6.0.0")
    def apply(str: String, encoding: String) = `class`.New[Buffer](str)

    /**
      * new Buffer(str, [encoding])
      */
    @inline
    @deprecated("Use Buffer.from(str[, encoding]) instead.", since = "6.0.0")
    def apply(str: String) = `class`.New[Buffer](str)

    /**
      * @example new Buffer(array)
      */
    @inline
    @deprecated("Use Buffer.from(array) instead.", since = "6.0.0")
    def apply(array: js.Array[Int]) = `class`.New[Buffer](array)

    /**
      * @example new Buffer(buffer)
      */
    @inline
    @deprecated("Use Buffer.from(buffer) instead.", since = "6.0.0")
    def apply(buffer: Buffer) = `class`.New[Buffer](buffer)

    /**
      * @example {{{ new Buffer(arrayBuffer[, byteOffset[, length]]) }}}
      */
    @inline
    @deprecated("Use Buffer.from(arrayBuffer[, byteOffset [, length]]) instead.", since = "6.0.0")
    def apply(arrayBuffer: ArrayBuffer, byteOffset: Int, length: Int) = `class`.New[Buffer](arrayBuffer, byteOffset, length)

    /**
      * @example {{{ new Buffer(arrayBuffer[, byteOffset[, length]]) }}}
      */
    @inline
    @deprecated("Use Buffer.from(arrayBuffer[, byteOffset [, length]]) instead.", since = "6.0.0")
    def apply(arrayBuffer: ArrayBuffer, byteOffset: Int) = `class`.New[Buffer](arrayBuffer, byteOffset)

    /**
      * @example {{{ new Buffer(arrayBuffer[, byteOffset[, length]]) }}}
      */
    @inline
    @deprecated("Use Buffer.from(arrayBuffer[, byteOffset [, length]]) instead.", since = "6.0.0")
    def apply(arrayBuffer: ArrayBuffer) = `class`.New[Buffer](arrayBuffer)

  }

}