package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Creates a Ellipse object. A curve on a plane surrounding two focal points.
  * @param x      The X coordinate of the upper-left corner of the framing rectangle of this ellipse.
  * @param y      The Y coordinate of the upper-left corner of the framing rectangle of this ellipse.
  * @param width  The overall width of this ellipse.
  * @param height The overall height of this ellipse.
  */
@js.native
@JSName("Phaser.Ellipse")
class Ellipse(var x: Double, var y: Double, var width: Double, var height: Double) extends js.Object
