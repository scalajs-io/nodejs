package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Aggregation Cursor Options
  * @param batchSize The batchSize for the cursor
  */
@ScalaJSDefined
class AggregationCursorOptions(var batchSize: js.UndefOr[Int] = js.undefined) extends js.Object