package io.scalajs.npm.mongodb

import io.scalajs.FlexibleOptions

import scala.scalajs.js

/**
  * Aggregation Options
  * @param readPreference           The preferred read preference
  * @param cursor                   Return the query as cursor, on 2.6 > it returns as a real cursor on pre 2.6 it
  *                                 returns as an emulated cursor.
  * @param explain                  Explain returns the aggregation execution plan (requires mongodb 2.6 >).
  * @param allowDiskUse             allowDiskUse lets the server know if it can use disk to store temporary results for
  *                                 the aggregation (requires mongodb 2.6 >).
  * @param maxTimeMS                maxTimeMS specifies a cumulative time limit in milliseconds for processing operations
  *                                 on the cursor.
  *                                 MongoDB interrupts the operation at the earliest following interrupt point.
  * @param bypassDocumentValidation Allow driver to bypass schema validation in MongoDB 3.2 or higher.
  */
class AggregationOptions(var readPreference: js.UndefOr[ReadPreference] = js.undefined,
                         var cursor: js.UndefOr[AggregationCursorOptions] = js.undefined,
                         var explain: js.UndefOr[Boolean] = js.undefined,
                         var allowDiskUse: js.UndefOr[Boolean] = js.undefined,
                         var maxTimeMS: js.UndefOr[Int] = js.undefined,
                         var bypassDocumentValidation: js.UndefOr[Boolean] = js.undefined) extends js.Object

/**
  * Aggregation Options Companion
  * @author lawrence.daniels@gmail.com
  */
object AggregationOptions extends FlexibleOptions[AggregationOptions]
