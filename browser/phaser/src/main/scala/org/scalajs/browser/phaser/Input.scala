package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Input
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Input extends js.Object {
  val keyboard: Keyboard = js.native
  val onTap: Signal = js.native
}
