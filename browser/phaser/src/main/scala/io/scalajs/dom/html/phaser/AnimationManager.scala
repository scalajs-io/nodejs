package io.scalajs.dom.html.phaser

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * The Animation Manager is used to add, play and update Phaser Animations.
  * Any Game Object such as Phaser.Sprite that supports animation contains a single AnimationManager instance.
  * @param sprite A reference to the Game Object that owns this AnimationManager.
  * @see https://phaser.io/docs/2.6.2/Phaser.AnimationManager.html
  */
@js.native
@JSName("Phaser.AnimationManager")
class AnimationManager(sprite: Phaser.Sprite) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The currently displayed animation, if any.
    */
  var currentAnim: Phaser.Animation = js.native

  /**
    * The currently displayed Frame of animation, if any.
    * This property is only set once an Animation starts playing. Until that point it remains set as null.
    */
  var currentFrame: Phaser.Frame = js.native

  /**
    * Gets or sets the current frame index and updates the Texture Cache for display.
    */
  var frame: Int = js.native

  /**
    * The current animations FrameData
    */
  def frameData: Phaser.FrameData = js.native

  /**
    * Gets or sets the current frame name and updates the Texture Cache for display.
    */
  var frameName: String = js.native

  /**
    * The total number of frames in the currently loaded FrameData, or -1 if no FrameData is loaded.
    */
  def frameTotal: Int = js.native

  /**
    * A reference to the currently running Game.
    */
  var game: Phaser.Game = js.native

  /**
    * Set to true once animation data has been loaded.
    */
  var isLoaded: Boolean = js.native

  /**
    * Gets the current animation name, if set.
    */
  var name: String = js.native

  /**
    * Gets and sets the paused state of the current animation.
    */
  var paused: Boolean = js.native

  /**
    * Should the animation data continue to update even if the Sprite.visible is set to false.
    */
  var updateIfVisible: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds a new animation under the given key. Optionally set the frames, frame rate and loop.
    * Animations added in this way are played back with the play function.
    * @param name            The unique (within this Sprite) name for the animation, i.e. "run", "fire", "walk".
    * @param frames          An array of numbers/strings that correspond to the frames to add to this animation and in
    *                        which order. e.g. [1, 2, 3] or ['run0', 'run1', run2]). If null then all frames will be used.
    * @param frameRate       The speed at which the animation should play. The speed is given in frames per second.
    * @param loop            Whether or not the animation is looped or just plays once.
    * @param useNumericIndex Are the given frames using numeric indexes (default) or strings?
    * @return
    */
  def add(name: String,
          frames: js.Array[JsNumber | String] = js.native,
          frameRate: Double = js.native,
          loop: Boolean = js.native,
          useNumericIndex: Boolean = js.native): Animation = js.native

  /**
    * Destroys all references this AnimationManager contains.
    * Iterates through the list of animations stored in this manager and calls destroy on each of them.
    */
  def destroy(): Unit = js.native

  /**
    * Returns an animation that was previously added by name.
    * @param name The name of the animation to be returned, e.g. "fire".
    * @return The [[Animation]] instance, if found, otherwise null.
    */
  def getAnimation(name: String): Phaser.Animation = js.native

  /**
    * Advances by the given number of frames in the current animation, taking the loop value into consideration.
    * @param quantity The number of frames to advance.
    */
  def next(quantity: Int = js.native): Unit = js.native

  /**
    * Play an animation based on the given key. The animation should previously have been added via animations.add
    * If the requested animation is already playing this request will be ignored.
    * If you need to reset an already running animation do so directly on the Animation object itself.
    * @param name           The name of the animation to be played, e.g. "fire", "walk", "jump".
    * @param frameRate      The framerate to play the animation at. The speed is given in frames per second.
    *                       If not provided the previously set frameRate of the Animation is used.
    * @param loop           Should the animation be looped after playback. If not provided the previously set
    *                       loop value of the Animation is used.
    * @param killOnComplete If set to true when the animation completes (only happens if loop=false) the parent Sprite will be killed.
    * @return A reference to playing [[Animation]] instance.
    */
  def play(name: String, frameRate: Double = js.native, loop: Boolean = js.native, killOnComplete: Boolean = js.native): Phaser.Animation = js.native

  /**
    * Moves backwards the given number of frames in the current animation, taking the loop value into consideration.
    * @param quantity The number of frames to move back.
    */
  def previous(quantity: Int = js.native): Unit = js.native

  /**
    * Refreshes the current frame data back to the parent Sprite and also resets the texture data.
    */
  def refreshFrame(): Unit = js.native

  /**
    * Stop playback of an animation. If a name is given that specific animation is stopped, otherwise the
    * current animation is stopped.
    *
    * The currentAnim property of the AnimationManager is automatically set to the animation given.
    * @param name       The name of the animation to be stopped, e.g. "fire". If none is given the currently
    *                   running animation is stopped.
    * @param resetFrame When the animation is stopped should the currentFrame be set to the first frame of the
    *                   animation (true) or paused on the last frame displayed (false)
    */
  def stop(name: String = js.native, resetFrame: Boolean = js.native): Unit = js.native

  /**
    *
    * @param frames An array of frames to be validated.
    * @param useNumericIndex Validate the frames based on their numeric index (true) or string index (false)
    * @return True if all given Frames are valid, otherwise false.
    */
  def validateFrames(frames: js.Array[_], useNumericIndex: Boolean = js.native): Boolean = js.native

}
