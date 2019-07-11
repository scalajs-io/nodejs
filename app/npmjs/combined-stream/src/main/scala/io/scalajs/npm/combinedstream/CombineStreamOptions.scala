package io.scalajs.npm.combinedstream

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Combine Stream Options
  * @param maxDataSize  Whether to apply back pressure to the underlying streams. If set to false,
  *                     the underlying streams will never be paused. If set to true, the underlying
  *                     streams will be paused right after being appended, as well as when
  *                     delayedStream.pipe() wants to throttle.
  * @param pauseStreams The maximum amount of bytes (or characters) to buffer for all source streams.
  *                     If this value is exceeded, combinedStream emits an 'error' event.
  * @author lawrence.daniels@gmail.com
  */
class CombineStreamOptions(var maxDataSize: js.UndefOr[Int] = js.undefined,
                           var pauseStreams: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Combine Stream Options Companion
  * @author lawrence.daniels@gmail.com
  */
object CombineStreamOptions extends FlexibleOptions[CombineStreamOptions]