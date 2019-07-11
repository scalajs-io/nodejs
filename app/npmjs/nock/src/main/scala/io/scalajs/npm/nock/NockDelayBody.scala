package io.scalajs.npm.nock

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Nock Delay Body
  * @param body the delay (in milliseconds)
  */
class NockDelayBody(var body: js.UndefOr[Int] = js.undefined) extends js.Object

/**
  * Nock Delay Body Companion
  * @author lawrence.daniels@gmail.com
  */
object NockDelayBody extends FlexibleOptions[NockDelayBody]
