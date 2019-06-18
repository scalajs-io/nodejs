package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * The Rectangle object is an area defined by its position, as indicated by its top-left corner point (x, y) and by
  * its width and its height.
  * @param x      The X coordinate of the upper-left corner of the rectangle.
  * @param y      The Y coordinate of the upper-left corner of the rectangle.
  * @param width  The overall width of this rectangle.
  * @param height The overall height of this rectangle.
  */
@js.native
@JSGlobal("Rectangle")
class Rectangle(var x: Double, var y: Double, var width: Double, var height: Double) extends js.Object {

  /**
    * Creates a clone of this Circle instance
    */
  override def clone(): this.type = js.native

  /**
    * Checks whether the x and y coordinates given are contained within this circle.
    * @param x The X coordinate of the point to test.
    * @param y The Y coordinate of the point to test.
    * @return Whether the x/y coordinates are within this Circle.
    */
  def contains(x: Double, y: Double): Boolean = js.native

}