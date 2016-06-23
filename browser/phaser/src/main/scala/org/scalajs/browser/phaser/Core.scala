package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Core
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Core extends js.Object {
  val animations: AnimationManager = js.native
}
