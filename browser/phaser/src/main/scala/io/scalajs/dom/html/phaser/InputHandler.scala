package io.scalajs.dom.html.phaser

import scala.scalajs.js

/**
  * The Input Handler is bound to a specific Sprite and is responsible for managing all Input events on that Sprite.
  * @see http://phaser.io/docs/2.6.2/Phaser.InputHandler.html
  */
@js.native
class InputHandler(val sprite: Phaser.Sprite) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Controls if the Sprite is allowed to be dragged horizontally.
    */
  var allowHorizontalDrag: Boolean = js.native

  /**
    * Controls if the Sprite is allowed to be dragged vertically.
    */
  var allowVerticalDrag: Boolean = js.native

  /**
    * A region of the game world within which the sprite is restricted during drag.
    */
  var boundsRect: Phaser.Rectangle = js.native

  /**
    * A Sprite the bounds of which this sprite is restricted during drag.
    */
  var boundsSprite: Phaser.Sprite = js.native

  /**
    * If true when this Sprite is clicked or dragged it will automatically be bought to the top of the Group it is within.
    */
  var bringToTop: Boolean = js.native

  /**
    * A Point object containing the coordinates of the Pointer when it was first pressed down onto this Sprite.
    */
  var downPoint: Phaser.Point = js.native

  /**
    * The distance, in pixels, the pointer has to move while being held down, before the Sprite thinks it is being dragged.
    */
  var dragDistanceThreshold: Int = js.native

  /**
    * Is the Sprite dragged from its center, or the point at which the Pointer was pressed down upon it?
    */
  var dragFromCenter: Boolean = js.native

  /**
    * Is this sprite allowed to be dragged by the mouse? true = yes, false = no
    */
  var draggable: Boolean = js.native

  /**
    * The offset from the Sprites position that dragging takes place from.
    */
  var dragOffset: Phaser.Point = js.native

  /**
    * The Point from which the most recent drag started from. Useful if you need to return an object to its starting position.
    */
  var dragStartPoint: Phaser.Point = js.native

  /**
    * If enabled, when the Sprite stops being dragged, it will only dispatch the onDragStop event,
    * and not the `onInputUp` event. If set to `false` it will dispatch both events.
    */
  var dragStopBlocksInputUp: Boolean = js.native

  /**
    * The amount of time, in ms, the pointer has to be held down over the Sprite before it thinks it is being dragged.
    */
  var dragTimeThreshold: Int = js.native

  /**
    * If enabled the Input Handler will process input requests and monitor pointer activity.
    */
  var enabled: Boolean = js.native

  /**
    * A reference to the currently running game.
    */
  var game: Phaser.Game = js.native

  /**
    * Returns true if the Sprite is being currently dragged.
    */
  var isDragged: Boolean = js.native

  /**
    * The alpha tolerance threshold. If the alpha value of the pixel matches or is above this value, it's considered a hit.
    */
  var pixelPerfectAlpha: Int = js.native

  /**
    * Set to true to use pixel perfect hit detection when checking if the pointer is over this Sprite when it's clicked or touched.
    * The x/y coordinates of the pointer are tested against the image in combination with the InputHandler.pixelPerfectAlpha value.
    * This feature only works for display objects with image based textures such as Sprites. It won't work on BitmapText or Rope.
    *
    * Warning: This is expensive so only enable if you really need it. Use a pixel perfect check when testing for clicks
    * or touches on the Sprite.
    */
  var pixelPerfectClick: Boolean = js.native

  /**
    * Set to true to use pixel perfect hit detection when checking if the pointer is over this Sprite.
    * The x/y coordinates of the pointer are tested against the image in combination with the InputHandler.pixelPerfectAlpha value.
    * This feature only works for display objects with image based textures such as Sprites. It won't work on BitmapText or Rope.
    *
    * Warning: This is expensive, especially on mobile (where it's not even needed!) so only enable if required.
    * Also see the less-expensive InputHandler.pixelPerfectClick. Use a pixel perfect check when testing for pointer over.
    */
  var pixelPerfectOver: Boolean = js.native

  /**
    * The priorityID is used to determine which game objects should get priority when input events occur. For example if you have
    * several Sprites that overlap, by default the one at the top of the display list is given priority for input events. You can
    * stop this from happening by controlling the priorityID value. The higher the value, the more important they are
    * considered to the Input events.
    */
  var priorityID: Int = js.native

  /**
    * EXPERIMENTAL: Please do not use this property unless you know what it does. Likely to change in the future.
    */
  var scaleLayer: Boolean = js.native

  /**
    * A Point object that contains by how far the Sprite snap is offset.
    */
  var snapOffset: Phaser.Point = js.native

  /**
    * This defines the top-left X coordinate of the snap grid.
    */
  var snapOffsetX: Int = js.native

  /**
    * This defines the top-left Y coordinate of the snap grid.
    */
  var snapOffsetY: Int = js.native

  /**
    * When the Sprite is dragged this controls if the center of the Sprite will snap to the pointer on drag or not.
    */
  var snapOnDrag: Boolean = js.native

  /**
    * When the Sprite is dragged this controls if the Sprite will be snapped on release.
    */
  var snapOnRelease: Boolean = js.native

  /**
    * If the sprite is set to snap while dragging this holds the point of the most recent 'snap' event.
    */
  var snapPoint: Phaser.Point = js.native

  /**
    * When a Sprite has snapping enabled this holds the width of the snap grid.
    */
  var snapX: Int = js.native

  /**
    * When a Sprite has snapping enabled this holds the height of the snap grid.
    */
  var snapY: Int = js.native

  /**
    * On a desktop browser you can set the 'hand' cursor to appear when moving over the Sprite.
    */
  var useHandCursor: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Bounds Rect check for the sprite drag
    */
  def checkBoundsRect(): Unit = js.native

  /**
    * Parent Sprite Bounds check for the sprite drag.
    */
  def checkBoundsSprite(): Unit = js.native

  /**
    * Runs a pixel perfect check against the given x/y coordinates of the Sprite this InputHandler is bound to.
    * It compares the alpha value of the pixel and if >= InputHandler.pixelPerfectAlpha it returns true.
    * @param x       The x coordinate to check.
    * @param y       The y coordinate to check.
    * @param pointer The pointer to get the x/y coordinate from if not passed as the first two parameters.
    * @return true if there is the alpha of the pixel is >= InputHandler.pixelPerfectAlpha
    */
  def checkPixel(x: Double, y: Double, pointer: Phaser.Pointer = js.native): Boolean = js.native

  /**
    * Checks if the given pointer is both down and over the Sprite this InputHandler belongs to.
    * Use the fastTest flag is to quickly check just the bounding hit area even if InputHandler.pixelPerfectOver is true.
    * @param pointer  the [[Phaser.Pointer pointer]]
    * @param fastTest Force a simple hit area check even if pixelPerfectOver is true for this object?
    * @return True if the pointer is down, otherwise false.
    */
  def checkPointerDown(pointer: Phaser.Pointer, fastTest: Boolean = js.native): Boolean = js.native

  /**
    * Checks if the given pointer is over the Sprite this InputHandler belongs to.
    * Use the fastTest flag is to quickly check just the bounding hit area even if InputHandler.pixelPerfectOver is true.
    * @param pointer  the [[Phaser.Pointer pointer]]
    * @param fastTest Force a simple hit area check even if pixelPerfectOver is true for this object?
    * @return true or false
    */
  def checkPointerOver(pointer: Phaser.Pointer, fastTest: Boolean = js.native): Boolean = js.native

  /**
    * Clean up memory.
    */
  def destroy(): Unit = js.native

  /**
    * Stops this sprite from being able to be dragged.
    * If it is currently the target of an active drag it will be stopped immediately; also disables any set callbacks.
    */
  def disableDrag(): Unit = js.native

  /**
    * Stops the sprite from snapping to a grid during drag or release.
    */
  def disableSnap(): Unit = js.native

  /**
    * If the pointer is currently over this Sprite this returns how long it has been there for in milliseconds.
    * @param pointerId the optional pointer ID
    * @return The number of milliseconds the pointer has been pressed down on the Sprite, or -1 if not over.
    */
  def downDuration(pointerId: Int = js.native): Double = js.native

  /**
    * Allow this Sprite to be dragged by any valid pointer.
    * When the drag begins the Sprite.events.onDragStart event will be dispatched.
    * When the drag completes by way of the user letting go of the pointer that was dragging the sprite,
    * the Sprite.events.onDragStop event is dispatched.
    *
    * You can control the thresholds over when a drag starts via the properties:
    * Pointer.dragDistanceThreshold the distance, in pixels, that the pointer has to move
    * before the drag will start.
    * Pointer.dragTimeThreshold the time, in ms, that the pointer must be held down on
    * the Sprite before the drag will start.
    * You can set either (or both) of these properties after enabling a Sprite for drag.
    * For the duration of the drag the Sprite.events.onDragUpdate event is dispatched. This event is only
    * dispatched when the pointer actually changes position and moves. The event sends 5 parameters: sprite,
    * pointer, dragX, dragY and snapPoint.
    * @param lockCenter     If false the Sprite will drag from where you click it minus the dragOffset.
    *                       If true it will center itself to the tip of the mouse pointer.
    * @param bringToTop     If true the Sprite will be bought to the top of the rendering list in its current Group.
    * @param pixelPerfect   If true it will use a pixel perfect test to see if you clicked the Sprite.
    *                       False uses the bounding box.
    * @param alphaThreshold If using pixel perfect collision this specifies the alpha level from 0 to 255 above which
    *                       a collision is processed.
    * @param boundsRect     If you want to restrict the drag of this sprite to a specific Rectangle, pass the
    *                       [[Phaser.Rectangle]] here, otherwise it's free to drag anywhere.
    * @param boundsSprite   If you want to restrict the drag of this sprite to within the bounding box of another
    *                       sprite, pass it here.
    */
  def enableDrag(lockCenter: Boolean = js.native,
                 bringToTop: Boolean = js.native,
                 pixelPerfect: Boolean = js.native,
                 alphaThreshold: Boolean = js.native,
                 boundsRect: Phaser.Rectangle = js.native,
                 boundsSprite: Phaser.Sprite = js.native): Unit = js.native

  /**
    * Make this Sprite snap to the given grid either during drag or when it's released.
    * For example 16x16 as the snapX and snapY would make the sprite snap to every 16 pixels.
    * @param snapX       The width of the grid cell to snap to.
    * @param snapY       The height of the grid cell to snap to.
    * @param onDrag      If true the sprite will snap to the grid while being dragged.
    * @param onRelease   If true the sprite will snap to the grid when released.
    * @param snapOffsetX Used to offset the top-left starting point of the snap grid.
    * @param snapOffsetY Used to offset the top-left starting point of the snap grid.
    */
  def enableSnap(snapX: Double,
                 snapY: Double,
                 onDrag: Boolean = js.native,
                 onRelease: Boolean = js.native,
                 snapOffsetX: Double = js.native,
                 snapOffsetY: Double = js.native): Unit = js.native

  /**
    * Warning: EXPERIMENTAL
    * @param x TODO
    */
  def globalToLocalX(x: Double): Unit = js.native

  /**
    * Is this object using pixel perfect checking?
    * @return True if the this [[InputHandler]] has either `pixelPerfectClick` or `pixelPerfectOver` set to true.
    */
  def isPixelPerfect(): Boolean = js.native

  /**
    * Returns true if the pointer has left the Sprite within the specified delay time (defaults to 500ms, half a second)
    * @param pointerId the given pointer ID
    * @param delay     The time below which the pointer is considered as just out.
    * @return true or false
    */
  def justOut(pointerId: Int, delay: Double): Boolean = js.native

}
