package io.scalajs.npm.mysql

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * MySQL SSL Options
  * @param ca
  * @param rejectUnauthorized
  */
class MySQLSSLOptions(var ca: js.UndefOr[String] = js.undefined,
                      var rejectUnauthorized: js.UndefOr[Boolean] = js.undefined)
  extends js.Object

/**
  * MySQL SSL Options Companion
  * @author lawrence.daniels@gmail.com
  */
object MySQLSSLOptions extends FlexibleOptions[MySQLSSLOptions]
