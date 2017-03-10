package io.scalajs.nodejs
package zlib

import scala.scalajs.js

/**
  * Decompress a deflate stream.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Inflate extends CompressionAlgorithm with stream.Readable