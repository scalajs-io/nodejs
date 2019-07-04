package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.pixijs.DisplayObject

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * A reference to the GameObjectFactory which can be used to add new objects to the World.
  * @param game the running [[Game]].
  */
@js.native
@JSGlobal("Phaser.GameObjectFactory")
class GameObjectFactory(var game: Game = js.native) extends js.Object {

  /**
    * A reference to the game world.
    */
  var world: World = js.native

  def tween(aliens: DisplayObject): Tween = js.native

  def text(x: Double = js.native,
           y: Double = js.native,
           text: String = js.native,
           style: js.Dictionary[_] = js.native,
           group: Group[_] = js.native): Text = js.native

  def sprite(x: Int = js.native, y: Int = js.native, key: String = js.native, frame: Any = js.native, group: Group[_] = js.native): Sprite = js.native

  def group(parent: Any = js.native,
            name: String = js.native,
            addToStage: Boolean = js.native,
            enableBody: Boolean = js.native,
            physicsBodyType: Int = js.native): Group[Sprite] = js.native

  def tileSprite(x: Int, y: Int, width: Int, height: Int, key: String, frame: Any = js.native, group: Group[_] = js.native): TileSprite = js.native
}