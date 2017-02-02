package io.scalajs.npm.mongodb

import java.lang.{Boolean => JBoolean}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

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
@ScalaJSDefined
class AggregationOptions(var readPreference: js.UndefOr[ReadPreference] = js.undefined,
                         var cursor: js.UndefOr[AggregationCursorOptions] = js.undefined,
                         var explain: js.UndefOr[JBoolean] = js.undefined,
                         var allowDiskUse: js.UndefOr[JBoolean] = js.undefined,
                         var maxTimeMS: js.UndefOr[Integer] = js.undefined,
                         var bypassDocumentValidation: js.UndefOr[JBoolean] = js.undefined)
    extends js.Object
