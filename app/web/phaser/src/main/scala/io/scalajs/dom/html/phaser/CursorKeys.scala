package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Phaser Cursor Keys
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait CursorKeys extends js.Object {

  def up: Key = js.native

  def down: Key = js.native

  def left: Key = js.native

  def right: Key = js.native

}

/**
  * CursorKeys Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal("Phaser.CursorKeys")
object CursorKeys extends CursorKeys