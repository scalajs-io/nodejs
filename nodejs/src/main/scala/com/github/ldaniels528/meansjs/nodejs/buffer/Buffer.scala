package com.github.ldaniels528.meansjs.nodejs.buffer

import scala.scalajs.js

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
    * When passed a reference to the .buffer property of a TypedArray instance, the newly created Buffer
    * will share the same allocated memory as the TypedArray.
    * @example Buffer.from(arrayBuffer[, byteOffset[, length]])
    **/
  def from(arrayBuffer: ArrayBuffer, byteOffset: Int, length: Int): this.type

  /**
    * When passed a reference to the .buffer property of a TypedArray instance, the newly created Buffer
    * will share the same allocated memory as the TypedArray.
    * @example Buffer.from(arrayBuffer[, byteOffset[, length]])
    **/
  def from(arrayBuffer: ArrayBuffer, byteOffset: Int): this.type

  /**
    * When passed a reference to the .buffer property of a TypedArray instance, the newly created Buffer
    * will share the same allocated memory as the TypedArray.
    * @example Buffer.from(arrayBuffer[, byteOffset[, length]])
    **/
  def from(arrayBuffer: ArrayBuffer): this.type

  /**
    * Allocates a new Buffer using an array of octets.
    * @example Buffer.from(array)
    */
  def from(array: js.Array[js.Any]): this.type

}
