package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Aggregation Cursor Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class AggregationCursorOptions extends js.Object {
  /** The batchSize for the cursor */
  var batchSize: js.UndefOr[Integer] = _
}

/**
  * Aggregation Cursor Options
  * @author lawrence.daniels@gmail.com
  */
object AggregationCursorOptions {

  def apply(batchSize: js.UndefOr[Integer] = js.undefined) = {
    val options = new AggregationCursorOptions()
    options.batchSize = batchSize
    options
  }

}