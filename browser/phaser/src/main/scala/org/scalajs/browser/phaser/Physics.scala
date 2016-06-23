package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Physics
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Physics extends js.Object {
  val ARCADE: Int = js.native
  val arcade: ArcadePhysics = js.native

  def enable(player: Sprite, system: Int, debug: Boolean = false): Unit = js.native

  def startSystem(systemId: Int): Unit = js.native

}
