package io.scalajs.dom.html
package phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * An Image is a light-weight object you can use to display anything that doesn't need physics or animation.
  * It can still rotate, scale, crop and receive input events. This makes it perfect for logos, backgrounds, simple
  * buttons and other non-Sprite graphics.
  * @param game  A reference to the currently running game.
  * @param x     The x coordinate of the Image. The coordinate is relative to any parent container this Image may be in.
  * @param y     The y coordinate of the Image. The coordinate is relative to any parent container this Image may be in.
  * @param key   The texture used by the Image during rendering. It can be a string which is a reference to the Cache
  *              entry, or an instance of a RenderTexture, BitmapData or PIXI.Texture.
  * @param frame If this Image is using part of a sprite sheet or texture atlas you can specify the exact frame to use
  *              by giving a string or numeric index.
  * @see http://phaser.io/docs/2.6.2/Phaser.Image.html
  */
@js.native
@JSGlobal("Phaser.Image")
class Image(var game: Phaser.Game,
            override var x: Double,
            override var y: Double,
            var key: String | Phaser.RenderTexture | Phaser.BitmapData | pixijs.Texture,
            var frame: String | Int)
  extends pixijs.Sprite
    with phaser.component.Core
    with phaser.component.Angle
    with phaser.component.Animation
    with phaser.component.AutoCull
    with phaser.component.Bounds
    with phaser.component.BringToTop
    with phaser.component.Crop
    with phaser.component.Destroy
    with phaser.component.FixedToCamera
    with phaser.component.InputEnabled
    with phaser.component.LifeSpan
    with phaser.component.LoadTexture
    with phaser.component.Overlap
    with phaser.component.Reset
    with phaser.component.ScaleMinMax
    with phaser.component.Smoothed {

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
    * Base destroy method for generic display objects.
    */
  override def destroy(): Unit = js.native

  /**
    * Base destroy method for generic display objects.
    */
  override def destroy(destroyChildren: Boolean): Unit = js.native

  /**
    * The const type of this object.
    */
  def `type`: Int = js.native

}
