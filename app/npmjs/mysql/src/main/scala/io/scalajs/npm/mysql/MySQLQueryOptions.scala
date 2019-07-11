package io.scalajs.npm.mysql

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * MySQL Query Options
  * @author lawrence.daniels@gmail.com
  */
class MySQLQueryOptions(var sql: String,
                        var timeout: js.UndefOr[Int] = js.undefined,
                        var typeCast: js.UndefOr[Boolean] = js.undefined,
                        var values: js.Array[js.Any] = null)
  extends js.Object

/**
  * Query Options Companion
  * @author lawrence.daniels@gmail.com
  */
object MySQLQueryOptions extends FlexibleOptions[MySQLQueryOptions]
