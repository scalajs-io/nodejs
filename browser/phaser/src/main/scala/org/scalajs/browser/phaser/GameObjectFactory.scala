package org.scalajs.browser.phaser

import org.scalajs.browser.pixijs.PIXI
import PIXI.DisplayObject

import scala.scalajs.js

/**
  * Game Object Factory - A reference to the GameObjectFactory which can be used to add new objects to the World.
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait GameObjectFactory extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A reference to the currently running Game.
    */
  var game: Phaser.Game = js.native

  /**
    * A reference to the game world.
    */
  var world : Phaser.World = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def tween(aliens: DisplayObject): Tween = js.native

  def text(x: Double = 0, y: Double = 0, text: String = "", style: js.Dictionary[_] = null, group: Group[_] = null): Text = js.native

  def sprite(x: Int = 0, y: Int = 0, key: String = null, frame: Any = null, group: Group[_] = null): Sprite

  def group(parent: Any = null, name: String = null, addToStage: Boolean = false, enableBody: Boolean = false, physicsBodyType: Int = 0): Group[Sprite] = js.native

  def tileSprite(x: Int, y: Int, width: Int, height: Int, key: String, frame: Any = null, group: Group[_] = null): TileSprite = js.native

}
