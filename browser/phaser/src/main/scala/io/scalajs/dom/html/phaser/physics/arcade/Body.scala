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

  /**
    * The Sprite position is updated based on the delta x/y values. You can set a cap on those (both +-) using deltaMax.
    */
  var deltaMax: Phaser.Point = js.native

  /**
    * If this Body in a preUpdate (true) or postUpdate (false) state?
    */
  var dirty: Boolean = js.native

  /**
    * The drag applied to the motion of the Body.
    */
  var drag: Phaser.Point = js.native

  /**
    * If a body is overlapping with another body, but neither of them are moving (maybe they spawned on-top of each other?)
    * this is set to true. Body embed value.
    */
  var embedded: Boolean = js.native

  /**
    * A disabled body won't be checked for any form of collision or overlap or have its pre/post updates run.
    */
  var enable: Boolean = js.native

  /**
    * A const reference to the direction the Body is traveling or facing.
    */
  var facing: Int = js.native

  /**
    * The amount of movement that will occur if another object 'rides' this one.
    */
  var friction: Phaser.Point = js.native

  /**
    * Local reference to game.
    */
  var game: Phaser.Game = js.native

  /**
    * A local gravity applied to this Body. If non-zero this over rides any world gravity,
    * unless Body.allowGravity is set to false.
    */
  var gravity: Phaser.Point = js.native

  /**
    * The calculated height / 2 of the physics body.
    */
  def halfHeight: Double = js.native

  /**
    * The calculated width / 2 of the physics body.
    */
  def halfWidth: Double = js.native

  /**
    * The calculated height of the physics body.
    */
  def height: Double = js.native

  /**
    * An immovable Body will not receive any impacts from other bodies.
    */
  def immovable: Boolean = js.native

  /**
    * If true this Body is using circular collision detection. If false it is using rectangular.
    * Use Body.setCircle to control the collision shape this Body uses.
    */
  def isCircle: Boolean = js.native

  /**
    * Set by the moveTo and moveFrom methods.
    */
  var isMoving: Boolean = js.native

  /**
    * The x position of the Body. The same as `Body.x`.
    */
  var left: Double = js.native

  /**
    * The mass of the Body. When two bodies collide their mass is used in the calculation to determine
    * the exchange of velocity (default: 1).
    */
  var mass: Double = js.native

  /**
    * The maximum angular velocity in degrees per second that the Body can reach.
    */
  var maxAngular: Double = js.native

  /**
    * The maximum velocity in pixels per second sq. that the Body can reach.
    */
  var maxVelocity: Phaser.Point = js.native

  /**
    * Optional callback. If set, invoked during the running of `moveTo` or `moveFrom` events.
    */
  var movementCallback: js.Function = js.native

  /**
    * Context in which to call the movementCallback.
    */
  var movementCallbackContext: js.Object = js.native

  /**
    * If you have a Body that is being moved around the world via a tween or a Group motion, but its local x/y position never
    * actually changes, then you should set Body.moves = false. Otherwise it will most likely fly off the screen.
    *
    * If you want the physics system to move the body around, then set moves to true. Set to true to allow the
    * Physics system to move this Body, otherwise false to move it manually.
    */
  var moves: Boolean = js.native

  /**
    * The new velocity. Calculated during the Body.preUpdate and applied to its position.
    */
  def newVelocity: Phaser.Point = js.native

  /**
    * The offset of the Physics Body from the Sprite x/y position.
    */
  var offset: Phaser.Point = js.native

  /**
    * A Signal that is dispatched when this Body collides with another Body.
    * *
    * You still need to call game.physics.arcade.collide in your update method in order
    * for this signal to be dispatched.
    * *
    * Usually you'd pass a callback to the collide method, but this signal provides for
    * a different level of notification.
    * *
    * Due to the potentially high volume of signals this could create it is disabled by default.
    * *
    * To use this feature set this property to a Phaser.Signal:
    * {{{
    * sprite.body.onCollide = new Phaser.Signal()
    * }}}
    * and it will be called when a collision happens, passing two arguments: the sprites which collided.
    * The first sprite in the argument is always the owner of this Body.
    * *
    * If two Bodies with this Signal set collide, both will dispatch the Signal.
    */
  var onCollide: Phaser.Signal = js.native

  /**
    * Listen for the completion of `moveTo` or `moveFrom` events.
    */
  var onMoveComplete: Phaser.Signal = js.native

  /**
    * A Signal that is dispatched when this Body overlaps with another Body.
    *
    * You still need to call game.physics.arcade.overlap in your update method in order
    * for this signal to be dispatched.
    *
    * Usually you'd pass a callback to the overlap method, but this signal provides for
    * a different level of notification.
    *
    * Due to the potentially high volume of signals this could create it is disabled by default.
    *
    * To use this feature set this property to a Phaser.Signal: sprite.body.onOverlap = new Phaser.Signal()
    * and it will be called when a collision happens, passing two arguments: the sprites which collided.
    * The first sprite in the argument is always the owner of this Body.
    *
    * If two Bodies with this Signal set collide, both will dispatch the Signal.
    */
  var onOverlap: Phaser.Signal = js.native

  /**
    * A Signal that is dispatched when this Body collides with the world bounds.
    * Due to the potentially high volume of signals this could create it is disabled by default.
    * To use this feature set this property to a Phaser.Signal:
    * {{{
    * sprite.body.onWorldBounds = new Phaser.Signal()
    * }}}
    * and it will be called when a collision happens, passing five arguments:
    * {{{
    * onWorldBounds(sprite, up, down, left, right)
    * }}}
    * where the Sprite is a reference to the Sprite that owns this Body, and the other arguments are booleans
    * indicating on which side of the world the Body collided.
    */
  var onWorldBounds: Phaser.Signal = js.native

  /**
    * If `Body.isCircle` is true, and this body collides with another circular body, the amount of overlap is stored here.
    * The amount of overlap during the collision.
    */
  var overlapR: Double = js.native

  /**
    * When this body collides with another, the amount of overlap is stored here.
    * The amount of horizontal overlap during the collision.
    */
  var overlapX: Double = js.native

  /**
    * When this body collides with another, the amount of overlap is stored here.
    * The amount of vertical overlap during the collision.
    */
  var overlapY: Double = js.native

  /**
    * The position of the physics body.
    */
  def position: Phaser.Point = js.native

  /**
    * The previous rotation of the physics body.
    */
  def preRotation: Double = js.native

  /**
    * The previous position of the physics body.
    */
  def prev: Phaser.Point = js.native

  /**
    * The radius of the circular collision shape this Body is using if Body.setCircle has been enabled.
    * If you wish to change the radius then call setCircle again with the new value.
    * If you wish to stop the Body using a circle then call setCircle with a radius of zero (or undefined).
    */
  def radius: Double = js.native

  /**
    * The right value of this Body (same as Body.x + Body.width)
    */
  def right: Double = js.native

  /**
    * The Body's rotation in degrees, as calculated by its angularVelocity and angularAcceleration.
    * Please understand that the collision Body
    *
    * itself never rotates, it is always axis-aligned. However these values are passed up to the
    * parent Sprite and updates its rotation.
    */
  def rotation: Double = js.native

  /**
    * If true and you collide this Sprite against a Group,
    * it will disable the collision check from using a QuadTree.
    */
  var skipQuadTree: Boolean = js.native

  /**
    * The un-scaled original size.
    */
  def sourceHeight: Double = js.native

  /**
    * The un-scaled original size.
    */
  def sourceWidth: Double = js.native

  /**
    * The speed of the Body as calculated by its velocity.
    */
  def speed: Double = js.native

  /**
    * Set by the moveTo and moveFrom methods.
    */
  var stopVelocityOnCollide: Boolean = js.native

  /**
    * If true the Body will check itself against the Sprite.getBounds() dimensions and adjust its width and height accordingly.
    * If false it will compare its dimensions against the Sprite scale instead, and adjust its width height if the scale has changed.
    * Typically you would need to enable syncBounds if your sprite is the child of a responsive display object such as a FlexLayer,
    * or in any situation where the Sprite scale doesn't change, but its parents scale is effecting the dimensions regardless.
    */
  var syncBounds: Boolean = js.native

  /**
    * If this is an especially small or fast moving object then it can sometimes skip over tilemap collisions
    * if it moves through a tile in a step.
    *
    * Set this padding value to add extra padding to its bounds. tilePadding.x applied to its width, y to its
    * height. Extra padding to be added to this sprite's dimensions when checking for tile collision.
    */
  var tilePadding: Phaser.Point = js.native

  /**
    * The y position of the Body. The same as Body.y.
    */
  var top: Double = js.native

  /**
    * This object is populated with boolean values when the Body collides with another.
    *touching.up = true means the collision happened to the top of this Body for example.
    * An object containing touching results.
    */
  var touching: js.Object = js.native

  /**
    * The type of physics system this body belongs to.
    */
  var `type`: Int = js.native

  /**
    * The velocity, or rate of change in speed of the Body. Measured in pixels per second.
    */
  var velocity: Point = js.native

  /**
    * This object is populated with previous touching values from the bodies previous collision.
    * An object containing previous touching results.
    */
  var wasTouching: js.Object = js.native

  /**
    * The calculated width of the physics body.
    */
  def width: Double = js.native

  /**
    * The elasticity of the Body when colliding with the World bounds.
    * By default this property is null, in which case Body.bounce is used instead. Set this property
    * to a Phaser.Point object in order to enable a World bounds specific bounce value.
    */
  var worldBounce: Phaser.Point = js.native

  /**
    * The x position.
    */
  var x: Double = js.native

  /**
    * The y position.
    */
  var y: Double = js.native

}
