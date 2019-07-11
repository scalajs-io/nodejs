package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Remove User Options
  * @param w        The write concern
  * @param wtimeout The write concern timeout.
  * @param j        Specify a journal write concern..
  */
class RemoveUserOptions(var w: js.UndefOr[Int | String] = js.undefined,
                        var wtimeout: js.UndefOr[Int] = js.undefined,
                        var j: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Remove User Options Companion
  * @author lawrence.daniels@gmail.com
  */
object RemoveUserOptions extends FlexibleOptions[RemoveUserOptions]