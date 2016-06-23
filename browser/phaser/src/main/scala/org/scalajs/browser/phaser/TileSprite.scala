package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Tile Sprite
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait TileSprite extends js.Object {
  val tilePosition: Phaser.Point = js.native
}
