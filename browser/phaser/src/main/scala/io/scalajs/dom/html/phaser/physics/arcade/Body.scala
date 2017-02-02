package io.scalajs.dom.html.phaser
package physics.arcade

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The Physics Body is linked to a single Sprite. All physics operations should be performed against the body rather than
  * the Sprite itself. For example you can set the velocity, acceleration, bounce values etc all on the Body.
  * @see https://phaser.io/docs/2.6.2/Phaser.Physics.Arcade.Body.html
  */
@js.native
@JSName("Phaser.Physics.Arcade.Body")
class Body(val sprite: Phaser.Sprite) extends js.Object {

  /**
    * The acceleration is the rate of change of the velocity. Measured in pixels per second squared.
    */
  var acceleration: Phaser.Point = js.native

  /**
    * Allow this Body to be influenced by gravity? Either world or local.
    */
  var allowGravity: Boolean = js.native

  /**
    * Allow this Body to be rotated? (via angularVelocity, etc)
    */
  var allowRotation: Boolean = js.native

  /**
    * The angle of the Body's velocity in radians.
    */
  def angle: Double = js.native

  /**
    * The angular acceleration is the rate of change of the angular velocity. Measured in degrees per second squared.
    */
  var angularAcceleration: Double = js.native

  /**
    * The drag applied during the rotation of the Body. Measured in degrees per second squared.
    */
  var angularDrag: Double = js.native

  /**
    * The angular velocity controls the rotation speed of the Body. It is measured in degrees per second.
    */
  var angularVelocity: Double = js.native

  /**
    * This object is populated with boolean values when the Body collides with the World bounds or a Tile.
    * For example if blocked.up is true then the Body cannot move up. An object containing on which faces this Body
    * is blocked from moving, if any.
    */
  var blocked: js.Any = js.native

  /**
    * The bottom value of this Body (same as Body.y + Body.height)
    */
  def bottom: Double = js.native

  /**
    * The elasticity of the Body when colliding. bounce.x/y = 1 means full rebound, bounce.x/y = 0.5 means 50% rebound velocity.
    */
  var bounce: Phaser.Point = js.native

  /**
    * The center coordinate of the Physics Body.
    */
  def center: Phaser.Point = js.native

  /**
    * Set the checkCollision properties to control which directions collision is processed for this Body.
    * For example checkCollision.up = false means it won't collide when the collision happened while moving up.
    * If you need to disable a Body entirely, use `body.enable = false`, this will also disable motion.
    * If you need to disable just collision and/or overlap checks, but retain motion, set `checkCollision.none = true`.
    * An object containing allowed collision.
    */
  var checkCollision: js.Any = js.native

  /**
    * A Body can be set to collide against the World bounds automatically and rebound back into the World
    * if this is set to true. Otherwise it will leave the World. Should the Body collide with the World bounds?
    */
  var collideWorldBounds: Boolean = js.native

  /**
    * This flag allows you to disable the custom x separation that takes place by Physics.Arcade.separate.
    * Used in combination with your own collision processHandler you can create whatever type of collision
    * response you need. Use a custom separation system or the built-in one?
    */
  var customSeparateX: Boolean = js.native

  /**
    * This flag allows you to disable the custom y separation that takes place by Physics.Arcade.separate.
    * Used in combination with your own collision processHandler you can create whatever type of collision
    * response you need. Use a custom separation system or the built-in one?
    */
  var customSeparateY: Boolean = js.native

}
