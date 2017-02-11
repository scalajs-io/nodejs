package io.scalajs.dom.event

import io.scalajs.dom.Event

import scala.scalajs.js

/**
  * Animation Event Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
class AnimationEvent extends Event with AnimationEvents {

  /**
    * Returns the name of the animation
    */
  def animationName: String = js.native

  /**
    * Returns the number of seconds an animation has been running
    */
  def elapsedTime: Double = js.native

}
