package io.scalajs.dom.html.phaser.component

import scala.scalajs.js

@js.native
//@JSName("Phaser.Component.Angle")
trait Angle extends js.Object {

  /**
    * The angle property is the rotation of the Game Object in degrees from its original orientation.
    *
    * Values from 0 to 180 represent clockwise rotation; values from 0 to -180 represent counterclockwise rotation.
    *
    * Values outside this range are added to or subtracted from 360 to obtain a value within the range.
    * For example, the statement player.angle = 450 is the same as player.angle = 90.
    *
    * If you wish to work in radians instead of degrees you can use the property rotation instead.
    * Working in radians is slightly faster as it doesn't have to perform any calculations.
    */
  def angle: Double = js.native

  def angle_=(angle: Double): Unit = js.native

}
