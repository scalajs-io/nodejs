package io.scalajs.dom.html.phaser.component

import io.scalajs.dom.html.pixijs.DisplayObject

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("Phaser.Component.LifeSpan")
trait LifeSpan extends js.Object {
  var alive: Boolean = js.native

  def kill(): DisplayObject = js.native

  def revive(health: Double = 1): DisplayObject = js.native
}