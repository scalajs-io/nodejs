package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A TimerEvent is a single event that is processed by a Phaser.Timer.
  *
  * It consists of a delay, which is a value in milliseconds after which the event will fire.
  * When the event fires it calls a specific callback with the specified arguments.
  *
  * TimerEvents are removed by their parent timer once finished firing or repeating.
  *
  * Use [[Phaser.Timer]]#add, [[Phaser.Timer]]#repeat, or [[Phaser.Timer]]#loop methods to create a new event.
  * @param timer           The Timer object that this TimerEvent belongs to.
  * @param delay           The delay in ms at which this TimerEvent fires.
  * @param tick            The tick is the next game clock time that this event will fire at.
  * @param repeatCount     If this TimerEvent repeats it will do so this many times.
  * @param loop            True if this TimerEvent loops, otherwise false.
  * @param callback        The callback that will be called when the TimerEvent occurs.
  * @param callbackContext The context in which the callback will be called.
  * @param arguments       Additional arguments to be passed to the callback.
  */
@js.native
@JSName("Phaser.TimerEvent")
class TimerEvent(val timer: Phaser.Timer,
                 val delay: Double,
                 val tick: Double,
                 val repeatCount: Int,
                 val loop: Boolean,
                 val callback: js.Function,
                 val callbackContext: js.Any,
                 val arguments: js.Array[_]) extends js.Object