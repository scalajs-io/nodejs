package io.scalajs.dom.html.phaser
package component

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * The Bounds component contains properties related to the bounds of the Game Object.
  * @see http://phaser.io/docs/2.6.2/Phaser.Component.Bounds.html
  */
@js.native
//@JSName("Phaser.Component.Bounds")
trait Bounds extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The sum of the y and height properties.
    * This is the same as `y + height - offsetY`.
    */
  var bottom: Double = js.native

  /**
    * The center x coordinate of the Game Object.
    * This is the same as `(x - offsetX) + (width / 2)`.
    */
  var centerX: Double = js.native

  /**
    * The center y coordinate of the Game Object.
    * This is the same as `(y - offsetY) + (height / 2)`.
    */
  var centerY: Double = js.native

  /**
    * The left coordinate of the Game Object.
    * This is the same as `x - offsetX`.
    */
  var left: Double = js.native

  /**
    * The amount the Game Object is visually offset from its x coordinate.
    * This is the same as width * anchor.x.
    * It will only be > 0 if anchor.x is not equal to zero.
    */
  def offsetX: Double = js.native

  /**
    * The amount the Game Object is visually offset from its y coordinate.
    * This is the same as height * anchor.y.
    * It will only be > 0 if anchor.y is not equal to zero.
    */
  def offsetY: Double = js.native

  /**
    * The right coordinate of the Game Object.
    * This is the same as `x + width - offsetX`.
    */
  var right: Double = js.native

  /**
    * The y coordinate of the Game Object.
    * This is the same as `y - offsetY`.
    */
  var top: Double = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Aligns this Game Object to the side of another Game Object, or Rectangle, known as the
    * 'parent', in one of 11 possible positions.
    * The parent must be a Game Object, or Phaser.Rectangle object. This can include properties
    * such as World.bounds or Camera.view, for aligning Game Objects within the world
    * and camera bounds. Or it can include other Sprites, Images, Text objects, BitmapText,
    * TileSprites or Buttons.
    * Please note that aligning a Sprite to another Game Object does not make it a child of
    * the parent. It simply modifies its position coordinates so it aligns with it.
    * @param container The Game Object or Rectangle with which to align this Game Object to. Can also include
    *                  properties such as World.bounds or Camera.view
    * @param position  The position constant. One of Phaser.TOP_LEFT (default), Phaser.TOP_CENTER, Phaser.TOP_RIGHT,
    *                 Phaser.LEFT_CENTER, Phaser.CENTER, Phaser.RIGHT_CENTER, Phaser.BOTTOM_LEFT, Phaser.BOTTOM_CENTER
    *                  or Phaser.BOTTOM_RIGHT
    * @param offsetX   A horizontal adjustment of the Containers bounds, applied to the aligned position of the
    *                  Game Object. Use a negative value to shrink the bounds, positive to increase it.
    * @param offsetY   A vertical adjustment of the Containers bounds, applied to the aligned position of the
    *                  Game Object. Use a negative value to shrink the bounds, positive to increase it.
    * @return This Game Object.
    */
  def alignIn(container: Phaser.Rectangle | Phaser.Sprite | Phaser.Image | Phaser.Text | Phaser.BitmapText | Phaser.Button | Phaser.Graphics | Phaser.TileSprite,
              position: Int = js.native,
              offsetX: Double = js.native,
              offsetY: Double = js.native): js.Object = js.native

}