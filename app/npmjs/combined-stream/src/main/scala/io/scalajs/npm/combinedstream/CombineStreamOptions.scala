package io.scalajs.npm.combinedstream

import io.scalajs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * CombineStream Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CombineStreamOptions extends js.Object {
  var maxDataSize: js.UndefOr[Int] = js.undefined
  var pauseStreams: js.UndefOr[Boolean] = js.undefined
}

/**
  * CombineStream Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CombineStreamOptions {

  /**
    * CombineStream Options
    * @param maxDataSize  Whether to apply back pressure to the underlying streams. If set to false,
    *                     the underlying streams will never be paused. If set to true, the underlying
    *                     streams will be paused right after being appended, as well as when
    *                    delayedStream.pipe() wants to throttle.
    * @param pauseStreams The maximum amount of bytes (or characters) to buffer for all source streams.
    *                     If this value is exceeded, combinedStream emits an 'error' event.
    */
  def apply(maxDataSize: js.UndefOr[Int] = js.undefined,
            pauseStreams: js.UndefOr[Boolean] = js.undefined): CombineStreamOptions = {
    val options = New[CombineStreamOptions]
    maxDataSize.foreach(options.maxDataSize = _)
    pauseStreams.foreach(options.pauseStreams = _)
    options
  }

}