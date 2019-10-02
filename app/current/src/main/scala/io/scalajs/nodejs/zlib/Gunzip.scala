package io.scalajs.nodejs
package zlib

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Decompress a gzip stream.
  */
@js.native
@JSImport("zlib", "Gunzip")
class Gunzip extends ZlibBase
