package io.scalajs.npm.streamthrottle

import io.scalajs.FlexibleOptions

import scala.scalajs.js


/**
  * Throttle Options
  * @param rate      is the throttling rate, in bytes per second.
  * @param chunksize (optional) is the maximum chunk size into which larger writes are decomposed;
  *                  the default is opts.rate/10.
  */
class ThrottleOptions(var rate: Double,
                      var chunksize: js.UndefOr[Double] = js.undefined)
  extends js.Object

/**
  * Throttle Options
  * @author lawrence.daniels@gmail.com
  */
object ThrottleOptions extends FlexibleOptions[ThrottleOptions]