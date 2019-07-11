package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Delete Options
  * @param w        optional: The write concern.
  * @param wtimeout optional: The write concern timeout.
  * @param j        optional: Specify a journal write concern.
  */
class DeleteOptions(var w: js.UndefOr[js.Any] = js.undefined,
                    var wtimeout: js.UndefOr[Int] = js.undefined,
                    var j: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Delete Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DeleteOptions extends FlexibleOptions[DeleteOptions]
