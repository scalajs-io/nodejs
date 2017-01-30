package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Creates a new Circle object with the center coordinate specified by the x and y parameters and the diameter
  * specified by the diameter parameter. If you call this function without parameters, a circle with x, y, diameter
  * and radius properties set to 0 is created.
  * @param x        The x coordinate of the center of the circle.
  * @param y        The y coordinate of the center of the circle.
  * @param diameter The diameter of the circle.
  */
@js.native
@JSName("Phaser.Circle")
class Circle(var x: Double = 0, var y: Double = 0, var diameter: Double = 0) extends js.Object {

  /**
    * The area of this Circle.
    */
  def area: Double = js.native

  /**
    * The sum of the y and radius properties. Changing the bottom property of a Circle object has no effect on
    * the x and y properties, but does change the diameter. Gets or sets the bottom of the circle.
    */
  var bottom: Double = js.native

  /**
    * Determines whether or not this Circle object is empty. Will return a value of true if the Circle objects
    * diameter is less than or equal to 0; otherwise false. If set to true it will reset all of the Circle objects
    * properties to 0. A Circle object is empty if its diameter is less than or equal to 0. Gets or sets the empty
    * state of the circle.
    */
  var empty: Boolean = js.native

  /**
    * The x coordinate of the leftmost point of the circle. Changing the left property of a Circle object has no
    * effect on the x and y properties. However it does affect the diameter, whereas changing the x value does not
    * affect the diameter property.
    */
  var left: Double = js.native

  /**
    * The length of a line extending from the center of the circle to any point on the circle itself. The same as
    * half the diameter. Gets or sets the radius of the circle.
    */
  var radius: Double = js.native

  /**
    * The x coordinate of the rightmost point of the circle. Changing the right property of a Circle object has no
    * effect on the x and y properties. However it does affect the diameter, whereas changing the x value does not
    * affect the diameter property. Gets or sets the value of the rightmost point of the circle.
    */
  var right: Double = js.native

  /**
    * The sum of the y minus the radius property. Changing the top property of a Circle object has no effect on
    * the x and y properties, but does change the diameter. Gets or sets the top of the circle.
    */
  var top: Double = js.native

  /**
    * The const type of this object.
    */
  def `type`: Int = js.native

}
