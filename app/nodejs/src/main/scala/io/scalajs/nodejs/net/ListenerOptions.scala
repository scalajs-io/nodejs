package io.scalajs.nodejs.net

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Listener Options
  * @author lawrence.daniels@gmail.com
  */
class ListenerOptions(var host: js.UndefOr[String] = js.undefined,
                      var port: js.UndefOr[Int] = js.undefined,
                      var path: js.UndefOr[String] = js.undefined,
                      var backlog: js.UndefOr[Int] = js.undefined,
                      var exclusive: js.UndefOr[Boolean] = js.undefined) extends js.Object
/**
  * Listener Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ListenerOptions extends FlexibleOptions[ListenerOptions]