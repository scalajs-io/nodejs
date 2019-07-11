package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Document Update Options
  * @param w        The write concern
  * @param wtimeout The write concern timeout.
  * @param j        Specify a journal write concern.
  * @param upsert   Update operation is an upsert.
  */
class UpdateOptions(var w: js.UndefOr[Int | String] = js.undefined,
                    var wtimeout: js.UndefOr[Int] = js.undefined,
                    var j: js.UndefOr[Boolean] = js.undefined,
                    var upsert: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Update Options Companion
  * @author lawrence.daniels@gmail.com
  */
object UpdateOptions extends FlexibleOptions[UpdateOptions]