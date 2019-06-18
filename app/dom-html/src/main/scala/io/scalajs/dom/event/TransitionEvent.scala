package io.scalajs.dom.event

import io.scalajs.dom.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Transition Event Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class TransitionEvent extends Event with TransitionEvents {

  /**
    * Returns the name of the CSS property associated with the transition
    */
  def propertyName: String = js.native

  /**
    * Returns the number of seconds a transition has been running
    */
  def elapsedTime: Double = js.native

}
