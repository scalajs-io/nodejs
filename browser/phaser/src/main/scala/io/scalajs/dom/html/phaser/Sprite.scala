package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.phaser.component._
import io.scalajs.dom.html.pixijs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName
import scala.scalajs.js.|

/**
  * Sprites are the lifeblood of your game, used for nearly everything visual.
  * At its most basic a Sprite consists of a set of coordinates and a texture that is rendered to the canvas.
  * They also contain additional properties allowing for physics motion (via Sprite.body), input handling (via Sprite.input),
  * events (via Sprite.events), animation (via Sprite.animations), camera culling and more. Please see the Examples for use cases.
  */
@js.native
@JSName("Phaser.Sprite")
class Sprite(val game: Game, x0: Double, y0: Double, val key: String | RenderTexture | BitmapData | Texture, val frame: String | Int)
  extends pixijs.Sprite with Core with Angle with Animation with AutoCull with Bounds
    with BringToTop with Crop with Delta with Destroy with FixedToCamera
    with Health with InCamera with InputEnabled with InWorld with LifeSpan
    with LoadTexture with Overlap with PhysicsBody with Reset with ScaleMinMax
    with Smoothed {

  def this() = this(js.native, js.native, js.native, js.native, js.native)

  var body: PhysicsBody = js.native

}
