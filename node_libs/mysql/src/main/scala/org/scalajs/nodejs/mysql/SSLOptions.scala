package org.scalajs.nodejs.mysql

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * SSL Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class SSLOptions(var ca: js.UndefOr[String] = js.undefined,
                 var rejectUnauthorized: js.UndefOr[Boolean] = js.undefined) extends js.Object
