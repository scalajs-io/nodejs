package io.scalajs.nodejs
package zlib

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Compress data using deflate, and do not append a zlib header.
  */
@js.native
@JSImport("zlib", "DeflateRaw")
class DeflateRaw extends ZlibBase
