package com.github.ldaniels528.meansjs.nodejs.express

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Static Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class StaticOptions extends js.Object {
  var dotfiles: js.UndefOr[String] = _
  var etag: js.UndefOr[Boolean] = _
  var extensions: js.UndefOr[Boolean] = _
  var fallthrough: js.UndefOr[Boolean] = _
  var index: js.UndefOr[js.Any] = _
  var lastModified: js.UndefOr[Boolean] = _
  var maxAge: js.UndefOr[Double] = _
  var redirect: js.UndefOr[Boolean] = _
  var setHeaders: js.UndefOr[js.Function] = _
}

/**
  * Static Options Companion
  * @author lawrence.daniels@gmail.com
  */
object StaticOptions {

  def apply(dotfiles: js.UndefOr[String] = js.undefined,
            etag: js.UndefOr[Boolean] = js.undefined,
            extensions: js.UndefOr[Boolean] = js.undefined,
            fallthrough: js.UndefOr[Boolean] = js.undefined,
            index: js.UndefOr[js.Any] = js.undefined,
            lastModified: js.UndefOr[Boolean] = js.undefined,
            maxAge: js.UndefOr[Double] = js.undefined,
            redirect: js.UndefOr[Boolean] = js.undefined,
            setHeaders: js.UndefOr[js.Function] = js.undefined) = {
    val options = new StaticOptions()
    options.dotfiles = dotfiles
    options.etag = etag
    options.extensions = extensions
    options.fallthrough = fallthrough
    options.lastModified = lastModified
    options.maxAge = maxAge
    options.redirect = redirect
    options.setHeaders = setHeaders
    options
  }

}
