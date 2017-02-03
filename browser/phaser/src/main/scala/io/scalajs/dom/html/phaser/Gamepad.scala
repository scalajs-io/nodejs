package io.scalajs.dom.html.phaser

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

/**
  * The Gamepad class handles gamepad input and dispatches gamepad events.
  *
  * Remember to call gamepad.start().
  *
  * HTML5 GAMEPAD API SUPPORT IS AT AN EXPERIMENTAL STAGE!
  * At moment of writing this (end of 2013) only Chrome supports parts of it out of the box. Firefox supports it
  * via prefs flags (about:config, search gamepad). The browsers map the same controllers differently.
  * This class has constants for Windows 7 Chrome mapping of XBOX 360 controller.
  * @see http://phaser.io/docs/2.6.2/Phaser.Gamepad.html
  */
@js.native
@JSName("Phaser.Gamepad")
class Gamepad(var game: Phaser.Game) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * If the gamepad input is active or not - if not active it should not be updated from Input.js
    */
  def active: Boolean = js.native

  /**
    * The context under which the callbacks are run.
    */
  var callbackContext: js.Object = js.native

  /**
    * Gamepad input will only be processed if enabled (default: true).
    */
  var enabled: Boolean = js.native

  /**
    * This callback is invoked every time any gamepad axis is changed.
    */
  var onAxisCallback: js.Function = js.native

  /**
    * This callback is invoked every time any gamepad is disconnected
    */
  var onConnectCallback: js.Function = js.native

  /**
    * This callback is invoked every time any gamepad button is pressed down.
    */
  var onDownCallback: js.Function = js.native

  /**
    * This callback is invoked every time any gamepad button is changed to a value where value > 0 and value < 1.
    */
  var onFloatCallback: js.Function = js.native

  /**
    * This callback is invoked every time any gamepad button is released.
    */
  var onUpCallback: js.Function = js.native

  /**
    * Gamepad #1
    */
  def pad1: Phaser.SinglePad = js.native

  /**
    * Gamepad #2
    */
  def pad2: Phaser.SinglePad = js.native

  /**
    * Gamepad #3
    */
  def pad3: Phaser.SinglePad = js.native

  /**
    * Gamepad #4
    */
  def pad4: Phaser.SinglePad = js.native

  /**
    * How many live gamepads are currently connected.
    */
  def padsConnected: Int = js.native

  /**
    * Whether or not gamepads are supported in current browser.
    */
  def supported: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Add callbacks to the main Gamepad handler to handle connect/disconnect/button down/button
    * up/axis change/float value buttons.
    * @param context   The context under which the callbacks are run.
    * @param callbacks Object that takes six different callback methods:
    *                  onConnectCallback, onDisconnectCallback, onDownCallback, onUpCallback,
    *                  onAxisCallback, onFloatCallback
    */
  def addCallbacks(context: RawOptions, callbacks: Callbacks): Unit = js.native

  /**
    * Destroys this object and the associated event listeners.
    */
  def destroy(): Unit = js.native

  /**
    * Returns true if the button is currently pressed down, on ANY gamepad.
    * @param buttonCode The buttonCode of the button to check for.
    * @return True if a button is currently down.
    */
  def isDown(buttonCode: ButtonCode): Boolean = js.native

  /**
    * Returns the "just released" state of a button from ANY gamepad connected.
    * Just released is considered as being true if the button was released within
    * the duration given (default 250ms).
    * @param buttonCode The buttonCode of the button to check for.
    * @param duration   The duration below which the button is considered as being just released.
    * @return True if the button is just released otherwise false.
    */
  def justPressed(buttonCode: ButtonCode, duration: Double = js.native): Boolean = js.native

  /**
    * Reset all buttons/axes of all gamepads
    */
  def reset(): Unit = js.native

  /**
    * Sets the deadZone variable for all four gamepads
    */
  def setDeadZones(): Unit = js.native

  /**
    * Starts the Gamepad event handling.
    * This MUST be called manually before Phaser will start polling the Gamepad API.
    */
  def start(): Unit = js.native

  /**
    * Stops the Gamepad event handling.
    */
  def stop(): Unit = js.native

}

/**
  * Callbacks Object
  * @param onConnectCallback
  * @param onDisconnectCallback
  * @param onDownCallback
  * @param onUpCallback
  * @param onAxisCallback
  * @param onFloatCallback
  */
@ScalaJSDefined
class Callbacks(var onConnectCallback: js.UndefOr[js.Function] = js.undefined,
                var onDisconnectCallback: js.UndefOr[js.Function] = js.undefined,
                var onDownCallback: js.UndefOr[js.Function] = js.undefined,
                var onUpCallback: js.UndefOr[js.Function] = js.undefined,
                var onAxisCallback: js.UndefOr[js.Function] = js.undefined,
                var onFloatCallback: js.UndefOr[js.Function] = js.undefined) extends js.Object