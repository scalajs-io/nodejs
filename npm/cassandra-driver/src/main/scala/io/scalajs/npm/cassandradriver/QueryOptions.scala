package io.scalajs.npm.cassandradriver

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Cassandra Query Options
  * @param autoPage  indicates whether paging should be used
  * @param fetchSize sets the fetch size (5000 by default)
  */
@ScalaJSDefined
class QueryOptions(val autoPage: Boolean = false,
                   val consistency: js.UndefOr[ConsistencyLevel] = js.undefined,
                   val fetchSize: Int = 5000,
                   val pageState: PageState = null,
                   val prepare: Boolean = false)
    extends js.Object
