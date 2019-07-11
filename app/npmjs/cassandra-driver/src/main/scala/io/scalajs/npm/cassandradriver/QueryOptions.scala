package io.scalajs.npm.cassandradriver

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Cassandra Query Options
  * @param autoPage    indicates whether paging should be used
  * @param consistency the [[ConsistencyLevel consistency level]]
  * @param fetchSize   sets the fetch size (5000 by default)
  * @param pageState   the [[PageState page state]]
  * @param prepare
  */
class QueryOptions(var autoPage: js.UndefOr[Boolean] = js.undefined,
                   var consistency: js.UndefOr[ConsistencyLevel] = js.undefined,
                   var fetchSize: js.UndefOr[Int] = js.undefined,
                   var pageState: js.UndefOr[PageState] = js.undefined,
                   var prepare: js.UndefOr[Boolean] = js.undefined)
  extends js.Object

/**
  * Cassandra Query Options Companion
  * @author lawrence.daniels@gmail.com
  */
object QueryOptions extends FlexibleOptions[QueryOptions]