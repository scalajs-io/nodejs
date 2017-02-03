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
class Graphics(var game: Phaser.Game,
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

  /**
    * The angle property is the rotation of the Game Object in degrees from its original orientation.
    *
    * Values from 0 to 180 represent clockwise rotation; values from 0 to -180 represent counterclockwise rotation.
    *
    * Values outside this range are added to or subtracted from 360 to obtain a value within the range.
    * For example, the statement player.angle = 450 is the same as player.angle = 90.
    *
    * If you wish to work in radians instead of degrees you can use the property rotation instead.
    * Working in radians is slightly faster as it doesn't have to perform any calculations.
    */
  override var angle: Double = js.native

  /**
    * Base destroy method for generic display objects.
    */
  override def destroy(): Unit = js.native

  /**
    * Base destroy method for generic display objects.
    */
  override def destroy(destroyChildren: Boolean): Unit = js.native

}