package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Audio Sprites are a combination of audio files and a JSON configuration. The JSON follows the format of that
  * created by https://github.com/tonistiigi/audiosprite.
  * @param game the reference to the current game instance.
  * @param key  the asset key for the sound.
  */
@js.native
@JSName("Phaser.AudioSprite")
class AudioSprite(val game: Game, val key: String) extends js.Object {

  /**
    * Is a sound set to autoplay or not?
    */
  var autoplay: Boolean = js.native

  /**
    * If a sound is set to auto play, this holds the marker key of it.
    */
  var autoplayKey: String = js.native

  /**
    * JSON audio atlas object.
    */
  var config: js.Any = js.native

  /**
    * An object containing the Phaser.Sound objects for the Audio Sprite.
    */
  var sounds: js.Any = js.native

  /**
    * Get a sound with the given name.
    * @param marker The name of sound to get.
    * @return The sound instance.
    */
  def get(marker: String): Sound = js.native

  /**
    * Play a sound with the given name.
    * @param marker The name of sound to play
    * @param volume Volume of the sound you want to play. If none is given it will use the volume given to the Sound
    *               when it was created (which defaults to 1 if none was specified).
    * @return This sound instance.
    */
  def play(marker: String, volume: Int): Sound = js.native

  /**
    * Stop a sound with the given name.
    * @param marker The name of sound to stop. If none is given it will stop all sounds in the audio sprite.
    */
  def stop(marker: String): Unit = js.native

}