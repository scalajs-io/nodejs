package com.github.ldaniels528.meansjs.nodejs.mongodb

import java.lang.{Boolean => JBoolean}

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Aggregation Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class AggregationOptions extends js.Object {

  /**
    * The preferred read preference
    * @see [[ReadPreference.PRIMARY]]
    * @see [[ReadPreference.PRIMARY_PREFERRED]]
    * @see [[ReadPreference.SECONDARY]]
    * @see [[ReadPreference.SECONDARY_PREFERRED]]
    * @see [[ReadPreference.NEAREST]]
    */
  var readPreference: js.UndefOr[ReadPreference] = _

  /** Return the query as cursor, on 2.6 > it returns as a real cursor on pre 2.6 it returns as an emulated cursor. */
  var cursor: js.UndefOr[AggregationCursorOptions] = _

  /** Explain returns the aggregation execution plan (requires mongodb 2.6 >). */
  var explain: js.UndefOr[JBoolean] = _

  /** allowDiskUse lets the server know if it can use disk to store temporary results for the aggregation (requires mongodb 2.6 >). */
  var allowDiskUse: js.UndefOr[JBoolean] = _

  /** maxTimeMS specifies a cumulative time limit in milliseconds for processing operations on the cursor.
    * MongoDB interrupts the operation at the earliest following interrupt point. */
  var maxTimeMS: js.UndefOr[Integer] = _

  /** Allow driver to bypass schema validation in MongoDB 3.2 or higher. */
  var bypassDocumentValidation: js.UndefOr[JBoolean] = _

}

/**
  * Aggregation Options
  * @author lawrence.daniels@gmail.com
  */
object AggregationOptions {

  def apply(readPreference: js.UndefOr[ReadPreference] = js.undefined,
            cursor: js.UndefOr[AggregationCursorOptions] = js.undefined,
            explain: js.UndefOr[JBoolean] = js.undefined,
            allowDiskUse: js.UndefOr[JBoolean] = js.undefined,
            maxTimeMS: js.UndefOr[Integer] = js.undefined,
            bypassDocumentValidation: js.UndefOr[JBoolean] = js.undefined) = {
    val options = new AggregationOptions()
    options.readPreference = readPreference
    options.cursor = cursor
    options.explain = explain
    options.allowDiskUse = allowDiskUse
    options.maxTimeMS = maxTimeMS
    options.bypassDocumentValidation = bypassDocumentValidation
    options
  }

}