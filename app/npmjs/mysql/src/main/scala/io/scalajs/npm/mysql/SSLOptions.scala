package io.scalajs.npm.mysql

import scala.scalajs.js

/**
  * MySQL SSL Options
  * @author lawrence.daniels@gmail.com
  */
class SSLOptions(var ca: js.UndefOr[String] = js.undefined,
                 var rejectUnauthorized: js.UndefOr[Boolean] = js.undefined)
  extends js.Object
