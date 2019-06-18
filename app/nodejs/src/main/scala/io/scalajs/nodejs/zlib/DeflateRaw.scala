package io.scalajs.nodejs
package zlib

import scala.scalajs.js

/**
  * Compress data using deflate, and do not append a zlib header.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DeflateRaw extends CompressionAlgorithm