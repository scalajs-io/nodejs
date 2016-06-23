package org.scalajs.browser.phaser

import org.scalajs.browser.pixijs.PIXI
import PIXI.DisplayObject

import scala.scalajs.js

/**
  * Phaser: Sprite
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Sprite extends Core with DisplayObject with Lifespan with Reset {

  var body: PhysicsBody = js.native

  def play(key: String, frameRate: Double = 60, loop: Boolean = false, killOnComplete: Boolean = false): Animation = js.native

}
