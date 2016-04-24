package com.github.ldaniels528.meansjs.nodejs.os

import scala.scalajs.js

/**
  * CPU Time
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CPUTime extends js.Object {
  var user: Double = js.native
  var nice: Double = js.native
  var sys: Double = js.native
  var idle: Double = js.native
  var irq: Double = js.native
}
