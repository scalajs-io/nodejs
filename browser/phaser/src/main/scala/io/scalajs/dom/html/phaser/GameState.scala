package io.scalajs.dom.html.phaser

/**
  * Phaser: Game State
  * @version 2.6.2
  * @author lawrence.daniels@gmail.com
  */
trait GameState {

  def preload(): Unit

  def create(): Unit

  def update(): Unit

  def render(): Unit

}
