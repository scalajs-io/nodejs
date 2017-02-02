package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.pixijs.DisplayObject

import scala.scalajs.js

// TODO should this really extend DisplayObject?
@js.native
trait PhysicsBody extends DisplayObject {
  //var x: Double = js.native
  //var y: Double = js.native
  var moves: Boolean  = js.native
  var velocity: Point = js.native
}
