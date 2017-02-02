package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A Timer is a way to create and manage timer events that wait for a specific duration and then run a callback.
  * Many different timer events, with individual delays, can be added to the same Timer.
  *
  * All Timer delays are in milliseconds (there are 1000 ms in 1 second); so a delay value of 250 represents a quarter of a second.
  *
  * Timers are based on real life time, adjusted for game pause durations.
  * That is, timer events are based on elapsed game time and do not take physics time or slow motion into account.
  * @param game        A reference to the currently running game.
  * @param autoDestroy If true, the timer will automatically destroy itself after all the events have been dispatched
  *                    (assuming no looping events).
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Timer")
class Timer(val game: Phaser.Game, val autoDestroy: Boolean = js.native) extends js.Object {

  /**
    * The duration in ms remaining until the next event will occur.
    */
  def duration: Double = js.native

  /**
    * An array holding all of this timers Phaser.TimerEvent objects. Use the methods add, repeat and loop to populate it.
    */
  def events: js.Array[Phaser.TimerEvent] = js.native

  /**
    * An expired Timer is one in which all of its events have been dispatched and none are pending.
    */
  def expired: Boolean = js.native

  /**
    * The number of pending events in the queue.
    */
  def length: Int = js.native

  /**
    * The duration in milliseconds that this Timer has been running for.
    */
  def ms: Double = js.native

  /**
    * The time at which the next event will occur.
    */
  def next: Double = js.native

  /**
    * This signal will be dispatched when this Timer has completed which means that there are no more events in the queue.
    *
    * The signal is supplied with one argument, `timer`, which is this Timer object.
    */
  def onComplete: Phaser.Signal = js.native

  /**
    * The paused state of the Timer. You can pause the timer by calling Timer.pause() and Timer.resume() or by the game pausing.
    */
  def paused: Boolean = js.native

  /**
    * True if the Timer is actively running.
    *
    * Do not modify this boolean - use pause (and resume) to pause the timer.
    */
  def running: Boolean = js.native

  /**
    * The duration in seconds that this Timer has been running for.
    */
  def seconds: Double = js.native

  /**
    * If the difference in time between two frame updates exceeds this value, the event times are reset to avoid catch-up situations.
    */
  def timeCap: Double = js.native

}

/**
  * Timer Singleton
  */
@js.native
@JSName("Phaser.Timer")
object Timer extends js.Object {
  val HALF: Int = js.native
  val MINUTE: Int = js.native
  val QUARTER: Int = js.native
  val SECOND: Int = js.native

}