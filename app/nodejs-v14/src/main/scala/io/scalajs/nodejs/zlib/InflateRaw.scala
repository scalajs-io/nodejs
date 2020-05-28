package io.scalajs.nodejs
package zlib

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Decompress a raw deflate stream.
  */
@js.native
@JSImport("zlib", "InflateRaw")
class InflateRaw extends ZlibBase
