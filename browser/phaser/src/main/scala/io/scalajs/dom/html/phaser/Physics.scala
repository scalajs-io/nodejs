package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.p2

import scala.scalajs.js

@js.native
trait Physics extends js.Object {
  val ARCADE: Int = js.native
  val arcade: ArcadePhysics = js.native

  def enable(player: Sprite, system: Int, debug: Boolean = false): Unit = js.native

  def startSystem(systemId: Int): Unit = js.native

  val P2: p2.P2 = js.native

}
