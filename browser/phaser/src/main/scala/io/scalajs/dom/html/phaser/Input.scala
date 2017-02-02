package io.scalajs.dom.html.phaser

import scala.scalajs.js

@js.native
trait Input extends js.Object {
  val keyboard: Keyboard = js.native
  val onTap: Signal      = js.native
}
