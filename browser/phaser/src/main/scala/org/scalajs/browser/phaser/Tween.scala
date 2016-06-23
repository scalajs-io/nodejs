package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Tween
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Tween extends js.Object {

  def to(properties: js.Dictionary[_],
         duration: Int = 1000,
         ease: Any = null,
         autoStart: Boolean = false,
         delay: Int = 0,
         repeat: Int = 0,
         yoyo: Boolean = false): Tween = js.native

  def onLoop: Signal = js.native
}
