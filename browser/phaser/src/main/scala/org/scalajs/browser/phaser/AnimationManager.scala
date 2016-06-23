package org.scalajs.browser.phaser

import scala.scalajs.js

/**
  * Phaser: Animation Manager
  * @version 2.5.0
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait AnimationManager extends js.Object {

  def add(name: String,
          frames: js.Array[_] = js.Array(),
          frameRate: js.UndefOr[Int] = 60,
          loop: js.UndefOr[Boolean] = false,
          useNumericIndex: js.UndefOr[Boolean] = true): Animation = js.native
}