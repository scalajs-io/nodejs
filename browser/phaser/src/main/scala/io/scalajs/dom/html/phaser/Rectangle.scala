package io.scalajs.dom.html.phaser

import scala.scalajs.js

/**
  * Creates a new Rectangle object with the top-left corner specified by the x and y parameters and with the specified
  * width and height parameters. If you call this function without parameters, a Rectangle with x, y, width, and height
  * properties set to 0 is created.
  * @param x      The x coordinate of the top-left corner of the Rectangle.
  * @param y      The y coordinate of the top-left corner of the Rectangle.
  * @param width  The width of the Rectangle. Should always be either zero or a positive value.
  * @param height The height of the Rectangle. Should always be either zero or a positive value.
  */
@js.native
class Rectangle(var x: Int, var y: Int, var width: Int, var height: Int) extends js.Object {

  /**
    * The sum of the y and height properties. Changing the bottom property of a Rectangle object has no effect on
    * the x, y and width properties, but does change the height property.
    */
  var bottom: Double = js.native

  /**
    * The location of the Rectangles bottom left corner as a Point object. Gets or sets the location of the Rectangles
    * bottom left corner as a Point object.
    */
  var bottomLeft: Point = js.native

  /**
    * The location of the Rectangles bottom right corner as a Point object. Gets or sets the location of the Rectangles
    * bottom right corner as a Point object.
    */
  var bottomRight: Point = js.native

  /**
    * The x coordinate of the center of the Rectangle.
    */
  var centerX: Double = js.native

  /**
    * The y coordinate of the center of the Rectangle.
    */
  var centerY: Double = js.native

  /**
    * Determines whether or not this Rectangle object is empty. A Rectangle object is empty if its width or height is
    * less than or equal to 0. If set to true then all of the Rectangle properties are set to 0. Gets or sets the
    * Rectangles empty state.
    */
  var empty: Boolean = js.native

  /**
    * Half of the height of the Rectangle.
    */
  def halfHeight: Double = js.native

  /**
    * Half of the width of the Rectangle.
    */
  def halfWidth: Double = js.native

  /**
    * The x coordinate of the left of the Rectangle. Changing the left property of a Rectangle object has no effect
    * on the y and height properties. However it does affect the width property, whereas changing the x value does
    * not affect the width property.
    */
  var left: Double = js.native

  /**
    * The perimeter size of the Rectangle. This is the sum of all 4 sides.
    */
  def perimeter: Double = js.native

  /**
    * A random value between the left and right values (inclusive) of the Rectangle.
    */
  var randomX: Double = js.native

  /**
    * A random value between the top and bottom values (inclusive) of the Rectangle.
    */
  var randomY: Double = js.native

  /**
    * The sum of the x and width properties. Changing the right property of a Rectangle object has no effect on
    * the x, y and height properties, however it does affect the width property.
    */
  var right: Double = js.native

  /**
    * The y coordinate of the top of the Rectangle. Changing the top property of a Rectangle object has no effect on
    * the x and width properties. However it does affect the height property, whereas changing the y value does not
    * affect the height property.
    */
  var top: Double = js.native

  /**
    * The location of the Rectangles top left corner as a Point object.
    */
  var topLeft: Point = js.native

  /**
    * The location of the Rectangles top right corner as a Point object. The location of the Rectangles top left
    * corner as a Point object.
    */
  var topRight: Point = js.native

  /**
    * The const type of this object.
    */
  def `type`: Int = js.native

  /**
    * The volume of the Rectangle derived from width * height.
    */
  def volume: Double = js.native

}

@js.native
object Rectangle extends js.Object {

  /**
    * @param a      The Rectangle object.
    * @param output Optional: Rectangle object. If given the values will be set into the object, otherwise a brand new
    *               Rectangle object will be created and returned.
    * @return a new Rectangle object with the same values for the x, y, width, and height properties as the original
    *         Rectangle object.
    */
  def clone(a: Rectangle, output: Rectangle = js.native): this.type = js.native

}
