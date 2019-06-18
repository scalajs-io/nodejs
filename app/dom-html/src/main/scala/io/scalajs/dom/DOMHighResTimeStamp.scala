package io.scalajs.dom

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * The DOMHighResTimeStamp type is a double and is used to store a time value. The value could be a discrete point in
  * time or the difference in time between two discrete points in time. The unit is milliseconds and should be accurate
  * to 5 µs (microseconds). However, if the browser is unable to provide a time value accurate to 5 microseconds
  * (due, for example, to hardware or software constraints), the browser can represent the value as a time in milliseconds
  * accurate to a millisecond.
  * @see https://developer.mozilla.org/en-US/docs/Web/API/DOMHighResTimeStamp
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal("DOMHighResTimeStamp")
class DOMHighResTimeStamp(timestamp: Double) extends js.Object
