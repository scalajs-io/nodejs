package org.scalajs.browser.p2

import org.scalajs.browser.phaser.Phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * This is your main access to the P2 Physics World. From here you can create materials, listen for events and add bodies
  * into the physics simulation.
  * @param game   Reference to the current game instance.
  * @param config Physics configuration object passed in from the game constructor.
  */
@js.native
@JSName("P2")
class P2(val game: Phaser.Game, val config: js.Any) extends js.Object {

  /**
    * TODO
    */
  var allowSleep: Boolean = js.native

  /**
    * The angle of the Body in degrees from its original orientation. Values from 0 to 180 represent clockwise rotation;
    * values from 0 to -180 represent counterclockwise rotation. Values outside this range are added to or subtracted
    * from 360 to obtain a value within the range. For example, the statement Body.angle = 450 is the same as
    * Body.angle = 90. If you wish to work in radians instead of degrees use the property Body.rotation instead.
    * Working in radians is faster as it doesn't have to convert values. The angle of this Body in degrees.
    */
  var angle: Double = js.native

  /**
    * Damping is specified as a value between 0 and 1, which is the proportion of velocity lost per second. The angular
    * damping acting acting on the body.
    */
  var angularDamping: Double = js.native

  /**
    * The angular force acting on the body.
    */
  var angularForce: Double = js.native

  /**
    * The angular velocity of the body.
    */
  var angularVelocity: Double = js.native

  /**
    * A Body can be set to collide against the World bounds automatically if this is set to true. Otherwise it will
    * leave the World. Note that this only applies if your World has bounds! The response to the collision should be
    * managed via CollisionMaterials. Also note that when you set this it will only effect Body shapes that already
    * exist. If you then add further shapes to your Body after setting this it will not proactively set them to collide
    * with the bounds. Should the Body collide with the World bounds?
    */
  var collidesWith: js.Array[_] = js.native

  /**
    * Damping is specified as a value between 0 and 1, which is the proportion of velocity lost per second. The linear
    * damping acting on the body in the velocity direction.
    */
  var damping: Double = js.native

  /**
    * The p2 Body data.
    * Internal: This member is internal (protected) and may be modified or removed in the future.
    */
  var data: P2.Body = js.native

  /**
    * Enable or disable debug drawing of this body
    */
  var debug: Boolean = js.native

  /**
    * Reference to the debug body.
    */
  var debugBody: /*Phaser.Physics.*/ P2.BodyDebug = js.native

  /**
    * Internally used by Sprite.x/y
    */
  var dirty: Boolean = js.native

}

@js.native
@JSName("P2")
object P2 extends js.Object {

  /**
    * The Physics Body is typically linked to a single Sprite and defines properties that determine how the physics body
    * is simulated. These properties affect how the body reacts to forces, what forces it generates on itself (to simulate
    * friction), and how it reacts to collisions in the scene. In most cases, the properties are used to simulate physical
    * effects. Each body also has its own property values that determine exactly how it reacts to forces and collisions
    * in the scene. By default a single Rectangle shape is added to the Body that matches the dimensions of the parent
    * Sprite. See addShape, removeShape, clearShapes to add extra shapes around the Body. Note: When bound to a Sprite
    * to avoid single-pixel jitters on mobile devices we strongly recommend using Sprite sizes that are even on both
    * axis, i.e. 128x128 not 127x127. Note: When a game object is given a P2 body it has its anchor x/y set to 0.5,
    * so it becomes centered.
    * @param game   Game reference to the currently running game.
    * @param sprite The Sprite object this physics body belongs to.
    * @param x      The x coordinate of this Body.
    * @param y      The y coordinate of this Body.
    * @param mass   The default mass of this Body (0 = static).
    */
  @js.native
  class Body(val game: Phaser.Game, val sprite: Phaser.Sprite, val x: Int = js.native, val y: Int = js.native, val mass: Int = js.native) extends js.Object

  @js.native
  object Body extends js.Object {

    /**
      * Dynamic body. Dynamic bodies body can move and respond to collisions and forces.
      */
    def DYNAMIC: Int = js.native

    /**
      * Kinematic body. Kinematic bodies only moves according to its .velocity, and does not respond to collisions or force.
      */
    def KINEMATIC: Int = js.native

    /**
      * Static body. Static bodies do not move, and they do not respond to forces or collision.
      */
    def STATIC: Int = js.native

  }

  /**
    * Draws a P2 Body to a Graphics instance for visual debugging. Needless to say, for every body you enable debug
    * drawing on, you are adding processor and graphical overhead. So use sparingly and rarely (if ever) in production code.
    *
    * Also be aware that the Debug body is only updated when the Sprite it is connected to changes position. If you
    * manipulate the sprite in any other way (such as moving it to another Group or bringToTop, etc) then you will need
    * to manually adjust its BodyDebug as well.
    * @param game     Game reference to the currently running game.
    * @param body     The P2 Body to display debug data for.
    * @param settings Settings object.
    */
  @js.native
  class BodyDebug(val game: Phaser.Game, val body: /*Phaser.Physics.*/ P2.Body, val settings: js.Any) extends js.Object // Phaser.Group(game, )

  @js.native
  object BodyDebug extends js.Object

}