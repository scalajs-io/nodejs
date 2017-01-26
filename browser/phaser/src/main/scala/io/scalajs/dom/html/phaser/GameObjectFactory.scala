package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.pixijs.DisplayObject

import scala.scalajs.js

/**
  * A reference to the GameObjectFactory which can be used to add new objects to the World.
  */
@js.native
trait GameObjectFactory extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A reference to the currently running Game.
    */
  var game: Game = js.native

  /**
    * A reference to the game world.
    */
  var world: World = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def tween(aliens: DisplayObject): Tween = js.native

  def text(x: Double = 0, y: Double = 0, text: String = "", style: js.Dictionary[_] = null, group: Group[_] = null): Text = js.native

  def sprite(x: Int = 0, y: Int = 0, key: String = null, frame: Any = null, group: Group[_] = null): Sprite = js.native

  def group(parent: Any = null, name: String = null, addToStage: Boolean = false, enableBody: Boolean = false, physicsBodyType: Int = 0): Group[Sprite] = js.native

  def tileSprite(x: Int, y: Int, width: Int, height: Int, key: String, frame: Any = null, group: Group[_] = null): TileSprite = js.native
}
