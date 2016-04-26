package com.github.ldaniels528.meansjs.nodejs.bodyparser

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Express Body Parser Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class BodyParserOptions extends js.Object {
  var extended: Boolean = _
}

/**
  * Express Body Parser Options Companion
  * @author lawrence.daniels@gmail.com
  */
object BodyParserOptions {

  def apply(extended: Boolean) = {
    val options = new BodyParserOptions()
    options.extended = extended
    options
  }

}
