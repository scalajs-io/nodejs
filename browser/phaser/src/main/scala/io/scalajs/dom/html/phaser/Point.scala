package io.scalajs.dom.html.phaser

import scala.scalajs.js

/**
  * A Point object represents a location in a two-dimensional coordinate system, where x represents the horizontal axis
  * and y represents the vertical axis. The following code creates a point at (0,0):
  * {{{ var myPoint = new Phaser.Point(); }}}
  * You can also use them as 2D Vectors and you'll find different vector related methods in this class.
  * @param x The horizontal position of this Point.
  * @param y The vertical position of this Point.
  */
@js.native
class Point(var x: Double, var y: Double) extends js.Object {

  /**
    * Adds the coordinates of two points together to create a new point.
    * @param x The value to add to Point.x.
    * @param y The value to add to Point.y.
    * @return This Point object. Useful for chaining method calls.
    */
  def add(x: Double, y: Double): this.type = js.native

  /**
    * Returns the angle between this Point object and another object with public x and y properties.
    * @param a         The object to get the angle from this Point to.
    * @param asDegrees Is the given angle in radians (false) or degrees (true)?
    * @return The angle between the two objects.
    */
  def angle(a: js.Any, asDegrees: Boolean): this.type = js.native

  /**
    * Math.ceil() both the x and y properties of this Point.
    * @return This Point object.
    */
  def ceil(): this.type = js.native

  /**
    * Clamps this Point object values to be between the given min and max.
    * @param min The minimum value to clamp this Point to.
    * @param max The maximum value to clamp this Point to.
    * @return This Point object.
    */
  def clamp(min: Double, max: Double): this.type = js.native

  /**
    * Clamps the x value of this Point to be between the given min and max.
    * @param min The minimum value to clamp this Point to.
    * @param max The maximum value to clamp this Point to.
    * @return This Point object.
    */
  def clampX(min: Double, max: Double): this.type = js.native

  /**
    * Clamps the y value of this Point to be between the given min and max.
    * @param min The minimum value to clamp this Point to.
    * @param max The maximum value to clamp this Point to.
    * @return This Point object.
    */
  def clampY(min: Double, max: Double): this.type = js.native

  /**
    * Creates a copy of the given Point.
    * @param output Optional Point object. If given the values will be set into this object, otherwise a brand new
    *               Point object will be created and returned.
    * @return The new Point object.
    */
  def clone(output: Point = null): Point = js.native

  /**
    * Copies the x and y properties from any given object to this Point.
    * @param source The object to copy from.
    * @return This Point object.
    */
  def copyFrom(source: js.Any): this.type = js.native

  /**
    * Copies the x and y properties from this Point to any given object.
    * @param dest The object to copy to.
    * @return The dest object.
    */
  def copyTo(dest: js.Object): js.Object = js.native

  /**
    * The cross product of this and another Point object.
    * @param a The Point object to get the cross product combined with
    * @return The result.
    */
  def cross(a: Point): Double = js.native

  /**
    * Returns the distance of this Point object to the given object (can be a Circle, Point or anything with x/y properties)
    * @param dest  The target object. Must have visible x and y properties that represent the center of the object.
    * @param round Round the distance to the nearest integer (default false).
    * @return The distance between this Point object and the destination Point object.
    */
  def distance(dest: js.Object, round: Boolean = false): Double = js.native

  /**
    * Divides Point.x and Point.y by the given x and y values.
    * @param x The value to divide Point.x by.
    * @param y The value to divide Point.x by.
    * @return This Point object. Useful for chaining method calls.
    */
  def divide(x: Double, y: Double): this.type = js.native

  /**
    * The dot product of this and another Point object.
    * @param a The Point object to get the dot product combined with this Point.
    * @return The result.
    */
  def dot(a: Point): Double = js.native

  /**
    * Determines whether the given objects x/y values are equal to this Point object.
    * @param a The object to compare with this Point.
    * @return A value of true if the x and y points are equal, otherwise false.
    */
  def equals(a: js.Any): Boolean = js.native

  /**
    * Math.floor() both the x and y properties of this Point.
    * @return This Point object.
    */
  def floor(): this.type = js.native

  /**
    * Calculates the length of the Point object.
    * @return The length of the Point.
    */
  def getMagnitude(): Double = js.native

  /**
    * Calculates the length squared of the Point object.
    * @return The {{{ length ^ 2 }}} of the Point.
    */
  def getMagnitudeSq(): Double = js.native

  /**
    * Inverts the x and y values of this Point
    * @return This Point object.
    */
  def invert(): this.type = js.native

  /**
    * Determine if this point is at 0,0.
    * @return True if this Point is 0,0, otherwise false.
    */
  def isZero(): Boolean = js.native

  /**
    * Multiplies Point.x and Point.y by the given x and y values. Sometimes known as Scale.
    * @param x The value to multiply Point.x by.
    * @param y The value to multiply Point.x by.
    * @return This Point object. Useful for chaining method calls.
    */
  def multiply(x: Double, y: Double): this.type = js.native

  /**
    * Alters the Point object so that its length is 1, but it retains the same direction.
    * @return This Point object.
    */
  def normalize(): this.type = js.native

  /**
    * Right-hand normalize (make unit length) this Point.
    * @return This Point object.
    */
  def normalRightHand(): this.type = js.native

  /**
    * Make this Point perpendicular (90 degrees rotation)
    * @return This Point object.
    */
  def perp(): this.type = js.native

  /**
    * Rotates this Point around the x/y coordinates given to the desired angle.
    * @param x         The x coordinate of the anchor point.
    * @param y         The y coordinate of the anchor point.
    * @param angle     The angle in radians (unless asDegrees is true) to rotate the Point to.
    * @param asDegrees Is the given angle in radians (false) or degrees (true)?
    * @param distance  An optional distance constraint between the Point and the anchor.
    * @return The modified point object.
    */
  def rotate(x: Double, y: Double, angle: Double, asDegrees: Boolean, distance: Double): this.type = js.native

  /**
    * Make this Point perpendicular (-90 degrees rotation)
    * @return This Point object.
    */
  def rperp(): this.type = js.native

  /**
    * Sets the x and y values of this Point object to the given values. If you omit the y value then the x value
    * will be applied to both, for example: Point.set(2) is the same as Point.set(2, 2)
    * @param x The horizontal value of this point.
    * @param y The vertical value of this point. If not given the x value will be used in its place.
    * @return This Point object. Useful for chaining method calls.
    */
  def set(x: Double, y: Double = js.native): this.type = js.native

  /**
    * Alters the length of the Point without changing the direction.
    * @param magnitude The desired magnitude of the resulting Point.
    * @return This Point object.
    */
  def setMagnitude(magnitude: Double): this.type = js.native

  /**
    * Sets the x and y values of this Point object to the given values. If you omit the y value then the x value will
    * be applied to both, for example: Point.setTo(2) is the same as Point.setTo(2, 2)
    * @param x The horizontal value of this point.
    * @param y Optional: The vertical value of this point. If not given the x value will be used in its place.
    * @return This Point object. Useful for chaining method calls.
    */
  def setTo(x: Double, y: Double = js.native): this.type = js.native

  /**
    * Subtracts the given x and y values from this Point.
    * @param x The value to subtract from Point.x.
    * @param y The value to subtract from Point.y.
    * @return This Point object. Useful for chaining method calls.
    */
  def subtract(x: Double, y: Double): this.type = js.native

}

/**
  * Point Singleton
  */
@js.native
object Point extends js.Object {

  /**
    * Adds the coordinates of two points together to create a new point.
    * @param a   The first Point object.
    * @param b   The second Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def add(a: Point, b: Point, out: Point = null): Point = js.native

  /**
    * Returns the angle between two Point objects.
    * @param a The first Point object.
    * @param b The second Point object.
    * @return The angle between the two Points.
    */
  def angle(a: Point, b: Point): Double = js.native

  /**
    * Calculates centroid (or midpoint) from an array of points. If only one point is provided, that point is returned.
    * @param points The array of one or more points.
    * @param out    Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def centroid(points: js.Array[Point], out: Point = null): Point = js.native

  /**
    * Returns the euclidian distance of this Point object to the given object (can be a Circle, Point or anything
    * with x/y properties).
    * @param a     The target object. Must have visible x and y properties that represent the center of the object.
    * @param b     The target object. Must have visible x and y properties that represent the center of the object.
    * @param round Round the distance to the nearest integer.
    * @return The distance between this Point object and the destination Point object.
    */
  def distance(a: Point, b: Point, round: Boolean = false): Double = js.native

  /**
    * Divides the coordinates of two points to create a new point.
    * @param a   The first Point object.
    * @param b   The second Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def divide(a: Point, b: Point, out: Point = null): Point = js.native

  /**
    * Determines whether the two given Point objects are equal. They are considered equal if they have the same x and y values.
    * @param a The first Point object.
    * @param b The second Point object.
    * @return A value of true if the Points are equal, otherwise false.
    */
  def equals(a: Point, b: Point): Boolean = js.native

  /**
    * Interpolates the two given Points, based on the f value (between 0 and 1) and returns a new Point.
    * @param a   The first Point object.
    * @param b   The second Point object.
    * @param f   The level of interpolation between the two points. Indicates where the new point will be, along the
    *            line between pt1 and pt2. If f=1, pt1 is returned; if f=0, pt2 is returned.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def interpolate(a: Point, b: Point, f: Double, out: Point = null): Point = js.native

  /**
    * Multiplies the coordinates of two points to create a new point.
    * @param a   The first Point object.
    * @param b   The second Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def multiply(a: Point, b: Point, out: Point = null): Point = js.native

  /**
    * Adds two 2D Points together and multiplies the result by the given scalar.
    * @param a   The first Point object.
    * @param b   The second Point object.
    * @param s   The scaling value.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def multiplyAdd(a: Point, b: Point, s: Double, out: Point = null): Point = js.native

  /**
    * Creates a negative Point.
    * @param a   The first Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def negative(a: Point, out: Point = null): Point = js.native

  /**
    * Normalize (make unit length) a Point.
    * @param a   The Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def normalize(a: Point, out: Point = null): Point = js.native

  /**
    * Right-hand normalize (make unit length) a Point.
    * @param a   The Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def normalRightHand(a: Point, out: Point = null): Point = js.native

  /**
    * Parses an object for x and/or y properties and returns a new Phaser.Point with matching values. If the object
    * doesn't contain those properties a Point with x/y of zero will be returned.
    * @param obj   The object to parse.
    * @param xProp The property used to set the Point.x value.
    * @param yProp The property used to set the Point.y value.
    * @return The new Point object.
    */
  def parse(obj: js.Object, xProp: String, yProp: String): Point = js.native

  /**
    * Return a perpendicular vector (90 degrees rotation)
    * @param a   The Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def perp(a: Point, out: Point = null): Point = js.native

  /**
    * Project two Points onto another Point.
    * @param a   The first Point object.
    * @param b   The second Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def project(a: Point, b: Point, out: Point = null): Point = js.native

  /**
    * Project two Points onto a Point of unit length.
    * @param a   The first Point object.
    * @param b   The second Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def projectUnit(a: Point, b: Point, out: Point = null): Point = js.native

  /**
    * Rotates a Point object, or any object with exposed x/y properties, around the given coordinates by the angle
    * specified. If the angle between the point and coordinates was 45 deg and the angle argument is 45 deg then the
    * resulting angle will be 90 deg, as the angle argument is added to the current angle. The distance allows you to
    * specify a distance constraint for the rotation between the point and the coordinates. If none is given the
    * distance between the two is calculated and used.
    * @param a         The Point object to rotate.
    * @param x         The x coordinate of the anchor point
    * @param y         The y coordinate of the anchor point
    * @param angle     The angle in radians (unless asDegrees is true) to rotate the Point by.
    * @param asDegrees Is the given angle in radians (false) or degrees (true)?
    * @param distance  An optional distance constraint between the Point and the anchor.
    * @return The modified point object.
    */
  def rotate(a: Point, x: Double, y: Double, angle: Boolean, asDegrees: Double, distance: Double): Point = js.native

  /**
    * Return a perpendicular vector (-90 degrees rotation)
    * @param a   The Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def rperp(a: Point, out: Point = null): Point = js.native

  /**
    * Subtracts the coordinates of two points to create a new point.
    * @param a   The first Point object.
    * @param b   The second Point object.
    * @param out Optional Point to store the value in, if not supplied a new Point object will be created.
    * @return The new Point object.
    */
  def subtract(a: Point, b: Point, out: Point = null): Point = js.native

}