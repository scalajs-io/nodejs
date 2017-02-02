package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A Camera is your view into the game world. It has a position and size and renders only those objects within its field of view.
  * The game automatically creates a single Stage sized camera on boot. Move the camera around the world with Phaser.Camera.x/y
  * @param game   Game reference to the currently running game.
  * @param id     Not being used at the moment, will be when Phaser supports multiple camera
  * @param x      Position of the camera on the X axis
  * @param y      Position of the camera on the Y axis
  * @param width  The width of the view rectangle
  * @param height The height of the view rectangle
  */
@js.native
@JSName("Phaser.Camera")
class Camera(val game: Game, val id: Int = 0, var x: Double, var y: Double, var width: Double, var height: Double)
    extends js.Object {

  /**
    * Camera view.
    * The view into the world we wish to render (by default the game dimensions).
    * The x/y values are in world coordinates, not screen coordinates, the width/height is how many pixels to render.
    * Sprites outside of this view are not rendered if Sprite.autoCull is set to `true`. Otherwise they are always rendered.
    */
  val view: Rectangle = js.native

  /**
    * The Camera is bound to this Rectangle and cannot move outside of it. By default it is enabled and set to the size of the World.
    * The Rectangle can be located anywhere in the world and updated as often as you like. If you don't wish the Camera to be bound
    * at all then set this to null. The values can be anything and are in World coordinates, with 0,0 being the top-left of the world.
    * @return The Rectangle in which the Camera is bounded. Set to null to allow for movement anywhere.
    */
  val bounds: Rectangle = js.native

}
