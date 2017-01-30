package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * BitmapText objects work by taking a texture file and an XML or JSON file that describes the font structure.
  * It then generates a new Sprite object for each letter of the text, proportionally spaced out and aligned to
  * match the font structure.
  *
  * BitmapText objects are less flexible than Text objects, in that they have less features such as shadows, fills and the ability
  * to use Web Fonts, however you trade this flexibility for rendering speed. You can also create visually compelling BitmapTexts by
  * processing the font texture in an image editor, applying fills and any other effects required.
  *
  * To create multi-line text insert \r, \n or \r\n escape codes into the text string.
  *
  * If you are having performance issues due to the volume of sprites being rendered, and do not require the text to be constantly
  * updating, you can use BitmapText.generateTexture to create a static texture from this BitmapText.
  * @param game  A reference to the currently running game.
  * @param x     X coordinate to display the BitmapText object at.
  * @param y     Y coordinate to display the BitmapText object at.
  * @param font  The key of the BitmapText as stored in Phaser.Cache.
  * @param text  The text that will be rendered. This can also be set later via BitmapText.text.
  * @param size  The size the font will be rendered at in pixels.
  * @param align Alignment for multi-line text ('left', 'center' or 'right'), does not affect single lines of text.
  * @see https://phaser.io/docs/2.6.2/Phaser.BitmapText.html
  */
@js.native
@JSName("Phaser.BitmapText")
class BitmapText(val game: Game,
                 override var x: Double,
                 override var y: Double,
                 val font: String,
                 val text: String = js.native,
                 val size: Double = js.native,
                 val align: String = js.native)
  extends pixijs.DisplayObjectContainer
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

}