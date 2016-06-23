package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Loader
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Loader extends js.Object {

  def image(key: String, url: String): Unit = js.native

  def spritesheet(key: String, url: String, frameWidth: Int, frameHeight: Int, frameMax: Int = -1, margin: Int = 0, spacing: Int = 0): Unit = js.native

}