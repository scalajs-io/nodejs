package io.scalajs.nodejs.os

import scala.scalajs.js

/**
  * Operating System Constants
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait OSConstants extends js.Object {

  /**
    * The lowest process scheduling priority. This corresponds to IDLE_PRIORITY_CLASS on Windows,
    * and a nice value of 19 on all other platforms.
    */
  val PRIORITY_LOW: Priority = js.native

  /**
    * The process scheduling priority above PRIORITY_LOW and below PRIORITY_NORMAL. This corresponds to
    * BELOW_NORMAL_PRIORITY_CLASS on Windows, and a nice value of 10 on all other platforms.
    */
  val PRIORITY_BELOW_NORMAL: Priority = js.native

  /**
    * The default process scheduling priority. This corresponds to NORMAL_PRIORITY_CLASS on Windows,
    * and a nice value of 0 on all other platforms.
    */
  val PRIORITY_NORMAL: Priority = js.native

  /**
    * The process scheduling priority above PRIORITY_NORMAL and below PRIORITY_HIGH.
    * This corresponds to ABOVE_NORMAL_PRIORITY_CLASS on Windows, and a nice value of -7 on all other platforms.
    */
  val PRIORITY_ABOVE_NORMAL: Priority = js.native

  /**
    * The process scheduling priority above PRIORITY_ABOVE_NORMAL and below PRIORITY_HIGHEST.
    * This corresponds to HIGH_PRIORITY_CLASS on Windows, and a nice value of -14 on all other platforms.
    */
  val PRIORITY_HIGH: Priority = js.native

  /**
    * The highest process scheduling priority. This corresponds to REALTIME_PRIORITY_CLASS on Windows,
    * and a nice value of -20 on all other platforms.
    */
  val PRIORITY_HIGHEST: Priority = js.native

}
