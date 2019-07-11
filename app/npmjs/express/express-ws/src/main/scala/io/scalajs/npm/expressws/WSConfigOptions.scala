package io.scalajs.npm.expressws

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * WS-Config Configuration Options
  * @param leaveRouterUntouched indicates whether to leave the router untouched
  */
class WSConfigOptions(leaveRouterUntouched: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * WS-Config Options Companion
  * @author lawrence.daniels@gmail.com
  */
object WSConfigOptions extends FlexibleOptions[WSConfigOptions]