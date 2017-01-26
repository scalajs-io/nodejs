package io.scalajs.dom.html.phaser

import scala.scalajs.js

/**
  * The Rounded Rectangle object is an area defined by its position and has nice rounded corners, as indicated by its
  * top-left corner point (x, y) and by its width and its height.
  * @param x      The x coordinate of the top-left corner of the Rectangle.
  * @param y      The y coordinate of the top-left corner of the Rectangle.
  * @param width  The width of the Rectangle. Should always be either zero or a positive value.
  * @param height The height of the Rectangle. Should always be either zero or a positive value.
  * @param radius Controls the radius of the rounded corners.
  */
@js.native
class RoundedRectangle(x: Int, y: Int, width: Int, height: Int, radius: Int) extends js.Object {

  /**
    * The const type of this object.
    */
  def `type`: Int = js.native

  /**
    * @return a new RoundedRectangle object with the same values for the x, y, width, height and radius properties
    *         as this RoundedRectangle object.
    */
  override def clone(): this.type = js.native

  /**
    * Determines whether the specified coordinates are contained within the region defined by this Rounded Rectangle object.
    * @param x The x coordinate of the point to test.
    * @param y The y coordinate of the point to test.
    * @return A value of true if the RoundedRectangle Rectangle object contains the specified point; otherwise false.
    */
  def contains(x: Int, y: Int): Boolean = js.native

}
