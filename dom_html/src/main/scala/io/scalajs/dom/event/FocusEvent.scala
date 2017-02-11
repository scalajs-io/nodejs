package io.scalajs.dom.event

import io.scalajs.dom.{Element, Event}

import scala.scalajs.js

/**
  * Focus Event Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
class FocusEvent extends Event {

  /**
    * Returns the element related to the element that triggered the event
    */
  def relatedTarget: Element = js.native

}
