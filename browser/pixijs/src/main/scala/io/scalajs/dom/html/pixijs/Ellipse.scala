package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The Ellipse object can be used to specify a hit area for displayObjects
  * @param x      The X coordinate of the center of the ellipse
  * @param y      The Y coordinate of the center of the ellipse
  * @param width  The half width of this ellipse
  * @param height The half height of this ellipse
  */
@js.native
@JSName("Ellipse")
class Ellipse(var x: Double, var y: Double, var width: Double, var height: Double) extends js.Object {

  /**
    * The const type of this object.
    */
  def `type`: Int = js.native

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

  /**
    * Returns the framing rectangle of the circle as a Rectangle object.
    * @return the framing rectangle
    */
  def getBounds(): Rectangle = js.native

}
