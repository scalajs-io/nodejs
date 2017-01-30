package io.scalajs.dom.html.phaser

import io.scalajs.JsNumber
import io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
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
@JSName("Phaser.Image")
class Image(var game: Phaser.Game,
            override var x: Double,
            override var y: Double,
            var key: String | Phaser.RenderTexture | Phaser.BitmapData | pixijs.Texture,
            var frame: String | JsNumber)
  extends pixijs.Sprite
    with Phaser.Component.Core
    with Phaser.Component.Angle
    with Phaser.Component.Animation
    with Phaser.Component.AutoCull
    with Phaser.Component.Bounds
    with Phaser.Component.BringToTop
    with Phaser.Component.Crop
    with Phaser.Component.Destroy
    with Phaser.Component.FixedToCamera
    with Phaser.Component.InputEnabled
    with Phaser.Component.LifeSpan
    with Phaser.Component.LoadTexture
    with Phaser.Component.Overlap
    with Phaser.Component.Reset
    with Phaser.Component.ScaleMinMax
    with Phaser.Component.Smoothed {

  protected def this() = this(js.native, js.native, js.native, js.native, js.native)

  override var angle: Double = js.native

  /**
    * The const type of this object.
    */
  def `type`: Int = js.native

}
