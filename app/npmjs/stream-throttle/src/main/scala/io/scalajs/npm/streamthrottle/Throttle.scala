package io.scalajs.npm.streamthrottle

import io.scalajs.nodejs.stream.Transform

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Throttle creates a single throttled stream, based on stream.Transform.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("stream-throttle", "Throttle")
class Throttle(options: ThrottleOptions) extends Transform