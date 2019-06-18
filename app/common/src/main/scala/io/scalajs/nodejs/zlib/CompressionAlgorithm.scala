package io.scalajs.nodejs.zlib

import io.scalajs.nodejs.stream

import scala.scalajs.js

/**
  * Compression Algorithm
  */
@js.native
trait CompressionAlgorithm extends stream.Readable with stream.Writable
