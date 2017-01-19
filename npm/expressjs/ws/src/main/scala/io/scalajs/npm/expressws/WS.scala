package io.scalajs.npm.expressws

import io.scalajs.nodejs.events.IEventEmitter

import scala.scalajs.js

/**
  * Express Web Socket Handle
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WS extends IEventEmitter {

  def send(message: js.Any): Unit = js.native

}
