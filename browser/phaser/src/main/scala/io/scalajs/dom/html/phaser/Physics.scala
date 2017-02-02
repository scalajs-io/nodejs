package io.scalajs.dom.html.phaser

import io.scalajs.RawOptions

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}
import scala.scalajs.js.|

/**
  * The Physics Manager is responsible for looking after all of the running physics systems.
  * Phaser supports 4 physics systems: Arcade Physics, P2, Ninja Physics and Box2D via a commercial plugin.
  *
  * Game Objects (such as Sprites) can only belong to 1 physics system, but you can have multiple systems
  * active in a single game.
  *
  * For example you could have P2 managing a polygon-built terrain landscape that an vehicle drives over,
  * while it could be firing bullets that use the
  * faster (due to being much simpler) Arcade Physics system.
  * @param game   A reference to the currently running game.
  * @param config A physics configuration object to pass to the Physics world on creation.
  * @see http://phaser.io/docs/2.6.2/Phaser.Physics.html
  */
@js.native
@JSName("Phaser.Physics")
class Physics(var game: Phaser.Game, var config: PhysicsConfig | RawOptions) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The Arcade Physics system.
    */
  var arcade: Phaser.Physics.Arcade = js.native

  /**
    * The Box2D Physics system.
    */
  var box2d: Phaser.Physics.Box2D = js.native

  /**
    * The Chipmunk Physics system (to be done).
    */
  var chipmunk: Phaser.Physics.Chipmunk = js.native

  /**
    * The MatterJS Physics system (coming soon).
    */
  var matter: Phaser.Physics.Matter = js.native

  /**
    * The N+ Ninja Physics system.
    */
  var ninja: Phaser.Physics.Ninja = js.native

  /**
    * The P2.JS Physics system.
    */
  var p2: Phaser.Physics.P2 = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Destroys all active physics systems. Usually only called on a Game Shutdown, not on a State swap.
    */
  def destroy(): Unit = js.native

  /**
    * This will create a default physics body on the given game object or array of objects.
    * A game object can only have 1 physics body active at any one time, and it can't be changed until the object is destroyed.
    * It can be for any of the physics systems that have been started:
    * Phaser.Physics.Arcade - A light weight AABB based collision system with basic separation.
    * Phaser.Physics.P2JS - A full-body advanced physics system supporting multiple object shapes, polygon loading,
    * contact materials, springs and constraints.
    * Phaser.Physics.NINJA - A port of Metanet Softwares N+ physics system. Advanced AABB and Circle vs. Tile collision.
    * Phaser.Physics.BOX2D - A port of https://code.google.com/p/box2d-html5
    * Phaser.Physics.MATTER - A full-body and light-weight advanced physics system (still in development)
    * Phaser.Physics.CHIPMUNK is still in development.
    * If you require more control over what type of body is created, for example to create a Ninja Physics Circle
    * instead of the default AABB, then see the
    * individual physics systems enable methods instead of using this generic one.
    * @param `object` The game object to create the physics body on. Can also be an array of objects, a body will be
    *                 created on every object in the array.
    * @param system   The physics system that will be used to create the body. Defaults to Arcade Physics.
    * @param debug    Enable the debug drawing for this body. Defaults to false.
    */
  def enable(`object`: js.Object | js.Array[_] = js.native, system: Int = js.native, debug: Boolean = js.native): Unit = js.native

  /**
    * Parses the Physics Configuration object passed to the Game constructor and starts any physics systems specified within.
    */
  def parseConfig(): Unit = js.native

  /**
    * Sets the bounds of the Physics world to match the Game.World dimensions.
    * You can optionally set which 'walls' to create: left, right, top or bottom.
    * @param left              If true will create the left bounds wall.
    * @param right             If true will create the right bounds wall.
    * @param top               If true will create the top bounds wall.
    * @param bottom            If true will create the bottom bounds wall.
    * @param setCollisionGroup If true the Bounds will be set to use its own Collision Group.
    */
  def setBoundsToWorld(left: Boolean = js.native,
                       right: Boolean = js.native,
                       top: Boolean = js.native,
                       bottom: Boolean = js.native,
                       setCollisionGroup: Boolean = js.native): Unit = js.native

  /**
    * Sets the given material against the 4 bounds of this World.
    * @param material The material to set.
    * @param left     If true will set the material on the left bounds wall.
    * @param right    If true will set the material on the right bounds wall.
    * @param top      If true will set the material on the top bounds wall.
    * @param bottom   If true will set the material on the bottom bounds wall.
    */
  def setWorldMaterial(material: Phaser.Physics.P2.Material,
                       left: Boolean = js.native,
                       right: Boolean = js.native,
                       top: Boolean = js.native,
                       bottom: Boolean = js.native): Unit = js.native


  /**
    * This will create an instance of the requested physics simulation.
    * Phaser.Physics.Arcade is running by default, but all others need activating directly.
    * You can start the following physics systems:
    * Phaser.Physics.P2JS - A full-body advanced physics system by Stefan Hedman.
    * Phaser.Physics.NINJA - A port of Metanet Softwares N+ physics system.
    * Phaser.Physics.BOX2D - A commercial Phaser Plugin (see http://phaser.io)
    * Both Ninja Physics and Box2D require their respective plugins to be loaded before you can start them.
    * They are not bundled into the core Phaser library.
    * If the physics world has already been created (i.e. in another state in your game) then
    * calling startSystem will reset the physics world, not re-create it. If you need to start them again from their constructors
    * then set Phaser.Physics.p2 (or whichever system you want to recreate) to null before calling startSystem.
    * @param system   The physics system to start: Phaser.Physics.ARCADE, Phaser.Physics.P2JS, Phaser.Physics.NINJA or
    *                 Phaser.Physics.BOX2D.
    */
  def startSystem(system: Int): Unit = js.native


}

/**
  * Physics Singleton
  */
@js.native
@JSName("Phaser.Physics")
object Physics extends js.Object {

  val ARCADE: Int = js.native

  val BOX2D: Int = js.native

  val CHIPMUNK: Int = js.native

  val MATTERJS: Int = js.native

  val NINJA: Int = js.native

  val P2JS: Int = js.native

}

/**
  * Physics Configuration Options
  * @see https://github.com/photonstorm/phaser/blob/v2.6.2/src/physics/Physics.js
  */
@ScalaJSDefined
class PhysicsConfig(var arcade: js.UndefOr[Boolean] = js.undefined,
                    var ninja: js.UndefOr[Boolean] = js.undefined,
                    var p2: js.UndefOr[Boolean] = js.undefined,
                    var box2d: js.UndefOr[Boolean] = js.undefined,
                    var matter: js.UndefOr[Boolean] = js.undefined) extends js.Object