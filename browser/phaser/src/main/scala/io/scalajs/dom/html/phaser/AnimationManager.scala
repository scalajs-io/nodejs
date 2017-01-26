package io.scalajs.dom.html.phaser

import io.scalajs.dom.html.phaser.component.Animation

import scala.scalajs.js

@js.native
trait AnimationManager extends js.Object {

  def add(name: String,
          frames: js.UndefOr[js.Array[_]] = js.undefined,
          frameRate: js.UndefOr[Int] = js.undefined,
          loop: js.UndefOr[Boolean] = js.undefined,
          useNumericIndex: js.UndefOr[Boolean] = js.undefined): Animation = js.native

}
