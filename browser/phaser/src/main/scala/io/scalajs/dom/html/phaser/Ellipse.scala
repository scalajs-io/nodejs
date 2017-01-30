package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Creates a Ellipse object. A curve on a plane surrounding two focal points.
  * @param x      The X coordinate of the upper-left corner of the framing rectangle of this ellipse.
  * @param y      The Y coordinate of the upper-left corner of the framing rectangle of this ellipse.
  * @param width  The overall width of this ellipse.
  * @param height The overall height of this ellipse.
  * @see http://phaser.io/docs/2.6.2/Phaser.Ellipse.html
  */
@js.native
@JSName("Phaser.Ellipse")
class Ellipse(var x: Double, var y: Double, var width: Double, var height: Double) extends js.Object {

  /**
    * Returns a new Ellipse object with the same values for the x, y, width, and height properties as this Ellipse object.
    * @param output Optional Ellipse object. If given the values will be set into the object, otherwise a brand
    *               new Ellipse object will be created and returned.
    * @return The cloned Ellipse object.
    */
  def clone(output: Phaser.Ellipse = js.native): Phaser.Ellipse = js.native

  /**
    * Return true if the given x/y coordinates are within this Ellipse object.
    * @param x The X value of the coordinate to test.
    * @param y The Y value of the coordinate to test.
    * @return True if the coordinates are within this ellipse, otherwise false.
    */
  def contains(x: Double, y: Double): Boolean = js.native

  /**
    * Copies the x, y, width and height properties from any given object to this Ellipse.
    * @param source The object to copy from.
    * @return This Ellipse object.
    */
  def copyFrom(source: js.Any): Phaser.Ellipse = js.native

  /**
    * Copies the x, y, width and height properties from this Ellipse to any given object.
    * @param dest The object to copy to.
    * @return This dest object.
    */
  def copyTo(dest: js.Any): js.Any = js.native

  /**
    * Returns the framing rectangle of the ellipse as a [[Phaser.Rectangle]] object.
    * @return The bounds of the Ellipse.
    */
  def getBounds(): Phaser.Rectangle = js.native

  /**
    * Returns a uniformly distributed random point from anywhere within this Ellipse.
    * @param out A Phaser.Point, or any object with public x/y properties, that the values will be set in.
    *            If no object is provided a new Phaser.Point object will be created. In high performance areas
    *            avoid this by re-using an existing object.
    * @return An object containing the random point in its `x` and `y` properties.
    */
  def random(out: Phaser.Point = js.native): Phaser.Point = js.native

  /**
    * Sets the members of the Ellipse to the specified values.
    * @param x      The X coordinate of the upper-left corner of the framing rectangle of this ellipse.
    * @param y      The Y coordinate of the upper-left corner of the framing rectangle of this ellipse.
    * @param width  The overall width of this ellipse.
    * @param height The overall height of this ellipse.
    * @return This Ellipse object.
    */
  def setTo(x: Double, y: Double, width: Double, height: Double): Phaser.Ellipse = js.native

}

/**
  * Ellipse Singleton
  */
@js.native
@JSName("Phaser.Ellipse")
object Ellipse extends js.Object {

  /**
    * Return true if the given x/y coordinates are within the Ellipse object.
    * @param a The Ellipse to be checked.
    * @param x The X value of the coordinate to test.
    * @param y The Y value of the coordinate to test.
    * @return True if the coordinates are within this ellipse, otherwise false.
    */
  def contains(a: Phaser.Ellipse, x: Double, y: Double): Boolean = js.native

}