package io.scalajs.nodejs.net

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Connect Options
  * @author lawrence.daniels@gmail.com
  */
class ConnectOptions(var path: js.UndefOr[String] = js.undefined,
                     var host: js.UndefOr[String] = js.undefined,
                     var port: js.UndefOr[Int] = js.undefined) extends js.Object

/**
  * Connect Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ConnectOptions extends FlexibleOptions[ConnectOptions]
