package io.scalajs.npm.express

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Static Options
  * @author lawrence.daniels@gmail.com
  */
class StaticOptions(var dotfiles: js.UndefOr[String] = js.undefined,
                    var etag: js.UndefOr[Boolean] = js.undefined,
                    var extensions: js.UndefOr[Boolean] = js.undefined,
                    var fallthrough: js.UndefOr[Boolean] = js.undefined,
                    var index: js.UndefOr[js.Any] = js.undefined,
                    var lastModified: js.UndefOr[Boolean] = js.undefined,
                    var maxAge: js.UndefOr[Double] = js.undefined,
                    var redirect: js.UndefOr[Boolean] = js.undefined,
                    var setHeaders: js.UndefOr[js.Function] = js.undefined)
  extends js.Object

/**
  * Static Options Companion
  * @author lawrence.daniels@gmail.com
  */
object StaticOptions extends FlexibleOptions[StaticOptions]