package io.scalajs.dom.html.phaser

import io.scalajs.dom.Event

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A Pointer object is used by the Mouse, Touch and MSPoint managers and represents a single finger on the touch screen.
  * @param game        A reference to the currently running game.
  * @param id          The ID of the Pointer object within the game. Each game can have up to 10 active pointers.
  * @param pointerMode The operational mode of this pointer, eg. CURSOR or TOUCH.
  * @see http://phaser.io/docs/2.6.2/Phaser.Pointer.html
  */
@js.native
@JSName("Phaser.Pointer")
class Pointer(game: Phaser.Game, id: Double, pointerMode: Phaser.PointerMode) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * An active pointer is one that is currently pressed down on the display. A Mouse is always active.
    */
  var active: Boolean = js.native

  /**
    * If this Pointer is a Mouse or Pen / Stylus then you can access its X1 (back) button directly through this property.
    *
    * The [[DeviceButton]] has its own properties such as `isDown`, duration and methods like justReleased for more fine-grained
    * button control.
    *
    * Please see the DeviceButton docs for details on browser button limitations.
    */
  var backButton: Phaser.DeviceButton = js.native

  /**
    * The button property of the most recent DOM event when this Pointer is started.
    * You should not rely on this value for accurate button detection, instead use the Pointer properties
    * `leftButton`, `rightButton`, `middleButton` and so on.
    */
  var button: js.Any = js.native

  /**
    * A Phaser.Circle that is centered on the x/y coordinates of this pointer, useful for hit detection.
    * The Circle size is 44px (Apples recommended "finger tip" size).
    */
  var circle: Phaser.Circle = js.native

  /**
    * The horizontal coordinate of the Pointer within the application's client area at which the event occurred
    * (as opposed to the coordinates within the page).
    */
  var clientX: Double = js.native

  /**
    * The vertical coordinate of the Pointer within the application's client area at which the event occurred
    * (as opposed to the coordinates within the page).
    */
  var clientY: Double = js.native

  /**
    * A dirty pointer needs to re-poll any interactive objects it may have been over, regardless if it has moved or not
    */
  var dirty: Boolean = js.native

  /**
    * How long the Pointer has been depressed on the touchscreen or any of the mouse buttons have been held down.
    * If not currently down it returns -1.
    * If you need to test a specific mouse or pen button then access the buttons directly, i.e. Pointer.rightButton.duration.
    */
  var duration: Double = js.native

  /**
    * If this Pointer is a Pen / Stylus then you can access its eraser button directly through this property.
    *
    * The DeviceButton has its own properties such as isDown, duration and methods like justReleased for more fine-grained
    * button control.
    *
    * Please see the DeviceButton docs for details on browser button limitations.
    */
  var eraserButton: Phaser.DeviceButton = js.native

  /**
    * A Pointer object that exists is allowed to be checked for physics collisions and overlaps.
    */
  var exists: Boolean = js.native

  /**
    * If this Pointer is a Mouse or Pen / Stylus then you can access its X2 (forward) button directly through this property.
    *
    * The DeviceButton has its own properties such as isDown, duration and methods like justReleased for more fine-grained
    * button control.
    *
    * Please see the DeviceButton docs for details on browser button limitations.
    */
  var forwardButton: Phaser.DeviceButton = js.native

  /**
    * This array is erased and re-populated every time this Pointer is updated. It contains references to all
    * of the Game Objects that were considered as being valid for processing by this Pointer, this frame. To be
    * valid they must have suitable a priorityID, be Input enabled, visible and actually have the Pointer over
    * them. You can check the contents of this array in events such as onInputDown, but beware it is reset
    * every frame.
    */
  var interactiveCandidates: js.Array[_] = js.native

  /**
    * If the Pointer is touching the touchscreen, or any mouse or pen button is held down, isDown is set to true.
    * If you need to check a specific mouse or pen button then use the button properties, i.e. Pointer.rightButton.isDown.
    */
  var isDown: Boolean = js.native

  /**
    * If the Pointer is a mouse or pen / stylus this is true, otherwise false.
    */
  var isMouse: Boolean = js.native

  /**
    * If the Pointer is not touching the touchscreen, or all mouse or pen buttons are up, isUp is set to true.
    * If you need to check a specific mouse or pen button then use the button properties, i.e. Pointer.rightButton.isUp.
    */
  var isUp: Boolean = js.native

  /**
    * If this Pointer is a Mouse or Pen / Stylus then you can access its left button directly through this property.
    *
    * The DeviceButton has its own properties such as `isDown`, duration and methods like `justReleased` for more fine-grained
    * button control.
    */
  var leftButton: Phaser.DeviceButton = js.native

  /**
    * If this Pointer is a Mouse or Pen / Stylus then you can access its middle button directly through this property.
    *
    * The DeviceButton has its own properties such as isDown, duration and methods like justReleased for more fine-grained
    * button control.
    *
    * Please see the DeviceButton docs for details on browser button limitations.
    */
  var middleButton: Phaser.DeviceButton = js.native

  /**
    * The horizontal processed relative movement of the Pointer in pixels since last event.
    */
  var movementX: Double = js.native

  /**
    * The vertical processed relative movement of the Pointer in pixels since last event.
    */
  var movementY: Double = js.native

  /**
    * The number of milliseconds since the last click or touch event.
    */
  var msSinceLastClick: Double = js.native

  /**
    * The horizontal coordinate of the Pointer relative to whole document.
    */
  var pageX: Double = js.native

  /**
    * The vertical coordinate of the Pointer relative to whole document.
    */
  var pageY: Double = js.native

  /**
    * The pointerId property of the Pointer as set by the DOM event when this Pointer is started.
    * The browser can and will recycle this value.
    */
  var pointerId: Double = js.native

  /**
    * A Phaser.Point object containing the current x/y values of the pointer on the display.
    */
  var position: Phaser.Point = js.native

  /**
    * A Phaser.Point object containing the x/y values of the pointer when it was last in a down state on the display.
    */
  var positionDown: Phaser.Point = js.native

  /**
    * A Phaser.Point object containing the x/y values of the pointer when it was last released.
    */
  var positionUp: Phaser.Point = js.native

  /**
    * A timestamp representing when the Pointer was last tapped or clicked.
    */
  var previousTapTime: Double = js.native

  /**
    * The horizontal raw relative movement of the Pointer in pixels since last event.
    */
  var rawMovementX: Double = js.native

  /**
    * The vertical raw relative movement of the Pointer in pixels since last event.
    */
  var rawMovementY: Double = js.native

  /**
    * If this Pointer is a Mouse or Pen / Stylus then you can access its right button directly through this property.
    *
    * The DeviceButton has its own properties such as `isDown`, duration and methods like `justReleased` for more fine-grained
    * button control.
    *
    * Please see the [[DeviceButton]] docs for details on browser button limitations.
    */
  var rightButton: Phaser.DeviceButton = js.native

  /**
    * The horizontal coordinate of the Pointer relative to the screen.
    */
  var screenX: Double = js.native

  /**
    * The vertical coordinate of the Pointer relative to the screen.
    */
  var screenY: Double = js.native

  /**
    * The target property of the Pointer as set by the DOM event when this Pointer is started.
    */
  var target: js.Any = js.native

  /**
    * The Game Object this Pointer is currently over / touching / dragging.
    */
  var targetObject: js.Any = js.native

  /**
    * A timestamp representing when the Pointer first touched the touchscreen.
    */
  var timeDown: Double = js.native

  /**
    * A timestamp representing when the Pointer left the touchscreen.
    */
  var timeUp: Double = js.native

  /**
    * The total number of times this Pointer has been touched to the touchscreen.
    */
  var totalTouches: Int = js.native

  /**
    * The const type of this object.
    */
  def `type`: Int = js.native

  /**
    * Returns true if the Pointer is over the game canvas, otherwise false.
    */
  var withinGame: Boolean = js.native

  /**
    * Gets the X value of this Pointer in world coordinates based on the world camera.
    */
  def worldX: Double = js.native

  /**
    * Gets the Y value of this Pointer in world coordinates based on the world camera.
    */
  def worldY: Double = js.native

  /**
    * The horizontal coordinate of the Pointer. This value is automatically scaled based on the game scale.
    */
  def x: Double = js.native

  /**
    * The vertical coordinate of the Pointer. This value is automatically scaled based on the game scale.
    */
  def y: Double = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The Pointer is considered `justPressed` if the time it was pressed onto the touchscreen or clicked is less than `justPressedRate`.
    * Note that calling `justPressed` doesn't reset the pressed status of the Pointer, it will return true for as long as
    * the duration is valid.
    *
    * If you wish to check if the Pointer was pressed down just once then see the `Sprite.events.onInputDown` event.
    * @param duration The time to check against. If none given it will use InputManager.justPressedRate.
    * @return true if the Pointer was pressed down within the duration given.
    */
  def justPressed(duration: Double = js.native): Boolean = js.native

  /**
    * The Pointer is considered `justReleased` if the time it left the touchscreen is less than `justReleasedRate`.
    * Note that calling `justReleased` doesn't reset the pressed status of the Pointer, it will return true for as
    * long as the duration is valid.
    *
    * If you wish to check if the Pointer was released just once then see the `Sprite.events.onInputUp` event.
    * @param duration The time to check against. If none given it will use InputManager.justReleasedRate.
    * @return true if the Pointer was released within the duration given.
    */
  def justReleased(duration: Double = js.native): Boolean = js.native

  /**
    * Called when the Pointer leaves the target area.
    * @param event The event passed up from the input handler (MouseEvent | PointerEvent | TouchEvent).
    */
  def leave(event: Event): Unit = js.native

  /**
    * Called when the Pointer is moved.
    * @param event     The event passed up from the input handler (MouseEvent | PointerEvent | TouchEvent).
    * @param fromClick Was this called from the click event?
    */
  def move(event: Event, fromClick: Boolean = js.native): Unit = js.native

  /**
    * Resets the Pointer properties. Called by InputManager.reset when you perform a State change.
    */
  def reset(): Unit = js.native

  /**
    * Resets the movementX and movementY properties. Use in your update handler after retrieving the values.
    */
  def resetMovement(): Unit = js.native

  /**
    * Called when the Pointer is pressed onto the touchscreen.
    * @param event The DOM event from the browser.
    */
  def start(event: Event): Unit = js.native

  /**
    * Called when the Pointer leaves the touchscreen.
    * @param event The event passed up from the input handler (MouseEvent | PointerEvent | TouchEvent).
    */
  def stop(event: Event): Unit = js.native

  /**
    * This will change the `Pointer.targetObject` object to be the one provided.
    * This allows you to have fine-grained control over which object the Pointer is targeting.
    * Note that even if you set a new Target here, it is still able to be replaced by any other valid
    * target during the next Pointer update.
    * @param newTarget The new target for this Pointer. Note this is an InputHandler, so don't pass a Sprite,
    *                  instead pass `sprite.input` to it.
    * @param silent    If true the new target AND the old one will NOT dispatch their `onInputOver` or `onInputOut` events.
    */
  def swapTarget(newTarget: Phaser.InputHandler, silent: Boolean = js.native): Unit = js.native

  /**
    * Called by the Input Manager.
    */
  def update(): Unit = js.native

}

/**
  * Pointer Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Pointer")
object Pointer extends js.Object {

  /**
    * The X1 button. This is typically the mouse Back button, but is often reconfigured.
    * On Linux (GTK) this is unsupported. On Windows if advanced pointer software (such as IntelliPoint)
    * is installed this doesn't register.
    */
  val BACK_BUTTON: Int = js.native

  /**
    * The Eraser pen button on PointerEvent supported devices only.
    */
  val ERASER_BUTTON: Int = js.native

  /**
    * The X2 button. This is typically the mouse Forward button, but is often reconfigured.
    * On Linux (GTK) this is unsupported. On Windows if advanced pointer software (such as IntelliPoint)
    * is installed this doesn't register.
    */
  val FORWARD_BUTTON: Int = js.native

  /**
    * The Middle Mouse button.
    */
  val MIDDLE_BUTTON: Int = js.native

  /**
    * No buttons at all.
    */
  val NO_BUTTON: Int = js.native

  /**
    * The Right Mouse button, or in PointerEvent devices a Pen contact with a barrel button.
    */
  val RIGHT_BUTTON: Int = js.native


}