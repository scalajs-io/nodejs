package io.scalajs.dom.html.phaser.component

import scala.scalajs.js

/**
  * The Destroy component is responsible for destroying a Game Object.
  * @see http://phaser.io/docs/2.6.2/Phaser.Component.Destroy.html
  */
@js.native
//@JSName("Phaser.Component.Destroy")
trait Destroy extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * As a Game Object runs through its destroy method this flag is set to true,
    * and can be checked in any sub-systems or plugins it is being destr
    */
  def destroyPhase: Boolean = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Destroys the Game Object. This removes it from its parent group, destroys the input, event
    * and animation handlers if present   and nulls its reference to game, freeing it up for garbage collection.
    *
    * If this Game Object has the Events component it will also dispatch the onDestroy event.
    * You can optionally also destroy the BaseTexture this Game Object is using. Be careful if you've
    * more than one Game Object sharing the same BaseTexture.
    * @param destroyChildren Should every child of this object have its destroy method called as well?
    * @param destroyTexture  Destroy the BaseTexture this Game Object is using? Note that if another Game
    *                        Object is sharing the same BaseTexture it will invalidate it.
    */
  def destroy(destroyChildren: Boolean, destroyTexture: Boolean): Unit = js.native

  def destroy(destroyChildren: Boolean): Unit = js.native

  def destroy(): Unit = js.native

}
