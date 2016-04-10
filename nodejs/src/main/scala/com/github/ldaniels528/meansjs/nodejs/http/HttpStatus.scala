package com.github.ldaniels528.meansjs.nodejs.http

import scala.scalajs.js

/**
  * Http Status
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpStatus extends js.Object {

  def end(): Unit

  def send(data: String): Unit

  def sendFile(path: String): Unit

}
