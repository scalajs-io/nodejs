package io.scalajs.npm.nock

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Nock Options
  * @author lawrence.daniels@gmail.com
  */
class NockOptions(var allowUnmocked: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Nock Options Companion
  * @author lawrence.daniels@gmail.com
  */
object NockOptions extends FlexibleOptions[NockOptions]