package io.scalajs.nodejs.buffer

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Returns an un-pooled Buffer.
  *
  * In order to avoid the garbage collection overhead of creating many individually allocated Buffer instances,
  * by default allocations under 4KB are sliced from a single larger allocated object. This approach improves
  * both performance and memory usage since v8 does not need to track and cleanup as many Persistent objects.
  *
  * In the case where a developer may need to retain a small chunk of memory from a pool for an indeterminate
  * amount of time, it may be appropriate to create an un-pooled Buffer instance using SlowBuffer then copy
  * out the relevant bits.
  * @see https://nodejs.org/api/buffer.html#buffer_class_slowbuffer
  * @author lawrence.daniels@gmail.com
  */
@deprecated("Use Buffer.allocUnsafeSlow() instead.", since = "6.0.0")
@js.native
@JSImport("buffer", "SlowBuffer")
class SlowBuffer(size: Int) extends Buffer