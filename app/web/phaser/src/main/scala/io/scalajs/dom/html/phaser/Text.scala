package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Create a new game object for displaying Text.
  *
  * This uses a local hidden Canvas object and renders the type into it. It then makes a texture from this for rendering to the view.
  * Because of this you can only display fonts that are currently loaded and available to the browser: fonts must be pre-loaded.
  * @param game  Current game instance.
  * @param x     X position of the new text object.
  * @param y     Y position of the new text object.
  * @param text  The actual text that will be written.
  * @param style The style properties to be set on the Text.
  */
@js.native
@JSGlobal("Phaser.Text")
class Text(game: Phaser.Game,
           x: Double,
           y: Double,
           var text: String,
           var style: StyleOptions = js.native) extends Sprite
