package io.scalajs.dom.html.phaser
package component

import scala.scalajs.js

@js.native
//@JSName("Phaser.Component.Core")
trait Core extends js.Object {

  /**
    * If the Game Object is enabled for animation (such as a Phaser.Sprite) this is a reference to its AnimationManager instance.
    * Through it you can create, play, pause and stop animations.
    */
  var animations: Phaser.AnimationManager = js.native

  /**
    * An empty Object that belongs to this Game Object.
    * This value isn't ever used internally by Phaser, but may be used by your own code, or
    * by Phaser Plugins, to store data that needs to be associated with the Game Object,
    * without polluting the Game Object directly.
    */
  var data: js.Object = js.native

  /**
    * A debug flag designed for use with `Game.enableStep`.
    */
  var debug: Boolean = js.native

  var events: Phaser.Events = js.native

  /**
    * The world coordinates of this Game Object in pixels.
    * Depending on where in the display list this Game Object is placed this value can differ from `position`,
    * which contains the x/y coordinates relative to the Game Objects parent.
    */
  var world: Phaser.Point = js.native

  /**
    * The z depth of this Game Object within its parent Group.
    * No two objects in a Group can have the same z value.
    * This value is adjusted automatically whenever the Group hierarchy changes.
    * If you wish to re-order the layering of a Game Object then see methods like Group.moveUp or Group.bringToTop.
    */
  var z: Double = js.native

}