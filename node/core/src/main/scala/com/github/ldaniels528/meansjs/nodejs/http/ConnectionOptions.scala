package com.github.ldaniels528.meansjs.nodejs.http

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Connection Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ConnectionOptions extends js.Object {
  /** Keep sockets around in a pool to be used by other requests in the future. Default = false */
  var keepAlive: js.UndefOr[Boolean] = _

  /**
    * When using HTTP KeepAlive, how often to send TCP KeepAlive packets over sockets being kept alive.
    * Default = 1000. Only relevant if keepAlive is set to true.
    */
  var keepAliveMsecs: js.UndefOr[Int] = _

  /** Maximum number of sockets to allow per host. Default = Infinity. */
  var maxSockets: js.UndefOr[Double] = _

  /** Maximum number of sockets to leave open in a free state. Only relevant if keepAlive is set to true. Default = 256. */
  var maxFreeSockets: js.UndefOr[Int] = _

}

/**
  * Connection Options Companion
  * @author lawrence.daniels@gmail.com
  */
object ConnectionOptions {

  def apply(keepAlive: js.UndefOr[Boolean] = js.undefined,
            keepAliveMsecs: js.UndefOr[Int] = js.undefined,
            maxSockets: js.UndefOr[Double] = js.undefined,
            maxFreeSockets: js.UndefOr[Int] = js.undefined) = {
    val options = new ConnectionOptions()
    options.keepAlive = keepAlive
    options.keepAliveMsecs = keepAliveMsecs
    options.maxSockets = maxSockets
    options.maxFreeSockets = maxFreeSockets
    options
  }

}