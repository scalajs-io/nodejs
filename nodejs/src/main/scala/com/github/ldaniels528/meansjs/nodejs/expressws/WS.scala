package com.github.ldaniels528.meansjs.nodejs.expressws

import scala.scalajs.js

/**
  * Express Web Socket Handle
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WS extends js.Object {

  def on(eventName: String, callback: js.Function): Unit = js.native

  def send(message: js.Any): Unit = js.native

}
