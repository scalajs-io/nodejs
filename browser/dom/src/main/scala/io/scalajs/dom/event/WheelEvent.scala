package io.scalajs.dom.event

import io.scalajs.dom.Event

import scala.scalajs.js

/**
  * Wheel Event Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
class WheelEvent extends Event {

  /**
    * Returns the horizontal scroll amount of a mouse wheel (x-axis)
    */
  def deltaX: Int = js.native

  /**
    * Returns the vertical scroll amount of a mouse wheel (y-axis)
    */
  def deltaY: Int = js.native

  /**
    * Returns the scroll amount of a mouse wheel for the z-axis
    */
  def deltaZ: Int = js.native

  /**
    * Returns a number that represents the unit of measurements for delta values (pixels, lines or pages)
    */
  def deltaMode: Int = js.native

}
