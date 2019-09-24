package io.scalajs.nodejs.os

import scala.scalajs.js

@js.native
trait CPUInfo extends js.Object {
  val model: String  = js.native
  val speed: Double  = js.native
  val times: CPUTime = js.native
}

@js.native
trait CPUTime extends js.Object {
  val user: Double = js.native
  val nice: Double = js.native
  val sys: Double  = js.native
  val idle: Double = js.native
  val irq: Double  = js.native
}
