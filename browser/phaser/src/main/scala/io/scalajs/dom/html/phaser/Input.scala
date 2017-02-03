package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Phaser.Input is the Input Manager for all types of Input across Phaser,
  * including mouse, keyboard, touch and MSPointer.
  * The Input manager is updated automatically by the core game loop.
  * @param game Current game instance.
  * @see http://phaser.io/docs/2.6.2/Phaser.Input.html
  */
@js.native
@JSName("Phaser.Input")
class Input(var game: Phaser.Game) extends js.Object {

  /**
    * The most recently active Pointer object.
    * When you've limited max pointers to 1 this will accurately be either the first finger touched or mouse.
    */
  var activePointer: Phaser.Pointer = js.native

  /**
    * A Circle object centered on the x/y screen coordinates of the Input.
    * Default size of 44px (Apples recommended "finger tip" size) but can be changed to anything.
    */
  var circle: Phaser.Circle = js.native

  /**
    * The number of milliseconds between taps of the same Pointer for it to be considered a double tap / click.
    * default: 300
    */
  var doubleTapRate: Double = js.native

  /**
    * When enabled, input (eg. Keyboard, Mouse, Touch) will be processed - as long as the
    * individual sources are enabled themselves.
    *
    * When not enabled, all input sources are ignored. To disable just one type of input;
    * for example, the Mouse, use input.mouse.enabled = false.
    */
  var enabled: Boolean = js.native

  /**
    *
     */
  var gamepad : Phaser.Gamepad = js.native

  /**
    *
    */
  var keyboard: Keyboard = js.native

  /**
    *
    */
  var onTap: Signal = js.native

}

@js.native
@JSName("Phaser.Input")
object Input extends js.Object {

  /**
    * The maximum number of pointers that can be added. This excludes the mouse pointer.
    */
  var MAX_POINTERS: Int = js.native

  /**
    *
    */
  var MOUSE_OVERRIDES_TOUCH: Int = js.native

  /**
    *
    */
  var MOUSE_TOUCH_COMBINE: Int = js.native


}