package io.scalajs.dom.html.phaser

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A collection of useful mathematical functions.
  * These are normally accessed through [[Math game.math]].
  * @see https://phaser.io/docs/2.6.2/Phaser.Math.html
  * @see [[io.scalajs.dom.html.phaser.utils.ArrayUtils]]
  * @see [[io.scalajs.dom.html.phaser.utils.Utils]]
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Math")
class Math extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Twice PI.
    */
  def PI2: Double = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Find the angle of a segment from (x1, y1) -> (x2, y2).
    * @param x1 The x coordinate of the first value.
    * @param y1 The y coordinate of the first value.
    * @param x2 The x coordinate of the second value.
    * @param y2 The y coordinate of the second value.
    * @return The angle, in radians.
    */
  def angleBetween(x1: Double, y1: Double, x2: Double, y2: Double): Double = js.native

  /**
    * Find the angle of a segment from (point1.x, point1.y) -> (point2.x, point2.y).
    * @param point1 The first point.
    * @param point2 The second point.
    * @return The angle between the two points, in radians.
    */
  def angleBetweenPoints(point1: Phaser.Point, point2: Phaser.Point): Double = js.native

  /**
    * Find the angle of a segment from (point1.x, point1.y) -> (point2.x, point2.y).
    * @param point1 The first point.
    * @param point2 The second point.
    * @return The angle, in radians.
    */
  def angleBetweenPointsY(point1: Phaser.Point, point2: Phaser.Point): Double = js.native

  /**
    * Find the angle of a segment from (x1, y1) -> (x2, y2).
    * The difference between this method and Math.angleBetween is that this assumes the y coordinate travels
    * down the screen.
    * @param x1 The x coordinate of the first value.
    * @param y1 The y coordinate of the first value.
    * @param x2 The x coordinate of the second value.
    * @param y2 The y coordinate of the second value.
    * @return The angle, in radians.
    */
  def angleBetweenY(x1: Double, y1: Double, x2: Double, y2: Double): Double = js.native

  /**
    * Averages all values passed to the function and returns the result.
    * @return The average of all given values.
    */
  def average(): Double = js.native

  /**
    * Returns a number between the `min` and `max` values.
    * @param min The minimum value. Must be positive, and less than 'max'.
    * @param max The maximum value. Must be position, and greater than 'min'.
    * @return A value between the range min to max.
    */
  def between(min: Double, max: Double): Double = js.native

  /**
    * A Bezier Interpolation Method, mostly used by [[Phaser.Tween]].
    * @param v The input array of values to interpolate between.
    * @param k The percentage of interpolation, between 0 and 1.
    * @return The interpolated value
    */
  def bezierInterpolation(v: js.Array[JsNumber], k: Double): Double = js.native

  /**
    * A Catmull Rom Interpolation Method, mostly used by [[Phaser.Tween]].
    * @param v The input array of values to interpolate between.
    * @param k The percentage of interpolation, between 0 and 1.
    * @return The interpolated value
    */
  def catmullRomInterpolation(v: js.Array[JsNumber], k: Double): Double = js.native

  /**
    * Ceils to some place comparative to a `base`, default is 10 for decimal place.
    * The `place` is represented by the power applied to `base` to get that place.
    * @param value The value to round.
    * @param place The place to round to.
    * @param base  The base to round in. Default is 10 for decimal.
    * @return The rounded value.
    */
  def ceilTo(value: JsNumber, place: JsNumber = js.native, base: JsNumber = js.native): Double = js.native

  /**
    * Force a value within the boundaries by clamping it to the range `min`, `max`.
    * @param v   The value to be clamped.
    * @param min The minimum bounds.
    * @param max The maximum bounds.
    * @return The clamped value.
    */
  def clamp(v: Double, min: Double, max: Double): Double = js.native

  /**
    * Clamp `x` to the range `[a, Infinity)`.
    * Roughly the same as `Math.max(x, a)`, except for NaN handling.
    * @param x TODO
    * @param a TODO
    * @return a number
    */
  def clampBottom(x: Double, a: Double): Double = js.native

  /**
    * Convert degrees to radians.
    * @param degrees Angle in degrees.
    * @return Angle in radians.
    */
  def degToRad(degrees: Double): Double = js.native

  /**
    * The absolute difference between two values.
    * @param a The first value to check.
    * @param b The second value to check.
    * @return The absolute difference between the two values.
    */
  def difference(a: Double, b: Double): Double = js.native

  /**
    * Returns the euclidian distance between the two given set of coordinates.
    * @param x1 The x coordinate of the first value.
    * @param y1 The y coordinate of the first value.
    * @param x2 The x coordinate of the second value.
    * @param y2 The y coordinate of the second value.
    * @return The distance between the two sets of coordinates.
    */
  def distance(x1: Double, y1: Double, x2: Double, y2: Double): Double = js.native

  /**
    * Returns the distance between the two given set of coordinates at the power given.
    * @param x1  The x coordinate of the first value.
    * @param y1  The y coordinate of the first value.
    * @param x2  The x coordinate of the second value.
    * @param y2  The y coordinate of the second value.
    * @param pow optional: exponent
    * @return The distance between the two sets of coordinates.
    */
  def distancePow(x1: Double, y1: Double, x2: Double, y2: Double, pow: Double = js.native): Double = js.native

  /**
    * Returns the euclidean distance squared between the two given set of
    * coordinates (cuts out a square root operation before returning).
    * @param x1 The x coordinate of the first value.
    * @param y1 The y coordinate of the first value.
    * @param x2 The x coordinate of the second value.
    * @param y2 The y coordinate of the second value.
    * @return The distance squared between the two sets of coordinates.
    */
  def distanceSq(x1: Double, y1: Double, x2: Double, y2: Double): Double = js.native

  /**
    * Computes the factorial of the given value
    * @param value the number you want to evaluate
    * @return the factorial value
    */
  def factorial(value: Double): Double = js.native

  /**
    * Floors to some place comparative to a `base`, default is 10 for decimal place.
    * The `place` is represented by the power applied to `base` to get that place.
    * @param value The value to round.
    * @param place The place to round to.
    * @param base  The base to round in. Default is 10 for decimal.
    * @return The rounded value.
    */
  def floorTo(value: Double, place: Double, base: Double): Double = js.native

  /**
    * Applies a fuzzy ceil to the given value.
    * @param value   The value to ceil.
    * @param epsilon The epsilon (a small value used in the calculation)
    * @return `ceiling(value - epsilon)`
    */
  def fuzzyCeil(value: Double, epsilon: Double): Double = js.native

  /**
    * Two number are fuzzyEqual if their difference is less than epsilon.
    * @param a       The first number to compare.
    * @param b       The second number to compare.
    * @param epsilon The epsilon (a small value used in the calculation)
    * @return True if `| a-b | < epsilon`
    */
  def fuzzyEqual(a: Double, b: Double, epsilon: Double): Boolean = js.native

  /**
    * Applies a fuzzy floor to the given value.
    * @param value   The value to floor.
    * @param epsilon The epsilon (a small value used in the calculation)
    * @return `floor(value + epsilon)`
    */
  def fuzzyFloor(value: Double, epsilon: Double): Double = js.native

  /**
    * `a` is fuzzyGreaterThan `b` if it is more than b - epsilon.
    * @param a       The first number to compare.
    * @param b       The second number to compare.
    * @param epsilon The epsilon (a small value used in the calculation)
    * @return True if `a > b + epsilon`
    */
  def fuzzyGreaterThan(a: Double, b: Double, epsilon: Double): Boolean = js.native

  /**
    * `a` is fuzzyLessThan `b` if it is less than `b + epsilon`.
    * @param a       The first number to compare.
    * @param b       The second number to compare.
    * @param epsilon The epsilon (a small value used in the calculation)
    * @return True if `a < b + epsilon`
    */
  def fuzzyLessThan(a: Double, b: Double, epsilon: Double): Boolean = js.native

  /**
    * Gets the shortest angle between `angle1` and `angle2`.
    * Both angles must be in the range -180 to 180, which is the same clamped
    * range that `sprite.angle` uses, so you can pass in two sprite angles to
    * this method, and get the shortest angle back between the two of them.
    * The angle returned will be in the same range. If the returned angle is
    * greater than 0 then it's a counter-clockwise rotation, if < 0 then it's
    * a clockwise rotation.
    * @param angle1 The first angle. In the range -180 to 180.
    * @param angle2 The second angle. In the range -180 to 180.
    * @return The shortest angle, in degrees. If greater than zero it's a counter-clockwise rotation.
    */
  def getShortestAngle(angle1: Double, angle2: Double): Double = js.native

  /**
    * Returns true if the number given is even.
    * @param n The number to check.
    * @return True if the given number is even. False if the given number is odd.
    */
  def isEven(n: Double): Boolean = js.native

  /**
    * Returns true if the number given is odd.
    * @param n The number to check.
    * @return True if the given number is odd. False if the given number is even.
    */
  def isOdd(n: Double): Boolean = js.native

  /**
    * Calculates a linear (interpolation) value over t.
    * @param p0 number
    * @param p1 number
    * @param t  A value between 0 and 1.
    * @return number
    */
  def linear(p0: Double, p1: Double, t: Double): Double = js.native

  /**
    * A Linear Interpolation Method, mostly used by [[Phaser.Tween]].
    * @param v The input array of values to interpolate between.
    * @param k The percentage of interpolation, between 0 and 1.
    * @return The interpolated value
    */
  def linearInterpolation(v: Double, k: Double): Double = js.native

  /**
    * Linear mapping from range to range
    * @param x  The value to map
    * @param a1 First endpoint of the range
    * @param a2 Final endpoint of the range
    * @param b1 First endpoint of the range
    * @param b2 Final endpoint of the range
    * @return number
    */
  def mapLinear(x: Double, a1: Double, a2: Double, b1: Double, b2: Double): Double = js.native

  /**
    * Variation of Math.max that can be passed either an array of numbers or the numbers as parameters.
    * Prefer the standard `Math.max` function when appropriate.
    * @return The largest value from those given.
    */
  def max(): Double = js.native

  /**
    * Adds the given amount to the value, but never lets the value go over the specified maximum.
    * @param value  The value to add the amount to.
    * @param amount The amount to add to the value.
    * @param max    The maximum the value is allowed to be.
    * @return The new value.
    */
  def maxAdd(value: Double, amount: Double, max: Double): Double = js.native

  /**
    * Variation of Math.max that can be passed a property and either an array of objects or the objects as parameters.
    * It will find the largest matching property value from the given objects.
    * @return The largest value from those given.
    */
  def maxProperty(): Double = js.native

  /**
    * Variation of Math.min that can be passed either an array of numbers or the numbers as parameters.
    * Prefer the standard `Math.min` function when appropriate.
    * @return The lowest value from those given.
    */
  def min(): Double = js.native

  /**
    * Variation of Math.min that can be passed a property and either an array of objects or the objects as parameters.
    * It will find the lowest matching property value from the given objects.
    * @return The lowest value from those given.
    */
  def minProperty(): Double = js.native

  /**
    * Subtracts the given amount from the value, but never lets the value go below the specified minimum.
    * @param value  The base value.
    * @param amount The amount to subtract from the base value.
    * @param min    The minimum the value is allowed to be.
    * @return The new value.
    */
  def minSub(value: Double, amount: Double, min: Double): Double = js.native

  /**
    * Normalizes an angle to the [0,2pi) range.
    * @param angleRad The angle to normalize, in radians.
    * @return The angle, fit within the [0,2pi] range, in radians.
    */
  def normalizeAngle(angleRad: Double): Double = js.native

  /**
    * Work out what percentage value `a` is of value `b` using the given base.
    * @param a    The value to work out the percentage for.
    * @param b    The value you wish to get the percentage of.
    * @param base The base value.
    * @return The percentage `a` is of `b`, between `0` and `1`.
    */
  def percent(a: Double, b: Double, base: Double = js.native): Double = js.native

  /**
    * Convert radians to degrees.
    * @param radians Angle in radians.
    * @return Angle in degrees
    */
  def radToDeg(radians: Double): Double = js.native

  /**
    * Reverses an angle.
    * @param angleRad The angle to reverse, in radians.
    * @return The reverse angle, in radians.
    */
  def reverseAngle(angleRad: Double): Double = js.native

  /**
    * Rotates currentAngle towards targetAngle, taking the shortest rotation distance.
    * The lerp argument is the amount to rotate by in this call.
    * @param currentAngle The current angle, in radians.
    * @param targetAngle  The target angle to rotate to, in radians.
    * @param lerp         The lerp value to add to the current angle.
    * @return The adjusted angle.
    */
  def rotateToAngle(currentAngle: Double, targetAngle: Double, lerp: Double): Double = js.native

  /**
    * Round to the next whole number away from zero.
    * @param value Any number.
    * @return The rounded value of that number.
    */
  def roundAwayFromZero(value: Double): Long = js.native

  /**
    * Round to some place comparative to a `base`, default is 10 for decimal place.
    * The `place` is represented by the power applied to `base` to get that place.
    * @param value The value to round.
    * @param place The place to round to.
    * @param base  The base to round in. Default is 10 for decimal.
    * @return The rounded value.
    */
  def roundTo(value: Double, place: Double, base: Double): Double = js.native

  /**
    * Shear
    * @param n a number
    * @return `n mod 1`
    */
  def shear(n: Double): Double = js.native

  /**
    * A value representing the sign of the value: `-1` for negative, `+1` for positive, `0` if value is `0`.
    * This works differently from `Math.sign` for values of `NaN` and `-0`, etc.
    * @param x a number
    * @return An integer in {-1, 0, 1}
    */
  def sign(x: Double): Double = js.native

  /**
    * Generate a sine and cosine table simultaneously and extremely quickly.
    * The parameters allow you to specify the length, amplitude and frequency of the wave.
    * This generator is fast enough to be used in real-time.
    * Code based on research by Franky of scene.at
    * @param length       The length of the wave
    * @param sinAmplitude The amplitude to apply to the sine table (default 1.0) if you need
    *                     values between say -/+ 125 then give 125 as the value
    * @param cosAmplitude The amplitude to apply to the cosine table (default 1.0) if you need
    *                     values between say -/+ 125 then give 125 as the value
    * @param frequency    The frequency of the sine and cosine table data
    * @return Returns the table data.
    */
  def sinCosGenerator(length: Double, sinAmplitude: Double, cosAmplitude: Double, frequency: Double): js.Any = js.native

  /**
    * Smootherstep function as detailed at http://en.wikipedia.org/wiki/Smoothstep
    * @param x   The input value.
    * @param min The left edge. Should be smaller than the right edge.
    * @param max The right edge.
    * @return A value between `0` and `1`.
    */
  def smootherstep(x: Double, min: Double, max: Double): Double = js.native

  /**
    * Smoothstep function as detailed at http://en.wikipedia.org/wiki/Smoothstep
    * @param x   The input value.
    * @param min The left edge. Should be smaller than the right edge.
    * @param max The right edge.
    * @return A value between `0` and `1`.
    */
  def smoothstep(x: Double, min: Double, max: Double): Double = js.native

  /**
    * Snap a value to nearest grid slice, using rounding.
    * Example: if you have an interval gap of 5 and a position of 12... you will snap to 10 whereas 14 will snap to 15.
    * @param input The value to snap.
    * @param gap   The interval gap of the grid.
    * @param start Optional starting offset for gap.
    * @return The snapped value.
    */
  def snapTo(input: Double, gap: Double, start: Double = js.native): Double = js.native

  /**
    * Snap a value to nearest grid slice, using ceil.
    * Example: if you have an interval gap of 5 and a position of 12... you will snap to 15.
    * As will 14 will snap to 15... but 16 will snap to 20.
    * @param input The value to snap.
    * @param gap   The interval gap of the grid.
    * @param start Optional starting offset for gap.
    * @return The snapped value.
    */
  def snapToCeil(input: Double, gap: Double, start: Double = js.native): Double = js.native

  /**
    * Snap a value to nearest grid slice, using floor.
    * Example: if you have an interval gap of 5 and a position of 12... you will snap to 10.
    * As will 14 snap to 10... but 16 will snap to 15.
    * @param input The value to snap.
    * @param gap   The interval gap of the grid.
    * @param start Optional starting offset for gap.
    * @return The snapped value.
    */
  def snapToFloor(input: Double, gap: Double, start: Double = js.native): Double = js.native

  /**
    * Checks if two values are within the given tolerance of each other.
    * @param a         The first number to check
    * @param b         The second number to check
    * @param tolerance The tolerance. Anything equal to or less than this is considered within the range.
    * @return True if `a` is <= tolerance of `b`.
    */
  def within(a: Double, b: Double, tolerance: Double): Double = js.native

  /**
    * Ensures that the value always stays between `min` and `max`, by wrapping the value around.
    * If `max` is not larger than `min` the result is 0.
    * @param value The value to wrap.
    * @param min   The minimum the value is allowed to be.
    * @param max   The maximum the value is allowed to be, should be larger than `min`.
    * @return The wrapped value.
    */
  def wrap(value: Double, min: Double, max: Double): Double = js.native

  /**
    * Keeps an angle value between -180 and +180; or -PI and PI if radians.
    * @param angle   The angle value to wrap
    * @param radians Set to true if the angle is given in radians, otherwise degrees is expected.
    * @return
    */
  def wrapAngle(angle: Double, radians: Double = js.native): Double = js.native

  /**
    * Adds value to amount and ensures that the result always stays between 0 and max, by wrapping the value around.
    * Values must be positive integers, and are passed through Math.abs. See Phaser.Math#wrap for an alternative.
    * @param value  The value to add the amount to.
    * @param amount The amount to add to the value.
    * @param max    The maximum the value is allowed to be.
    * @return The wrapped value.
    */
  def wrapValue(value: Double, amount: Double, max: Double): Double = js.native

}

/**
  * Phaser Math Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Math")
object Math extends Math