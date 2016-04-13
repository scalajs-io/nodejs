package com.github.ldaniels528.meansjs.nodejs.bodyparser

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Express Body Parser Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait BodyParserOptions extends js.Object {
  var extended: Boolean = js.native
}

/**
  * Express Body Parser Options Companion
  * @author lawrence.daniels@gmail.com
  */
object BodyParserOptions {

  def apply(extended: Boolean) = {
    val options = makeNew[BodyParserOptions]
    options.extended = extended
    options
  }

}
