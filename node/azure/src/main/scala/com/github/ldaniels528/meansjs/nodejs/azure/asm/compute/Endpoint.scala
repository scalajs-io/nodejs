package com.github.ldaniels528.meansjs.nodejs.azure.asm.compute

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Endpoint
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class Endpoint(var localPort: Int, var protocol: String, var name: String) extends js.Object

/**
  * Endpoint Component
  * @author lawrence.daniels@gmail.com
  */
object Endpoint {

  def apply(localPort: Int, protocol: String, name: String) = new Endpoint(localPort, protocol, name)

}
