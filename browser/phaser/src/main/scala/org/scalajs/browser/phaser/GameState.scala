package org.scalajs.browser.phaser

/**
  * Phaser: Game State
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
trait GameState {

  def preload(): Unit

  def create(): Unit

  def update(): Unit

  def render(): Unit

}
