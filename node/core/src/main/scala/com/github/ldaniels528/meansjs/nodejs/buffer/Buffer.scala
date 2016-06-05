package com.github.ldaniels528.meansjs.nodejs.buffer

import com.github.ldaniels528.meansjs.core.{JsIterator, optional}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Prior to the introduction of TypedArray in ECMAScript 2015 (ES6), the JavaScript language had no mechanism for
  * reading or manipulating streams of binary data. The Buffer class was introduced as part of the Node.js API to
  * make it possible to interact with octet streams in the context of things like TCP streams and file system operations.
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
trait Buffer extends js.Object {

  /**
    * @example {{{ buf.compare(target[, targetStart[, targetEnd[, sourceStart[, sourceEnd]]]]) }}}
    */
  @optional(fields = Seq("targetStart", "targetEnd", "sourceStart", "sourceEnd"))
  def compare2(target: Buffer, targetStart: Int, targetEnd: Int, sourceStart: Int, sourceEnd: Int): Int = js.native

  /**
    * @example {{{ buf.compare(target[, targetStart[, targetEnd[, sourceStart[, sourceEnd]]]]) }}}
    */
  def compare(target: Buffer, targetStart: Int, targetEnd: Int, sourceStart: Int, sourceEnd: Int): Int = js.native

  def compare(target: Buffer, targetStart: Int, targetEnd: Int, sourceStart: Int): Int = js.native

  def compare(target: Buffer, targetStart: Int, targetEnd: Int): Int = js.native

  def compare(target: Buffer, targetStart: Int): Int = js.native

  def compare(target: Buffer): Int = js.native

  /**
    * Creates and returns an iterator of [index, byte] pairs from the Buffer contents.
    */
  def entries(): JsIterator[js.Array[Int]] = js.native

  def toString(encoding: String): String = js.native

}

@js.native
@JSName("Buffer")
object Buffer extends BufferClass