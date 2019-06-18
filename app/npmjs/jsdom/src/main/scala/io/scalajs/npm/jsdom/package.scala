package io.scalajs.npm

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * jsdom package object
  * @author lawrence.daniels@gmail.com
  */
package object jsdom {

  @js.native
  @JSGlobal("window")
  object window extends JsDomWindowWithJQuery

}
