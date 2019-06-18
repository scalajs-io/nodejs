package io.scalajs.util

import scala.concurrent.duration._

/**
  * Duration Helper
  */
object DurationHelper {

  /////////////////////////////////////////////////////////////////////////
  //    Number to Duration
  /////////////////////////////////////////////////////////////////////////

  implicit def double2Duration(value: Double): FiniteDuration = value.millis

  implicit def int2Duration(value: Int): FiniteDuration = value.millis

  implicit def long2Duration(value: Long): FiniteDuration = value.millis

  /////////////////////////////////////////////////////////////////////////
  //   Duration to  Number
  /////////////////////////////////////////////////////////////////////////

  implicit def duration2Double(duration: Duration): Double = duration.toMillis

  implicit def duration2Int(duration: Duration): Int = duration.toMillis.toInt

  implicit def duration2Long(duration: Duration): Long = duration.toMillis

}
