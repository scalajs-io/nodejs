package io.scalajs.dom.html.phaser

import scala.scalajs.js

@js.native
trait Loader extends js.Object {

  def image(key: String, url: String): Unit = js.native

  def spritesheet(key: String, url: String, frameWidth: Int, frameHeight: Int, frameMax: Int = -1, margin: Int = 0, spacing: Int = 0): Unit = js.native

}
