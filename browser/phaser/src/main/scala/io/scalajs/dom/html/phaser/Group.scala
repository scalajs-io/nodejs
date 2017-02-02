package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.pixijs.{DisplayObject, DisplayObjectContainer}

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
  */
@js.native
@JSName("Phaser.Group")
class Group[T](var game: Game,
               var parent: DisplayObject,
               var name: String,
               var addToStage: Boolean,
               var enableBody: Boolean,
               var physicsBodyType: Int)
    extends DisplayObjectContainer {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The alive property is useful for Groups that are children of other Groups and need to be included/excluded in
    * checks like forEachAlive.
    */
  var alive: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def countLiving(): Int = js.native

  def create(x: Double, y: Double, key: Any = null, frame: Any = null, exists: Boolean = true): T = js.native

  def createMultiple(quantity: Int, key: String, frame: Any = null, exists: Boolean = false): Unit = js.native

  def getFirstAlive(): js.UndefOr[T] = js.native

  def getFirstAlive(createIfNull: Boolean = false,
                    x: Double,
                    y: Double,
                    key: String = null,
                    frame: String | Int = null): js.UndefOr[T] = js.native

  def getFirstExists(exists: Boolean): js.UndefOr[T] = js.native

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
