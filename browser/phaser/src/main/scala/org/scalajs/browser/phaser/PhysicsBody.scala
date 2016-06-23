package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Physics Body
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait PhysicsBody extends js.Object {
  val x: Double = js.native
  val y: Double = js.native
  var moves: Boolean = js.native
  val velocity: Phaser.Point = js.native
}
