package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Animation
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Animation extends js.Object {

  def play(frameRate: Int = 60, loop: Boolean = false, killOnComplete: Boolean = false): Animation = js.native

}
