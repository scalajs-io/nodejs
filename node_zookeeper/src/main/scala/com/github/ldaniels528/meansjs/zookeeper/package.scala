package com.github.ldaniels528.meansjs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Zookeeper Package Object
  * @author lawrence.daniels@gmail.com
  */
package object zookeeper {

  @js.native
  @JSName("STATES")
  object STATES extends js.Array[State]

}
