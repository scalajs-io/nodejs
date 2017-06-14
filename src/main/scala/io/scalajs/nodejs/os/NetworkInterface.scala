package io.scalajs.nodejs.os

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Represents a Network Interface
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class NetworkInterface(val address: String,
                       val netmask: String,
                       val family: String,
                       val mac: String,
                       val scopeid: js.UndefOr[Int],
                       val internal: Boolean) extends js.Object
