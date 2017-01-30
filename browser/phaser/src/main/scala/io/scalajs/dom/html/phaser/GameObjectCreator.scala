package io.scalajs.dom.html.phaser

import io.scalajs.{JsNumber, RawOptions}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The GameObjectCreator is a quick way to create common game objects without adding them to the game world.
  * The object creator can be accessed with `game.make`.
  * @see https://phaser.io/docs/2.6.2/Phaser.GameObjectCreator.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.GameObjectCreator")
class GameObjectCreator(val game: Game) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A reference to the game world
    */
  def world: Phaser.World = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Creates a new Sound object.
    * @param key     The Game.cache key of the sound that this object will use.
    * @param volume  The volume at which the sound will be played.
    * @param loop    Whether or not the sound will loop.
    * @param connect Controls if the created Sound object will connect to the master gainNode of the SoundManager
    *                when running under WebAudio.
    * @return The newly created text object.
    */
  def audio(key: String, volume: JsNumber = js.native, loop: Boolean = js.native, connect: Boolean = js.native): Phaser.Sound = js.native

  /**
    * Creates a new AudioSprite object.
    * @param key The Game.cache key of the sound that this object will use.
    * @return The newly created AudioSprite object.
    */
  def audioSprite(key: String): Phaser.AudioSprite = js.native

  /**
    * Creates a new Text object.
    * @param x     X-position of the new text object.
    * @param y     Y-position of the new text object.
    * @param text  The actual text that will be written.
    * @param style The style object containing style attributes like font, font size , etc.
    * @return The newly created text object.
    */
  def text(x: JsNumber, y: JsNumber, text: String, style: RawOptions): Phaser.Text = js.native

}
