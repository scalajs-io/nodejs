package io.scalajs.npm.winston

import io.scalajs.FlexibleOptions

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Winston Configuration Options
  * @param transports
  * @param exitOnError
  * @param rewriters
  * @param filters
  */
class ConfigurationOptions(var transports: js.UndefOr[js.Array[_ <: Transport]] = js.undefined,
                           var exitOnError: js.UndefOr[Boolean | js.Function1[WinstonError, Boolean]] = js.undefined,
                           var rewriters: js.UndefOr[js.Array[js.Function]] = js.undefined,
                           var filters: js.UndefOr[js.Array[js.Function]] = js.undefined)
  extends js.Object

/**
  * Configuration Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ConfigurationOptions extends FlexibleOptions[ConfigurationOptions]