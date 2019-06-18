package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * The Point object represents a location in a two-dimensional coordinate system, where x represents the horizontal
  * axis and y represents the vertical axis.
  * @param x position of the point on the x axis
  * @param y position of the point on the x axis
  */
@js.native
@JSGlobal("Point")
class Point(var x: Double = 0, var y: Double = 0) extends js.Object {

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
    * Copies x and y from the given point
    * @param p the given point
    */
  def copy(p: Point): Unit = js.native

  /**
    * Returns true if the given point is equal to this point.
    * @param p the given point
    * @return true, if the given point is equal to this point.
    */
  def equals(p: Point): Boolean = js.native

  /**
    * Sets the point to a new x and y position. If y is omitted, both x and y will be set to x.
    * @param x position of the point on the x axis
    * @param y position of the point on the x axis
    */
  def set(x: Double = 0, y: Double = 0): Unit = js.native

  def setTo(x: Double = 0, y: Double = 0): Unit = js.native

}