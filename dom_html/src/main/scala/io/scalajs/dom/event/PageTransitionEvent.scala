package io.scalajs.dom.event

import io.scalajs.dom.Event

import scala.scalajs.js

/**
  * Page Transition Event
  * @author lawrence.daniels@gmail.com
  */
@js.native
class PageTransitionEvent extends Event {

  /**
    * Returns whether the webpage was cached by the browser
    */
  def persisted: Boolean = js.native

}
