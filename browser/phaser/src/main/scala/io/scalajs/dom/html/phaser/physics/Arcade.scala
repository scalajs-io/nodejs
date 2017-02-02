package io.scalajs.dom.html.phaser
package physics

import io.scalajs.dom.html.pixijs.DisplayObject

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The Arcade Physics world. Contains Arcade Physics related collision, overlap and motion methods.
  * @param game reference to the current game instance.
  * @version 2.6.2
  * @see http://phaser.io/docs/2.6.2/Phaser.Physics.Arcade.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Physics.Arcade")
class Arcade(val game: Phaser.Game) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The bounds inside of which the physics world exists. Defaults to match the world bounds.
    */
  var bounds: Phaser.Rectangle = js.native

  /**
    * Set the checkCollision properties to control for which bounds collision is processed.
    * For example checkCollision.down = false means Bodies cannot collide with the World.bounds.bottom.
    * An object containing allowed collision flags.
    */
  var checkCollision: js.Any = js.native

  /**
    * If true World.separate will always separate on the X axis before Y. Otherwise it will check gravity totals first.
    */
  var forceX: Boolean = js.native

  /**
    * The World gravity setting. Defaults to x: 0, y: 0, or no gravity.
    */
  var gravity: Phaser.Point = js.native

  /**
    * If `true` the `Body.preUpdate` method will be skipped, halting all motion for all bodies.
    * Note that other methods such as `collide` will still work, so be careful not to call them on paused bodies.
    */
  var isPaused: Boolean = js.native

  /**
    * Used by the QuadTree to set the maximum number of iteration levels.
    */
  var maxLevels: Double = js.native

  /**
    * Used by the QuadTree to set the maximum number of objects per quad.
    */
  var maxObjects: Double = js.native

  /**
    * A value added to the delta values during collision checks.
    */
  var OVERLAP_BIAS: Double = js.native

  /**
    * The world QuadTree.
    */
  var quadTree: Phaser.QuadTree = js.native

  /**
    * If true the QuadTree will not be used for any collision. QuadTrees are great if objects are well spread out
    * in your game, otherwise they are a performance hit. If you enable this you can disable on a per body basis
    * via Body.skipQuadTree.
    */
  var skipQuadTree: Boolean = js.native

  /**
    * Used when colliding a Sprite vs. a Group, or a Group vs. a Group, this defines the direction the sort is based on.
    * Default is Phaser.Physics.Arcade.LEFT_RIGHT.
    */
  var sortDirection: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Sets the acceleration.x/y property on the display object so it will move towards the target at the given speed
    * (in pixels per second sq.)
    *
    * You must give a maximum speed value, beyond which the display object won't go any faster.
    *
    * Note: The display object does not continuously track the target. If the target changes location during transit
    * the display object will not modify its course.
    *
    * Note: The display object doesn't stop moving once it reaches the destination coordinates.
    * @param displayObject The display object to move.
    * @param destination   The display object to move towards. Can be any object but must have visible x/y properties.
    * @param speed         The speed it will accelerate in pixels per second.
    * @param xSpeedMax     The maximum x velocity the display object can reach.
    * @param ySpeedMax     The maximum y velocity the display object can reach.
    * @return The angle (in radians) that the object should be visually set to in order to match its new trajectory.
    */
  def accelerateToObject(displayObject: DisplayObject, destination: js.Any, speed: Double, xSpeedMax: Double, ySpeedMax: Double): Double = js.native


}

/**
  * Arcade Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSName("Phaser.Physics.Arcade")
object Arcade extends js.Object {

  /**
    * A constant used for the sortDirection value. Use this if your game world is narrow but tall and scrolls
    * from the bottom to the top (i.e. Commando or a vertically scrolling shoot-em-up)
    */
  val BOTTOM_TOP: Double = js.native

  /**
    * A constant used for the sortDirection value.
    * Use this if your game world is wide but short and scrolls from the left to the right (i.e. Mario)
    */
  val LEFT_RIGHT: Double = js.native

  /**
    * A constant used for the sortDirection value.
    * Use this if your game world is wide but short and scrolls from the right to the left (i.e. Mario backwards)
    */
  val RIGHT_LEFT: Double = js.native

  /**
    * A constant used for the sortDirection value.
    * Use this if you don't wish to perform any pre-collision sorting at all, or will manually sort your Groups.
    */
  val SORT_NONE: Double = js.native

  /**
    * A constant used for the sortDirection value.
    * Use this if your game world is narrow but tall and scrolls from the top to the bottom (i.e. Dig Dug)
    */
  val TOP_BOTTOM: Double = js.native

}