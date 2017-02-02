package io.scalajs.dom.html.phaser
package component

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The PhysicsBody component manages the Game Objects physics body and physics enabling.
  * It also overrides the x and y properties, ensuring that any manual adjustment of them
  * is reflected in the physics body itself.
  * @see https://phaser.io/docs/2.6.2/Phaser.Component.PhysicsBody.html
  */
@js.native
trait PhysicsBody extends js.Object {

  /**
    * body is the Game Objects physics body. Once a Game Object is enabled for physics you access all associated
    * properties and methods via it.
    *
    * By default Game Objects won't add themselves to any physics system and their body property will be null.
    *
    * To enable this Game Object for physics you need to call game.physics.enable(object, system) where object is this object
    * and system is the Physics system you are using. If none is given it defaults to Phaser.Physics.Arcade.
    *
    * You can alternatively call game.physics.arcade.enable(object), or add this Game Object to a physics enabled Group.
    *
    * Important: Enabling a Game Object for P2 or Ninja physics will automatically set its anchor property to 0.5,
    * so the physics body is centered on the Game Object.
    *
    * If you need a different result then adjust or re-create the Body shape offsets manually or reset the anchor
    * after enabling physics.
    */
  var body: Phaser.Component.PhysicsBody = js.native

  /**
    * The position of the Game Object on the x axis relative to the local coordinates of the parent.
    */
  def x: Double = js.native

  def x_=(x : Double): Unit = js.native

  /**
    * The position of the Game Object on the y axis relative to the local coordinates of the parent.
    */
  def y: Double = js.native

  def y_=(y : Double): Unit = js.native

}

@js.native
@JSName("Phaser.Component.PhysicsBody")
object PhysicsBody extends js.Object {

  /**
    * The PhysicsBody component postUpdate handler.
    * Called automatically by the Game Object.
    */
  def postUpdate(): Unit = js.native

  /**
    * The PhysicsBody component preUpdate handler.
    * Called automatically by the Game Object.
    */
  def preUpdate(): Unit = js.native

}