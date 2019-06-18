package io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * The Polygon object
  * @param points_ This can be an array of Points that form the polygon, a flat array of numbers that will be
  *                interpreted as [x,y, x,y, ...], or the arguments passed can be all the points of the polygon
  *                e.g. new PIXI.Polygon(new PIXI.Point(), new PIXI.Point(), ...), or the arguments passed can be
  *                flat x,y values e.g. new Polygon(x,y, x,y, x,y, ...) where x and y are Numbers.
  */
@js.native
@JSGlobal("Polygon")
class Polygon(points_ : js.Array[Point | Double]) extends js.Object {

  /**
    * An array of the points of this polygon
    */
  def points: js.Array[Double] = js.native

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

}
