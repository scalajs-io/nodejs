package io.scalajs.npm

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * jsdom package object
  * @author lawrence.daniels@gmail.com
  */
package object jsdom {

  @js.native
  @JSName("window")
  object window extends JsDomWindowWithJQuery

}
