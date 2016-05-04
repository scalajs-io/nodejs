package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Delete Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class DeleteOptions extends js.Object {
  //	number | string	null	optional - The write concern.
  var w: js.UndefOr[js.Any] = _

  // number	null	optional - The write concern timeout.
  var wtimeout: js.UndefOr[Int] = _

  // boolean	false	optional - Specify a journal write concern.
  var j: js.UndefOr[Boolean] = _
}

/**
  * Delete Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DeleteOptions {

  def apply(w: js.UndefOr[js.Any] = js.undefined,
            wtimeout: js.UndefOr[Int] = js.undefined,
            j: js.UndefOr[Boolean] = js.undefined) = {
    val options = new DeleteOptions()
    options.w = w
    options.wtimeout = wtimeout
    options.j = j
    options
  }

}