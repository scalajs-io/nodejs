package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: State
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait State extends js.Object {

  def add(name: String, state: GameState): Unit = js.native

  def start(name: String): Unit = js.native

}
