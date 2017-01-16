package io.scalajs.npm

import scala.concurrent.duration.FiniteDuration
import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * Angularjs Package Object
  * @author lawrence.daniels@gmail.com
  */
package object angularjs {

  //////////////////////////////////////////////////////////////
  //    Globals
  //////////////////////////////////////////////////////////////

  /**
    * Singleton "angular" instance
    */
  @js.native
  @JSName("angular")
  object angular extends Angular

  //////////////////////////////////////////////////////////////
  //    Type Definitions
  //////////////////////////////////////////////////////////////

  /**
    * Generically represents Angular options
    */
  type AngularOptions = js.Dictionary[_] | js.Object

  //////////////////////////////////////////////////////////////
  //    Implicit Conversions
  //////////////////////////////////////////////////////////////

  implicit def durationToInt(duration: FiniteDuration): Int = duration.toMillis.toInt

  implicit def durationToLong(duration: FiniteDuration): Double = duration.toMillis

}
