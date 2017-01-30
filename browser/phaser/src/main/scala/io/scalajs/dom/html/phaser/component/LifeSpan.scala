package io.scalajs.dom.html.phaser.component

import io.scalajs.dom.html.phaser.Phaser
import io.scalajs.dom.html.pixijs.DisplayObject

import scala.scalajs.js

@js.native
//@JSName("Phaser.Component.LifeSpan")
trait LifeSpan extends js.Object {

  /**
    * A useful flag to control if the Game Object is alive or dead.
    *
    * This is set automatically by the Health components damage method should the object run out of health.
    * Or you can toggle it via your game code.
    *
    * This property is mostly just provided to be used by your game - it doesn't effect rendering or logic updates.
    * However you can use Group.getFirstAlive in conjunction with this property for fast object pooling and recycling.
    * @see [[Phaser.Component.LifeSpan#alive]]
    */
  var alive: Boolean = js.native

  def kill(): DisplayObject = js.native

  def revive(health: Double = 1): DisplayObject = js.native
}