package io.scalajs.dom.html.phaser.physics.ninja

import io.scalajs.dom.html.phaser.Phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The Physics Body is linked to a single Sprite. All physics operations should be performed
  * against the body rather than the Sprite itself. For example you can set the velocity,
  * bounce values etc all on the Body.
  * @param system The physics system this Body belongs to.
  * @param sprite The Sprite object this physics body belongs to.
  * @param `type` The type of Ninja shape to create. 1 = AABB, 2 = Circle or 3 = Tile.
  * @param id     If this body is using a Tile shape, you can set the Tile id here,
  *               i.e. Phaser.Physics.Ninja.Tile.SLOPE_45DEGpn, Phaser.Physics.Ninja.Tile.CONVEXpp, etc.
  * @param radius If this body is using a Circle shape this controls the radius.
  * @param x      The x coordinate of this Body. This is only used if a sprite is not provided.
  * @param y      The y coordinate of this Body. This is only used if a sprite is not provided.
  * @param width  The width of this Body. This is only used if a sprite is not provided.
  * @param height The height of this Body. This is only used if a sprite is not provided.
  * @see http://phaser.io/docs/2.6.2/Phaser.Physics.Ninja.Body.html
  */
@js.native
@JSName("Phaser.Physics.Ninja.Body")
class Body(var system: Phaser.Physics.Ninja,
           var sprite: Phaser.Sprite,
           var `type`: Int = js.native,
           var id: Int = js.native,
           var radius: Double = js.native,
           var x: Double = js.native,
           var y: Double = js.native,
           var width: Double = js.native,
           var height: Double = js.native)
  extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * The AABB object this body is using for collision.
    */
  var aabb: Phaser.Physics.Ninja.AABB = js.native

  /**
    * The angle of this Body
    */
  def angle: Double = js.native

  /**
    * The bottom value of this Body (same as Body.y + Body.height)
    */
  var bottom: Double = js.native

  /**
    * The bounciness of this object when it collides. A value between 0 and 1.
    * We recommend setting it to 0.999 to avoid jittering.
    */
  var bounce: Double = js.native

  /**
    * Set the checkCollision properties to control which directions collision is processed for this Body.
    * For example checkCollision.up = false means it won't collide when the collision happened while moving up.
    * An object containing allowed collision.
    */
  var checkCollision: js.Object = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////



}
