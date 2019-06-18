package io.scalajs.dom.event

import io.scalajs.dom.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Page Transition Event
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class PageTransitionEvent extends Event {

  /**
    * Returns whether the webpage was cached by the browser
    */
  def persisted: Boolean = js.native

}
