package io.scalajs.dom.html.phaser

import scala.scalajs.js

@js.native
trait State extends js.Object {

  def add(name: String, state: GameState): Unit = js.native

  def start(name: String): Unit = js.native
}
