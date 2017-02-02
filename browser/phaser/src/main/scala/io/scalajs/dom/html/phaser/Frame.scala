package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A Frame is a single frame of an animation and is part of a [[FrameData]] collection.
  * @param index  The index of this Frame within the FrameData set it is being added to.
  * @param x      X position of the frame within the texture image.
  * @param y      Y position of the frame within the texture image.
  * @param width  Width of the frame within the texture image.
  * @param height Height of the frame within the texture image.
  * @param name   The name of the frame. In Texture Atlas data this is usually set to the filename.
  * @see https://phaser.io/docs/2.6.2/Phaser.Frame.html
  */
@js.native
@JSName("Phaser.Frame")
class Frame(var index: Int, var x: Double, var y: Double, var width: Double, var height: Double, var name: String) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The bottom of the frame (y + height).
    */
  var bottom: Double = js.native

  /**
    * Center X position within the image to cut from.
    */
  var centerX: Double = js.native

  /**
    * Center Y position within the image to cut from.
    */
  var centerY: Double = js.native

  /**
    * The distance from the top left to the bottom-right of this Frame.
    */
  var distance: Double = js.native

  /**
    * The right of the Frame (x + width).
    */
  var right: Double = js.native

  /**
    * Rotated? (not yet implemented)
    */
  var rotated: Boolean = js.native

  /**
    * Either 'cw' or 'ccw', rotation is always 90 degrees.
    */
  var rotationDirection: String = js.native

  /**
    * Height of the original sprite before it was trimmed.
    */
  var sourceSizeH: Double = js.native

  /**
    * Width of the original sprite before it was trimmed.
    */
  var sourceSizeW: Double = js.native

  /**
    * Height of the trimmed sprite.
    */
  var spriteSourceSizeH: Double = js.native

  /**
    * Width of the trimmed sprite.
    */
  var spriteSourceSizeW: Double = js.native

  /**
    * X position of the trimmed sprite inside original sprite.
    */
  var spriteSourceSizeX: Double = js.native

  /**
    * Y position of the trimmed sprite inside original sprite.
    */
  var spriteSourceSizeY: Double = js.native

  /**
    * Was it trimmed when packed?
    */
  var trimmed: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Clones this Frame into a new Phaser.Frame object and returns it.
    * Note that all properties are cloned, including the name, index and UUID.
    * @return An exact copy of this Frame object.
    */
  override def clone(): this.type = js.native

  /**
    * Returns a Rectangle set to the dimensions of this Frame.
    * @param out A rectangle to copy the frame dimensions to.
    * @return A rectangle.
    */
  def getRect(out: Phaser.Rectangle = js.native): Phaser.Rectangle = js.native

  /**
    * Adjusts of all the Frame properties based on the given width and height values.
    * @param width  The new width of the Frame.
    * @param height The new height of the Frame.
    */
  def resize(width: Double, height: Double): Unit = js.native

  /**
    * If the frame was trimmed when added to the Texture Atlas this records the trim and source data.
    * @param trimmed      If this frame was trimmed or not.
    * @param actualWidth  The width of the frame before being trimmed.
    * @param actualHeight The height of the frame before being trimmed.
    * @param destX        The destination X position of the trimmed frame for display.
    * @param destY        The destination Y position of the trimmed frame for display.
    * @param destWidth    The destination width of the trimmed frame for display.
    * @param destHeight   The destination height of the trimmed frame for display.
    */
  def setTrim(trimmed: Boolean, actualWidth: Double, actualHeight: Double, destX: Double, destY: Double, destWidth: Double, destHeight: Double): Unit = js.native

}
