package io.scalajs.npm.winston.transports

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Console Transport Options
  * @author lawrence.daniels@gmail.com
  */
class ConsoleTransportOptions(var level: js.UndefOr[String] = js.undefined,
                              var formatter: js.UndefOr[js.Function1[ConsoleTransportOptions, String]] = js.undefined,
                              var timestamp: js.UndefOr[js.Function1[Unit, Double]] = js.undefined)
  extends js.Object

/**
  * Console Transport Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ConsoleTransportOptions extends FlexibleOptions[ConsoleTransportOptions]