package org.scalajs.nodejs.http

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Connection Options
  * @param keepAlive      Keep sockets around in a pool to be used by other requests in the future. Default = false
  * @param keepAliveMsecs When using HTTP KeepAlive, how often to send TCP KeepAlive packets over sockets being kept alive.
  *                       Default = 1000. Only relevant if keepAlive is set to true.
  * @param maxSockets     Maximum number of sockets to allow per host. Default = Infinity.
  * @param maxFreeSockets Maximum number of sockets to leave open in a free state. Only relevant if keepAlive is set to
  *                       true (default: 256).
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ConnectionOptions(var keepAlive: js.UndefOr[Boolean] = js.undefined,
                        var keepAliveMsecs: js.UndefOr[Int] = js.undefined,
                        var maxSockets: js.UndefOr[Double] = js.undefined,
                        var maxFreeSockets: js.UndefOr[Int] = js.undefined) extends js.Object