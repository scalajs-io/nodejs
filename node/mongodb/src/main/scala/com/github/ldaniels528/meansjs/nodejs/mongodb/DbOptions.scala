package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Mongo Database Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class DbOptions extends js.Object {
  var w: js.UndefOr[Int] = _
}

/**
  * Mongo Database Options Companion
  * @author lawrence.daniels@gmail.com
  */
object DbOptions {

  def apply(w: js.UndefOr[Int] = js.undefined) = {
    val options = new DbOptions()
    options.w = w
    options
  }

}