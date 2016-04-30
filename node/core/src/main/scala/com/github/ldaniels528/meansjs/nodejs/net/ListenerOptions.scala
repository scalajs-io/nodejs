package com.github.ldaniels528.meansjs.nodejs.net

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Listener Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ListenerOptions extends js.Object {
  var host: js.UndefOr[String] = _
  var port: js.UndefOr[Int] = _
  var path: js.UndefOr[String] = _
  var backlog: js.UndefOr[Int] = _
  var exclusive: js.UndefOr[Boolean] = _
}

/**
  * Listener Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ListenerOptions {

  def apply(host: js.UndefOr[String] = js.undefined,
            port: js.UndefOr[Int] = js.undefined,
            path: js.UndefOr[String] = js.undefined,
            backlog: js.UndefOr[Int] = js.undefined,
            exclusive: js.UndefOr[Boolean] = js.undefined) = {
    val options = new ListenerOptions()
    options.host = host
    options.port = port
    options.path = path
    options.backlog = backlog
    options.exclusive = exclusive
    options
  }

}
