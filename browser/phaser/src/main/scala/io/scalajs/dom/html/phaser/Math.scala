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

}

/**
  * Phaser Math Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Math")
object Math extends Math