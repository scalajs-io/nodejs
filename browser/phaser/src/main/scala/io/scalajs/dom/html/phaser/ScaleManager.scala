package io.scalajs.dom.html.phaser

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * Create a new ScaleManager object - this is done automatically by [[Phaser.Game]]
  *
  * The width and height constructor parameters can either be a number which represents pixels or a string that
  * represents a percentage: e.g. 800 (for 800 pixels) or "80%" for 80%.
  * @param game   A reference to the currently running game.
  * @param width  The width of the game. See above.
  * @param height The height of the game. See above.
  * @see https://phaser.io/docs/2.6.2/Phaser.ScaleManager.html
  */
@js.native
@JSName("Phaser.ScaleManager")
class ScaleManager(val game: Phaser.Game, val width: JsNumber | String, val height: JsNumber | String)
    extends js.Object {}
