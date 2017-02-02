package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * This is the core internal game clock.
  *
  * It manages the elapsed time and calculation of elapsed values, used for game object motion and tweens,
  * and also handles the standard Timer pool.
  *
  * To create a general timed event, use the master [[Phaser.Timer]] accessible through events.
  * @param game A reference to the currently running game.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Time")
class Time(val game: Phaser.Game) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * If true then advanced profiling, including the fps rate, fps min/max, suggestedFps and msMin/msMax are updated.
    */
  var advancedTiming: Boolean = js.native

  /**
    * The desired frame rate of the game.
    *
    * This is used is used to calculate the physic / logic multiplier and how to apply catch-up logic updates.
    * The desired frame rate of the game. Defaults to 60.
    */
  var desiredFps: Int = js.native

  /**
    * A [[Phaser.Timer]] object bound to the master clock (this Time object) which events can be added to.
    */
  def events: Phaser.Timer = js.native

  /**
    * Advanced timing result: Frames per second.
    *
    * Only calculated if [[advancedTiming]] is enabled.
    * @return
    */
  def fps: Double = js.native

  /**
    * Advanced timing result: The highest rate the fps has reached (usually no higher than 60fps).
    *
    * Only calculated if [[advancedTiming]] is enabled.
    * This value can be manually reset.
    */
  def fpsMax: Double = js.native

  /**
    * Advanced timing result: The lowest rate the fps has dropped to.
    *
    * Only calculated if [[advancedTiming]] is enabled.
    * This value can be manually reset.
    */
  var fpsMin: Double = js.native

  /**
    * Advanced timing result: The number of render frames record in the last second.
    *
    * Only calculated if [[advancedTiming]] is enabled.
    */
  def frames: Int = js.native

  /**
    * Advanced timing result: The maximum amount of time the game has taken between consecutive frames.
    *
    * Only calculated if [[advancedTiming]] is enabled.
    * This value can be manually reset.
    */
  def msMax: Double = js.native

  /**
    * Advanced timing result: The minimum amount of time the game has taken between consecutive frames.
    *
    * Only calculated if [[advancedTiming]] is enabled.
    * This value can be manually reset.
    */
  def msMin: Double = js.native

  /**
    * An increasing value representing cumulative milliseconds since an undisclosed epoch.
    *
    * While this value is in milliseconds and can be used to compute time deltas,
    * it must must not be used with `Date.now()` as it may not use the same epoch / starting reference.
    *
    * The source may either be from a high-res source (eg. if RAF is available) or the standard `Date.now`;
    * the value can only be relied upon within a particular game instance.
    */
  def now: Double = js.native

  /**
    * Records how long the game was last paused, in milliseconds.
    * (This is not updated until the game is resumed.)
    */
  def pauseDuration: Double = js.native

  /**
    * The physics update delta, in fractional seconds.
    *
    * This should be used as an applicable multiplier by all logic update steps (eg. `preUpdate/postUpdate/update`)
    * to ensure consistent game timing. Game/logic timing can drift from real-world time if the system
    * is unable to consistently maintain the desired FPS.
    *
    * With fixed-step updates this is normally equivalent to `1.0 / desiredFps`.
    */
  def physicsElapsed: Double = js.native

  /**
    * The physics update delta, in milliseconds - equivalent to `physicsElapsed * 1000`.
    */
  def physicsElapsedMS: Double = js.native

  /**
    * Scaling factor to make the game move smoothly in slow motion
    * <ul>
    * <li>1.0 = normal speed</li>
    * <li>2.0 = half speed</li>
    * <ul>
    */
  def slowMotion: Double = js.native

  /**
    * The suggested frame rate for your game, based on an averaged real frame rate.
    * This value is only populated if [[Time.advancedTiming]] is enabled.
    *
    * Note: This is not available until after a few frames have passed; until then
    * it's set to the same value as desiredFps.
    */
  def suggestedFps: Double = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds an existing Phaser.Timer object to the Timer pool.
    * @param timer An existing [[Phaser.Timer]] object.
    * @return The given [[Phaser.Timer]] object.
    */
  def add(timer: Phaser.Timer): Phaser.Timer = js.native

  /**
    * Creates a new stand-alone Phaser.Timer object.
    * @param autoDestroy A Timer that is set to automatically destroy itself will do so after all of its events have
    *                    been dispatched (assuming no looping events).
    * @return The [[Phaser.Timer Timer]] object that was created.
    */
  def create(autoDestroy: Boolean = js.native): Phaser.Timer = js.native

  /**
    * How long has passed since the given time (in seconds).
    * @param since The time you want to measure (in seconds).
    * @return Duration between given time and now (in seconds).
    */
  def elapsedSecondsSince(since: Double): Double = js.native

  /**
    * How long has passed since the given time.
    * @param since The time you want to measure against.
    * @return The difference between the given time and now.
    */
  def elapsedSince(since: Double): Double = js.native

  /**
    * Refreshes the Time.time and Time.elapsedMS properties from the system clock.
    */
  def refresh(): Unit = js.native

  /**
    * Remove all Timer objects, regardless of their state and clears all Timers from the events timer.
    */
  def removeAll(): Unit = js.native

  /**
    * Resets the private _started value to now and removes all currently running Timers.
    */
  def reset(): Unit = js.native

  /**
    * The number of seconds that have elapsed since the game was started.
    */
  def totalElapsedSeconds(): Double = js.native

}
