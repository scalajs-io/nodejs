package io.scalajs.nodejs.os

import scala.scalajs.js

/**
  * CPU Information
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CPUInfo extends js.Object {
  var model: String = js.native
  var speed: Double = js.native
  var times: js.Dictionary[Double] = js.native
}
