package com.github.ldaniels528.meansjs.nodejs.express

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Router Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class RouterOptions extends js.Object {
  var caseSensitive: js.UndefOr[Boolean] = _
  var mergeParams: js.UndefOr[Boolean] = _
  var strict: js.UndefOr[Boolean] = _
}

/**
  * Router Options Companion
  * @author lawrence.daniels@gmail.com
  */
object RouterOptions {

  def apply(caseSensitive: js.UndefOr[Boolean] = js.undefined,
            mergeParams: js.UndefOr[Boolean] = js.undefined,
            strict: js.UndefOr[Boolean] = js.undefined) = {
    val options = new RouterOptions()
    options.caseSensitive = caseSensitive
    options.mergeParams = mergeParams
    options.strict = strict
    options
  }

}
