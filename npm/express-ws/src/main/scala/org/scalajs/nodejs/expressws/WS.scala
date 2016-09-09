package org.scalajs.nodejs.expressws

import org.scalajs.nodejs.events.EventEmitter
import org.scalajs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * Express Web Socket Handle
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WS extends EventEmitter {

  def send(message: js.Any): Unit = js.native

}
