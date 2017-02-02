package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.pixijs.DisplayObject

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

@js.native
@JSName("Phaser.ArcadePhysics")
class ArcadePhysics extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////


  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  def moveToObject(displayObject: DisplayObject, destination: Any, speed: Int = 60, maxTime: Long = 0): Double = js.native

  def overlap(object1: Sprite | Group[_] | js.Array[_],
              object2: Sprite | Group[_] | js.Array[_],
              overlapCallback: js.Function2[_, _, _],
              processCallback: Option[js.Function2[_, _, Boolean]],
              callbackContext: js.Any = js.native): Unit = js.native

}
