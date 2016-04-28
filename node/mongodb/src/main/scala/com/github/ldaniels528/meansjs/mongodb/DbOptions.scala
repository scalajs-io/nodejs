package com.github.ldaniels528.meansjs.mongodb

import scala.scalajs.js

/**
  * Mongo Database Options
  * @author lawrence.daniels@gmail.com
  */
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