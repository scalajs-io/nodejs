package io.scalajs.dom.html.phaser.component

import scala.scalajs.js

@js.native
//@JSName("Phaser.Component.Smoothed")
trait Smoothed extends js.Object {

  /**
    * Enable or disable texture smoothing for this Game Object.
    * It only takes effect if the Game Object is using an image based texture.
    * Smoothing is enabled by default.
    */
  var smoothed: Boolean = js.native

}
