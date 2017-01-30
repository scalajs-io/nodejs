package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
trait Keyboard extends js.Object {

  val SPACEBAR: Int = js.native

  def addKey(code: Int): Key = js.native

  def createCursorKeys(): CursorKeys = js.native

}

@js.native
@JSName("Phaser.Keyboard")
object Keyboard extends Keyboard