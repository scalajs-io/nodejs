package com.github.ldaniels528.meansjs.nodejs.express

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Static Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class StaticOptions(var dotfiles: js.UndefOr[String] = js.undefined,
                    var etag: js.UndefOr[Boolean] = js.undefined,
                    var extensions: js.UndefOr[Boolean] = js.undefined,
                    var fallthrough: js.UndefOr[Boolean] = js.undefined,
                    var index: js.UndefOr[js.Any] = js.undefined,
                    var lastModified: js.UndefOr[Boolean] = js.undefined,
                    var maxAge: js.UndefOr[Double] = js.undefined,
                    var redirect: js.UndefOr[Boolean] = js.undefined,
                    var setHeaders: js.UndefOr[js.Function] = js.undefined) extends js.Object