package com.github.ldaniels528.meansjs.nodejs.net

import com.github.ldaniels528.meansjs.util.ScalaJsHelper._

import scala.scalajs.js

/**
  * Listener Options
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait ListenerOptions extends js.Object {
  var host: js.UndefOr[String] = js.native
  var port: js.UndefOr[Int] = js.native
  var path: js.UndefOr[String] = js.native
  var backlog: js.UndefOr[Int] = js.native
  var exclusive: js.UndefOr[Boolean] = js.native
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
    val options = New[ListenerOptions]
    options.host = host
    options.port = port
    options.path = path
    options.backlog = backlog
    options.exclusive = exclusive
    options
  }

}
