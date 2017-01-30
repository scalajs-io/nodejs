package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("Phaser.Tween")
class Tween extends js.Object {

  def to(properties: js.Dictionary[_],
         duration: Int = 1000,
         ease: Any = null,
         autoStart: Boolean = false,
         delay: Int = 0,
         repeat: Int = 0,
         yoyo: Boolean = false): Tween = js.native

  def onLoop: Signal = js.native

}
