package com.github.ldaniels528.meansjs.nodejs.azure.asm.compute

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Listener Type
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ListenerType(var listenerType: String) extends js.Object

/**
  * Listener Type Companion
  * @author lawrence.daniels@gmail.com
  */
object ListenerType {

  def apply(listenerType: String) = new ListenerType(listenerType)

}
