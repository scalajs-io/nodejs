package com.github.ldaniels528.meansjs.nodejs.mongodb

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
class UpdateOptions(w: js.UndefOr[Int],
                    wtimeout: js.UndefOr[Int],
                    j: js.UndefOr[Boolean],
                    upsert: js.UndefOr[Boolean]) extends js.Object

/**
  * Update Options Companion
  * @author lawrence.daniels@gmail.com
  */
object UpdateOptions {

  def apply(w: js.UndefOr[Int] = js.undefined,
            wtimeout: js.UndefOr[Int] = js.undefined,
            j: js.UndefOr[Boolean] = js.undefined,
            upsert: js.UndefOr[Boolean] = js.undefined) = {
    new UpdateOptions(w, wtimeout, j, upsert)
  }

}

