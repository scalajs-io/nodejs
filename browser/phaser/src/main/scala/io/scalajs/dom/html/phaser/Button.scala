package io.scalajs.dom.html.phaser

import io.scalajs.{JsNumber, RawOptions}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * Create a new Button object. A Button is a special type of Sprite that is set-up to handle Pointer events automatically.
  *
  * The four states a Button responds to are:
  *
  * 'Over' - when the Pointer moves over the Button. This is also commonly known as 'hover'.
  * 'Out' - when the Pointer that was previously over the Button moves out of it.
  * 'Down' - when the Pointer is pressed down on the Button. I.e. touched on a touch enabled device or clicked with the mouse.
  * 'Up' - when the Pointer that was pressed down on the Button is released again.
  * A different texture/frame and activation sound can be specified for any of the states.
  *
  * Frames can be specified as either an integer (the frame ID) or a string (the frame name);
  * the same values that can be used with a Sprite constructor.
  * @param game            Current game instance.
  * @param x               X position of the Button.
  * @param y               Y position of the Button.
  * @param key             The image key (in the Game.Cache) to use as the texture for this Button.
  * @param callback        The function to call when this Button is pressed.
  * @param callbackContext The context in which the callback will be called (usually 'this').
  * @param overFrame       The frame / frameName when the button is in the Over state.
  * @param outFrame        The frame / frameName when the button is in the Out state.
  * @param downFrame       The frame / frameName when the button is in the Down state.
  * @param upFrame         The frame / frameName when the button is in the Up state.
  */
@js.native
@JSName("Phaser.Button")
class Button(game: Phaser.Game,
             x: Double,
             y: Double,
             key: String,
             var callback: js.Function,
             var callbackContext: RawOptions,
             var overFrame: String | JsNumber,
             var outFrame: String | JsNumber,
             var downFrame: String | JsNumber,
             var upFrame: String | JsNumber) extends Phaser.Image {

  /**
    * When the Button is touched / clicked and then released you can force it to enter a state of "out" instead of "up".
    * This can also accept a pointer mode bitmask for more refined control.
    */
  var forceOut: Boolean | Phaser.PointerMode = js.native

  /**
    * When true the the texture frame will not be automatically switched on up/down/over/out events.
    */
  var freezeFrames: Boolean = js.native

  /**
    * Suppress the over event if a pointer was just released and it matches the given pointer mode bitmask.
    * This behavior was introduced in Phaser 2.3.1; this property is a soft-revert of the change.
    */
  var justReleasedPreventsOver: Phaser.PointerMode = js.native

  /**
    * The Sound Marker used in conjunction with the onDownSound.
    */
  def onDownSoundMarker: String = js.native

  /**
    * The Signal (or event) dispatched when this Button is in an Down state.
    */
  var onInputDown: Phaser.Signal = js.native

  /**
    * The Signal (or event) dispatched when this Button is in an Out state.
    */
  var onInputOut: Phaser.Signal = js.native

  /**
    * The Signal (or event) dispatched when this Button is in an Over state.
    */
  var onInputOver: Phaser.Signal = js.native

  /**
    * The Signal (or event) dispatched when this Button is in an Up state.
    */
  var onInputUp: Phaser.Signal = js.native

  /**
    * The Sound to be played when this Buttons Out state is activated.
    */
  var onOutSound: Phaser.Sound | Phaser.AudioSprite = js.native

  /**
    * The Sound Marker used in conjunction with the onOutSound.
    */
  def onOutSoundMarker: String = js.native

  /**
    * If true then onOver events (such as onOverSound) will only be triggered if the Pointer object causing them was the Mouse Pointer.
    * The frame will still be changed as applicable.
    */
  var onOverMouseOnly: Boolean = js.native

  /**
    * The Sound to be played when this Buttons Over state is activated.
    */
  def onOverSound: Phaser.Sound | Phaser.AudioSprite = js.native

  /**
    * The Sound Marker used in conjunction with the onOverSound.
    */
  def onOverSoundMarker: String = js.native

  /**
    * The Sound to be played when this Buttons Up state is activated.
    */
  def onUpSound: Phaser.Sound | Phaser.AudioSprite = js.native

  /**
    * The Sound Marker used in conjunction with the onUpSound.
    */
  def onUpSoundMarker: String = js.native

  /**
    * A Game Object is that is pendingDestroy is flagged to have its destroy method called on the next logic update.
    * You can set it directly to allow you to flag an object to be destroyed on its next update.
    *
    * This is extremely useful if you wish to destroy an object from within one of its own callbacks
    * such as with Buttons or other Input events.
    */
  var pendingDestroy: Boolean = js.native

  /**
    * The const physics body type of this object.
    */
  def physicsType: Int = js.native

  /**
    * The position the Game Object was located in the previous frame.
    */
  def previousPosition: Phaser.Point = js.native

  /**
    * The rotation the Game Object was in set to in the previous frame. Value is in radians.
    */
  def previousRotation: Int = js.native

  /**
    * The render order ID is used internally by the renderer and Input Manager and should not be modified.
    * This property is mostly used internally by the renderers, but is exposed for the use of plugins.
    */
  def renderOrderID: Int = js.native



}
