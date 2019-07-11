package io.scalajs.npm.jsdom

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Resource Loader Options
  * @param proxy
  * @param strictSSL
  * @param userAgent
  */
class ResourceLoaderOptions(var proxy: js.UndefOr[String] = js.undefined,
                            var strictSSL: js.UndefOr[Boolean] = js.undefined,
                            var userAgent: js.UndefOr[String] = js.undefined) extends js.Object

/**
  * Resource Loader Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ResourceLoaderOptions extends FlexibleOptions[ResourceLoaderOptions]