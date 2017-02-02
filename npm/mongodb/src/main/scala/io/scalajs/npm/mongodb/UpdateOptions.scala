package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Document Update Options
  * @param w        The write concern
  * @param wtimeout The write concern timeout.
  * @param j        Specify a journal write concern.
  * @param upsert   Update operation is an upsert.
  */
@ScalaJSDefined
class UpdateOptions(var w: js.UndefOr[Int] = js.undefined,
                    var wtimeout: js.UndefOr[Int] = js.undefined,
                    var j: js.UndefOr[Boolean] = js.undefined,
                    var upsert: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
