package io.scalajs.npm

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Zookeeper Package Object
  * @author lawrence.daniels@gmail.com
  */
package object nzc {

  @js.native
  @JSGlobal("STATES")
  object STATES extends js.Array[State]

}
