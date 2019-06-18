package io.scalajs.npm.engineio

import io.scalajs.nodejs.events.IEventEmitter
import io.scalajs.nodejs.http

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Engine.IO is the implementation of transport-based cross-browser/cross-device bi-directional communication layer for Socket.IO.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait EngineIO extends IEventEmitter {

  def attach(server: http.Server): this.type = js.native

  def listen(port: Int): this.type = js.native

}

@js.native
@JSImport("engine.io", JSImport.Namespace)
object EngineIO extends EngineIO