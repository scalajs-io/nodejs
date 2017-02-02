package io.scalajs.npm.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Find-And-Update Options
  * @param projection     Limits the fields to return for all matching documents.
  * @param sort           Determines which document the operation modifies if the query selects multiple documents.
  * @param maxTimeMS      The maximum amount of time to allow the query to run.
  * @param upsert         the document if it does not exist.
  * @param returnOriginal When false, returns the updated document rather than the original. The default is true.
  */
@ScalaJSDefined
class FindAndUpdateOptions(var projection: js.UndefOr[js.Any] = js.undefined,
                           var sort: js.UndefOr[js.Any] = js.undefined,
                           var maxTimeMS: js.UndefOr[Integer] = js.undefined,
                           var upsert: js.UndefOr[Boolean] = js.undefined,
                           var returnOriginal: js.UndefOr[Boolean] = js.undefined)
    extends js.Object
