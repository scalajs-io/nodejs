package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * Sprites are the lifeblood of your game, used for nearly everything visual.
  * At its most basic a Sprite consists of a set of coordinates and a texture that is rendered to the canvas.
  * They also contain additional properties allowing for physics motion (via Sprite.body), input handling (via Sprite.input),
  * events (via Sprite.events), animation (via Sprite.animations), camera culling and more.
  * Please see the Examples for use cases.
  * @see http://phaser.io/docs/2.6.2/Phaser.Sprite.html
  */
@js.native
@JSName("Phaser.Sprite")
class Sprite(var game: Phaser.Game,
             override var x: Double,
             override var y: Double,
             var key: String | Phaser.RenderTexture | Phaser.BitmapData | Phaser.Texture,
             var frame: String | Int)
  extends pixijs.Sprite
    with Phaser.Component.Core
    with Phaser.Component.Angle
    with Phaser.Component.Animation
    with Phaser.Component.AutoCull
    with Phaser.Component.Bounds
    with Phaser.Component.BringToTop
    with Phaser.Component.Crop
    with Phaser.Component.Delta
    with Phaser.Component.Destroy
    with Phaser.Component.FixedToCamera
    with Phaser.Component.Health
    with Phaser.Component.InCamera
    with Phaser.Component.InputEnabled
    with Phaser.Component.InWorld
    with Phaser.Component.LifeSpan
    with Phaser.Component.LoadTexture
    with Phaser.Component.Overlap
    with Phaser.Component.PhysicsBody
    with Phaser.Component.Reset
    with Phaser.Component.ScaleMinMax
    with Phaser.Component.Smoothed {

  /**
    * Protected constructor
    */
  protected def this() = this(js.native, js.native, js.native, js.native, js.native)

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
    * The blend mode to be applied to the sprite. Set to PIXI.blendModes.NORMAL to remove any blend mode.
    * Warning: You cannot have a blend mode and a filter active on the same Sprite. Doing so will render the sprite invisible.
    */
  var blendMode: Double = js.native

  /**
    * Base destroy method for generic display objects.
    */
  override def destroy(): Unit = js.native

  /**
    * Base destroy method for generic display objects.
    */
  override def destroy(destroyChildren: Boolean): Unit = js.native

}
