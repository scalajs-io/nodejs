package io.scalajs.npm.winston.transports

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Daily Rotate Transport Options
  * @param filename    the base name of the log file (e.g. "rotating.log" becomes "2017-02-12.rotating.log")
  * @param datePattern A string representing the pattern to be used when appending the date to the
  *                    filename (default 'yyyy-MM-dd'). The meta characters used in this string will
  *                    dictate the frequency of the file rotation. For example, if your datePattern
  *                    is simply 'HH' you will end up with 24 log files that are picked up and appended
  *                    to every day.
  * @param prepend     Defines if the rolling time of the log file should be prepended at the beginning
  *                    of the filename (default 'false').
  * @param level       the logging level
  */

class DailyRotateFileOptions(var filename: js.UndefOr[String] = js.undefined,
                             var datePattern: js.UndefOr[String] = js.undefined,
                             var prepend: js.UndefOr[Boolean] = js.undefined,
                             var level: js.UndefOr[String] = js.undefined,
                             var formatter: js.UndefOr[js.Function1[DailyRotateFileOptions, String]] = js.undefined,
                             var timestamp: js.UndefOr[js.Function1[Unit, Double]] = js.undefined)
  extends js.Object

/**
  * Daily Rotate File Transport Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DailyRotateFileOptions extends FlexibleOptions[DailyRotateFileOptions]