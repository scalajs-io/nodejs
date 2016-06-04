package com.github.ldaniels528.meansjs.nodejs.buffer

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

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
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BufferClass extends js.Object {

  /**
    * @example {{{ Buffer.alloc(size[, fill[, encoding]]) }}}
    */
  def alloc(size: Int, fill: Int, encoding: String): Buffer = js.native

  /**
    * Compares buf1 to buf2 typically for the purpose of sorting arrays of Buffers.
    * This is equivalent is calling buf1.compare(buf2).
    */
  def compare(buf1: Buffer, buf2: Buffer): Int = js.native

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

  def from(str: String, encoding: String): Buffer = js.native

  def from(str: String): Buffer = js.native

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
    def apply(str: String, encoding: String) = `class`.New[Buffer](str)

    /**
      * new Buffer(str, [encoding])
      */
    @inline
    def apply(str: String) = `class`.New[Buffer](str)

    /**
      * @example new Buffer(array)
      */
    @inline
    def apply(array: js.Array[Int]) = `class`.New[Buffer](array)

    /**
      * @example new Buffer(buffer)
      */
    @inline
    def apply(buffer: Buffer) = `class`.New[Buffer](buffer)

    /**
      * @example {{{ new Buffer(arrayBuffer[, byteOffset[, length]]) }}}
      */
    @inline
    def apply(arrayBuffer: ArrayBuffer, byteOffset: Int, length: Int) = `class`.New[Buffer](arrayBuffer, byteOffset, length)

    /**
      * @example {{{ new Buffer(arrayBuffer[, byteOffset[, length]]) }}}
      */
    @inline
    def apply(arrayBuffer: ArrayBuffer, byteOffset: Int) = `class`.New[Buffer](arrayBuffer, byteOffset)

    /**
      * @example {{{ new Buffer(arrayBuffer[, byteOffset[, length]]) }}}
      */
    @inline
    def apply(arrayBuffer: ArrayBuffer) = `class`.New[Buffer](arrayBuffer)

  }

}