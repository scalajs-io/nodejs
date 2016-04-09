package com.github.ldaniels528.nodesjs.nodejs.http

import scala.scalajs.js

/**
  * Http Request
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait HttpRequest extends js.Object {

  def end(): Unit

  def end(text: String): Unit

  def on(event: String, callback: js.Function)

  def setNoDelay(): Unit

  def setNoDelay(noDelay: Int): Unit

  /**
    * @see https://nodejs.org/api/net.html#net_socket_setkeepalive_enable_initialdelay
    * @param enable
    * @param initialDelay
    */
  def setSocketKeepAlive(enable: js.UndefOr[Boolean] = js.undefined, initialDelay: js.UndefOr[Int] = js.undefined)

}
