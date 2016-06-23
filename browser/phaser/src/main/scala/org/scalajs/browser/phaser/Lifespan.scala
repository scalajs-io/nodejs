package org.scalajs.browser.phaser

import org.scalajs.browser.pixijs.PIXI
import PIXI.DisplayObject

import scala.scalajs.js

/**
  * Phaser: Lifespan
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Lifespan extends js.Object {
  val alive: Boolean = js.native

  def kill(): DisplayObject = js.native

  def revive(health: Double = 1): DisplayObject = js.native
}
