package com.github.ldaniels528.meansjs.nodejs.net

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Socket Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class SocketOptions extends js.Object {
  var fd: js.UndefOr[js.Object] = _
  var allowHalfOpen: js.UndefOr[Boolean] = _
  var readable: js.UndefOr[Boolean] = _
  var writable: js.UndefOr[Boolean] = _
}

/**
  * Socket Options Companion
  * @author lawrence.daniels@gmail.com
  */
object SocketOptions {

  def apply(fd: js.UndefOr[js.Object] = js.undefined,
            allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
            readable: js.UndefOr[Boolean] = js.undefined,
            writable: js.UndefOr[Boolean] = js.undefined) = {
    val options = new SocketOptions()
    options.fd = fd
    options.allowHalfOpen = allowHalfOpen
    options.readable = readable
    options.writable = writable
    options
  }

}

