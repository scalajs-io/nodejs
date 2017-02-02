package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The Sound class constructor.
  * @param game   Reference to the current game instance.
  * @param key    Asset key for the sound.
  * @param volume Default value for the volume, between 0 and 1.
  * @param loop   Whether or not the sound will loop.
  */
@js.native
@JSName("Phaser.Sound")
class Sound(val game: Game, val key: String, val volume: Int = js.native, val loop: Boolean = js.native)
    extends js.Object
