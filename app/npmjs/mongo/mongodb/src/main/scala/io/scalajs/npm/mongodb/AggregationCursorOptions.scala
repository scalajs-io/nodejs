package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Aggregation Cursor Options
  * @param batchSize The batchSize for the cursor
  */
class AggregationCursorOptions(var batchSize: js.UndefOr[Int] = js.undefined) extends js.Object

/**
  * Aggregation Cursor Options Companion
  * @author lawrence.daniels@gmail.com
  */
object AggregationCursorOptions extends FlexibleOptions[AggregationCursorOptions]