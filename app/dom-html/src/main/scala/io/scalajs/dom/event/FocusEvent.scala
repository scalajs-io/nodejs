package io.scalajs.dom.event

import io.scalajs.dom.{Element, Event}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Focus Event Object
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class FocusEvent extends Event {

  /**
    * Returns the element related to the element that triggered the event
    */
  def relatedTarget: Element = js.native

}
