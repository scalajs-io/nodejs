package com.github.ldaniels528.nodesjs.nodejs.express

import com.github.ldaniels528.nodesjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Static Serve Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait StaticServeOptions extends js.Object {
  var dotfiles: js.UndefOr[String]
  var etag: js.UndefOr[Boolean]
  var extensions: js.UndefOr[Boolean]
  var fallthrough: js.UndefOr[Boolean]
  var index: js.UndefOr[js.Any]
  var lastModified: js.UndefOr[Boolean]
  var maxAge: js.UndefOr[Double]
  var redirect: js.UndefOr[Boolean]
  var setHeaders: js.UndefOr[js.Function]
}

/**
  * Static Serve Options Companion
  * @author lawrence.daniels@gmail.com
  */
object StaticServeOptions {

  def apply(dotfiles: js.UndefOr[String] = js.undefined,
            etag: js.UndefOr[Boolean] = js.undefined,
            extensions: js.UndefOr[Boolean] = js.undefined,
            fallthrough: js.UndefOr[Boolean] = js.undefined,
            index: js.UndefOr[js.Any] = js.undefined,
            lastModified: js.UndefOr[Boolean] = js.undefined,
            maxAge: js.UndefOr[Double] = js.undefined,
            redirect: js.UndefOr[Boolean] = js.undefined,
            setHeaders: js.UndefOr[js.Function] = js.undefined) = {
    val options = makeNew[StaticServeOptions]
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