package io.scalajs.npm.winston

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Winston Query Options
  * @param from
  * @param until
  * @param limit
  * @param start
  * @param order
  * @param fields
  */
class QueryOptions(val from: js.UndefOr[Double | js.Date] = js.undefined,
                   val until: js.UndefOr[Double | js.Date] = js.undefined,
                   val limit: js.UndefOr[Int] = js.undefined,
                   val start: js.UndefOr[Int] = js.undefined,
                   val order: js.UndefOr[String] = js.undefined,
                   val fields: js.UndefOr[js.Array[String]] = js.undefined)
  extends js.Object
