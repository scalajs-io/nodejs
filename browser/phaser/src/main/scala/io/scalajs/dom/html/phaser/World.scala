package io.scalajs.dom.html.phaser

import scala.scalajs.js

/**
  * A game has only one world. The world is an abstract place in which all game objects live. It is not bound by stage
  * limits and can be any size. You look into the world via cameras. All game objects live within the world at
  * world-based coordinates. By default a world is created the same size as your Stage.
  * @param game Reference to the current game instance.
  */
@js.native
class World(var game: Phaser.Game) extends js.Object {

  /**
    * The alive property is useful for Groups that are children of other Groups and need to be included/excluded in
    * checks like forEachAlive.
    */
  var alive: Boolean = js.native

  /**
    * The x coordinate of the center of the Rectangle.
    */
  var centerX: Double = js.native

  /**
    * The y coordinate of the center of the Rectangle.
    */
  var centerY: Double = js.native

  /**
    * The height of the Rectangle. This value should never be set to a negative.
    */
  var height: Double = js.native

  /**
    * The width of the Rectangle. This value should never be set to a negative.
    */
  var width: Double = js.native

}