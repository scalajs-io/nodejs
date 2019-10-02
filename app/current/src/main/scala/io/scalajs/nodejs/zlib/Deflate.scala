package io.scalajs.nodejs
package zlib

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Compress data using deflate.
  */
@js.native
@JSImport("zlib", "Deflate")
class Deflate extends ZlibBase
