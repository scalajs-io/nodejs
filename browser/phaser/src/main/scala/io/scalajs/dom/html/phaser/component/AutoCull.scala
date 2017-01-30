package io.scalajs.dom.html.phaser.component

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
//@JSName("Phaser.Component.AutoCull")
trait AutoCull extends js.Object {

  /**
    * A Game Object with `autoCull` set to true will check its bounds against the World Camera every frame.
    * If it is not intersecting the Camera bounds at any point then it has its `renderable` property set to `false`.
    * This keeps the Game Object alive and still processing updates, but forces it to skip the render step entirely.
    * *
    * This is a relatively expensive operation, especially if enabled on hundreds of Game Objects. So enable it only if you know it's required,
    * or you have tested performance and find it acceptable.
    */
  def autoCull: Boolean = js.native

}