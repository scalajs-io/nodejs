package com.github.ldaniels528.meansjs.nodejs.express

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Router Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RouterOptions extends js.Object {
  var caseSensitive: js.UndefOr[Boolean]
  var mergeParams: js.UndefOr[Boolean]
  var strict: js.UndefOr[Boolean]
}

/**
  * Router Options Companion
  * @author lawrence.daniels@gmail.com
  */
object RouterOptions {

  def apply(caseSensitive: js.UndefOr[Boolean] = js.undefined,
            mergeParams: js.UndefOr[Boolean] = js.undefined,
            strict: js.UndefOr[Boolean] = js.undefined) = {
    val options = makeNew[RouterOptions]
    options.caseSensitive = caseSensitive
    options.mergeParams = mergeParams
    options.strict = strict
    options
  }

}
