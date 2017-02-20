package io.scalajs.nodejs.net

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Server Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class ServerOptions(var allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
                    var pauseOnConnect: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
