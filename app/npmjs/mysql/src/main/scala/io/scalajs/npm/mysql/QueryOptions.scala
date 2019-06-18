package io.scalajs.npm.mysql

import scala.scalajs.js

/**
  * MySQL Query Options
  * @author lawrence.daniels@gmail.com
  */
class QueryOptions(var sql: String,
                   var timeout: js.UndefOr[Int] = js.undefined,
                   var typeCast: js.UndefOr[Boolean] = js.undefined,
                   var values: js.Array[js.Any] = null)
  extends js.Object
