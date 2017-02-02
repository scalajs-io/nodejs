package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A Graphics object is a way to draw primitives to your game. Primitives include forms of geometry, such as Rectangles,
  * Circles and Polygons. They also include lines, arcs and curves. When you initially create a Graphics object it will
  * be empty. To 'draw' to it you first specify a lineStyle or fillStyle (or both), and then draw a shape.
  * @param game Current game instance.
  * @param x    X-position of the new graphics object.
  * @param y    Y-position of the new graphics object.
  * @see http://phaser.io/docs/2.6.2/Phaser.Graphics.html
  */
@js.native
@JSName("Phaser.Graphics")
class Graphics(val game: Phaser.Game,
               override var x: Double,
               override var y: Double)
  extends pixijs.Graphics
    with Phaser.Component.Core
    with Phaser.Component.Angle
    with Phaser.Component.AutoCull
    with Phaser.Component.Bounds
    with Phaser.Component.Destroy
    with Phaser.Component.FixedToCamera
    with Phaser.Component.InputEnabled
    with Phaser.Component.InWorld
    with Phaser.Component.LifeSpan
    with Phaser.Component.PhysicsBody
    with Phaser.Component.Reset {

  override var angle: Double = js.native

}