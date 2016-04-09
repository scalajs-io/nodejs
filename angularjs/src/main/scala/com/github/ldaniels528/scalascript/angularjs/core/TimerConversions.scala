package com.github.ldaniels528.nodesjs.angularjs.core

import scala.concurrent.duration._
import scala.language.implicitConversions

/**
 * Timer Conversions
 * @author lawrence.daniels@gmail.com
 */
object TimerConversions {

  //////////////////////////////////////////////////////////////
  //    Implicit Conversions
  //////////////////////////////////////////////////////////////

  implicit def durationToInt(duration: FiniteDuration): Int = duration.toMillis.toInt

  implicit def durationToLong(duration: FiniteDuration): Long = duration.toMillis

}