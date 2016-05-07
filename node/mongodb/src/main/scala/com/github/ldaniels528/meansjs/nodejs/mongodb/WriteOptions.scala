package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Write Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class WriteOptions extends js.Object {
  var w: Int = _
}

/**
  * Write Options Companion
  * @author lawrence.daniels@gmail.com
  */
object WriteOptions {

  def apply(w: Int): WriteOptions = {
    val options = new WriteOptions()
    options.w = w
    options
  }

}