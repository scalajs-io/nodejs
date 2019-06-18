package io.scalajs.npm.throttle

import io.scalajs.nodejs.stream.{Readable, Writable}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * throttle - Node.js Transform stream that passes data through at n bytes per second
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("throttle", name = JSImport.Namespace)
class Throttle(options: ThrottleOptions) extends Readable with Writable {

  def this(rate: Double) = this(null)

}

/**
  * Throttle Options
  * @param bps           the rate in bytes/second
  * @param chunkSize     the chunk size in bytes
  * @param highWaterMark the high water mark
  */

class ThrottleOptions(val bps: js.UndefOr[Double] = js.undefined,
                      val chunkSize: js.UndefOr[Double] = js.undefined,
                      val highWaterMark: js.UndefOr[Double] = js.undefined) extends js.Object