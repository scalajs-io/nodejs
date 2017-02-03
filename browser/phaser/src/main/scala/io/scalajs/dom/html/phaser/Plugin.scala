package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * This is a base Plugin template to use for any Phaser plugin development.
  * @see http://phaser.io/docs/2.6.2/Phaser.Plugin.html
  */
@js.native
@JSName("Phaser.Plugin")
class Plugin(var game: Phaser.Game, val parent: Phaser.PluginManager) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * A Plugin with active=true has its preUpdate and update methods called by the parent, otherwise they are skipped.
    */
  var active: Boolean = js.native

  /**
    * A flag to indicate if this plugin has a postRender method.
    */
  var hasPostRender: Boolean = js.native

  /**
    * A flag to indicate if this plugin has a postUpdate method.
    */
  var hasPostUpdate: Boolean = js.native

  /**
    * A flag to indicate if this plugin has a preUpdate method.
    */
  var hasPreUpdate: Boolean = js.native

  /**
    * A flag to indicate if this plugin has a render method.
    */
  var hasRender: Boolean = js.native

  /**
    * A flag to indicate if this plugin has an update method.
    */
  var hasUpdate: Boolean = js.native

  /**
    * A Plugin with visible=true has its render and postRender methods called by the parent, otherwise they are skipped.
    */
  var visible: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Clear down this Plugin and null out references
    */
  def destroy(): Unit = js.native

  /**
    * Post-render is called after the Game Renderer and State.render have run.
    * It is only called if visible is set to true.
    */
  def postRender(): Unit = js.native

  /**
    * Pre-update is called at the very start of the update cycle, before any other subsystems have been updated (including Physics).
    * It is only called if active is set to true.
    */
  def preUpdate(): Unit = js.native

  /**
    * Render is called right after the Game Renderer completes, but before the State.render.
    * It is only called if visible is set to true.
    */
  def render(): Unit = js.native

  /**
    * Update is called after all the core subsystems (Input, Tweens, Sound, etc) and the State have updated, but before the render.
    * It is only called if active is set to true.
    */
  def update(): Unit = js.native

}
