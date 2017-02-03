package io.scalajs.dom.html.phaser.component

import scala.scalajs.js

/**
  * The Delta component provides access to delta values between the Game Objects current and previous position.
  * @see http://phaser.io/docs/2.6.2/Phaser.Component.Delta.html
  */
@js.native
//@JSName("Phaser.Component.Delta")
trait Delta extends js.Object {

  /**
    * Returns the delta x value. The difference between world.x now and in the previous frame.
    * The value will be positive if the Game Object has moved to the right or negative if to the left.
    */
  def deltaX: Double = js.native

  /**
    * Returns the delta y value. The difference between world.y now and in the previous frame.
    * The value will be positive if the Game Object has moved down or negative if up.
    */
  def deltaY: Double = js.native

  /**
    * Returns the delta z value. The difference between rotation now and in the previous frame. The delta value.
    */
  def deltaZ: Double = js.native

}
