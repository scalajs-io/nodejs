package io.scalajs.dom.html.phaser

import io.scalajs.JsNumber

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * An Animation instance contains a single animation and the controls to play it.
  *
  * It is created by the [[AnimationManager]], consists of Animation.Frame objects and
  * belongs to a single Game Object such as a Sprite.
  * @param game      A reference to the currently running game.
  * @param parent    A reference to the owner of this Animation.
  * @param name      The unique name for this animation, used in playback commands.
  * @param frameData The FrameData object that contains all frames used by this Animation.
  * @param frames    An array of numbers or strings indicating which frames to play in which order.
  * @param frameRate The speed at which the animation should play. The speed is given in frames per second.
  * @param loop      Whether or not the animation is looped or just plays once.
  * @see https://phaser.io/docs/2.6.2/Phaser.Animation.html
  */
@js.native
@JSName("Phaser.Animation")
class Animation(var game: Phaser.Game,
                var parent: Phaser.Sprite,
                var name: String,
                var frameData: Phaser.FrameData,
                var frames: js.Array[JsNumber | String],
                var frameRate: Double = js.native,
                var loop: Boolean = js.native)
  extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The currently displayed frame of the Animation.
    */
  var currentFrame: Phaser.Frame = js.native

  /**
    * The delay in ms between each frame of the Animation, based on the given frameRate.
    */
  var delay: Double = js.native

  /**
    * Gets or sets if this animation will dispatch the onUpdate events upon changing frame.
    */
  var enableUpdate: Boolean = js.native

  /**
    * Gets or sets the current frame index and updates the Texture Cache for display.
    */
  var frame: Int = js.native

  /**
    * The total number of frames in the currently loaded FrameData, or -1 if no FrameData is loaded.
    */
  def frameTotal: Int = js.native

  /**
    * The finished state of the Animation. Set to true once playback completes, false during playback.
    */
  var isFinished: Boolean = js.native

  /**
    * The paused state of the Animation.
    */
  var isPaused: Boolean = js.native

  /**
    * The playing state of the Animation. Set to false once playback completes, true during playback.
    */
  var isPlaying: Boolean = js.native

  /**
    * Indicates if the animation will play backwards.
    */
  var isReversed: Boolean = js.native

  /**
    * Should the parent of this Animation be killed when the animation completes?
    */
  var killOnComplete: Boolean = js.native

  /**
    * The number of times the animation has looped since it was last started.
    */
  var loopCount: Int = js.native

  /**
    * This event is dispatched when this Animation completes playback. If the animation is set to loop
    * this is never fired, listen for onLoop instead.
    */
  var onComplete: Phaser.Signal = js.native

  /**
    * This event is dispatched when this Animation starts playback.
    */
  var onLoop: Phaser.Signal = js.native

  /**
    * This event is dispatched when the Animation changes frame.
    * By default this event is disabled due to its intensive nature. Enable it with: `Animation.enableUpdate = true`.
    * Note that the event is only dispatched with the current frame. In a low-FPS environment Animations
    * will automatically frame-skip to try and claw back time, so do not base your code on expecting to
    * receive a perfectly sequential set of frames from this event.
    */
  var onUpdate: Phaser.Signal = js.native

  /**
    * Gets and sets the paused state of this Animation.
    */
  var paused: Boolean = js.native

  /**
    * Gets and sets the isReversed state of this Animation.
    */
  var reversed: Boolean = js.native

  /**
    * Gets or sets the current speed of the animation in frames per second. Changing this in a playing
    * animation will take effect from the next frame. Value must be greater than 0.
    */
  var speed: Double = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Called internally when the animation finishes playback.
    * Sets the isPlaying and isFinished states and dispatches the onAnimationComplete event
    * if it exists on the parent and local onComplete event.
    */
  def complete(): Unit = js.native

  /**
    * Cleans up this animation ready for deletion. Nulls all values and references.
    */
  def destroy(): Unit = js.native

  /**
    * Advances by the given number of frames in the Animation, taking the loop value into consideration.
    * @param quantity The number of frames to advance.
    */
  def next(quantity: Int = js.native): Unit = js.native

  /**
    * Called when the Game enters a paused state.
    */
  def onPause(): Unit = js.native

  /**
    * Called when the Game resumes from a paused state.
    */
  def onResume(): Unit = js.native

  /**
    * Plays this animation.
    * @param frameRate      The framerate to play the animation at. The speed is given in frames per second.
    *                       If not provided the previously set frameRate of the Animation is used.
    * @param loop           Should the animation be looped after playback. If not provided the previously
    *                       set loop value of the Animation is used.
    * @param killOnComplete If set to true when the animation completes (only happens if loop=false)
    *                       the parent Sprite will be killed.
    * @return A reference to this Animation instance.
    */
  def play(frameRate: Double = js.native, loop: Boolean = js.native, killOnComplete: Boolean = js.native): this.type = js.native

  /**
    * Moves backwards the given number of frames in the Animation, taking the loop value into consideration.
    * @param quantity The number of frames to move back.
    */
  def previous(quantity: Int = js.native): Unit = js.native

  /**
    * Sets this animation back to the first frame and restarts the animation.
    */
  def restart(): Unit = js.native

  /**
    * Reverses the animation direction.
    * @return A reference to this Animation instance.
    */
  def reverse(): this.type = js.native

  /**
    * Reverses the animation direction for the current/next animation only
    * Once the onComplete event is called this method will be called again and revert
    * the reversed state.
    * @return The animation instance.
    */
  def reverseOnce(): this.type = js.native

  /**
    * Sets this animations playback to a given frame with the given ID.
    * @param frameId            The identifier of the frame to set. Can be the name of the frame, the sprite index
    *                           of the frame, or the animation-local frame index.
    * @param useLocalFrameIndex If you provide a number for frameId, should it use the numeric indexes of the frameData,
    *                           or the 0-indexed frame index local to the animation.
    */
  def setFrame(frameId: JsNumber | String = js.native, useLocalFrameIndex: Boolean = js.native): Unit = js.native

  /**
    * Stops playback of this animation and set it to a finished state. If a resetFrame is provided it will
    * stop playback and set frame to the first in the animation.
    * If `dispatchComplete` is true it will dispatch the complete events, otherwise they'll be ignored.
    * @param resetFrame       If true after the animation stops the currentFrame value will be set to
    *                         the first frame in this animation.
    * @param dispatchComplete Dispatch the Animation.onComplete and parent.onAnimationComplete events?
    */
  def stop(resetFrame: Boolean = js.native, dispatchComplete: Boolean = js.native): Unit = js.native

  /**
    * Updates this animation. Called automatically by the [[AnimationManager]].
    */
  def update(): Unit = js.native

  /**
    * Changes the FrameData object this Animation is using.
    * @param frameData The FrameData object that contains all frames used by this Animation.
    */
  def updateFrameData(frameData: Phaser.FrameData): Unit = js.native

}

/**
  * Animation Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Animation")
object Animation extends js.Object {

  /**
    * Really handy function for when you are creating arrays of animation data but it's using frame names and not numbers.
    * For example imagine you've got 30 frames named: 'explosion_0001-large' to 'explosion0030-large'
    * You could use this function to generate those by doing: Phaser.Animation.generateFrameNames('explosion', 1, 30, '-large', 4);
    * @param prefix  The start of the filename. If the filename was 'explosion0001-large' the prefix would be 'explosion'.
    * @param start   The number to start sequentially counting from. If your frames are named 'explosion_0001' to
    *                'explosion_0034' the start is 1.
    * @param stop    The number to count to. If your frames are named 'explosion_0001' to 'explosion_0034' the stop value is 34.
    * @param suffix  The end of the filename. If the filename was 'explosion_0001-large' the prefix would be '-large'.
    * @param zeroPad The number of zeros to pad the min and max values with. If your frames are named 'explosion_0001'
    *                to 'explosion_0034' then the zeroPad is 4.
    * @return An array of framenames.
    */
  def generateFrameNames(prefix: String, start: Double, stop: Double, suffix: String = js.native, zeroPad: Int = js.native): js.Array[String] = js.native

}
