package com.github.ldaniels528.meansjs.nodejs.mysql

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Query Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class QueryOptions(var sql: String = _,
                   var timeout: js.UndefOr[Int] = js.undefined,
                   var typeCast: js.UndefOr[Boolean] = js.undefined,
                   var values: js.Array[js.Any] = null) extends js.Object
