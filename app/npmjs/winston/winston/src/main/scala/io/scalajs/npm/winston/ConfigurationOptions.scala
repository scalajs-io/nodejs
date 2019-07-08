package io.scalajs.npm.winston

import scala.scalajs.js

import scala.scalajs.js.|

/**
  * Configuration Options
  */

class ConfigurationOptions(val transports: js.UndefOr[js.Array[_ <: Transport]] = js.undefined,
                           val exitOnError: js.UndefOr[Boolean | js.Function1[WinstonError, Boolean]] = js.undefined,
                           val rewriters: js.UndefOr[js.Array[js.Function]] = js.undefined,
                           val filters: js.UndefOr[js.Array[js.Function]] = js.undefined)
  extends js.Object