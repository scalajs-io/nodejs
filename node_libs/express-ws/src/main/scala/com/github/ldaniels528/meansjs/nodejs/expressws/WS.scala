package com.github.ldaniels528.meansjs.nodejs.expressws

import com.github.ldaniels528.meansjs.nodejs.events.EventEmitter

import scala.scalajs.js

/**
  * Express Web Socket Handle
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait WS extends EventEmitter {

  def send(message: js.Any): Unit = js.native

}
