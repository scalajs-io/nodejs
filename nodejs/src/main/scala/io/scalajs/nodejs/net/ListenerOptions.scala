package io.scalajs.nodejs.net

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Listener Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ListenerOptions(var host: js.UndefOr[String] = js.undefined,
                      var port: js.UndefOr[Int] = js.undefined,
                      var path: js.UndefOr[String] = js.undefined,
                      var backlog: js.UndefOr[Int] = js.undefined,
                      var exclusive: js.UndefOr[Boolean] = js.undefined) extends js.Object