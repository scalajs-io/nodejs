package io.scalajs.npm.readablestream

import io.scalajs.nodejs.stream

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * readable-stream - Streams3, a user-land copy of the stream library from Node.js
  * @see https://www.npmjs.com/package/readable-stream
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("readable-stream", "Readable")
class Readable extends stream.Readable