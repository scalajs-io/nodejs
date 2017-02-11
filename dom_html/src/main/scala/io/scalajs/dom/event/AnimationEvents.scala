package io.scalajs.dom.event

import scala.scalajs.js

/**
  * Animation Event
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AnimationEvents extends js.Object {

  /**
    * The event occurs when a CSS animation has completed
    */
  def animationend(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a CSS animation is repeated
    */
  def animationiteration(callback: js.Function): Unit = js.native

  /**
    * The event occurs when a CSS animation has started
    */
  def animationstart(callback: js.Function): Unit = js.native

}
