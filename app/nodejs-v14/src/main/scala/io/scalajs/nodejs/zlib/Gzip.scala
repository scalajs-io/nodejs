package io.scalajs.nodejs
package zlib

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Compress data using gzip.
  */
@js.native
@JSImport("zlib", "Gzip")
class Gzip extends ZlibBase
