package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Created by ldaniels on 12/14/16.
  */
@js.native
trait TransitionEvents extends js.Object {

  /**
    * The event occurs when a CSS transition has completed
    */
  def transitionend: Boolean = js.native

}
