package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.pixijs.{DisplayObject, PIXI}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * A Group is a container for display objects including Sprites and Images.
  *
  * Groups form the logical tree structure of the display/scene graph where local transformations are applied to
  * children. For instance, all children are also moved/rotated/scaled when the group is moved/rotated/scaled.
  *
  * In addition, Groups provides support for fast pooling and object recycling.
  *
  * Groups are also display objects and can be nested as children within other Groups.
  * @param game            A reference to the currently running game.
  * @param parent          The parent Group (or other DisplayObject) that this group will be added to. If undefined/unspecified
  *                        the Group will be added to the Game World; if null the Group will not be added to any parent.
  * @param name            A name for this group. Not used internally but useful for debugging.
  * @param addToStage      If true this group will be added directly to the Game.Stage instead of Game.World.
  * @param enableBody      If true all Sprites created with #create or #createMulitple will have a physics body created on
  *                        them. Change the body type with #physicsBodyType.
  * @param physicsBodyType The physics body type to use when physics bodies are automatically added.
  *                        See #physicsBodyType for values.
  * @see http://phaser.io/docs/2.6.2/Phaser.Group.html
  */
@js.native
@JSName("Phaser.Group")
class Group[T](var game: Phaser.Game,
               var parent: DisplayObject,
               var name: String = js.native,
               var addToStage: Boolean = js.native,
               var enableBody: Boolean = js.native,
               var physicsBodyType: Int = js.native)
  extends PIXI.DisplayObjectContainer {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The alive property is useful for Groups that are children of other Groups and
    * need to be included/excluded inchecks like forEachAlive.
    */
  var alive: Boolean = js.native

  /**
    * The bottom coordinate of this Group.
    * It is derived by calling `getBounds`, calculating the Groups dimensions based on its
    * visible children.
    */
  var bottom: Double = js.native

  /**
    * If this object is fixedToCamera then this stores the x/y position offset relative
    * to the top-left of the camera view.
    *
    * If the parent of this Group is also fixedToCamera then the offset here is in addition
    * to that and should typically be disabled.
    */
  var cameraOffset: Phaser.Point = js.native

  /**
    * The center x coordinate of this Group.
    * It is derived by calling getBounds, calculating the Groups dimensions based on its
    * visible children.
    */
  var centerX: Double = js.native

  /**
    * The center y coordinate of this Group.
    * It is derived by calling getBounds, calculating the Groups dimensions based on its
    * visible children.
    */
  var centerY: Double = js.native

  /**
    * The type of objects that will be created when using create or createMultiple.
    * Any object may be used but it should extend either Sprite or Image and accept
    * the same constructor arguments:
    * when a new object is created it is passed the following parameters to its
    * constructor: `(game, x, y, key, frame)`.
    */
  var classType: js.Object = js.native

  /**
    * The current display object that the group cursor is pointing to, if any. (Can be set manually.)
    * The cursor is a way to iterate through the children in a Group using next and previous.
    */
  var cursor: DisplayObject = js.native

  /**
    * The current index of the Group cursor. Advance it with Group.next.
    */
  def cursorIndex: Int = js.native

  /**
    * If true when a physics body is created (via enableBody) it will create a physics debug object as well.
    * This only works for P2 bodies.
    */
  var enableBodyDebug: Boolean = js.native

  /**
    * If exists is true the group is updated, otherwise it is skipped.
    */
  var exists: Boolean = js.native

  /**
    * A Group that is fixed to the camera uses its x/y coordinates as
    * offsets from the top left of the camera. These are stored in Group.cameraOffset.
    *
    * Note that the cameraOffset values are in addition to any parent in the display list.
    * So if this Group was in a Group that has x: 200, then this will be added to the cameraOffset.x
    */
  var fixedToCamera: Boolean = js.native

  /**
    * The hash array is an array belonging to this Group into which you can add any of its children
    * via `Group.addToHash` and `Group.removeFromHash`.
    *
    * Only children of this Group can be added to and removed from the hash.
    *
    * This hash is used automatically by Phaser Arcade Physics in order to perform non z-index
    * based destructive sorting.
    *
    * However if you don't use Arcade Physics, or this isn't a physics enabled Group, then you
    * can use the hash to perform your own sorting and filtering of Group
    */
  var hash: js.Array[_] = js.native

  /**
    * A group with `ignoreDestroy` set to `true` ignores all calls to its `destroy` method.
    */
  var ignoreDestroy: Boolean = js.native

  /**
    * A Group with inputEnableChildren set to true will automatically call inputEnabled = true
    * on any children added to, or created by, this Group.
    *
    * If there are children already in the Group at the time you set this property, they are not changed.
    */
  var inputEnableChildren: Boolean = js.native

  /**
    * The left coordinate of this Group.
    * It is derived by calling `getBounds`, calculating the Groups dimensions based on its
    * visible children.
    */
  var left: Double = js.native

  /**
    * Total number of children in this group, regardless of exists/alive status.
    */
  def length: Int = js.native

  /**
    * This Signal is dispatched whenever a child of this Group emits an onInputDown signal as a result
    * of having been interacted with by a Pointer. You can bind functions to this Signal instead of to
    * every child Sprite.
    *
    * This Signal is sent 2 arguments: A reference to the Sprite that triggered the signal, and
    * a reference to the Pointer that caused it.
    */
  var onChildInputDown: Phaser.Signal = js.native

  /**
    * This Signal is dispatched whenever a child of this Group emits an onInputOut signal as a result
    * of having been interacted with by a Pointer. You can bind functions to this Signal instead of to
    * every child Sprite.
    *
    * This Signal is sent 2 arguments: A reference to the Sprite that triggered the signal, and
    * a reference to the Pointer that caused it.
    */
  var onChildInputOut: Phaser.Signal = js.native

  /**
    * This Signal is dispatched whenever a child of this Group emits an onInputOver signal as a result
    * of having been interacted with by a Pointer. You can bind functions to this Signal instead of to
    * every child Sprite.
    *
    * This Signal is sent 2 arguments: A reference to the Sprite that triggered the signal, and
    * a reference to the Pointer that caused it.
    */
  var onChildInputOver: Phaser.Signal = js.native

  /**
    * This Signal is dispatched whenever a child of this Group emits an onInputUp signal as a result
    * of having been interacted with by a Pointer. You can bind functions to this Signal instead of to
    * every child Sprite.
    *
    * This Signal is sent 3 arguments: A reference to the Sprite that triggered the signal,
    * a reference to the Pointer that caused it, and a boolean value isOver that tells you if the Pointer
    * is still over the Sprite or not.
    */
  var onChildInputUp: Phaser.Signal = js.native

  /**
    * This signal is dispatched when the group is destroyed.
    */
  var onDestroy: Phaser.Signal = js.native

  /**
    * A Group is that has `pendingDestroy` set to `true` is flagged to have its destroy method
    * called on the next logic update.
    * You can set it directly to flag the Group to be destroyed on its next update.
    *
    * This is extremely useful if you wish to destroy a Group from within one of its own callbacks
    * or a callback of one of its children.
    */
  var pendingDestroy: Boolean = js.native

  /**
    * If this Group contains Arcade Physics Sprites you can set a custom sort direction via this property.
    *
    * It should be set to one of the Phaser.Physics.Arcade sort direction constants:
    *
    * Phaser.Physics.Arcade.SORT_NONE
    * Phaser.Physics.Arcade.LEFT_RIGHT
    * Phaser.Physics.Arcade.RIGHT_LEFT
    * Phaser.Physics.Arcade.TOP_BOTTOM
    * Phaser.Physics.Arcade.BOTTOM_TOP
    *
    * If set to null the Group will use whatever Phaser.Physics.Arcade.sortDirection
    * is set to. This is the default behavior.
    */
  var physicsSortDirection: Int = js.native

  /**
    * The const physics body type of this object.
    */
  def physicsType: Int = js.native

  /**
    * The right coordinate of this Group.
    *
    * It is derived by calling getBounds, calculating the Groups dimensions based on its
    * visible children.
    */
  var right: Double = js.native

  /**
    * The angle of rotation of the group container, in radians.
    *
    * This will adjust the group container itself by modifying its rotation.
    * This will have no impact on the rotation value of its children, but it
    * will update their worldTransform and on-screen position.
    */
  var rotation: Double = js.native

  /**
    * The top coordinate of this Group.
    *
    * It is derived by calling getBounds, calculating the Groups dimensions based on its
    * visible children.
    */
  var top: Double = js.native

  /**
    * Total number of existing children in the group.
    */
  def total: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Adds an existing object as the top child in this group.
    * The child is automatically added to the top of the group, and is displayed above every previous child.
    * Or if the optional index is specified, the child is added at the location specified by the index value,
    * this allows you to control child ordering.
    *
    * If the child was already in this Group, it is simply returned,
    * and nothing else happens to it.
    *
    * If Group.enableBody is set, then a physics body will be created on the object,
    * so long as one does not already exist.
    *
    * If Group.inputEnableChildren is set, then an Input Handler will be created on the object,
    * so long as one does not already exist.
    *
    * Use addAt to control where a child is added. Use create to create and add a new child.
    * @param child  The display object to add as a child.
    * @param silent If true the child will not dispatch the `onAddedToGroup` event.
    * @param index  The index within the group to insert the child to.
    *               Where 0 is the bottom of the Group.
    * @return The child that was added to the group.
    */
  def add(child: DisplayObject, silent: Boolean = js.native, index: Int = js.native): DisplayObject = js.native

  /**
    * Adds the amount to the given property on all children in this group.
    * `Group.addAll('x', 10)` will add 10 to the child.x value for each child.
    * @param property     The property to increment, for example 'body.velocity.x' or 'angle'.
    * @param amount       The amount to increment the property by. If `child.x = 10` then `addAll('x', 40)`
    *                     would make `child.x = 50`.
    * @param checkAlive   If true the property will only be changed if the child is alive.
    * @param checkVisible If true the property will only be changed if the child is visible.
    */
  def addAll(property: String, amount: Double, checkAlive: Boolean, checkVisible: Boolean): Unit = js.native

  /**
    *
    * @return
    */
  def countLiving(): Int = js.native

  /**
    *
    * @param x
    * @param y
    * @param key
    * @param frame
    * @param exists
    * @return
    */
  def create(x: Double, y: Double, key: Any = null, frame: Any = null, exists: Boolean = true): T = js.native

  /**
    *
    * @param quantity
    * @param key
    * @param frame
    * @param exists
    */
  def createMultiple(quantity: Int, key: String, frame: Any = null, exists: Boolean = false): Unit = js.native

  /**
    *
    * @return
    */
  def getFirstAlive(): js.UndefOr[T] = js.native

  /**
    *
    * @param createIfNull
    * @param x
    * @param y
    * @param key
    * @param frame
    * @return
    */
  def getFirstAlive(createIfNull: Boolean = false,
                    x: Double,
                    y: Double,
                    key: String = null,
                    frame: String | Int = null): js.UndefOr[T] = js.native

  /**
    *
    * @param exists
    * @return
    */
  def getFirstExists(exists: Boolean): js.UndefOr[T] = js.native

  /**
    *
    * @param callback
    * @param context
    * @param checkExists
    */
  def forEach(callback: js.Function1[T, Any], context: Any = this, checkExists: Boolean = false): Unit = js.native

  def forEach(callback: js.Function1[T, Any], context: Any, checkExists: Boolean, args: Any*): Unit = js.native

  def forEachAlive(callback: js.Function1[T, Any], context: Any = this): Unit = js.native

  def forEachAlive(callback: js.Function1[T, Any], context: Any, args: Any*): Unit = js.native

  def removeAll(destroy: Boolean = false, silent: Boolean = false): Unit = js.native

  def setAll(key: String,
             value: Any,
             checkAlive: Boolean = false,
             checkVisible: Boolean = false,
             operation: Int = 0,
             force: Boolean = false): Unit = js.native

}

/**
  * Group Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Group")
object Group extends js.Object {

  /**
    * A returnType value, as specified in iterate eg.
    */
  val RETURN_ALL: Int = js.native

  /**
    * A returnType value, as specified in iterate eg.
    */
  val RETURN_CHILD: Int = js.native

  /**
    * A returnType value, as specified in iterate eg.
    */
  val RETURN_NONE: Int = js.native

  /**
    * A returnType value, as specified in iterate eg.
    */
  val RETURN_TOTAL: Int = js.native

  /**
    * A sort ordering value, as specified in sort eg.
    */
  val SORT_ASCENDING: Int = js.native

  /**
    * A sort ordering value, as specified in sort eg.
    */
  val SORT_DESCENDING: Int = js.native

}