package io.scalajs.npm.winston
package transports

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Daily Rotate Transport
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("winston", "transports.DailyRotateFile")
class DailyRotateFile(options: DailyRotateFileOptions = js.native) extends Transport

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

class DailyRotateFileOptions(val filename: js.UndefOr[String] = js.undefined,
                             val datePattern: js.UndefOr[String] = js.undefined,
                             val prepend: js.UndefOr[Boolean] = js.undefined,
                             val level: js.UndefOr[String] = js.undefined,
                             val formatter: js.UndefOr[js.Function1[DailyRotateFileOptions, String]] = js.undefined,
                             val timestamp: js.UndefOr[js.Function1[Unit, Double]] = js.undefined)
  extends js.Object
