package io.scalajs.dom.html.phaser
package physics.ninja

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Ninja Physics AABB constructor.
  * Note: This class could be massively optimised and reduced in size. I leave that challenge up to you.
  * @param body   The body that owns this shape.
  * @param x      The x coordinate to create this shape at.
  * @param y      The y coordinate to create this shape at.
  * @param width  The width of this AABB.
  * @param height The height of this AABB.
  */
@js.native
@JSName("Phaser.Physics.Ninja.AABB")
class AABB(var body: Phaser.Physics.Ninja.Body,
           var x: Double,
           var y: Double,
           var width: Double,
           var height: Double)
  extends js.Object {

}
