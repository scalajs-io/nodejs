package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
@JSName("Phaser.State")
class State extends js.Object {

  def add(name: String, state: GameState): Unit = js.native

  def start(name: String): Unit = js.native

}
