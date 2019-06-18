package io.scalajs.dom.html.phaser

import io.scalajs.RawOptions
import io.scalajs.dom.html.pixijs.{DisplayObject, PIXI}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
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
@JSGlobal("Phaser.Group")
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
    * Adds an existing object to this group.
    * The child is added to the group at the location specified by the index value,
    * this allows you to control child ordering.
    *
    * If Group.enableBody is set, then a physics body will be created on the object,
    * so long as one does not already exist.
    *
    * If Group.inputEnableChildren is set, then an Input Handler will be created on the object,
    * so long as one does not already exist.
    * @param child  The display object to add as a child.
    * @param index  The index within the group to insert the child to.
    * @param silent If true the child will not dispatch the onAddedToGroup event.
    * @return The child that was added to the group.
    */
  def addAt(child: DisplayObject, index: Int = js.native, silent: Boolean = js.native): DisplayObject = js.native

  /**
    * Adds an array of existing Display Objects to this Group.
    * The Display Objects are automatically added to the top of this Group, and will
    * render on-top of everything already in this Group.
    *
    * As well as an array you can also pass another Group as the first argument.
    * In this case all of the children from that Group will be removed from it
    * and added into this Group.
    *
    * If Group.enableBody is set, then a physics body will be created on the objects,
    * so long as one does not already exist.
    *
    * If Group.inputEnableChildren is set, then an Input Handler will be created on
    * the objects, so long as one does not already exist.
    * @param children An array of display objects or a Phaser.Group. If a Group is given then all children will be moved from it.
    * @param silent   If true the children will not dispatch the `onAddedToGroup` event.
    * @return The array of children or Group of children that were added to this Group.
    */
  def addMultiple(children: js.Array[T] | Phaser.Group[T], silent: Boolean = js.native): js.Array[T] | Phaser.Group[T] = js.native

  /**
    * Adds a child of this Group into the hash array. This call will return false if the child is
    * not a child of this Group, or is already in the hash.
    * @param child The display object to add to this Groups hash. Must be a member of this Group
    *              already and not present in the hash.
    * @return True if the child was successfully added to the hash, otherwise false.
    */
  def addToHash(child: DisplayObject): Boolean = js.native

  /**
    * This method iterates through all children in the Group (regardless if they are visible or exist)
    * and then changes their position so they are arranged in a Grid formation. Children must have
    * the alignTo method in order to be positioned by this call. All default Phaser Game Objects have
    * this.
    *
    * The grid dimensions are determined by the first four arguments. The width and height arguments
    * relate to the width and height of the grid respectively.
    *
    * For example if the Group had 100 children in it:
    * `Group.align(10, 10, 32, 32)`
    * This will align all of the children into a grid formation of 10x10, using 32 pixels per
    * grid cell. If you want a wider grid, you could do:
    * `Group.align(25, 4, 32, 32)`
    * This will align the children into a grid of 25x4, again using 32 pixels per grid cell.
    * You can choose to set either the width or height value to -1. Doing so tells the method
    * to keep on aligning children until there are no children left. For example if this Group had
    * 48 children in it, the following:
    * `Group.align(-1, 8, 32, 32)`
    * ... will align the children so that there are 8 children vertically (the second argument),
    * and each row will contain 6 sprites, except the last one, which will contain 5 (totaling 48)
    *
    * You can also do:
    * `Group.align(10, -1, 32, 32)`
    * In this case it will create a grid 10 wide, and as tall as it needs to be in order to fit
    * all of the children in.
    *
    * The position property allows you to control where in each grid cell the child is positioned.
    * This is a constant and can be one of [[Phaser.TOP_LEFT]] (default), [[Phaser.TOP_CENTER]],
    * [[Phaser.TOP_RIGHT]], [[Phaser.LEFT_CENTER]], [[Phaser.CENTER]], [[Phaser.RIGHT_CENTER]],
    * [[Phaser.BOTTOM_LEFT]], [[Phaser.BOTTOM_CENTER]] or [[Phaser.BOTTOM_RIGHT]].
    * The final argument; offset lets you start the alignment from a specific child index.
    * @param width      The width of the grid in items (not pixels). Set to -1 for a dynamic width.
    *                   If -1 then you must set an explicit height value.
    * @param height     The height of the grid in items (not pixels). Set to -1 for a dynamic height.
    *                   If -1 then you must set an explicit width value.
    * @param cellWidth  The width of each grid cell, in pixels.
    * @param cellHeight The height of each grid cell, in pixels.
    * @param position   The position constant. One of [[Phaser.TOP_LEFT]] (default), [[Phaser.TOP_CENTER]],
    *                   [[Phaser.TOP_RIGHT]], [[Phaser.LEFT_CENTER]], [[Phaser.CENTER]], [[Phaser.RIGHT_CENTER]],
    *                   [[Phaser.BOTTOM_LEFT]], [[Phaser.BOTTOM_CENTER]] or [[Phaser.BOTTOM_RIGHT]].
    * @param offset     Optional index to start the alignment from. Defaults to zero, the first child
    *                   in the Group, but can be set to any valid child index value.
    * @return True if the Group children were aligned, otherwise false.
    */
  def align(width: Int, height: Int, cellWidth: Int, cellHeight: Int, position: Int = js.native, offset: Int = js.native): Boolean = js.native

  /**
    * Aligns this Group within another Game Object, or Rectangle, known as the
    * 'container', to one of 9 possible positions.
    * The container must be a Game Object, or `Phaser.Rectangle` object. This can include properties
    * such as World.bounds or `Camera.view`, for aligning Groups within the world
    * and camera bounds. Or it can include other [[Sprite]]s, [[Image]]s, [[Text]] objects, [[BitmapText]],
    * [[TileSprite]]s or [[Button]]s.
    *
    * Please note that aligning a Group to another Game Object does not make it a child of
    * the container. It simply modifies its position coordinates so it aligns with it.
    * The position constants you can use are:
    * [[Phaser.TOP_LEFT]], [[Phaser.TOP_CENTER]], [[Phaser.TOP_RIGHT]], [[Phaser.LEFT_CENTER]],
    * [[Phaser.CENTER]], [[Phaser.RIGHT_CENTER]], [[Phaser.BOTTOM_LEFT]],
    * [[Phaser.BOTTOM_CENTER]] and [[Phaser.BOTTOM_RIGHT]].
    *
    * Groups are placed in such a way that their bounds align with the
    * container, taking into consideration rotation and scale of its children.
    * This allows you to neatly align Groups, irrespective of their position value.
    * The optional offsetX and offsetY arguments allow you to apply extra spacing to the final
    * aligned position of the Group. For example:
    * `group.alignIn(background, Phaser.BOTTOM_RIGHT, -20, -20)`
    * Would align the group to the bottom-right, but moved 20 pixels in from the corner.
    * Think of the offsets as applying an adjustment to the containers bounds before the alignment takes place.
    * So providing a negative offset will 'shrink' the container bounds by that amount, and providing a positive
    * one expands it.
    * @param container The Game Object or Rectangle with which to align this Group to.
    *                  Can also include properties such as World.bounds or Camera.view.
    * @param position  The position constant. One of Phaser.TOP_LEFT (default), [[Phaser.TOP_CENTER]],
    *                  [[Phaser.TOP_RIGHT]], [[Phaser.LEFT_CENTER]], [[Phaser.CENTER]], [[Phaser.RIGHT_CENTER]],
    *                  [[Phaser.BOTTOM_LEFT]], [[Phaser.BOTTOM_CENTER]] or [[Phaser.BOTTOM_RIGHT]].
    * @param offsetX   A horizontal adjustment of the Containers bounds, applied to the aligned
    *                  position of the Game Object. Use a negative value to shrink the bounds,
    *                  positive to increase it.
    * @param offsetY   A vertical adjustment of the Containers bounds, applied to the aligned
    *                  position of the Game Object. Use a negative value to shrink the bounds,
    *                  positive to increase it.
    * @return This Group.
    */
  def alignIn(container: Phaser.Rectangle | Phaser.Sprite | Phaser.Image | Phaser.Text | Phaser.BitmapText | Phaser.Button | Phaser.Graphics | Phaser.TileSprite,
              position: Int = js.native,
              offsetX: Int = js.native,
              offsetY: Int = js.native): this.type = js.native

  /**
    * Aligns this Group to the side of another Game Object, or Rectangle, known as the
    * 'parent', in one of 11 possible positions.
    * The parent must be a Game Object, or [[Phaser.Rectangle]] object. This can include properties
    * such as World.bounds or Camera.view, for aligning Groups within the world
    * and camera bounds. Or it can include other [[Sprite]]s, [[Image]]s, [[Text]] objects, [[BitmapText]],
    * [[TileSprite]]s or [[Button]]s.
    *
    * Please note that aligning a Group to another Game Object does not make it a child of
    * the parent. It simply modifies its position coordinates so it aligns with it.
    * The position constants you can use are:
    * [[Phaser.TOP_LEFT]] (default), [[Phaser.TOP_CENTER]], [[Phaser.TOP_RIGHT]], [[Phaser.LEFT_TOP]],
    * [[Phaser.LEFT_CENTER]], [[Phaser.LEFT_BOTTOM]], [[Phaser.RIGHT_TOP]], [[Phaser.RIGHT_CENTER]],
    * [[Phaser.RIGHT_BOTTOM]], [[Phaser.BOTTOM_LEFT]], [[Phaser.BOTTOM_CENTER]]
    * and [[Phaser.BOTTOM_RIGHT]].
    *
    * Groups are placed in such a way that their bounds align with the
    * parent, taking into consideration rotation and scale of the children.
    * This allows you to neatly align Groups, irrespective of their position value.
    * The optional offsetX and offsetY arguments allow you to apply extra spacing to the final
    * aligned position of the Group.
    *
    * For example:
    * `group.alignTo(background, Phaser.BOTTOM_RIGHT, -20, -20)`
    * Would align the group to the bottom-right, but moved 20 pixels in from the corner.
    * Think of the offsets as applying an adjustment to the parents bounds before the alignment takes place.
    * So providing a negative offset will 'shrink' the parent bounds by that amount, and providing a positive
    * one expands it.
    * @param parent   The Game Object or Rectangle with which to align this Group to.
    *                 Can also include properties such as World.bounds or Camera.view.
    * @param position The position constant. One of [[Phaser.TOP_LEFT]], [[Phaser.TOP_CENTER]],
    *                 [[Phaser.TOP_RIGHT]], [[Phaser.LEFT_TOP]], [[Phaser.LEFT_CENTER]], [[Phaser.LEFT_BOTTOM]],
    *                 [[Phaser.RIGHT_TOP]], [[Phaser.RIGHT_CENTER]], [[Phaser.RIGHT_BOTTOM]], [[Phaser.BOTTOM_LEFT]],
    *                 [[Phaser.BOTTOM_CENTER]] or [[Phaser.BOTTOM_RIGHT]].
    * @param offsetX  A horizontal adjustment of the Containers bounds, applied to the aligned position
    *                 of the Game Object. Use a negative value to shrink the bounds, positive to increase it.
    * @param offsetY  A vertical adjustment of the Containers bounds, applied to the aligned position of
    *                 the Game Object. Use a negative value to shrink the bounds, positive to increase it.
    * @return This Group.
    */
  def alignTo(parent: Phaser.Rectangle | Phaser.Sprite | Phaser.Image | Phaser.Text | Phaser.BitmapText | Phaser.Button | Phaser.Graphics | Phaser.TileSprite,
              position: Double,
              offsetX: Double,
              offsetY: Double): this.type = js.native

  /**
    * Brings the given child to the top of this group so it renders above all other children.
    * @param child The child to bring to the top of this group.
    * @return The child that was moved.
    */
  def bringToTop(child: js.Any): js.Any = js.native

  /**
    * Name of the function on the child to call. Deep property lookup is supported.
    * @param method  Name of the function on the child to call. Deep property lookup is supported.
    * @param context A string containing the context under which the method will be executed.
    *                Set to null to default to the child.
    * @param args    Additional parameters that will be passed to the method.
    */
  def callAll(method: String, context: String, args: js.Any*): Unit = js.native

  def callAll(method: String): Unit = js.native

  /**
    * Calls a function, specified by name, on all children in the group who exist (or do not exist).
    * After the existsValue parameter you can add as many parameters as you like, which will all be
    * passed to the child callback.
    * @param callback    Name of the function on the children to call.
    * @param existsValue Only children with exists=existsValue will be called.
    * @param parameter   Additional parameters that will be passed to the callback.
    */
  def callAllExists(callback: String, existsValue: Boolean, parameter: js.Any*): Unit = js.native

  /**
    * Quickly check that the same property across all children of this group is equal to the given value.
    * This call doesn't descend down children, so if you have a Group inside of this group, the property
    * will be checked on the group but not its children.
    * @param key          The property, as a string, to be set. For example: 'body.velocity.x'
    * @param value        The value that will be checked.
    * @param checkAlive   If set then only children with alive=true will be checked.
    *                     This includes any Groups that are children.
    * @param checkVisible If set then only children with visible=true will be checked.
    *                     This includes any Groups that are children.
    * @param force        If force is true then the property will be checked on the child regardless
    *                     if it already exists or not. If true and the property doesn't exist,
    *                     false will be returned.
    */
  def checkAll(key: String,
               value: js.Any,
               checkAlive: Boolean = js.native,
               checkVisible: Boolean = js.native,
               force: Boolean = js.native): Unit = js.native

  /**
    * Checks a property for the given value on the child.
    * @param child The child to check the property value on.
    * @param key   An array of strings that make up the property that will be set.
    * @param value The value that will be checked.
    * @param force If force is true then the property will be checked on the child
    *              regardless if it already exists or not. If true and the property
    *              doesn't exist, false will be returned.
    * @return True if the property was was equal to value, false if not.
    */
  def checkProperty(child: js.Any, key: js.Array[_], value: js.Any, force: Boolean): Boolean = js.native

  /**
    * Get the number of dead children in this group.
    * @return The number of children flagged as dead.
    */
  def countDead(): Int = js.native

  /**
    * Get the number of living children in this group.
    * @return The number of children flagged as alive.
    */
  def countLiving(): Int = js.native

  /**
    * Creates a new [[Phaser.Sprite]] object and adds it to the top of this group.
    * Use classType to change the type of object created.
    * The child is automatically added to the top of the group, and is displayed above every previous child.
    * Or if the optional index is specified, the child is added at the location specified by the index value,
    * this allows you to control child ordering.
    * If Group.enableBody is set, then a physics body will be created on the object, so long as one does not already exist.
    * If Group.inputEnableChildren is set, then an Input Handler will be created on the object, so long as one does not already exist.
    * @param x      The x coordinate to display the newly created Sprite at.
    *               The value is in relation to the group.x point.
    * @param y      The y coordinate to display the newly created Sprite at.
    *               The value is in relation to the group.y point.
    * @param key    This is the image or texture used by the Sprite during rendering.
    *               It can be a string which is a reference to the Cache Image entry,
    *               or an instance of a RenderTexture, BitmapData, Video or PIXI.Texture.
    * @param frame  If this Sprite is using part of a sprite sheet or texture atlas you
    *               can specify the exact frame to use by giving a string or numeric index.
    * @param exists The default exists state of the Sprite.
    * @param index  The index within the group to insert the child to.
    *               Where 0 is the bottom of the Group.
    * @return The child that was created: will be a Phaser.Sprite unless #classType has been changed.
    */
  def create(x: Double,
             y: Double,
             key: String | Phaser.RenderTexture | Phaser.BitmapData | Phaser.Video | PIXI.Texture = js.native,
             frame: Any = js.native,
             exists: Boolean = js.native,
             index: Int = js.native): T = js.native

  /**
    * Creates multiple Phaser.Sprite objects and adds them to the top of this Group.
    * This method is useful if you need to quickly generate a pool of sprites, such as bullets.
    * Use classType to change the type of object created.
    * You can provide an array as the key and / or frame arguments. When you do this
    * it will create quantity Sprites for every key (and frame) in the arrays.
    *
    * For example:
    * `createMultiple(25, ['ball', 'carrot'])`
    *
    * In the above code there are 2 keys (ball and carrot) which means that 50 sprites will be
    * created in total, 25 of each. You can also have the frame as an array:
    * `createMultiple(5, 'bricks', [0, 1, 2, 3])`
    *
    * In the above there is one key (bricks), which is a sprite sheet. The frames array tells
    * this method to use frames 0, 1, 2 and 3. So in total it will create 20 sprites, because
    * the quantity was set to 5, so that is 5 brick sprites of frame 0, 5 brick sprites with
    * frame 1, and so on.
    *
    * If you set both the key and frame arguments to be arrays then understand it will create
    * a total quantity of sprites equal to the size of both arrays times each other. I.e.:
    * `createMultiple(20, ['diamonds', 'balls'], [0, 1, 2])`
    *
    * The above will create 20 'diamonds' of frame 0, 20 with frame 1 and 20 with frame 2.
    * It will then create 20 'balls' of frame 0, 20 with frame 1 and 20 with frame 2.
    * In total it will have created 120 sprites.
    *
    * By default the Sprites will have their exists property set to false, and they will be
    * positioned at 0x0, relative to the Group.x / y values.
    * If Group.enableBody is set, then a physics body will be created on the objects,
    * so long as one does not already exist.
    *
    * If Group.inputEnableChildren is set, then an Input Handler will be created on the objects,
    * so long as one does not already exist.
    * @param quantity The number of Sprites to create.
    * @param key      The Cache key of the image that the Sprites will use.
    *                 Or an Array of keys.
    *                 See the description for details on how the quantity applies when arrays are used.
    * @param frame    If the Sprite image contains multiple frames you can specify which one to use here.
    *                 Or an Array of frames.
    *                 See the description for details on how the quantity applies when arrays are used.
    * @param exists   The default exists state of the Sprite.
    * @return An array containing all of the Sprites that were created.
    */
  def createMultiple(quantity: Int,
                     key: String | js.Array[String],
                     frame: Any = js.native,
                     exists: Boolean = js.native): js.Array[String] = js.native

  /**
    * Sort the children in the group according to custom sort function.
    * The sortHandler is provided the two parameters: the two children involved in the comparison (a and b).
    * It should return -1 if a > b, 1 if a < b or 0 if a === b.
    * @param sortHandler The custom sort function.
    * @param context     The context in which the sortHandler is called.
    */
  def customSort[A >: T](sortHandler: js.Function2[A, A, Int], context: js.Any): Unit = js.native

  /**
    * Destroys this group.
    * Removes all children, then removes this group from its parent and nulls references.
    * @param destroyChildren If true `destroy` will be invoked on each removed child.
    * @param soft            A 'soft destroy' (set to true) doesn't remove this group from its parent
    *                        or null the game reference. Set to false and it does.
    */
  def destroy(destroyChildren: Boolean = js.native, soft: Boolean = js.native): Unit = js.native

  /**
    * Divides the given property by the amount on all children in this group.
    * `Group.divideAll('x', 2)` will half the child.x value for each child.
    * @param property     The property to divide, for example 'body.velocity.x' or 'angle'.
    * @param amount       The amount to divide the property by. If `child.x = 100` then
    *                     `divideAll('x', 2)` would make `child.x = 50`.
    * @param checkAlive   If true the property will only be changed if the child is alive.
    * @param checkVisible If true the property will only be changed if the child is visible.
    */
  def divideAll(property: String, amount: Int, checkAlive: Boolean, checkVisible: Boolean): Unit = js.native

  /**
    * Find children matching a certain predicate.
    * For example:
    * {{{
    *   var healthyList = Group.filter(function(child, index, children) {
    *     return child.health > 10 ? true : false;
    *   }, true);
    *   healthyList.callAll('attack');
    * }}}
    * @param predicate   The function that each child will be evaluated against.
    *                    Each child of the group will be passed to it as its first parameter,
    *                    the index as the second, and the entire child array as the third
    * @param checkExists If true, only existing can be selected; otherwise all children
    *                    can be selected and will be passed to the predicate.
    * @return an array list containing all the children that the predicate returned true for
    */
  def filter(predicate: js.Function3[T, Int, js.Array[T], Boolean], checkExists: Boolean = js.native): Phaser.ArraySet[T] = js.native

  /**
    * Call a function on each child in this group.
    * Additional arguments for the callback can be specified after the checkExists parameter.
    * For example,
    * {{{
    * Group.forEach(awardBonusGold, this, true, 100, 500)
    * }}}
    * would invoke `awardBonusGold` function with the parameters (child, 100, 500).
    * Note: This check will skip any children which are Groups themselves.
    * @param callback        The function that will be called for each applicable child.
    *                        The child will be passed as the first argument.
    * @param callbackContext The context in which the function should be called (usually 'this').
    * @param checkExists     Optional: If set only children matching for which exists is true will be passed
    *                        to the callback, otherwise all children will be passed.
    * @param args            Additional arguments to pass to the callback function, after the child item.
    */
  def forEach(callback: js.Function1[T, Any], callbackContext: RawOptions, checkExists: Boolean, args: js.Any*): Unit = js.native

  def forEach(callback: js.Function1[T, Any], callbackContext: RawOptions = js.native): Unit = js.native

  /**
    * Call a function on each alive child in this group.
    * See [[forEach]] for details.
    * @param callback        The function that will be called for each applicable child.
    *                        The child will be passed as the first argument.
    * @param callbackContext The context in which the function should be called (usually 'this').
    * @param args            Additional arguments to pass to the callback function, after the child item.
    */
  def forEachAlive(callback: js.Function1[T, Any], callbackContext: RawOptions, args: js.Any*): Unit = js.native

  def forEachAlive(callback: js.Function1[T, Any]): Unit = js.native

  /**
    * Call a function on each dead child in this group.
    * See [[forEach]] for details.
    * @param callback        The function that will be called for each applicable child.
    *                        The child will be passed as the first argument.
    * @param callbackContext The context in which the function should be called (usually 'this').
    * @param args            Additional arguments to pass to the callback function, after the child item.
    */
  def forEachDead(callback: js.Function1[T, Any], callbackContext: RawOptions, args: js.Any*): Unit = js.native

  def forEachDead(callback: js.Function1[T, Any]): Unit = js.native

  /**
    * Call a function on each existing child in this group.
    * See [[forEach]] for details.
    * @param callback        The function that will be called for each applicable child.
    *                        The child will be passed as the first argument.
    * @param callbackContext The context in which the function should be called (usually 'this').
    * @param args            Additional arguments to pass to the callback function, after the child item.
    */
  def forEachExists(callback: js.Function1[T, Any], callbackContext: RawOptions, args: js.Any*): Unit = js.native

  def forEachExists(callback: js.Function1[T, Any]): Unit = js.native

  /**
    * Returns all children in this Group.
    * You can optionally specify a matching criteria using the property and value arguments.
    * For example: getAll('exists', true) would return only children that have their exists property set.
    * Optionally you can specify a start and end index. For example if this Group had 100 children,
    * and you set startIndex to 0 and endIndex to 50, it would return a random child from only
    * the first 50 children in the Group.
    * @param property   An optional property to test against the value argument.
    * @param value      If property is set then Child.property must strictly equal this value to be included in the results.
    * @param startIndex The first child index to start the search from.
    * @param endIndex   The last child index to search up until.
    * @return A random existing child of this Group.
    */
  def getAll(property: String = js.native, value: Any = js.native, startIndex: Int = js.native, endIndex: Int = js.native): T = js.native

  /**
    * Returns the child found at the given index within this group.
    * @param index The index to return the child from.
    * @return The child that was found at the given index, or -1 for an invalid index.
    */
  def getAt(index: Int): DisplayObject | Int = js.native

  /**
    * Returns the child at the bottom of this group.
    * The bottom child the child being displayed (rendered) below every other child.
    * @return The child at the bottom of the Group.
    */
  def getBottom(): T = js.native

  /**
    * Searches the Group for the first instance of a child with the `name`
    * property matching the given argument. Should more than one child have
    * the same name only the first instance is returned.
    * @param name The name to search for.
    * @return The first child with a matching name, or null if none were found.
    */
  def getByName(name: String): T = js.native

  /**
    *
    * @param createIfNull
    * @param x
    * @param y
    * @param key
    * @param frame
    * @return
    */
  def getFirstAlive(createIfNull: Boolean = js.native,
                    x: Double = js.native,
                    y: Double = js.native,
                    key: String = js.native,
                    frame: String | Int = js.native): js.UndefOr[T] = js.native

  /**
    *
    * @param exists
    * @return
    */
  def getFirstExists(exists: Boolean): js.UndefOr[T] = js.native

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
@JSGlobal("Phaser.Group")
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