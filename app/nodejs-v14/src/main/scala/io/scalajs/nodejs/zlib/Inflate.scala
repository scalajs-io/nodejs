package io.scalajs.nodejs
package zlib

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Decompress a deflate stream.
  */
@js.native
@JSImport("zlib", "Inflate")
class Inflate extends ZlibBase
