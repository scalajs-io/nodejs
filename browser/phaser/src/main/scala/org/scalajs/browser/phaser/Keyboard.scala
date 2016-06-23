package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Keyboard
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Keyboard extends js.Object {
  val SPACEBAR: Int = js.native

  def addKey(code: Int): Key = js.native

  def createCursorKeys(): CursorKeys = js.native

}
