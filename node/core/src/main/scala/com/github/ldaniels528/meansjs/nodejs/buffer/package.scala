package com.github.ldaniels528.meansjs.nodejs

import scala.scalajs.js

/**
  * buffer package object
  */
package object buffer {

  /**
    * Buffer Extensions
    * @author lawrence.daniels@gmail.com
    */
  implicit class BufferExtensions(val buffer: Buffer) extends AnyVal {

    /**
      * Syntactic sugar for concatenating a buffer
      * @param aBuffer another buffer
      * @return a new buffer with the concatenated contents of both buffers
      */
    def +(aBuffer: Buffer) = Buffer.concat(js.Array(buffer, aBuffer))

    /**
      * Returns the actual byte length of a string. This is not the same as String.prototype.length since that returns
      * the number of characters in a string.
      * @param encoding the optional encoding (default "utf8")
      */
    def byteLength(encoding: String = "utf8"): Int = Buffer.byteLength(buffer, encoding)

  }

}
