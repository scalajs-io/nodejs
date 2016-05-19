package com.github.ldaniels528.meansjs.nodejs.net

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Client Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ClientOptions extends js.Object {
  var port: js.UndefOr[Int] = _
}

/**
  * Client Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ClientOptions {

  def apply(port: js.UndefOr[Int] = js.undefined) = {
    val options = new ClientOptions()
    options.port = port
    options
  }

}