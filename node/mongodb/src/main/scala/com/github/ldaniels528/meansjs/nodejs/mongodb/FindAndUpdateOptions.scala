package com.github.ldaniels528.meansjs.nodejs.mongodb

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
  * Find-And-Update Options
  * @author lawrence.daniels@gmail.com
  */
@ScalaJSDefined
class FindAndUpdateOptions extends js.Object {
  /** Limits the fields to return for all matching documents. */
  var projection: js.Any = _

  /** Determines which document the operation modifies if the query selects multiple documents. */
  var sort: js.Any = _

  /** The maximum amount of time to allow the query to run. */
  var maxTimeMS: js.UndefOr[Integer] = _

  /** Upsert the document if it does not exist. */
  var upsert: js.UndefOr[Boolean] = _

  /** When false, returns the updated document rather than the original. The default is true. */
  var returnOriginal: js.UndefOr[Boolean] = _

}

/**
  * Find-And-Update Options Companion
  * @author lawrence.daniels@gmail.com
  */
object FindAndUpdateOptions {

  def apply(projection: js.Any = js.undefined,
            sort: js.Any = js.undefined,
            maxTimeMS: js.UndefOr[Integer] = js.undefined,
            upsert: js.UndefOr[Boolean] = js.undefined,
            returnOriginal: js.UndefOr[Boolean] = js.undefined) = {
    val options = new FindAndUpdateOptions()
    options.projection = projection
    options.sort = sort
    options.maxTimeMS = maxTimeMS
    options.upsert = upsert
    options.returnOriginal = returnOriginal
    options
  }

}