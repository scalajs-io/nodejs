package io.scalajs.dom.html.phaser.math

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A collection of useful mathematical functions.
  * These are normally accessed through [[Math game.math]].
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

}

/**
  * Phaser Math Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
object Math extends Math