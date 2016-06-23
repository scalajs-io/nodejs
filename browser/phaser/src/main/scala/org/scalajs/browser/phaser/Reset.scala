package org.scalajs.browser.phaser

import org.scalajs.browser.pixijs.PIXI
import PIXI.DisplayObject

import scala.scalajs.js

/**
  * Phaser Physics
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Reset extends js.Object {

  def reset(x: Double, y: Double, health: Double = 1): DisplayObject = js.native

}
