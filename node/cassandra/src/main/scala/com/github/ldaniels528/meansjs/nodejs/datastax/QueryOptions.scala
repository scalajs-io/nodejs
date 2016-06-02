package com.github.ldaniels528.meansjs.nodejs.datastax

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cassandra Query Options
  * @param autoPage  indicates whether paging should be used
  * @param fetchSize sets the fetch size (5000 by default)
  */
@ScalaJSDefined
class QueryOptions(var autoPage: Boolean = false,
                   var consistency: js.UndefOr[ConsistencyLevel] = js.undefined,
                   var fetchSize: Int = 5000,
                   var pageState: PageState = null,
                   var prepare: Boolean = false) extends js.Object