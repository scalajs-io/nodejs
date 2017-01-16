package io.scalajs.npm.socketio

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Client Socket Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class SocketOptions(var reconnection: js.UndefOr[Boolean] = js.undefined,
                    var reconnectionAttempts: js.UndefOr[Int] = js.undefined,
                    var reconnectionDelay: js.UndefOr[Int] = js.undefined,
                    var reconnectionDelayMax: js.UndefOr[Int] = js.undefined,
                    var randomizationFactor: js.UndefOr[Double] = js.undefined,
                    var timeout: js.UndefOr[Int] = js.undefined,
                    var autoConnect: js.UndefOr[Boolean] = js.undefined) extends js.Object