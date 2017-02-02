package io.scalajs.dom.html.phaser

import io.scalajs.RawOptions

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
  def audio(key: String, volume: Double = js.native, loop: Boolean = js.native, connect: Boolean = js.native): Phaser.Sound = js.native

  /**
    * Creates a new AudioSprite object.
    * @param key The Game.cache key of the sound that this object will use.
    * @return The newly created AudioSprite object.
    */
  def audioSprite(key: String): Phaser.AudioSprite = js.native

  /**
    * Create a BitmpaData object.
    * A BitmapData object can be manipulated and drawn to like a traditional Canvas object and used to texture Sprites.
    * @param width      The width of the BitmapData in pixels.
    * @param height     The height of the BitmapData in pixels.
    * @param key        Asset key for the BitmapData when stored in the Cache (see addToCache parameter).
    * @param addToCache Should this BitmapData be added to the Game.Cache? If so you can retrieve it with Cache.getBitmapData(key)
    * @return The newly created [[Phaser.BitmapData]] object.
    */
  def bitmapData(width: Double = js.native, height: Double = js.native, key: String = js.native, addToCache: Boolean = js.native): Phaser.BitmapData = js.native

  /**
    * Create a new BitmapText object.
    * BitmapText objects work by taking a texture file and an XML file that describes the font structure.
    * It then generates a new Sprite object for each letter of the text, proportionally spaced out and aligned to
    * match the font structure.
    *
    * BitmapText objects are less flexible than Text objects, in that they have less features such as shadows, fills and the ability
    * to use Web Fonts. However you trade this flexibility for pure rendering speed. You can also create visually compelling BitmapTexts by
    * processing the font texture in an image editor first, applying fills and any other effects required.
    * To create multi-line text insert \r, \n or \r\n escape codes into the text string.
    * @param x     X-coordinate to display the BitmapText object at.
    * @param y     Y-coordinate to display the BitmapText object at.
    * @param font  The key of the BitmapText as stored in Phaser.Cache.
    * @param text  The text that will be rendered. This can also be set later via BitmapText.text.
    * @param size  The size the font will be rendered at in pixels.
    * @param align The alignment of multi-line text. Has no effect if there is only one line of text.
    * @return The newly created bitmapText object.
    */
  def bitmapText(x: Double, y: Double, font: String, text: String, size: Double, align: String): Phaser.BitmapData = js.native

  /**
    * Creates a new Text object.
    * @param x     X-position of the new text object.
    * @param y     Y-position of the new text object.
    * @param text  The actual text that will be written.
    * @param style The style object containing style attributes like font, font size , etc.
    * @return The newly created [[Phaser.BitmapText text object]].
    */
  def text(x: Double, y: Double, text: String, style: RawOptions): Phaser.Text = js.native

}
