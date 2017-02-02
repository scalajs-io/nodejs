package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Delete Options
  * @param w        optional: The write concern.
  * @param wtimeout optional: The write concern timeout.
  * @param j        optional: Specify a journal write concern.
  */
@ScalaJSDefined
class DeleteOptions(var w: js.UndefOr[js.Any] = js.undefined,
                    var wtimeout: js.UndefOr[Int] = js.undefined,
                    var j: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
