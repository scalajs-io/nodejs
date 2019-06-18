package io.scalajs.dom.html.phaser.component

import io.scalajs.dom.html.pixijs.DisplayObject

import scala.scalajs.js

@js.native
//@JSGlobal("Phaser.Component.Reset")
trait Reset extends js.Object {

  def reset(x: Double, y: Double, health: Double = 1): DisplayObject = js.native

}
