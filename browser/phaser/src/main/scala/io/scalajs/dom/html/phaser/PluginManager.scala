package io.scalajs.dom.html.phaser

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * The Plugin Manager is responsible for the loading, running and unloading of Phaser Plugins.
  * @param game A reference to the currently running game.
  * @see http://phaser.io/docs/2.6.2/Phaser.PluginManager.html
  */
@js.native
@JSName("Phaser.PluginManager")
class PluginManager(val game: Phaser.Game) extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * An array of all the plugins being managed by this PluginManager.
    */
  def plugins: js.Array[Phaser.Plugin] = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Add a new Plugin into the PluginManager.
    * The Plugin must have 2 properties: game and parent. Plugin.game is set to the game reference the
    * PluginManager uses, and parent is set to the PluginManager.
    * @param plugin    The [[Plugin]] to add into the PluginManager. This can be a function or an existing object.
    * @param parameter Additional arguments that will be passed to the Plugin.init method.
    * @return The [[Plugin]] that was added to the manager.
    */
  def add(plugin: Phaser.Plugin, parameter: js.Any*): Phaser.Plugin = js.native

  /**
    * Clear down this PluginManager, calls destroy on every plugin and nulls out references.
    */
  def destroy(): Unit = js.native

  /**
    * Post-render is called after the Game Renderer and State.render have run.
    * It only calls plugins who have visible=true.
    */
  def postRender(): Unit = js.native

  /**
    * PostUpdate is the last thing to be called before the world render.
    * In particular, it is called after the world postUpdate, which means the camera has been adjusted.
    * It only calls plugins who have active=true.
    */
  def postUpdate(): Unit = js.native

  /**
    * Pre-update is called at the very start of the update cycle, before any other subsystems have been updated (including Physics).
    * It only calls plugins who have active=true.
    */
  def preUpdate(): Unit = js.native

  /**
    * Remove a Plugin from the PluginManager. It calls Plugin.destroy on the plugin before removing it from the manager.
    * @param plugin  The plugin to be removed.
    * @param destroy Call destroy on the plugin that is removed?
    */
  def remove(plugin: Phaser.Plugin, destroy: Boolean = js.native): Unit = js.native

  /**
    * Remove all Plugins from the PluginManager. It calls Plugin.destroy on every plugin before removing it from the manager.
    */
  def removeAll(): Unit = js.native

  /**
    * Render is called right after the Game Renderer completes, but before the State.render.
    * It only calls plugins who have visible=true.
    */
  def render(): Unit = js.native

  /**
    * Update is called after all the core subsystems (Input, Tweens, Sound, etc) and the State have updated, but before the render.
    * It only calls plugins who have active=true.
    */
  def update(): Unit = js.native

}
